package com.schottenTotten.model;

public class Joueur {

    private String nom;
    private int numero;          // 1 ou 2
    private boolean estIA;       // true si c'est une IA, false si c'est un humain
    private int bornesGagnees;   // nombre de bornes gagnées

    // Gestion de la main avec un tableau simple
    private Carte[] main;
    private int nbCartesMain;    // nombre de cartes réellement dans la main
    private static final int TAILLE_MAX_MAIN = 20; // taille max (large pour être tranquille)

    // Constructeur
    public Joueur(String nom, int numero, boolean estIA) {
        this.nom = nom;
        this.numero = numero;
        this.estIA = estIA;
        this.bornesGagnees = 0;

        this.main = new Carte[TAILLE_MAX_MAIN];
        this.nbCartesMain = 0;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public boolean estIA() {
        return estIA;
    }

    public int getBornesGagnees() {
        return bornesGagnees;
    }

    public Carte[] getMain() {
        return main;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBornesGagnees(int bornesGagnees) {
        this.bornesGagnees = bornesGagnees;
    }

    public void incrementerBornesGagnees() {
        this.bornesGagnees++;
    }

    // Gestion de la main

    // Ajouter une carte dans la main
    public void ajouterCarte(Carte carte) {
        if (carte != null && nbCartesMain < TAILLE_MAX_MAIN) {
            main[nbCartesMain] = carte;
            nbCartesMain++;
        }
    }

    // Retirer une carte par son indice, et la renvoyer
    public Carte retirerCarte(int index) {
        if (index >= 0 && index < nbCartesMain) {
            Carte carte = main[index];

            // Décaler les cartes suivantes vers la gauche
            for (int i = index; i < nbCartesMain - 1; i++) {
                main[i] = main[i + 1];
            }

            // Libérer la dernière place
            main[nbCartesMain - 1] = null;
            nbCartesMain--;

            return carte;
        }
        return null;
    }

    // Récupérer une carte sans la retirer
    public Carte getCarte(int index) {
        if (index >= 0 && index < nbCartesMain) {
            return main[index];
        }
        return null;
    }

    public int getTailleMain() {
        return nbCartesMain;
    }

    public boolean mainVide() {
        return (nbCartesMain == 0);
    }

    public void viderMain() {
        for (int i = 0; i < nbCartesMain; i++) {
            main[i] = null;
        }
        nbCartesMain = 0;
    }

    // Affichage simple de la main
    public String afficherMain() {
        String texte = "Main de " + nom + " :\n";

        if (nbCartesMain == 0) {
            texte += "  [Vide]\n";
        } else {
            for (int i = 0; i < nbCartesMain; i++) {
                texte += "  [" + i + "] " + main[i].description() + "\n";
            }
        }

        return texte;
    }

    

    @Override
    public String toString() {
        String typeJoueur = estIA ? "IA" : "Humain";
        return nom + " (Joueur " + numero + ", " + typeJoueur + ")";
    }

    // Afficher des infos sur le joueur
    public String afficherStats() {
        return toString()
               + " - Bornes gagnées: " + bornesGagnees
               + " - Cartes en main: " + nbCartesMain;
    }
}
