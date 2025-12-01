package com.schottenTotten.model;
//la pioche du jeu, le paquet de cartes commun à tous les joueurs.
public class Deck {

    private Carte[] cartes;          // tableau de cartes
    private int nombreCartes;        // nombre de cartes actuellement dans le deck
    private boolean avecCartesTactiques;//est ce quon jeu avec carte tactile ou pas

    // Constructeur
    public Deck(boolean avecCartesTactiques) {
        this.avecCartesTactiques = avecCartesTactiques;
        initialiser();
    }

    // Initialiser le deck avec les cartes
    private void initialiser() {
        // 54 cartes clan + éventuellement 10 cartes tactiques
        int total = 54;
        if (avecCartesTactiques) {
            total += 10;
        }

        cartes = new Carte[total];
        nombreCartes = 0;

        // Ajouter les cartes Clan (6 couleurs × 9 valeurs = 54 cartes)
        for (Couleur couleur : Couleur.values()) {
            for (int valeur = 1; valeur <= 9; valeur++) {
                cartes[nombreCartes] = new CarteClan(valeur, couleur);
                nombreCartes++;
            }
        }

        // Ajouter les cartes Tactiques si nécessaire (10 cartes)
        if (avecCartesTactiques) {
            // 3 Jokers
            for (int i = 0; i < 3; i++) {
                cartes[nombreCartes] = new CarteTactique(TypeTactique.JOKER, 0, null);
                nombreCartes++;
            }

            // 2 Espions
            for (int i = 0; i < 2; i++) {
                cartes[nombreCartes] = new CarteTactique(TypeTactique.ESPION, 7, null);
                nombreCartes++;
            }

            // 1 de chaque carte d'action
            cartes[nombreCartes++] = new CarteTactique(TypeTactique.PORTE_BOUCLIER, 0, null);
            cartes[nombreCartes++] = new CarteTactique(TypeTactique.COMBAT_DE_BOUE, 0, null);
            cartes[nombreCartes++] = new CarteTactique(TypeTactique.COLIN_MAILLARD, 0, null);
            cartes[nombreCartes++] = new CarteTactique(TypeTactique.CHASSEUR_DE_TETE, 0, null);
            cartes[nombreCartes++] = new CarteTactique(TypeTactique.BANSHEE, 0, null);
        }
    }

    // Mélanger le deck (sans Collections.shuffle)
    public void melanger() {
        for (int i = 0; i < nombreCartes; i++) {
            int j = (int) (Math.random() * nombreCartes); // indice aléatoire
            Carte temp = cartes[i];
            cartes[i] = cartes[j];
            cartes[j] = temp;
        }
    }

    // Piocher une carte
    public Carte piocher() {
        if (nombreCartes == 0) {
            return null;
        }
        // On prend la dernière carte du tableau
        nombreCartes--;
        Carte carte = cartes[nombreCartes];
        cartes[nombreCartes] = null; // optionnel : libérer la place
        return carte;
    }

    // Vérifier si le deck est vide
    public boolean estVide() {
        return (nombreCartes == 0);
    }

    // Obtenir le nombre de cartes restantes
    public int getTaille() {
        return nombreCartes;
    }

    // Réinitialiser le deck
    public void reinitialiser() {
        initialiser();
    }

    // Accéder au tableau des cartes (si besoin)
    public Carte[] getCartes() {
        return cartes;
    }

   
    public String toString() {
        return "Deck : " + nombreCartes + " cartes restantes";
    }
}
