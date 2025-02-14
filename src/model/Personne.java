package model;

import java.util.Vector; 

public class Personne {
    protected String prenom;
    protected Arbre arbre;
    protected Homme pere;
    protected Femme mere;
    protected String dateNaissance;
    protected String dateMort;

    public Personne(String preN, Arbre arb, Homme pr, Femme mr, String dateN, String dateM) {
        prenom = preN;
        dateNaissance = dateN;
        dateMort = dateM;
        arbre = arb;
        dateMort = dateM;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPere(Homme h) {
        pere = h;
    }

    public void setMere(Femme f) {
        mere = f;
    }

    public Homme getPere() {
        return pere;
    }

    public Femme getMere() {
        return mere;
    }

    public Vector<Personne> getListEnfant() {
        return new Vector<Personne>();
    }
}
