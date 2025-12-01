package com.schottenTotten.model;

public abstract class Carte {
    
    protected int valeur;
    protected Couleur couleur;
    
    // Constructeur vide
    public Carte() {
        this.valeur = 0;
        this.couleur = null;
    }
    
    // Constructeur avec paramètres
    public Carte(int valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }
    
    // Getters
    public int getValeur() {
        return valeur;
    }
    
    public Couleur getCouleur() {
        return couleur;
    }
    
    // Setters
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    // Méthode pour afficher la carte
   
    public String toString() {
        if (couleur != null) {
            return valeur + " " + couleur;
        }
        return "Carte vide";
    }
    
    // Méthode description alternative
    public String description() {
        return toString();
    }
}