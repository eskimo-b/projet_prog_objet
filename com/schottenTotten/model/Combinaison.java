package com.schottenTotten.model;

public class Combinaison {

    private Carte[] cartes;
    private TypeCombinaison type;
    private int somme;

    // Constructeur
    public Combinaison(Carte[] cartes) {
        this.cartes = cartes;
        this.type = determinerType();
        this.somme = calculerSomme();
    }

    // Déterminer le type de combinaison
    private TypeCombinaison determinerType() {
        // Vérifier qu'on a bien 3 cartes non nulles
        if (cartes == null || cartes.length != 3) {
            return TypeCombinaison.INVALIDE;
        }

        for (int i = 0; i < 3; i++) {
            if (cartes[i] == null) {
                return TypeCombinaison.INVALIDE;
            }
        }

        // Copier les cartes dans un nouveau tableau
        Carte[] copie = new Carte[3];
        for (int i = 0; i < 3; i++) {
            copie[i] = cartes[i];
        }

        // Trier les 3 cartes par valeur 
        for (int i = 0; i < copie.length - 1; i++) {
            for (int j = i + 1; j < copie.length; j++) {
                if (copie[j].getValeur() < copie[i].getValeur()) {
                    Carte tmp = copie[i];
                    copie[i] = copie[j];
                    copie[j] = tmp;
                }
            }
        }

        boolean memeCouleur = memeCouleur(copie);
        boolean suite = estSuite(copie);
        boolean brelan = estBrelan(copie);

        if (suite && memeCouleur) {
            return TypeCombinaison.SUITE_COULEUR;
        }
        if (brelan) {
            return TypeCombinaison.BRELAN;
        }
        if (memeCouleur) {
            return TypeCombinaison.COULEUR;
        }
        if (suite) {
            return TypeCombinaison.SUITE;
        }
        return TypeCombinaison.SOMME;
    }

    // Les 3 cartes sont-elles de la même couleur ?
    private boolean memeCouleur(Carte[] c) {
        Couleur col = c[0].getCouleur();
        if (col == null) {
            return false;
        }
        for (int i = 1; i < c.length; i++) {
            if (c[i].getCouleur() != col) {
                return false;
            }
        }
        return true;
    }

    // Les valeurs forment-elles une suite v, v+1, v+2 ?
    private boolean estSuite(Carte[] c) {
        int v1 = c[0].getValeur();
        int v2 = c[1].getValeur();
        int v3 = c[2].getValeur();
        return (v2 == v1 + 1) && (v3 == v2 + 1);
    }

    // Les 3 cartes ont-elles la même valeur ?
    private boolean estBrelan(Carte[] c) {
        int v = c[0].getValeur();
        return (c[1].getValeur() == v && c[2].getValeur() == v);
    }

    // Somme des valeurs des cartes
    private int calculerSomme() {
        int total = 0;
        if (cartes != null) {
            for (int i = 0; i < cartes.length; i++) {
                if (cartes[i] != null) {
                    total += cartes[i].getValeur();
                }
            }
        }
        return total;
    }

    // Getters
    public TypeCombinaison getType() {
        return type;
    }

    public int getSomme() {
        return somme;
    }

    public Carte[] getCartes() {
        return cartes;
    }

    /**
     * Compare deux combinaisons :
     * -1 : this plus faible
     *  0 : égal
     *  1 : this plus forte
     */
    public int comparerAvec(Combinaison autre) {
        if (autre == null) {
            return 1;
        }

        // d'abord comparer les types (force)
        if (this.type.getForce() < autre.type.getForce()) {
            return -1;
        } else if (this.type.getForce() > autre.type.getForce()) {
            return 1;
        } else {
            // même type → on compare la somme
            if (this.somme < autre.somme) {
                return -1;
            } else if (this.somme > autre.somme) {
                return 1;
            } else {
                return 0;
            }
        }
    }

  @Override 
    public String toString() {
        return type.toString() + " (Somme: " + somme + ")";
    }
}
