package autoshop.controller;

import autoshop.model.Auto;
import autoshop.model.AutoDAO;
import autoshop.util.DBUtil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.stage.Modality;

public class AutoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem close1;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem help;

    @FXML
    private Tab tab_clienti;

    @FXML
    private Button u_tranzactii;

    @FXML
    private Button c_tranzactii;

    @FXML
    private Button d_tranzactii;

    @FXML
    private Button r_tranzactii;

    @FXML
    private TextArea result_tranzactii;

    @FXML
    private TableView<?> tabel_tranzactii;

    @FXML
    private TableColumn<?, ?> column_id_tranzactie;

    @FXML
    private TableColumn<?, ?> column_masina;

    @FXML
    private TableColumn<?, ?> column_client;

    @FXML
    private TableColumn<?, ?> column_data;

    @FXML
    private TableColumn<?, ?> column_agent;

    @FXML
    private Tab tab_masini;

    @FXML
    private Button u_masina;

    @FXML
    private Button c_masina;

    @FXML
    private Button d_masina;

    @FXML
    private Button ed_masina;

    @FXML
    private TextArea result_inventar;

    @FXML
    private TableView<Auto> tabel_inventar;

    @FXML
    private TableColumn<Auto, String> column_id_vehicul;

    @FXML
    private TableColumn<Auto, String> column_marca_model;

    @FXML
    private TableColumn<Auto, String> column_an;

    @FXML
    private TableColumn<Auto, String> column_km;

    @FXML
    private TableColumn<Auto, String> column_combustibil;

    @FXML
    private TableColumn<Auto, String> column_transmisie;

    @FXML
    private TableColumn<Auto, String> column_pret;

    @FXML
    private Tab tab_modele;

    @FXML
    private Button u_model;

    @FXML
    private Button c_model;

    @FXML
    private Button d_model;

    @FXML
    private Button ed_model;

    @FXML
    private TextArea result_modele;

    @FXML
    private TableView<?> tabel_modele;

    @FXML
    private TableColumn<?, ?> marca;

    @FXML
    private TableColumn<?, ?> model_marca;

    @FXML
    private Button u_clienti;

    @FXML
    private Button add_clienti;

    @FXML
    private Button d_client;

    @FXML
    private Button ed_client;

    @FXML
    private TextArea result_clienti;

    @FXML
    private TableView<?> tabel_client;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> nume;

    @FXML
    private TableColumn<?, ?> prenume;

    @FXML
    private TableColumn<?, ?> cnp;

    @FXML
    private TableColumn<?, ?> telefon;

    @FXML
    private Tab tab_agenti;

    @FXML
    private Button u_agenti;

    @FXML
    private Button ad_agent;

    @FXML
    private Button d_agent;

    @FXML
    private Button ed_agent;

    @FXML
    private TextArea result_agenti;

    @FXML
    private TableView<?> tabel_agenti;

    @FXML
    private TableColumn<?, ?> nume_ag;

    @FXML
    private TableColumn<?, ?> prenume_ag;

    @FXML
    private TableColumn<?, ?> cnp_ag;

    @FXML
    private TableColumn<?, ?> telefon_ag;

    @FXML
    void add_agent(ActionEvent event) {

    }

    @FXML
    void add_client(ActionEvent event) {

    }

    @FXML
    void add_masina(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("create.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fXMLLoader.load());
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Creare");
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println("nu merge" + " " + e);
        }
    }

    @FXML

    void add_model(ActionEvent event) {

    }

    @FXML
    void add_tranzactie(ActionEvent event) {

    }

    @FXML
    void delete_agent(ActionEvent event) {

    }

    @FXML
    void delete_client(ActionEvent event) {

    }

    @FXML
    void delete_masina(ActionEvent event) throws ClassNotFoundException, SQLException {
        Auto auto = tabel_inventar.getSelectionModel().getSelectedItem();
        String id = auto.getId_vehicul();
        try {
            AutoDAO.deleteAutoWithId(id);
            result_inventar.setText("Auto deleted! Employee id: " + id + "\n");
        } catch (SQLException e) {
            result_inventar.setText("Problem occurred while deleting auto " + e);
            throw e;
        }
    }

    @FXML
    void delete_model(ActionEvent event) {

    }

    @FXML
    void delete_tranzactie(ActionEvent event) {

    }

    @FXML
    void edit_agent(ActionEvent event) {

    }

    @FXML
    void edit_client(ActionEvent event) {

    }

    @FXML
    void edit_model(ActionEvent event) {

    }

    @FXML
    void edit_tranzactie(ActionEvent event) {

    }

    @FXML
    void edt_masina(ActionEvent event) {
        System.out.println("ksdfhn");
        Auto auto = tabel_inventar.getSelectionModel().getSelectedItem();
        String id = auto.getId_vehicul();
        System.out.println(id);
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("edit.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fXMLLoader.load());
            ObservableList<String> options = FXCollections.observableArrayList();
            try {
                String query = "SELECT * FROM `inventar_auto` WHERE id_vehicul= " + id;
                ResultSet rs = DBUtil.dbExecuteQuery(query);
                while (rs.next()) {
                    Auto aut = new Auto();
                    aut.setId_vehicul(rs.getString("id_vehicul"));
                    aut.setModel(rs.getString("marca_model"));
                    aut.setAn(rs.getString("an"));
                    aut.setKm(rs.getString("km"));
                    aut.setCombustibil(rs.getString("combustibil"));
                    aut.setTransmisie(rs.getString("trasnmisie"));
                    aut.setPret(rs.getString("pret"));
                   //  incarca valorile randului selectat in fereastra edit 
                    EditController editcontroller = fXMLLoader.getController();
                    editcontroller.parsid(aut.getId_vehicul());
                    editcontroller.parsemodel(aut.getModel());
                    editcontroller.parsean(aut.getAn());
                    editcontroller.parsekm(aut.getKm());
                    editcontroller.parsecomb(aut.getCombustibil());
                    editcontroller.parsetransms(aut.getTransmisie());
                    editcontroller.parsepret(aut.getPret());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Creare");
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println("nu merge" + " " + e);
        }

    }

    @FXML
    void handle_exit(ActionEvent event) {

    }

    @FXML
    void handle_help(ActionEvent event) {

    }

    @FXML
    void select_agenti(ActionEvent event) {

    }

    @FXML
    void select_masina(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            /* Get all Employees information */
            ObservableList<Auto> autList = AutoDAO.searchAutos();
            /* Populate Employees on TableView */
            populateAuto(autList);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting autos information from DB.\n" + e);
            throw e;
        }

    }

    @FXML
    void select_model(ActionEvent event) {

    }

    @FXML
    void select_tranzactie(ActionEvent event) {

    }

    @FXML
    void slect_clienti(ActionEvent event) {

    }

    @FXML
    void initialize() {

        //initializare date in tabe- cand porneste aplicatia
        column_id_vehicul.setCellValueFactory(cellData -> cellData.getValue().id_vehiculProperty());
        column_marca_model.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        column_an.setCellValueFactory(cellData -> cellData.getValue().anProperty());
        column_km.setCellValueFactory(cellData -> cellData.getValue().kmProperty());
        column_combustibil.setCellValueFactory(cellData -> cellData.getValue().combustibilProperty());
        column_transmisie.setCellValueFactory(cellData -> cellData.getValue().transmisieProperty());
        column_pret.setCellValueFactory(cellData -> cellData.getValue().pretProperty());
        // astea au fost coloanele pt tabelul inventar

    }

    @FXML
    private void populateAuto(ObservableList<Auto> autList) throws ClassNotFoundException {
        //Set items to the tabel Inventar
        tabel_inventar.setItems(autList);
    }

    public void infoSelectieTabel(String id) {
        System.out.println(id);
        ObservableList<String> options = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM `inventar_auto` WHERE id_vehicul= " + "id";
            ResultSet rs = DBUtil.dbExecuteQuery(query);
            while (rs.next()) {
                Auto aut = new Auto();
                aut.setId_vehicul(rs.getString("id_vehicul"));
                aut.setModel(rs.getString("marca_model"));
                aut.setAn(rs.getString("an"));
                aut.setKm(rs.getString("km"));
                aut.setCombustibil(rs.getString("combustibil"));
                aut.setTransmisie(rs.getString("trasnmisie"));
                aut.setPret(rs.getString("pret"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
