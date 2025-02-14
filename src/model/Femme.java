package model;
import java.util.Vector;

public class Femme extends Personne {
    protected Vector<Personne> listEnfant = new Vector<Personne>();
    protected Homme epoux;

    public Femme(Vector<Personne> tabE, String preN, Arbre arb, Homme pr, Femme mr, String dateN, String dateM) {
        super(preN, arb, pr, mr, dateN, dateM);
        listEnfant = tabE;
    }

    public Vector<Personne> getListEnfant() {
        return listEnfant;
    }

    public Homme getConjoint() {
        return epoux;
    }

    public void ajouterEnfant(Personne enfant) {
        listEnfant.add(enfant);
    }
}
