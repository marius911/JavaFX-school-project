package autoshop.model;

import autoshop.util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author marius
 */
public class AutoDAO {

  //*******************************
  //SELECT an Auto
  //*******************************
  public static Auto searchAuto(String id_vehicul) throws SQLException, ClassNotFoundException {
    //Declare a SELECT statement
    String selectStmt = "SELECT * FROM inventar_auto WHERE id_vehicul=" + id_vehicul;

    //Execute SELECT statement
    try {
      //Get ResultSet from dbExecuteQuery method
      ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

      //Send ResultSet to the getAutoFromResultSet method and get employee object
      Auto auto = getAutoFromResultSet(rsEmp);

      //Return auto object
      return auto;
    } catch (SQLException e) {
      System.out.println("While searching an auto with " + id_vehicul + " id, an error occurred: " + e);
      //Return exception
      throw e;
    }
  }

  //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
  private static Auto getAutoFromResultSet(ResultSet rs) throws SQLException {
    Auto auto = null;
    if (rs.next()) {
      auto = new Auto();
      auto.setId_vehicul(rs.getString("id_vehicul"));
      auto.setModel(rs.getString("model"));
      auto.setAn(rs.getString("an"));
      auto.setCombustibil(rs.getString("combustibil"));
      auto.setTransmisie(rs.getString("transmisie"));
      auto.setPret(rs.getString("pret"));
    }
    return auto;
  }

  //*******************************
  //SELECT Auto
  //*******************************
  public static ObservableList<Auto> searchAutos () throws SQLException, ClassNotFoundException {
    //Declare a SELECT statement
    String selectStmt = "SELECT * FROM inventar_auto";

    //Execute SELECT statement
    try {
      //Get ResultSet from dbExecuteQuery method
      ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

      //Send ResultSet to the getEmployeeList method and get employee object
      ObservableList<Auto> autList = getAutoList(rs);

      //Return employee object
      return autList;
    } catch (SQLException e) {
      System.out.println("SQL select operation has been failed: " + e);
      //Return exception
      throw e;
    }
  }

  //Select * from employees operation
  private static ObservableList<Auto> getAutoList(ResultSet rs) throws SQLException, ClassNotFoundException {
    //Declare a observable List which comprises of Employee objects
    ObservableList<Auto> autList = FXCollections.observableArrayList();

    while (rs.next()) {
      Auto aut = new Auto();
      aut.setId_vehicul(rs.getString("id_vehicul"));
      aut.setModel(rs.getString("marca_model"));
      aut.setAn(rs.getString("an"));
      aut.setKm(rs.getString("km"));
      aut.setCombustibil(rs.getString("combustibil"));
      aut.setTransmisie(rs.getString("trasnmisie"));
      aut.setPret(rs.getString("pret"));

      //Add auto to the ObservableList
      autList.add(aut);

    }
    //return autList (ObservableList of Employees)
    return autList;
  }

  // DE adaptat codul la aplicatia mea
  //*************************************
  //UPDATE an employee's email address
  //*************************************
  public static void updateEmpEmail(String empId, String empEmail) throws SQLException, ClassNotFoundException {
    //Declare a UPDATE statement
    String updateStmt
            = "BEGIN\n"
            + "   UPDATE employees\n"
            + "      SET EMAIL = '" + empEmail + "'\n"
            + "    WHERE EMPLOYEE_ID = " + empId + ";\n"
            + "   COMMIT;\n"
            + "END;";

    //Execute UPDATE operation
    try {
      DBUtil.dbExecuteUpdate(updateStmt);
    } catch (SQLException e) {
      System.out.print("Error occurred while UPDATE Operation: " + e);
      throw e;
    }
  }

  //*************************************
  //DELETE an employee
  //*************************************
  public static void deleteAutoWithId(String empId) throws SQLException, ClassNotFoundException {
    //Declare a DELETE statement
    String updateStmt
            = "BEGIN\n"
            + "   DELETE FROM employees\n"
            + "         WHERE employee_id =" + empId + ";\n"
            + "   COMMIT;\n"
            + "END;";

    //Execute UPDATE operation
    try {
      DBUtil.dbExecuteUpdate(updateStmt);
    } catch (SQLException e) {
      System.out.print("Error occurred while DELETE Operation: " + e);
      throw e;
    }
  }

  //*************************************
  //INSERT an employee
  //*************************************
  public static void insertAuto(String model, String an, String km, String combustibil, String transmisie, String pret) throws SQLException, ClassNotFoundException {
    //Declare a DELETE statement
    String updateStmt = "INSERT INTO inventar_auto (id_vehicul, marca_model, an, km, combustibil, trasnmisie, pret, evaluare_mecanic) VALUES ( NULL, '" + model + "', '" + an + "','" + km + "','" + combustibil + "','" + transmisie + "','" + pret + "', '');";
      System.out.println(updateStmt);
    //Execute DELETE operation
    try {
      DBUtil.dbExecuteUpdate(updateStmt);
    } catch (SQLException e) {
      System.out.print("Error occurred while DELETE Operation: " + e);
      throw e;
    }
  }

}
