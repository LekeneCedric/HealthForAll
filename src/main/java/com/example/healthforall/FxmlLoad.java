package com.example.healthforall;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


import java.net.URL;

public class FxmlLoad {
    private Pane view ;

    public Pane getView (String filename)
    {
        try {
            URL link =HelloApplication.class.getResource(filename+".fxml");
            if(link == null)
            {
                System.out.println("Erreur lors du chargement de la page");

            }
            new FXMLLoader();
            view = FXMLLoader.load(link);
        }
        catch(Exception e)
        {
            System.out.println("Erreur:"+e);
        }
        return view;
    }

}