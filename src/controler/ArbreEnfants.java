package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreEnfants implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreEnfants(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
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

        Vector<Personne> enfants = personne.getListEnfant();
        StringBuilder relations = new StringBuilder();
        relations.append("Enfants de ").append(personne.getPrenom()).append(" :\n");
        if (!enfants.isEmpty()) {
            for (Personne enfant : enfants) {
                relations.append("- ").append(enfant.getPrenom()).append("\n");
            }
        } else {
            relations.append("Aucun enfant trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}
