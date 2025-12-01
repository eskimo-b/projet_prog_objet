package com.schottenTotten.model;

public enum TypeCombinaison {
    SUITE_COULEUR(5),    // 3 cartes consécutives de même couleur
    BRELAN(4),           // 3 cartes de même valeur
    COULEUR(3),          // 3 cartes de même couleur
    SUITE(2),            // 3 cartes consécutives
    SOMME(1),            // Aucune combinaison spéciale
    INVALIDE(0);         // Combinaison invalide ou incomplète
    
    private final int force;
    
    TypeCombinaison(int force) {
        this.force = force;
    }
    
    public int getForce() {
        return force;
    }
    
    @Override
    public String toString() {
        switch(this) {
            case SUITE_COULEUR: return "Suite Couleur";
            case BRELAN: return "Brelan";
            case COULEUR: return "Couleur";
            case SUITE: return "Suite";
            case SOMME: return "Somme";
            default: return "Invalide";
        }
    }
}