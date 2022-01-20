package com.example.healthforall;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomeController {

    public BorderPane borderPane;
    public PasswordField BilanSanteClientCode;
    public TextField BilanSanteClientName;
    public TextArea BilanSanteDescription;
    public Button close;

    public void bilanSante(ActionEvent actionEvent) {
        FxmlLoad page1 = new FxmlLoad();
        Pane View1 = page1.getView("Bilan de Sante");
        borderPane.setCenter(View1);
    }
    public void traitementPage(ActionEvent actionEvent) {
        FxmlLoad page3 = new FxmlLoad();
        Pane View3 = page3.getView("traitements");
        borderPane.setCenter(View3);
    }


    public void prescriptions(ActionEvent actionEvent) {
        FxmlLoad page4 = new FxmlLoad();
        Pane View4 = page4.getView("prescriptionMedicale");
        borderPane.setCenter(View4);
    }

    public void exit(ActionEvent actionEvent) {
        Stage stage  = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void testcovid(ActionEvent actionEvent) {
        FxmlLoad page2 = new FxmlLoad();
        Pane View2 = page2.getView("covidtest");
        borderPane.setCenter(View2);
    }

    public void SendBilanSante(ActionEvent actionEvent) {
        String BilanCode = BilanSanteClientCode.getText();
        String BilanName = BilanSanteClientName.getText();
        String BilanDescription = BilanSanteDescription.getText();
        String dateActuel = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        PreparedStatement statement = null;

        ResultSet resultat;


        try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/healthforall","root","");

                if(BilanCode!="" & BilanName!="" & BilanDescription!="")
                {
                    String addBilan = "insert into bilan(DATE,CONSULTER,CODEP,DESCRIPTIONBILAN)" + "values(?,?,?,?)";
                    PreparedStatement preparedStm = con.prepareStatement(addBilan);
                    preparedStm.setString(1, dateActuel);
                    preparedStm.setString(2, "non");
                    preparedStm.setString(3,BilanCode );
                    preparedStm.setString(4, BilanDescription);
                    preparedStm.execute();
                    con.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Succes");
                    alert.setHeaderText(null);
                    alert.setContentText("Enregistrement effectue");
                    alert.showAndWait();
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Formulaire invalide");
                    alert.setHeaderText(null);
                    alert.setContentText("Formulaire invalide ! Verifier a nouveaux les champs de saisies");
                    alert.showAndWait();
                }



            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }


}

