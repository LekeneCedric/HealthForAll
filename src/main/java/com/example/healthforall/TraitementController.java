package com.example.healthforall;

import com.example.healthforall.Models.Traitement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class TraitementController implements Initializable {


    public VBox traitementLayout;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Traitement traitement = null;
    private List<Traitement> ListTraitement;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListTraitement = new ArrayList<>(loadTraitement());
        try{
            for(int i=0 ; i<ListTraitement.size();i++)
            {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("traitementItem.fxml"));
                 VBox treatmentBox = fxmlLoader.load();
                TraitementItemController treatmentItem = fxmlLoader.getController();
                treatmentItem.setData(ListTraitement.get(i));
                traitementLayout.getChildren().add(treatmentBox);
            }
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }

    }
    private List<Traitement> loadTraitement() {
        List<Traitement> traitementList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/healthforall", "root", "");
            query = "SELECT * FROM `traitement`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Traitement treatment= new Traitement();
                treatment.setId(resultSet.getInt("IDTRAITEMENT"));
                treatment.setNom(resultSet.getString("NOMTRAITEMENT"));
                treatment.setCodeDoc(resultSet.getString("CODEDOC"));
                treatment.setAdressImage( resultSet.getString("IMAGE"));
                treatment.setDescription(resultSet.getString("DESCRIPTIONTRAITEMENT"));
                traitementList.add(treatment);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (Exception e) {
           System.out.println(e);
        }
        return traitementList;
    }
}
