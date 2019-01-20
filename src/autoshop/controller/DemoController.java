/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoshop.controller;

import autoshop.model.AutoDAO;
import autoshop.util.DBUtil;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marius
 */
public class DemoController implements Initializable {

    ObservableList<String> options = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> add_ed_model;
    @FXML
    private TextField add_ed_an;
    @FXML
    private TextField add_ed_km;
    @FXML
    private TextField add_ed_pret;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private ComboBox<String> add_ed_trans;
    @FXML
    private ComboBox<String> add_ed_comb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fill_transmisie();
        fill_combustibil();
        fill_model();
    }

    @FXML
    private void save(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            AutoDAO.insertAuto(add_ed_model.getValue(), add_ed_an.getText(), add_ed_km.getText(), add_ed_comb.getValue(), add_ed_trans.getValue(),add_ed_pret.getText());
 //           resultArea.setText("Employee inserted! \n");
            System.out.println("added");
        } catch (SQLException e) {
//            resultArea.setText("Problem occurred while inserting employee " + e);
System.out.println("e");
            throw e;
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) cancel.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void fill_transmisie() {
        ObservableList<String> options = FXCollections.observableArrayList();
        try {
            String query = "Select * FROM " + "transmisie";
            ResultSet rs = DBUtil.dbExecuteQuery(query);
            while (rs.next()) {
                options.add(rs.getString("tip_transmisie"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        add_ed_trans.setItems(options);

    }

    public void fill_combustibil() {
        ObservableList<String> options = FXCollections.observableArrayList();
        try {
            String query = "Select * FROM " + "combustibil";
            ResultSet rs = DBUtil.dbExecuteQuery(query);
            while (rs.next()) {
                options.add(rs.getString("combustibil"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        add_ed_comb.setItems(options);

    }
        public void fill_model() {
        ObservableList<String> options = FXCollections.observableArrayList();
        try {
            String query = "Select * FROM " + "auto_model_marca";
            ResultSet rs = DBUtil.dbExecuteQuery(query);
            while (rs.next()) {
                options.add(rs.getString("model"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        add_ed_model.setItems(options);

    }

}
