public class EvalCartes{

    private static final int VAL_SUITE_COULEUR = 400;
    private static final int VAL_BRELAN = 300;
    private static final int VAL_COULEUR = 200;
    private static final int VAL_SUITE = 100;

    private int valeurCartes;

    public EvalCartes(EnsembleCarte e){
        this.valeurCartes = eval(e);
    }
    
    public static int eval(EnsembleCarte e){

        valeurCartes = suiteCouleur(e);
        if (valeurCartes > 0){ 
            return (valeurCartes + VAL_SUITE_COULEUR);
        }

        valeurCartes = brelan(e);
        if (valeurCartes > 0){
            return (valeurCartes + VAL_BRELAN);
        }

        valeurCartes = couleur(e);
        if (valeurCartes > 0){
            return (valeurCartes + VAL_COULEUR);
        }

        valeurCartes = suite(e);
        if (valeurCartes > 0){
            return (valeurCartes + VAL_SUITE);
        }

        valeurCartes = somme(e);
        return valeurCartes;
    }

    private static int suiteCouleur(Ensemble e){

    }

    private static int brelan(Ensemble e){

    }
    
    private static int couleur(Ensemble e){

    }

    private static int suite(Ensemble e){

    }
    private static int Somme(Ensemble e){

    }
}