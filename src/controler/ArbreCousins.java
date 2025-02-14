package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreCousins implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreCousins(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
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

        Vector<Personne> cousins = arbre.trouverCousins(personne);
        StringBuilder relations = new StringBuilder();
        relations.append("Cousins de ").append(personne.getPrenom()).append(" :\n");
        if (!cousins.isEmpty()) {
            for (Personne cousin : cousins) {
                relations.append("- ").append(cousin.getPrenom()).append("\n");
            }
        } else {
            relations.append("Aucun cousin trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}
