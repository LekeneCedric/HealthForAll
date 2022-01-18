package com.example.healthforall.Models;

public class Prescription {
    public int idDescription;
    public String codeDoc;
    public String codeP;
    public String date;
    public String Description;
    public Prescription(int id, String codeDoc , String codeP,String date,String Description)
    {
        this.idDescription = id ;
        this.codeDoc = codeDoc;
        this.codeP = codeP;
        this.date = date ;
        this.Description = Description;
    }
    public int getID()
    {
        return this.idDescription;
    }
    public void setID(int id)
    {
        this.idDescription = id;
    }
    public String getCodeDoc()
    {
        return this.codeDoc;
    }
    public void setCodeDoc(String codeDoc)
    {
        this.codeDoc = codeDoc;
    }
    public String getCodeP()
    {
        return this.codeP;
    }
    public void setCodeP(String codeDoc)
    {
        this.codeP = codeDoc;
    }
    public String getDate()
    {
        return this.date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDescription()
    {
        return this.Description;
    }
    public void setDescription(String Description)
    {
        this.Description = Description;
    }


}
