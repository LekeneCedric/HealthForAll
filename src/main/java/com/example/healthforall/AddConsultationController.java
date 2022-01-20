package com.example.healthforall;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddConsultationController {

    public TextField codeDoc;
    public TextField codePat;
    public TextArea prescription;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void prescrire(ActionEvent actionEvent){
        String dateActuel = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        String Codedoc =codeDoc.getText();
        String Codepat = codePat.getText();
        String Prescription = prescription.getText();
        if(Codedoc=="" || Codepat == "" || Prescription == "")
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Formulaire invalide");
            alert.setHeaderText(null);
            alert.setContentText("Formulaire invalide ! Verifier a nouveaux les champs de saisies");
            alert.showAndWait();
        }
        else
        {
            try
            {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/healthforall","root","");
                String addPrescription = "insert into prescription(CODEDOC,CODEP,DESCRIPTIONPRESCRIPTION,DATE)" + "values(?,?,?,?)";
                PreparedStatement preparedStm = connection.prepareStatement(addPrescription);
                preparedStm.setString(1,Codedoc);
                preparedStm.setString(2,Codepat);
                preparedStm.setString(3,Prescription );
                preparedStm.setString(4,dateActuel);
                preparedStm.execute();
                String addConsutl = "UPDATE bilan SET"+"`CONSULTER`=?"+"WHERE CODEP ='"+Codepat+"'";
                PreparedStatement modif = connection.prepareStatement(addConsutl);
                modif.setString(1,"oui");
                modif.executeUpdate();
                connection.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setHeaderText(null);
                alert.setContentText("Traitement envoye avec success");
                alert.showAndWait();
            }
            catch(Exception e)
            {
              System.out.println(e);
            }
        }

    }

    public void clean(ActionEvent actionEvent) {
    }

    public void closePrescription(MouseEvent mouseEvent) {
        Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
