package com.example.healthforall;

import com.example.healthforall.Models.Traitement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class TraitementDocteur implements Initializable {
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Traitement traitement = null;

    @FXML
    TableView<Traitement> traitementTable;
    @FXML
    TableColumn<Traitement,Integer> IDCol ;
    @FXML
    TableColumn<Traitement,String>NomCol ;
    @FXML
    TableColumn<Traitement,String>CodeCol ;
    @FXML
    TableColumn<Traitement,String>AdressCol ;
    @FXML
    TableColumn<Traitement,String>DescriptionCol ;
    ObservableList<Traitement> TraitementList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       LoadList();
    }

    private void LoadList() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall", "root", "");
            refreshTraitement();
            IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            NomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            CodeCol.setCellValueFactory(new PropertyValueFactory<>("codeDoc"));
            AdressCol.setCellValueFactory(new PropertyValueFactory<>("adressImage"));
            DescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        }
        catch (Exception e)
        {
System.out.println(e);
        }

    }


    public void addTraitement(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("AddTraitement.fxml"));
            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
    }

    public void refreshTraitement() throws ClassNotFoundException {
        try {
            TraitementList.clear();
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall", "root", "");
            query = "SELECT * FROM `traitement`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TraitementList.add(new Traitement(
                        resultSet.getInt("IDTRAITEMENT"),
                        resultSet.getString("CODEDOC"),
                        resultSet.getString("NOMTRAITEMENT"),
                        resultSet.getString("IMAGE"),
                        resultSet.getString("DESCRIPTIONTRAITEMENT")
                ));
                traitementTable.setItems(TraitementList);
            }
            preparedStatement.close();
            resultSet.close();connection.close();
        } catch (Exception e) {
        System.out.println(e);
        }
    }
}
