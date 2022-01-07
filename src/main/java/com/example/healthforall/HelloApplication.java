package com.example.healthforall;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)  {

      try{
          FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-signin-view.fxml"));
          Scene scene = new Scene(fxmlLoader.load());
          stage.setTitle("HealthForAll");
          stage.getIcons();
          stage.setScene(scene);
          stage.show();
      }catch (Exception e){}
    }

    public static void main(String[] args) {
        launch();
    }
}