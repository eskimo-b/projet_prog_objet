package com.schottenTotten.model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    
    private String nom;
    private int numero; // 1 ou 2
    private List<Carte> main;
    private boolean estIA;
    private int bornesGagnees;
    
    // Constructeur
    public Joueur(String nom, int numero, boolean estIA) {
        this.nom = nom;
        this.numero = numero;
        this.estIA = estIA;
        this.main = new ArrayList<>();
        this.bornesGagnees = 0;
    }
    
    // Getters
    public String getNom() {
        return nom;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public List<Carte> getMain() {
        return main;
    }
    
    public boolean estIA() {
        return estIA;
    }
    
    public int getBornesGagnees() {
        return bornesGagnees;
    }
    
    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void incrementerBornesGagnees() {
        this.bornesGagnees++;
    }
    
    public void setBornesGagnees(int bornesGagnees) {
        this.bornesGagnees = bornesGagnees;
    }
    
    // Gestion de la main
    public void ajouterCarte(Carte carte) {
        if (carte != null) {
            main.add(carte);
        }
    }
    
    public Carte retirerCarte(int index) {
        if (index >= 0 && index < main.size()) {
            return main.remove(index);
        }
        return null;
    }
    
    public Carte getCarte(int index) {
        if (index >= 0 && index < main.size()) {
            return main.get(index);
        }
        return null;
    }
    
    public int getTailleMain() {
        return main.size();
    }
    
    public boolean mainVide() {
        return main.isEmpty();
    }
    
    public void viderMain() {
        main.clear();
    }
    
    // Affichage de la main
    public String afficherMain() {
        StringBuilder sb = new StringBuilder();
        sb.append("Main de ").append(nom).append(" : \n");
        if (main.isEmpty()) {
            sb.append("  [Vide]\n");
        } else {
            for (int i = 0; i < main.size(); i++) {
                sb.append("  [").append(i).append("] ").append(main.get(i).description()).append("\n");
            }
        }
        return sb.toString();
    }
    
    // Affichage visuel stylisé de la main
    public String afficherMainVisuel() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════╗\n");
        sb.append("║  Main de ").append(nom);
        int espacesNom = 30 - nom.length();
        for (int i = 0; i < espacesNom; i++) {
            sb.append(" ");
        }
        sb.append("║\n");
        sb.append("╠════════════════════════════════════════╣\n");
        
        if (main.isEmpty()) {
            sb.append("║  [Vide]                                ║\n");
        } else {
            for (int i = 0; i < main.size(); i++) {
                String carteDesc = main.get(i).description();
                sb.append("║  [").append(i).append("] ").append(carteDesc);
                int espacesRestants = 32 - carteDesc.length();
                for (int j = 0; j < espacesRestants; j++) {
                    sb.append(" ");
                }
                sb.append("║\n");
            }
        }
        
        sb.append("╚════════════════════════════════════════╝\n");
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return nom + " (Joueur " + numero + ", " + (estIA ? "IA" : "Humain") + ")";
    }
    
    // Méthode pour afficher les statistiques du joueur
    public String afficherStats() {
        return toString() + " - Bornes gagnées: " + bornesGagnees + " - Cartes en main: " + main.size();
    }
}