package com.example.healthforall;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class DocteurController {
    static int tentative =0;
    @FXML
    public BorderPane borderPaneDocteur;
    public Label username;

    public void PrescriptionPatient(ActionEvent actionEvent) {

    }

    public void EtatPatient(ActionEvent actionEvent) {
        FxmlLoad page = new FxmlLoad();
        Pane View = page.getView("EtatPatient");
        borderPaneDocteur.setCenter(View);
    }

    public void TraitementPatient(ActionEvent actionEvent) {
        FxmlLoad page2 = new FxmlLoad();
        Pane View2 = page2.getView("TraitementDocteur");
        borderPaneDocteur.setCenter(View2);
    }

    public void exitDocteur(ActionEvent actionEvent) {
        Stage stage  = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void addDoctor(MouseEvent mouseEvent) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("signupDoctor.fxml"));
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    public PasswordField signinPassword;
    public Label message;
    public Button sigindocc;

    public boolean dejaexistin(String code) {
        int i = 0;
        String codec = signinPassword.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall", "root", "");
            Statement stmt = con.createStatement();
            System.out.println("Connection Reussit !");
            String query = "select NOMDOC from `docteur` where CODEDOC ='" + codec + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                i = 1;
                username.setText(rs.getString("NOMDOC"));
            } else {
                i = 0;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void connexion(ActionEvent actionEvent) throws IOException, ClassNotFoundException, SQLException {
        String code = signinPassword.getText();

        if (code != "")
        {
            boolean test1 = dejaexistin(code);
            if (test1 == true)
            {
                Parent root = FXMLLoader.load(getClass().getResource("DoctorView.fxml"));
                Stage windows = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                windows.setScene(new Scene(root));

            }
            else if(tentative == 2)
            {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Intrusion");
                alert.setHeaderText(null);
                alert.setContentText("Vous avez tentez de vous connecter trop de fois Pour plus de Securite nous allons vous arreter l'application  ");
                alert.showAndWait();
                Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                stage.close();
            }
            else
            {
                int rest = 2 - tentative;
                tentative+=1;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Connexion");
                alert.setHeaderText(null);
                alert.setContentText("Personnel introuvable il vous reste "+rest+"Tentatives");
                alert.showAndWait();
            }
        }


    }

    public void switchSingInPatient(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        Stage windows = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        windows.setScene(new Scene(root));

    }

    public void exit(MouseEvent mouseEvent) {
        Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    public TextField signupNomDocteur;
    public TextField signupCodeDocteur;
    public TextField signupPrenomDocteur;
    public TextField signupNumeroDocteur;
    public TextField signupSpecialiteDocteur;
    public PasswordField signupReMotDePasseDocteur;
    public PasswordField signupMotDePasseDocteur;
    public Button inscriptionDocteur;

    public boolean dejaexist(String code) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall", "root", "");
            Statement stmt = con.createStatement();
            System.out.println("Connection Reussit !");
            String query = "select NOMDOC from docteur where CODEDOC ='" + code + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                i = 0;
                username.setText(rs.getString("NOMDOC"));
            } else {
                i = 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        if (i == 1)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }
    public void switchconnexion(ActionEvent actionEvent) {
    }

    public void inscriptions(ActionEvent actionEvent) {
        String nom = signupNomDocteur.getText();
        String prenom = signupPrenomDocteur.getText();
        int numero = Integer.parseInt(signupNumeroDocteur.getText());
        String specialite = signupSpecialiteDocteur.getText();
        String code = signupCodeDocteur.getText();
        if (nom!="" & prenom!="" & numero > 0 & code!="" ) {

            boolean test1 = dejaexist(code);
            if (test1 == true) {

                try {


                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/healthforall", "root", "");
                    Statement stmt = con.createStatement();
                    String query = "insert into docteur(CODEDOC ,NOMDOC ,PRENOMDOC ,NUMERODOC ,SPECIALITEDOC)" + "values(?,?,?,?,?)";
                    PreparedStatement preparedStm = con.prepareStatement(query);
                    preparedStm.setString(1, code);
                    preparedStm.setString(2, nom);
                    preparedStm.setString(3, prenom);
                    preparedStm.setInt(4, numero);
                    preparedStm.setString(5, specialite);
                    preparedStm.execute();
                    con.close();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Inscription");
                    alert.setHeaderText(null);
                    alert.setContentText("Inscription Reussi ! Utilisateur enregistre avec succes");
                    alert.showAndWait();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Inscription");
                alert.setHeaderText(null);
                alert.setContentText("Utilisateur deja existant dans la base de donnee ! ");
                alert.showAndWait();
            }
        }
    }

    public void exitSignUpDoctor(MouseEvent mouseEvent) {
        Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void ListePatient(ActionEvent actionEvent) {
        FxmlLoad page = new FxmlLoad();
        Pane View = page.getView("afficheclient");
        borderPaneDocteur.setCenter(View);
    }
}
