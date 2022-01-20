package com.example.healthforall;

import com.example.healthforall.Models.Prescription;
import com.example.healthforall.Models.Traitement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class prescriptionController implements Initializable {
    @FXML
    public TableColumn<Traitement,String> codePatient;
    @FXML
    public TableColumn <Traitement,String> dateBilan;
    @FXML
    public TableColumn <Traitement,Integer> idPrescription;
    @FXML
    public TableColumn <Traitement,String> codeDocteur;
    @FXML
    public TableColumn <Traitement,String> DescriptionPrescription;
    @FXML
    public TableView PrescriptionTable;
    public TextField codeP;

    ObservableList<Prescription> PrescriptionList= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
loadList();
    }

    private void loadList() {
        refreahPrescription();
        try {
            idPrescription.setCellValueFactory(new PropertyValueFactory<>("ID"));
            codeDocteur.setCellValueFactory(new PropertyValueFactory<>("codeDoc"));
            codePatient.setCellValueFactory(new PropertyValueFactory<>("codeP"));
            dateBilan.setCellValueFactory(new PropertyValueFactory<>("date"));
            DescriptionPrescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        }
        catch (Exception e )
        {
            System.out.println(e);
        }
        }

    private void refreahPrescription() {
        try {
            PrescriptionList.clear();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall", "root", "");
            Statement stmt = connexion.createStatement();
            String query = "SELECT * FROM `prescription` ";
            PreparedStatement prepare = connexion.prepareStatement(query);
            ResultSet resultSet = prepare.executeQuery();
            while (resultSet.next())
            {

                PrescriptionList.add(new Prescription(
                        resultSet.getInt("IDPRESCRIPTION"),
                        resultSet.getString("CODEDOC"),
                        resultSet.getString("CODEP"),
                        resultSet.getString("DATE"),
                        resultSet.getString("DESCRIPTIONPRESCRIPTION")
                        )
                );
                PrescriptionTable.setItems(PrescriptionList);
            }
            prepare.close();
            resultSet.close();

        }
        catch (Exception e )
        {
            System.out.println(e);
        }
        }

    public void refresh(ActionEvent actionEvent) {
        try {
            String code = codeP.getText();
            PrescriptionList.clear();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall", "root", "");
            Statement stmt = connexion.createStatement();
            String query = "SELECT * FROM `prescription` WHERE CODEP LIKE '"+code+"'";
            PreparedStatement prepare = connexion.prepareStatement(query);
            ResultSet resultSet = prepare.executeQuery();
            while (resultSet.next()) {

                PrescriptionList.add(new Prescription(
                                resultSet.getInt("IDPRESCRIPTION"),
                                resultSet.getString("CODEDOC"),
                                resultSet.getString("CODEP"),
                                resultSet.getString("DATE"),
                                resultSet.getString("DESCRIPTIONPRESCRIPTION")
                        )
                );
                PrescriptionTable.setItems(PrescriptionList);
            }
            prepare.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
