package com.example.healthforall.Models;

public class patient

{

    private String code;
    private String nom;
    private String prenom;
    private int age;
    private float taille;
    private float poids;
    private String etat;

    public patient(String code, String nom, String prenom, int age, float taille, float poids, String etat) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.taille = taille;
        this.poids = poids;
        this.etat = etat;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public float getTaille() {
        return taille;
    }

    public float getPoids() {
        return poids;
    }

    public String getEtat() {
        return etat;
    }
}
