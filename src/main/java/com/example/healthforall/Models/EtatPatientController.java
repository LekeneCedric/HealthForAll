package com.example.healthforall;

import com.example.healthforall.Models.Bilan;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class EtatPatientController implements Initializable {

    public TextField codeDoc;
    public TextField codePat;
    public TextArea prescription;
    public Label BilanDescription;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void prescrire(ActionEvent actionEvent){
        String Codedoc =codeDoc.getText();
        String Codepat = codePat.getText();
        String Prescription = prescription.getText();
        if(Codedoc=="" || Codepat == "" || Prescription == "")
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Formulaire invalide");
            alert.setHeaderText(null);
            alert.setContentText("Formulaire invalide ! Verifier a nouveaux les champs de saisies");
            alert.showAndWait();
        }
        else
        {
            try
            {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/healthforall","root","");
                String addPrescription = "insert into prescription(CODEDOC,CODEP,DESCRIPTIONPRESCRIPTION)" + "values(?,?,?)";
                PreparedStatement preparedStm = connection.prepareStatement(addPrescription);
                preparedStm.setString(1,Codedoc);
                preparedStm.setString(2,Codepat);
                preparedStm.setString(3,Prescription );
                preparedStm.execute();
                String addConsutl = "UPDATE bilan SET"+"`CONSULTER`=?"+"WHERE CODEP ='"+Codepat+"'";
                PreparedStatement modif = connection.prepareStatement(addConsutl);
                modif.setString(1,"oui");
                modif.executeUpdate();
                connection.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setHeaderText(null);
                alert.setContentText("Traitement envoye avec success");
                alert.showAndWait();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }

    public void clean(ActionEvent actionEvent) {
    }

    public void closePrescription(MouseEvent mouseEvent) {
        Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }



    @FXML
    TableView <Bilan> BilanTable;
    @FXML
    TableColumn<Bilan,String> idPCol;
    @FXML
    TableColumn<Bilan,String> codeBilCol;
    @FXML
    TableColumn<Bilan,String>dateCol;
    @FXML
    TableColumn<Bilan,String> descriptionCol;
    @FXML
     TableColumn<Bilan,String>consulterCol;
    @FXML
    ObservableList<Bilan> BilanList = FXCollections.observableArrayList();


    private void setValueFromTable()
    {
        BilanTable.setOnMouseClicked(e-> {

            Bilan bilan = BilanTable.getItems().get(BilanTable.getSelectionModel().getSelectedIndex());
            BilanDescription.setText(bilan.getDescription());

        });
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadList();
        setValueFromTable();
    }

    private void loadList() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall", "root", "");
            refreshTable();
            idPCol.setCellValueFactory(new PropertyValueFactory<>("codeP"));
            codeBilCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
            descriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
            consulterCol.setCellValueFactory(new PropertyValueFactory<>("consulter"));
        }
        catch (Exception e)
        {

        }
        }

    public void refreshTable() throws Exception{
        BilanList.clear();
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/healthforall","root","");
        query = "SELECT * FROM `bilan` WHERE `CONSULTER`='non'";
         preparedStatement = connection.prepareStatement(query);
         resultSet = preparedStatement.executeQuery();
         while (resultSet.next())
         {
            BilanList.add(new Bilan(
                    resultSet.getString("CODEP"),
                    resultSet.getInt("IDBILAN"),
                    resultSet.getString("DATE"),
                    resultSet.getString("DESCRIPTIONBILAN"),
                    resultSet.getString("CONSULTER")));
            BilanTable.setItems(BilanList);
         }
         preparedStatement.close();
         resultSet.close();
    }

    public void AddBilan() throws Exception{
        try{
                Parent parent = FXMLLoader.load(getClass().getResource("AddConsultation.fxml"));
                Scene scene = new Scene(parent);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show();
        }
        catch (Exception e)
        {
          System.out.println("Erreur lors du chargement de la page ");
        }
    }


}
