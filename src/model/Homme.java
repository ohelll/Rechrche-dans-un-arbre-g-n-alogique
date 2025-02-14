package model;
import java.util.Vector; 

public class Homme extends Personne {
    protected Vector<Personne> listEnfant = new Vector<Personne>();
    protected Femme epouse ;

    public Homme(Vector<Personne> tabE, String preN, Arbre arb, Homme pr, Femme mr, String dateN, String dateM) {
        super(preN, arb, pr, mr, dateN, dateM); 
        listEnfant = tabE;
    }
    
    public Vector<Personne> getListEnfant() {
        return listEnfant;
    }

    public Femme getConjoint() {
        return epouse;
    }

    public void ajouterEnfant(Personne enfant) {
        listEnfant.add(enfant);
    }
}
