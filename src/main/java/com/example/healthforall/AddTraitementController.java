package com.example.healthforall;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;

public class AddTraitementController {
    @FXML
    public TextField traitementName;
    @FXML
    public TextField doctorCode;
    @FXML
    public TextField adressImage;
    @FXML
    public TextArea descriptionTraitement;




    public void NewTraitement(){
         String nom= traitementName.getText();
        String code = doctorCode.getText();
        String img = adressImage.getText();
        String description = descriptionTraitement.getText();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/healthforall", "root", "");
        Statement stmt = connexion.createStatement();
        String addTraitement = "insert into traitement(CODEDOC,NOMTRAITEMENT,IMAGE,DESCRIPTIONTRAITEMENT)" + "values(?,?,?,?)";
        PreparedStatement preparedStatement =connexion.prepareStatement(addTraitement);
        preparedStatement.setString(1,code);
        preparedStatement.setString(2,nom);
        preparedStatement.setString(3,img);
        preparedStatement.setString(4,description);
        preparedStatement.execute();
        connexion.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText(null);
        alert.setContentText("Traitement Ajouter avec success");
        alert.showAndWait();}
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void reset() {
        traitementName.setText("");
        doctorCode.setText("");
        adressImage.setText("");
        descriptionTraitement.setText("");
    }

    public void exit(MouseEvent mouseEvent) {
        Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
