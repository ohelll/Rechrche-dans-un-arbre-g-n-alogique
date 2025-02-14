package vue;

import model.*;
import controler.*;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    private JTextField prenomField1;
    private JTextField prenomField2;
    private JTextField prenomField3;
    private JTextArea resultArea;
    private Arbre arbre;

    public Fenetre(Arbre arb) {
        this.arbre = arb;

        setTitle("Rechercher des Relations");
        setSize(600, 310);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Définir la disposition de la fenêtre
        setLayout(new BorderLayout());

        // Panel pour les relations
        JPanel relationPanel = new JPanel(new FlowLayout());
        prenomField1 = new JTextField(10);
        prenomField2 = new JTextField(10);
        JButton trouverRelationButton = new JButton("Trouver Relation");
        relationPanel.add(prenomField1);
        relationPanel.add(prenomField2);
        relationPanel.add(trouverRelationButton);

        // Panel pour les recherches spécifiques
        JPanel recherchePanel = new JPanel(new FlowLayout());
        prenomField3 = new JTextField(10);
        JButton parentsButton = new JButton("Parents");
        JButton freresSoeursButton = new JButton("Frères/Sœurs");
        JButton cousinsButton = new JButton("Cousins");
        JButton enfantsButton = new JButton("Enfants");
        JButton onclesTantesButton = new JButton("Oncles/Tantes");
        JButton neveuxNiecesButton = new JButton("Neveux/Nièces");
        JButton grandsParentsButton = new JButton("Grands-Parents");
        JButton petitsEnfantsButton = new JButton("Petits-Enfants");

        
        recherchePanel.add(prenomField3);
        recherchePanel.add(parentsButton);
        recherchePanel.add(freresSoeursButton);
        recherchePanel.add(cousinsButton);
        recherchePanel.add(enfantsButton);
        recherchePanel.add(onclesTantesButton);
        recherchePanel.add(neveuxNiecesButton);
        recherchePanel.add(grandsParentsButton);
        recherchePanel.add(petitsEnfantsButton);

        // Zone de résultat
        resultArea = new JTextArea(10, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Ajout des composants à la fenêtre
        getContentPane().add(relationPanel, BorderLayout.NORTH);
        getContentPane().add(recherchePanel, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        // Assignation des actions aux boutons
        trouverRelationButton.addActionListener(new ArbreRelation(prenomField1, prenomField2, resultArea, arbre));
        parentsButton.addActionListener(new ArbreParents(prenomField3, resultArea, arbre));
        freresSoeursButton.addActionListener(new ArbreFrereSoeur(prenomField3, resultArea, arbre));
        cousinsButton.addActionListener(new ArbreCousins(prenomField3, resultArea, arbre));
        enfantsButton.addActionListener(new ArbreEnfants(prenomField3, resultArea, arbre));
        onclesTantesButton.addActionListener(new ArbreOncles(prenomField3, resultArea, arbre));
        neveuxNiecesButton.addActionListener(new ArbreNeveuxNieces(prenomField3, resultArea, arbre));
        grandsParentsButton.addActionListener(new ArbreGrandsParents(prenomField3, resultArea, arbre));
        petitsEnfantsButton.addActionListener(new ArbrePetitsEnfants(prenomField3, resultArea, arbre));

        setVisible(true);
    }
}
