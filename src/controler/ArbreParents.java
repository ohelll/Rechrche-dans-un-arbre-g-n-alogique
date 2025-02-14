package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreParents implements ActionListener {
    private JTextField prenomField;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreParents(JTextField prenomField, JTextArea resultArea, Arbre arbre) {
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

        Personne pere = personne.getPere();
        Personne mere = personne.getMere();

        StringBuilder relations = new StringBuilder();
        relations.append("Parents de ").append(personne.getPrenom()).append(" :\n");
        if (pere != null) {
            relations.append("- Père: ").append(pere.getPrenom()).append("\n");
        }
        if (mere != null) {
            relations.append("- Mère: ").append(mere.getPrenom()).append("\n");
        }
        if (pere == null && mere == null) {
            relations.append("Aucun parent trouvé.\n");
        }

        resultArea.setText(relations.toString());
    }
}