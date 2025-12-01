package com.schottenTotten.model;

public class CarteTactique extends Carte {

    private TypeTactique type;

    
    public CarteTactique() {
        super();
    }

   
    public CarteTactique(TypeTactique type, int valeur, Couleur couleur) {
        super(valeur, couleur);
        this.type = type;
    }

    public TypeTactique getType() {
        return type;
    }
}
