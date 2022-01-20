package com.example.healthforall;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CovidTestController {
    public RadioButton symptomeFrequent1Oui;
    public RadioButton symptomeFrequent2Oui;
    public RadioButton symptomeFrequent3Oui;
    public RadioButton symptomeFrequent4Oui;
    public RadioButton symptomeMoinsFrequent1Oui;
    public RadioButton symptomeMoinsFrequent2Oui;
    public RadioButton symptomeMoinsFrequent3Oui;
    public RadioButton symptomeMoinsFrequent4Oui;
    public RadioButton symptomeMoinsFrequent5Oui;
    public RadioButton symptomeGrave1Oui;
    public RadioButton symptomeGrave2Oui;
    public RadioButton symptomeGrave3Oui;
    public TextField codePatient;

    public void resetTestCovid(ActionEvent actionEvent) {

    }
    public int covidResutl()
    {
        int symptomesGraves = 0;
        int symptomesFrequents=0;
        int symptomesMoinsFrequents = 0 ;
        int covid = 0;
        if(symptomeFrequent1Oui.isSelected())
        {
            symptomesFrequents+=1;
        }
        if(symptomeFrequent2Oui.isSelected())
        {
            symptomesFrequents+=1;
        }
        if(symptomeFrequent3Oui.isSelected())
        {
            symptomesFrequents+=1;
        }
        if(symptomeFrequent4Oui.isSelected())
        {
            symptomesFrequents+=1;
        }
        if(symptomeMoinsFrequent1Oui.isSelected())
        {
            symptomesMoinsFrequents+=1;
        }
        if(symptomeMoinsFrequent2Oui.isSelected())
        {
            symptomesMoinsFrequents+=1;
        }
        if(symptomeMoinsFrequent3Oui.isSelected())
        {
            symptomesMoinsFrequents+=1;
        }
        if(symptomeMoinsFrequent4Oui.isSelected())
        {
            symptomesMoinsFrequents+=1;
        }
        if(symptomeMoinsFrequent5Oui.isSelected())
        {
            symptomesMoinsFrequents+=1;
        }
        if(symptomeGrave1Oui.isSelected())
        {
            symptomesGraves+=1;
        }
        if(symptomeGrave2Oui.isSelected())
        {
            symptomesGraves+=1;
        }
        if(symptomeGrave3Oui.isSelected())
        {
            symptomesGraves+=1;
        }

        if(symptomesGraves>=2 & symptomesFrequents>=2 & symptomesMoinsFrequents>=2)
        {
            covid =1;
        }
        else if(symptomesGraves>=1 & symptomesFrequents >=2 & symptomesMoinsFrequents>=2)
        {
            covid = 1 ;
        }
        else if(symptomesGraves==0 & symptomesFrequents>=3 & symptomesMoinsFrequents>=3)
        {
            covid =1 ;
        }
        else
        {
            covid =0;
        }
        return covid;
    }


    public void testCovid(ActionEvent actionEvent) {
        String dateActuel = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        String code = codePatient.getText();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthforall","root","");
            if(codePatient.getText()!="") {
                if (covidResutl() == 1) {
                    String request = "UPDATE patient SET ETATCOVIDP='oui' WHERE CODEP='"+codePatient.getText()+"'";
                    PreparedStatement prepare = con.prepareStatement(request);
                    String addPrescription = "insert into prescription(CODEDOC,CODEP,DESCRIPTIONPRESCRIPTION,DATE)" + "values(?,?,?,?)";
                    PreparedStatement preparedStm = con.prepareStatement(addPrescription);
                    preparedStm.setString(1,"DOC01");
                    preparedStm.setString(2,code);
                    preparedStm.setString(3,"Tester Positif au covid 19 " );
                    preparedStm.setString(4,dateActuel);
                    String addBilan = "insert into bilan(DATE,CONSULTER,CODEP,DESCRIPTIONBILAN)" + "values(?,?,?,?)";
                    PreparedStatement preparedStm2 = con.prepareStatement(addBilan);
                    preparedStm2.setString(1, dateActuel);
                    preparedStm2.setString(2, "non");
                    preparedStm2.setString(3,code );
                    preparedStm2.setString(4, "Tester Positif au covid - 19 ! ");
                    preparedStm2.execute();
                    preparedStm.execute();
                    prepare.execute();
                    prepare.close();
                    preparedStm.close();
                    preparedStm2.close();
                    con.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Test Covid");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous etes Positif au test covid Vos informations serons communiques directement au Presonnels Soignants");
                    alert.showAndWait();
                } else {

                    String request = "UPDATE patient SET ETATCOVIDP='non' WHERE CODEP='"+codePatient.getText()+"'";
                    PreparedStatement prepare = con.prepareStatement(request);
                    String addPrescription = "insert into prescription(CODEDOC,CODEP,DESCRIPTIONPRESCRIPTION,DATE)" + "values(?,?,?,?)";
                    PreparedStatement preparedStm = con.prepareStatement(addPrescription);
                    preparedStm.setString(1,"DOC01");
                    preparedStm.setString(2,code);
                    preparedStm.setString(3,"Tester Negatif au Covid-19" );
                    preparedStm.setString(4,dateActuel);
                    preparedStm.execute();
                    prepare.execute();
                    prepare.close();
                    preparedStm.close();
                    con.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Test Covid");
                    alert.setHeaderText(null);
                    alert.setContentText("Vous etes Negatif au test covid Vos informations serons communiques directement au Presonnels Soignants");
                    alert.showAndWait();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Test Covid");
                alert.setHeaderText(null);
                alert.setContentText("VEILLEZ REMPLIR TOUS LES CHAMPS ");
                alert.showAndWait();
            }
        }
        catch (Exception e )
        {
          System.out.println(e);
        }





    }
}
