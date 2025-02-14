package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreNeveuxNieces implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreNeveuxNieces(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
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

        Vector<Personne> neveuxNieces = arbre.trouverNeveuxNieces(personne);
        StringBuilder relations = new StringBuilder();
        relations.append("Neveux/Nièces de ").append(personne.getPrenom()).append(" :\n");
        if (!neveuxNieces.isEmpty()) {
            for (Personne neveuNiece : neveuxNieces) {
                relations.append("- ").append(neveuNiece.getPrenom()).append("\n");
            }
        } else {
            relations.append("Aucun neveu/nièce trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}
