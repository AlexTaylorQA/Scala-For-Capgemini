import java.sql.{Connection, DriverManager}

/**
  * Created by Administrator on 03/08/2017.
  */
object DBcon extends Enumeration {

  def dbConnection():(Connection, String) = {
    val url = "jdbc:mysql://192.168.1.49:3306/hangmanDB"
    val driver = "com.mysql.jdbc.Driver"
    val username = "root"
    val password = "merdegraw494"
    var connection: Connection = DriverManager.getConnection(url, username, password)
    (connection,driver)
  }
}
