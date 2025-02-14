package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreFrereSoeur implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreFrereSoeur(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
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

        Vector<Personne> freresSoeurs = arbre.trouverFreresSoeurs(personne);
        StringBuilder relations = new StringBuilder();
        relations.append("Frères/Sœurs de ").append(personne.getPrenom()).append(" :\n");
        if (!freresSoeurs.isEmpty()) {
            for (Personne frereSoeur : freresSoeurs) {
                relations.append("- ").append(frereSoeur.getPrenom()).append("\n");
            }
        } else {
            relations.append("Aucun frère/sœur trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}
