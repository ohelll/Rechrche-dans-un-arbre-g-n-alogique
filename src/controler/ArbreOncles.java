package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreOncles implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreOncles(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
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

        Vector<Personne> onclesTantes = arbre.trouverOnclesTantes(personne);
        StringBuilder relations = new StringBuilder();
        relations.append("Oncles/Tantes de ").append(personne.getPrenom()).append(" :\n");
        if (!onclesTantes.isEmpty()) {
            for (Personne oncleTante : onclesTantes) {
                relations.append("- ").append(oncleTante.getPrenom()).append("\n");
            }
        } else {
            relations.append("Aucun oncle/tante trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}