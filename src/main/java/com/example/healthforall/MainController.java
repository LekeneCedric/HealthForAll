package com.example.healthforall;

import com.example.healthforall.Models.Prescription;
import com.example.healthforall.Models.Traitement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainController {
    static int tentative=0;
    public Button inscrivezvous;
    public Button connectezvous;
    public TextField signupNom;
    public TextField signupPoids;
    public TextField signupPrenom;
    public TextField signupAge;
    public TextField signupTaille;
    public TextField signupCode;
    public PasswordField signupRePassword;
    public PasswordField signupPassword;
    public TextField signinUsername;
    public PasswordField signinPassword;
    public Label message;
    public AnchorPane PrincipalScreen;
    static Label username;
    static String pass;
    static String Name ;
    @FXML
    public  Label AccusalName;

    public void initialize() {
        loadList();
    }
    public void switchinscription(ActionEvent actionEvent) throws IOException {

        AnchorPane pane= FXMLLoader.load(getClass().getResource("signup.fxml"));
        PrincipalScreen.getChildren().setAll(pane);
    }

    public void switchconnexion(ActionEvent actionEvent) throws  IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        Stage windows = (Stage) connectezvous.getScene().getWindow();
        windows.setScene(new Scene(root));
    }


public int connexion(ActionEvent actionEven) throws IOException {

    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/healthforall","root","");
        Statement stmt=con.createStatement();

        String nom = signinUsername.getText();
        String password = signinPassword.getText();
        String loginname = nom;
        pass = password;
        Name = nom;



        if(nom != "" & password != "")
        {
            try{
                // Vérifier si le nom existe dans la table "utilisateurs"
                ResultSet rs=stmt.executeQuery("Select NOMP,PASSWORD from `patient` where NOMP like '"+nom+"' AND PASSWORD like '"+password+"'");

                if(rs.next()){

                    Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
                    Stage windows = (Stage) inscrivezvous.getScene().getWindow();
                    windows.setScene(new Scene(root));




                }
                else if(tentative==2)
                {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Compte Controle");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous avez depasse le nombre de tentatives ! Pour plus de securite nous allons arreter l'application");
                    alert.showAndWait();
                    Stage stage = (Stage)((Node) actionEven.getSource()).getScene().getWindow();
                    stage.close();
                }
                else
                {
                    int rest = 2-tentative;
                    tentative+=1;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Compte Controle");
                    alert.setHeaderText(null);
                    alert.setContentText("Compte innexistant il vous reste "+rest+" Essaies ! ");
                    alert.showAndWait();
                }
            }catch(Exception err)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Connexion");
                alert.setHeaderText(null);
                alert.setContentText("Erreur lors de la connexion de l'utilisateur veillez reessayer");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champs de Saisie vides");
            alert.setHeaderText(null);
            alert.setContentText("Attention remplissez correctement les champs de saisies en respectant les consignes");
            alert.showAndWait();
        }
        con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }

    setWelcomeName();
    return 0;

}
public void setWelcomeName()
{
    AccusalName.setText(Name);
}


    public void inscription(ActionEvent actionEvent) {
        String nom = signupNom.getText();
        String prenom = signupPrenom.getText();
        int age = Integer.parseInt(signupAge.getText());
        float taille = Float.parseFloat(signupTaille.getText());
        float poids = Float.parseFloat(signupPoids.getText());
        String code = signupCode.getText();
        String password = signupPassword.getText();

        if (nom!="" & prenom!="" & age>0 & taille>0 & poids>0 & code!="" & password !="" )
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/healthforall", "root", "");
                Statement stmt = con.createStatement();
                String createuser = "insert into patient(CODEP,NOMP,PRENOMP,AGEP,TAILLEP,POIDSP,ETATCOVIDP,PASSWORD)" + "values(?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStm = con.prepareStatement(createuser);
                preparedStm.setString(1, code);
                preparedStm.setString(2, nom);
                preparedStm.setString(3, prenom);
                preparedStm.setInt(4, age);
                preparedStm.setFloat(5, taille);
                preparedStm.setFloat(6, poids);
                preparedStm.setString(7, "Non");
                        preparedStm.setString(8, password);
                preparedStm.execute();
                con.close();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Enregistrement");
                alert.setHeaderText(null);
                alert.setContentText("Utilisateur enregistrer avec Success");
                alert.showAndWait();

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Inscription");
                alert.setHeaderText(null);
                alert.setContentText("Erreur lors de l'inscription de l'utilisateur");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inscription");
            alert.setHeaderText(null);
            alert.setContentText("Respectez les consignes de remplissage");
            alert.showAndWait();
        }
    }

    public void switchSingInDoctor(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("signinDoctor.fxml"));
        Stage windows = (Stage) inscrivezvous.getScene().getWindow();
        windows.setScene(new Scene(root));

    }

    public void exiticon(MouseEvent mouseEvent) {
        Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
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
                PreparedStatement preparedStm2 = con.prepareStatement(addBilan);
                preparedStm2.setString(1, dateActuel);
                preparedStm2.setString(2, "non");
                preparedStm2.setString(3,BilanCode );
                preparedStm2.setString(4, BilanDescription);
                preparedStm2.execute();
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
    /* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ */

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
                String password = pass;
                PrescriptionList.clear();
                Class.forName("com.mysql.jdbc.Driver");
                Connection connexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/healthforall", "root", "");
                Connection connexion2 = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/healthforall", "root", "");
                Statement stmt = connexion.createStatement();
                String query1 = "SELECT * FROM `patient` WHERE  PASSWORD LIKE '"+password+"'";

                PreparedStatement prepare1 = connexion.prepareStatement(query1);
                ResultSet resultSet1 = prepare1.executeQuery();

                    while (resultSet1.next()) {
                        String query2 = "SELECT * FROM `prescription` WHERE CODEP LIKE '" + resultSet1.getString("CODEP") + "'";
                        PreparedStatement prepare2 = connexion2.prepareStatement(query2);
                        ResultSet resultSet2 = prepare2.executeQuery();
                        while (resultSet2.next()) {

                            PrescriptionList.add(new Prescription(
                                            resultSet2.getInt("IDPRESCRIPTION"),
                                            resultSet2.getString("CODEDOC"),
                                            resultSet2.getString("CODEP"),
                                            resultSet2.getString("DATE"),
                                            resultSet2.getString("DESCRIPTIONPRESCRIPTION")
                                    )
                            );
                            PrescriptionTable.setItems(PrescriptionList);
                        }
                        prepare2.close();
                        resultSet2.close();
                    }
                    prepare1.close();
                    resultSet1.close();
                }
                catch (Exception e)
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


