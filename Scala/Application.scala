package controllers

import javax.inject.Inject

import play.modules.reactivemongo._
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api._
import play.api.mvc._
import models.movies
import reactivemongo.play.json.collection.JSONCollection
import reactivemongo.play.json._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import reactivemongo.api._
import scala.concurrent.Future
import play.api.libs.json._


class Application @Inject()(val reactiveMongoApi: ReactiveMongoApi, val messagesApi: MessagesApi) extends Controller with I18nSupport with MongoController with ReactiveMongoComponents{

// Gets a collection from a Mongo DB ('movies')
  def collection: Future[JSONCollection] = database.map(_.collection[JSONCollection]("movies"))

// Goes to the Home Page
  def index = Action {
    Ok(views.html.index("Test Output", "Welcome to the home page!"))
  }

// Adds a new movie to the database, then goes to the View Page to display it.
  def toView = Action { implicit request: Request[AnyContent] =>
    val formValidationResult = movies.createMovieForm.bindFromRequest
    formValidationResult.fold({
      formWithErrors =>
        BadRequest(views.html.theView(movies.theMovies, formWithErrors))
    }, { widget =>
      widget.mID = movies.theID
      collection.flatMap(_.insert(widget))
      Redirect(routes.Application.listMovies)
    })
  }

  // Goes to the View Page (view list of movies)
  def listMovies = Action.async {

    val cursor: Future[Cursor[movies]] = collection.map {
      _.find(Json.obj()).cursor[movies]
    }

    val futureMoviesList: Future[List[movies]] = cursor.flatMap(_.collect[List]())
    futureMoviesList.map { loadMovies =>
      movies.theMovies.clear()
      for(x <- loadMovies)
        {
          movies.theMovies += x
        }

      movies.theID
      Ok(views.html.theView(movies.theMovies, movies.createMovieForm))
    }

  }


// Goes to the Edit Page, sending the ID of the movie the user wants to edit.
  def toEdit(theID:Int) = Action {
    val oneMovie = movies.theMovies.zipWithIndex.filter(_._1.mID == theID).head._2
    Ok(views.html.theEdit(movies.theMovies, movies.createMovieForm.fill(movies.theMovies(oneMovie)), oneMovie))
  }

 // Edits an existing movie in the Mongo DB, then goes to the View Page to display the edit.
  def doEdit = Action { implicit request: Request[AnyContent] =>
    val formValidationResult = movies.createMovieForm.bindFromRequest
    formValidationResult.fold({
      formWithErrors =>
        BadRequest(views.html.theView(movies.theMovies, formWithErrors))
    }, { widget =>

      val modifier = Json.obj("$set" -> Json.obj("title"->widget.title,
        "description"->widget.description,
        "price"->widget.price,
        "director" -> widget.director,
        "starring" -> widget.starring,
        "rating" -> widget.rating
      ))

      collection.map{
        _.findAndUpdate(Json.obj("mID"->widget.mID),modifier)
      }

      Redirect(routes.Application.listMovies)
    })
  }

  // Deletes a selected movie from the Mongo DB collection, then goes to the View Page to display the updated movie list.
  def toDel(theID:Int) = Action {
    movies.theMovies.length <= 0 match {
      case true => Ok(views.html.theView(movies.theMovies, movies.createMovieForm))
      case false => collection.map{_.findAndRemove(Json.obj("mID"->theID))
      }
      Redirect(routes.Application.listMovies)
    }
  }

 // Redirects the user to another site.
  def doRedirect = Action {
     Redirect("http://www.google.com")
  }

 // Displays a variable that matches a user input (e.g. '../theDynamic/5'  outputs "The dynamic ID is: 5)
  def theDynamic(id:Int) = Action{
    Ok("The dynamic ID is: " + id)
  }

 // Displays a variable set in the routes file (Output will always be '5')
  def theStatic(id:Int) = Action{
    Ok("The static ID is always: " + id)
  }

  // Displays an ID submitted by the user and states that the default is always '1'.
  def theDefault(id:Int) = Action{
    Ok("The ID given is: " + id + ", and the default ID is always: " + 1 )
  }

  // Displays an ID submitted by the user, or an appropriate message if nothing was submitted.
  def theOptional(id:Option[String]) = Action{
    Ok("The optional ID is: " + id.getOrElse("No ID inputted."))
  }

  // Creates a cookie when the function runs.
  def hello(name: String) = Action{
    Ok("Hello " + name + "!").withCookies(Cookie("theme", "HelloCookie"))
  }

  // Prints the value assigned to the created cookie ('HelloCookie').
  def helloPrintCookie = Action {request =>
     request.cookies.get("theme").map{
      theCookie => Ok("Description: " + theCookie.value)
    }.getOrElse{
      Unauthorized("Error: There is no cookie available.")
    }
  }

 // Discards a created cookie with a specific identifier ('theme').
  def helloDiscardCookie = Action {
    Ok("The cookie was deleted.").discardingCookies(DiscardingCookie("theme"))
  }

 // Creates a dummy link that leads to a "to be implemented" default page.
  def dummy(name:String) = TODO


  // If two routes named '/doubleTry' lead to separate functions, only one of the 'doubleTry' functions will be called.
  // (In this case, 'doubleTryOne', the first one).
  def doubleTryOne = Action{
    Ok("The first doubleTry function was called.")
  }

  def doubleTryTwo = Action{
    Ok("The second doubleTry function was called.")
  }


}
