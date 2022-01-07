package com.example.healthforall;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
<<<<<<< Updated upstream
=======
import javafx.scene.Parent;
>>>>>>> Stashed changes
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.bson.Document;


public class HelloController{
    String uri = "mongodb://127.0.0.1:27017/?compressors=zlib&gssapiServiceName=mongodb";
    MongoClientURI clientURI = new MongoClientURI(uri);
    MongoClient mongoClient = new MongoClient(clientURI);

    MongoDatabase mongoDatabase = mongoClient.getDatabase("HealthForAll");
    MongoCollection auth = mongoDatabase.getCollection("authentification");
    @FXML
    protected BorderPane borderPane;
    @FXML
    private Button bilanSante;

    @FXML
    private Button exit;

    @FXML
    private Button testCovid;

    @FXML
    private Button traitements;

    @FXML
    void bilan(ActionEvent event) {
    FxmlLoader page = new FxmlLoader();
    Pane View = page.getView("bilan");
    borderPane.setCenter(View);

    }

    @FXML
    void covid(ActionEvent event) {
        FxmlLoader page = new FxmlLoader();
        Pane View = page.getView("covidtest");
        borderPane.setCenter(View);
    }

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void traitements(ActionEvent event) {
        FxmlLoader page = new FxmlLoader();
        Pane View = page.getView("traitements");
        borderPane.setCenter(View);
    }

    @FXML
    private TabPane signBar;
    @FXML
    private Label info;
    @FXML
    private Label labeltest;

    @FXML
    private Button signIn;

    @FXML
    private TextField signinPassword;

    @FXML
    private Tab signinTab;

    @FXML
    private TextField signinUsername;

    @FXML
    private TextField signupEmail;

    @FXML
    private TextField signupLastname;

    @FXML
    private TextField signupPassword;

    @FXML
    private Tab signupTab;

    @FXML
    private TextField signupUsername;

    @FXML
    private Button switchsignin;

    @FXML
    private Button switchsignup;
    @FXML
    private Label registerMessage;
<<<<<<< Updated upstream
    @FXML
    protected void signIn()
    {
        String username = signinUsername.getText();
        String password = signinPassword.getText();
        Document found = (Document)auth.find(new Document("password",password)).first();
        if (found != null) {
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
            }
            catch (Exception e)
            {

            }

        }
        else
        {
            info.setText(" Utilisateur non existant ");
        }
    }
=======

>>>>>>> Stashed changes
    @FXML
    protected void signUp()
    {
        String username = signupUsername.getText();
        String lastname = signupLastname.getText();
        String password = signupPassword.getText();
        String email = signupEmail.getText();
        Document document = new Document();
        document.append("username",username);
        document.append("lastname",lastname);
        document.append("email",email);
        document.append("password",password);
        try{

            auth.insertOne(document);
            registerMessage.setText("Utilisateur creer avec success");
           }
        catch (Exception e)
        {
            registerMessage.setText(e.getMessage());

        }

    }

    public void connexion(ActionEvent actionEvent) {
         ;
        String username = signinUsername.getText();
        String password = signinPassword.getText();
        Document found = (Document)auth.find(new Document("username",username)).first();
        if (found != null) {
            Stage stage = new Stage();
            try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Main Menu");
            stage.getIcons();
            stage.setScene(scene);
            stage.show();}
            catch(Exception e)
            {

            }
        }
        else
        {

        }
    }

}