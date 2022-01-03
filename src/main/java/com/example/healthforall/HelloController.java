package com.example.healthforall;


import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.mongodb.MongoClient;
import org.bson.Document;


public class HelloController {
    String uri = "mongodb://127.0.0.1:27017/?compressors=zlib&gssapiServiceName=mongodb";
    MongoClientURI clientURI = new MongoClientURI(uri);
    MongoClient mongoClient = new MongoClient(clientURI);

    MongoDatabase mongoDatabase = mongoClient.getDatabase("HealthForAll");
    MongoCollection auth = mongoDatabase.getCollection("authentification");
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

    }

    @FXML
    void covid(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void traitements(ActionEvent event) {

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
    @FXML
    protected void signIn()
    {
        String username = signinUsername.getText();
        String password = signinPassword.getText();
        Document found = (Document)auth.find(new Document("username",username)).first();
        if (found != null) {
            info.setText(" Utilisateur existant ! ");
        }
        else
        {
            info.setText(" Utilisateur non existant ");
        }
    }
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



}