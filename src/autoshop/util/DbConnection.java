package autoshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

  public Connection Connect() {
    String url = "jdbc:mysql://localhost:3306/Aplicatie_Java/C";
    String user = "root";
    String password = "Parolameaeparola7&";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, user, password);
      return conn;

    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

}
