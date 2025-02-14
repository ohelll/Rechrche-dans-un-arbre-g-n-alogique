package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreGrandsParents implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreGrandsParents(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
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

        Vector<Personne> grandsParents = arbre.trouverGrandsParents(personne);
        StringBuilder relations = new StringBuilder();
        relations.append("Grands-parents de ").append(personne.getPrenom()).append(" :\n");
        if (!grandsParents.isEmpty()) {
            for (Personne grandParent : grandsParents) {
                relations.append("- ").append(grandParent.getPrenom()).append("\n");
            }
        } else {
            relations.append("Aucun grand-parent trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}
