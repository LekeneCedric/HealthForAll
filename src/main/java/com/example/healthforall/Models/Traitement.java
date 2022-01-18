package com.example.healthforall.Models;

public class Traitement {
    public int id;
    public String nom ;
    public String codeDoc;
    public String adressImage;
    public String description;

    public Traitement(int id, String nom , String codeDoc , String adressImage , String description)
    {
        this.id = id ;
        this.nom  = nom ;
        this.codeDoc = codeDoc;
        this.adressImage = adressImage;
        this.description = description;
    }
    public  Traitement()
    {
        this.id=0;
        this.nom="";
        this.codeDoc="";
        this.adressImage="";
        this.description="";
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id )
    {
        this.id = id;
    }
    public String getNom()
    {
        return this.nom;
    }
    public void setNom(String nom )
    {
        this.nom = nom;
    }
    public String getCodeDoc()
    {
        return this.codeDoc;
    }
    public void setCodeDoc(String code )
    {
        this.codeDoc = code;
    }
    public String getAdressImage()
    {
        return this.adressImage;
    }
    public void setAdressImage(String adress )
    {
        this.adressImage = adress;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }


}
