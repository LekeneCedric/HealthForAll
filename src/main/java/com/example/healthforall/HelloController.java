package com.example.healthforall;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TabPane signBar;
    @FXML
    private Label info;

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
    protected void signIn()
    {
        String user;
        user = "Bienvenue "+signinUsername.getText() +" Mot de passe : "+signinPassword.getText();
        info.setText(user);
        
    }


}