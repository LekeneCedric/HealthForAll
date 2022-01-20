package com.example.healthforall;

import com.example.healthforall.Models.patient;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class afficheclientController<Patient> implements Initializable {
    public TextField codepatient;
    public Button searchbutton;
    @FXML
    private TableColumn<patient, Integer> agep;

    @FXML
    private TableColumn<patient,String> codep;

    @FXML
    private TableColumn<patient, String> etatp;

    @FXML
    private TableColumn<patient, String> nomp;

    @FXML
    private TableColumn<patient, Float> poidsp;

    @FXML
    private TableColumn<patient, String> prenomp;

    @FXML
    private TableView<patient> tabp;

    @FXML
    private TableColumn<patient, Float> taillep;



    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    patient Patient = null;
    ObservableList<patient> Patientlist = FXCollections.observableArrayList();
    private  void loadforn()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthforall","root","");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        try {
            refresh();
        }
        catch (Exception er)
        {
            System.out.println(er);
        }

        codep.setCellValueFactory(new PropertyValueFactory<patient,String>("code"));
        nomp.setCellValueFactory(new PropertyValueFactory<patient, String>("nom"));
        prenomp.setCellValueFactory(new  PropertyValueFactory<patient,String>("prenom"));
        agep.setCellValueFactory(new PropertyValueFactory<patient,Integer>("age"));
        taillep.setCellValueFactory(new PropertyValueFactory<patient,Float>("taille"));
        poidsp.setCellValueFactory(new  PropertyValueFactory<patient,Float>("poids"));
        etatp.setCellValueFactory(new  PropertyValueFactory<patient,String>("etat"));
    }


    public void refresh() throws SQLException {
        Patientlist.clear();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthforall","root","");
        query = "SELECT * FROM patient";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Patientlist.add(new patient(
                    resultSet.getString("CODEP"),
                    resultSet.getString("NOMP"),
                    resultSet.getString("PRENOMP"),
                    resultSet.getInt("AGEP"),
                    resultSet.getFloat("TAILLEP"),
                    resultSet.getFloat("POIDSP"),
                    resultSet.getString("ETATCOVIDP")));
            tabp.setItems(Patientlist);
        }
        preparedStatement.close();
        resultSet.close();

    }
    public  void searchx() throws SQLException {
        Patientlist.clear();
        String codes = codepatient.getText();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthforall","root","");
        query = "select * from patient where CODEP= '"+ codes+"' ";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Patientlist.add(new patient(
                    resultSet.getString("CODEP"),
                    resultSet.getString("NOMP"),
                    resultSet.getString("PRENOMP"),
                    resultSet.getInt("AGEP"),
                    resultSet.getFloat("TAILLEP"),
                    resultSet.getFloat("POIDSP"),
                    resultSet.getString("ETATCOVIDP")));
            tabp.setItems(Patientlist);
        }
        preparedStatement.close();
        resultSet.close();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadforn();
    }

    public void search(ActionEvent actionEvent) throws SQLException {

    searchx();
    }

    public void actualise(ActionEvent actionEvent) throws SQLException {
    refresh();
    }
}
