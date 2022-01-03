package com.example.healthforall;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URI;
import java.net.URL;

public class FxmlLoader {
    private Pane view ;

    public Pane getView (String filename)
    {
            try {
                    URL link =HelloApplication.class.getResource("src/main/resources/com.example.healthforall/"+filename+".fxml");
                    if(link == null)
                    {
                        System.out.println("Erreur lors du chargement de la page");

                    }
                    view = new FXMLLoader().load(link);
            }
            catch(Exception e)
            {
               System.out.println("Erreur lors du chargement de la page");
            }
            return view;
    }

}
