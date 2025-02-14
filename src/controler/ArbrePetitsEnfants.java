package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbrePetitsEnfants implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbrePetitsEnfants(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
        this.prenomField = prenomField;
        this.resultArea = resultArea;
        this.arbre = arbre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String prenom = prenomField.getText();
        Personne personne = arbre.trouverPersonneParPrenom(prenom);

        if (personne == null) {
            resultArea.setText("Personne non trouvée.");
            return;
        }

        Vector<Personne> petitsEnfants = arbre.trouverPetitsEnfants(personne);
        StringBuilder relations = new StringBuilder();
        relations.append("Petits-enfants de ").append(personne.getPrenom()).append(" :\n");
        if (!petitsEnfants.isEmpty()) {
            for (Personne petitEnfant : petitsEnfants) {
                relations.append("- ").append(petitEnfant.getPrenom()).append("\n");
            }
        } else {
            relations.append("Aucun petit-enfant trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}
