package vue;

import model.*;

import java.util.Vector;
public class Main {
    public static void main(String[] args) {
        Arbre Dupont = new Arbre("Dupont");

        Homme Jean = new Homme(new Vector<Personne>(), "Jean", Dupont, null, null, "19/05/1975", null);
        Femme Marie = new Femme(new Vector<Personne>(), "Marie", Dupont, null, null, "25/08/1977", null);

        Mariage jm = new Mariage("20/06/1999", Jean, Marie);
        
        Homme Paul = new Homme(new Vector<Personne>(), "Paul", Dupont, Jean, Marie, "10/10/2000", null);
        Femme Lucie = new Femme(new Vector<Personne>(), "Lucie", Dupont, Jean, Marie, "15/12/2003", null);

        Femme Rachel = new Femme(new Vector<Personne>(), "Rachel", Dupont, null, Lucie, "07/03/2020", null);
        Femme Laura = new Femme(new Vector<Personne>(), "Laura", Dupont, null, Lucie, "14/02/2024", null);
        Homme Max = new Homme(new Vector<Personne>(), "Max", Dupont, Paul, null, "21/01/2024", null);

        Dupont.ajouterPersonne(Jean);
        Dupont.ajouterPersonne(Marie);
        Dupont.ajouterPersonne(Paul);
        Dupont.ajouterPersonne(Lucie);
        Dupont.ajouterPersonne(Rachel);
        Dupont.ajouterPersonne(Laura);
        Dupont.ajouterPersonne(Max);

        Jean.ajouterEnfant(Paul);
        Marie.ajouterEnfant(Paul);
        Jean.ajouterEnfant(Lucie);
        Marie.ajouterEnfant(Lucie);

        Lucie.ajouterEnfant(Rachel);
        Lucie.ajouterEnfant(Laura);
        Paul.ajouterEnfant(Max);

        Lucie.setPere(Jean);
        Lucie.setMere(Marie);
        Paul.setPere(Jean);
        Paul.setMere(Marie);

        Laura.setMere(Lucie);
        Rachel.setMere(Lucie);
        Max.setPere(Paul);

        new Fenetre(Dupont);
    }
}
