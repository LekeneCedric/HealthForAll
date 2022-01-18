package com.example.healthforall.Models;

public class Bilan {

    int id;
    String Date ;
    String Consulter;
    String CodeP;
    String Description;

    public Bilan(String codeP ,int id , String Date ,   String Description,String consulter)
    {
        this.id = id;
        this.Date = Date;
        this.Consulter = consulter;
        this.CodeP = codeP;
        this.Description = Description;

    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getConsulter()
    {
        return this.Consulter;
    }
    public void setDate(String date)
    {
        this.Date = date;
    }
    public String getDate()
    {
        return this.Date;
    }
    public void setCodeP(String codeP)
    {
        this.CodeP = codeP;
    }
    public String getCodeP()
    {
        return this.CodeP;
    }
    public void setDescription(String description)
    {
        this.Description = description;
    }
    public String getDescription()
    {
        return this.Description;
    }







}
