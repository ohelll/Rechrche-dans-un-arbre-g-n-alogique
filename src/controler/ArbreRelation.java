package controler;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ArbreRelation implements ActionListener {
    private JTextField prenomField1;
    private JTextField prenomField2;
    private JTextArea resultArea;
    private Arbre arbre;

    public ArbreRelation(JTextField prenomField1, JTextField prenomField2, JTextArea resultArea, Arbre arbre) {
        this.prenomField1 = prenomField1;
        this.prenomField2 = prenomField2;
        this.resultArea = resultArea;
        this.arbre = arbre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String prenom1 = prenomField1.getText();
        String prenom2 = prenomField2.getText();
        Personne personne1 = arbre.trouverPersonneParPrenom(prenom1);
        Personne personne2 = arbre.trouverPersonneParPrenom(prenom2);

        if (personne1 == null || personne2 == null) {
            resultArea.setText("Personne non trouvée.");
            return;
        }

        StringBuilder relations = new StringBuilder();
        if (arbre.Maries(personne1, personne2)) {
            relations.append(personne1.getPrenom()).append(" et ").append(personne2.getPrenom()).append(" sont mariés.\n");
        }
        if (arbre.ParentEnfant(personne1, personne2)) {
            relations.append(personne1.getPrenom()).append(" est parent de ").append(personne2.getPrenom()).append(".\n");
        } else if (arbre.ParentEnfant(personne2, personne1)) {
            relations.append(personne2.getPrenom()).append(" est parent de ").append(personne1.getPrenom()).append(".\n");
        }
        if (arbre.FreresSoeurs(personne1, personne2)) {
            relations.append(personne1.getPrenom()).append(" et ").append(personne2.getPrenom()).append(" sont frères et sœurs.\n");
        }
        if (arbre.Cousins(personne1, personne2)) {
            relations.append(personne1.getPrenom()).append(" et ").append(personne2.getPrenom()).append(" sont cousins.\n");
        }
        if (arbre.OncleNeveu(personne1, personne2)) {
            relations.append(personne1.getPrenom()).append(" est oncle/tante de ").append(personne2.getPrenom()).append(".\n");
        } else if (arbre.OncleNeveu(personne2, personne1)) {
            relations.append(personne2.getPrenom()).append(" est oncle/tante de ").append(personne1.getPrenom()).append(".\n");
        }
        if (arbre.GpPe(personne1, personne2)) {
            relations.append(personne1.getPrenom()).append(" est grand-parent de ").append(personne2.getPrenom()).append(".\n");
        } else if (arbre.GpPe(personne2, personne1)) {
            relations.append(personne2.getPrenom()).append(" est grand-parent de ").append(personne1.getPrenom()).append(".\n");
        }

        if (relations.length() == 0) {
            relations.append("Aucune relation trouvée entre ").append(personne1.getPrenom()).append(" et ").append(personne2.getPrenom()).append(".\n");
        }

        resultArea.setText(relations.toString());
    }
}
