package com.schottenTotten.model;

public class Borne {

    //  Attributs
    private int index;

    // Maximum 3 cartes par joueur sur une borne
    private Carte[] cartesJoueur1;
    private Carte[] cartesJoueur2;

    // Pour savoir combien de cases du tableau sont déjà utilisées
    private int nbCartesJoueur1;
    private int nbCartesJoueur2;

    // Joueur qui a gagné la borne (null = personne)
    private Joueur proprietaire;

    //  Constructeur sans paramètre
    public Borne() {
        this(0); // appelle l'autre constructeur avec index = 0
    }

    // Constructeur avec paramètre index
    public Borne(int index) {
        this.index = index;
        this.cartesJoueur1 = new Carte[3];
        this.cartesJoueur2 = new Carte[3];
        this.nbCartesJoueur1 = 0;
        this.nbCartesJoueur2 = 0;
        this.proprietaire = null;
    }

   
    //lire
    public int getIndex() {
        return index;
    }
    //modifier
    public void setIndex(int index) {
        this.index = index;
    }
    //lire
    public Joueur getProprietaire() {
        return proprietaire;
    }
    //modifier
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    //gestion des cartes sur la borne il ya deux cote les carte du joueur 1 et les carte du joueur2

    // donner une carte à la borne pour un joueur donné
    public void ajouterCarte(int numeroJoueur, Carte carte) {
        if (numeroJoueur == 1) {
            if (nbCartesJoueur1 < 3) {
                cartesJoueur1[nbCartesJoueur1] = carte;
                nbCartesJoueur1++;
            }
        } else if (numeroJoueur == 2) {
            if (nbCartesJoueur2 < 3) {
                cartesJoueur2[nbCartesJoueur2] = carte;
                nbCartesJoueur2++;
            }
        }
    }

    public int getNbCartesJoueur1() {
        return nbCartesJoueur1;
    }

    public int getNbCartesJoueur2() {
        return nbCartesJoueur2;
    }

    // Méthode description alternative

    public String description() {
        String nomProprio = (proprietaire == null)
                ? "aucun"
                : proprietaire.getNom();

        return "Borne " + index
                + " (J1=" + nbCartesJoueur1
                + " cartes, J2=" + nbCartesJoueur2
                + " cartes, propriétaire=" + nomProprio + ")";
    }
}
