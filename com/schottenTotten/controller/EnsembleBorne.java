public class EnsembleBorne{
    private Borne[] bornes;
    private int nb_bornes; 

    public EnsembleBorne(Borne[] bornes){
        this.bornes = bornes;
        this.nb_bornes = bornes.length;
    }

    public int getNombreBornes(bornes, joueur){
        int acc = 0; 
        for (int i = 0; i < bornes.length; i++){
            if (bornes[i].proprietaire == joueur){
                acc++;
            }
        }
        return acc;
    }

    public 
}