package model;

import java.util.*;

public class Arbre {
    protected String nom;
    protected Vector<Personne> listPer = new Vector<Personne>();

    public Arbre(String n) {
        nom = n;
    }

    public Vector<Personne> getListPer() {
        return listPer;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterPersonne(Personne p) {
        listPer.add(p);
    }

    public Personne trouverPersonneParPrenom(String prenom) {
        for (Personne p : listPer) {
            if (p.getPrenom().equalsIgnoreCase(prenom)) {
                return p;
            }
        }
        return null;
    }
    

    public Vector<Personne> trouverParents(Personne personne) {
        Vector<Personne> parents = new Vector<>();
        Personne pere = personne.getPere();
        Personne mere = personne.getMere();
        if (personne.getPere() != null) {
            parents.add(pere);
        }
        if (personne.getMere() != null) {
            parents.add(mere);
        }
        return parents;
    }

    public Vector<Personne> trouverCousins(Personne personne) {
        Vector<Personne> cousins = new Vector<>();
        Personne pere = personne.getPere();
        Personne mere = personne.getMere();

        Vector<Personne> onclesEtTantes = new Vector<>();
        if (pere != null) {
            onclesEtTantes.addAll(trouverFreresSoeurs(pere));
        }
        if (mere != null) {
            onclesEtTantes.addAll(trouverFreresSoeurs(mere));
        }
        for (Personne oncleOuTante : onclesEtTantes) {
            for (Personne p : listPer) {
                if (p.getPere() == oncleOuTante || p.getMere() == oncleOuTante) {
                    cousins.add(p);
                }
            }
        }

        return cousins;
    }

    public Vector<Personne> trouverFreresSoeurs(Personne personne) {
        Set<Personne> freresSoeursSet = new HashSet<>();
        Personne pere = personne.getPere();
        Personne mere = personne.getMere();
    
        if (pere != null) {
            freresSoeursSet.addAll(pere.getListEnfant());
        }
        if (mere != null) {
            freresSoeursSet.addAll(mere.getListEnfant());
        }
    
        freresSoeursSet.remove(personne);
        return new Vector<>(freresSoeursSet);
    }
    

    public Vector<Personne> trouverEnfants(Personne personne) {
        Vector<Personne> enfants = new Vector<>();
        for (Personne p : listPer) {
            if (p.getPere() == personne || p.getMere() == personne) {
                enfants.add(p);
            }
        }
        return enfants;
    }

    public Vector<Personne> trouverOnclesTantes(Personne personne) {
        Set<Personne> onclesTantes = new HashSet<>();
        Personne pere = personne.getPere();
        Personne mere = personne.getMere();
    
        if (pere != null) {
            Vector<Personne> freresSoeursPere = trouverFreresSoeurs(pere);
            onclesTantes.addAll(freresSoeursPere);
        }
    
        if (mere != null) {
            Vector<Personne> freresSoeursMere = trouverFreresSoeurs(mere);
            onclesTantes.addAll(freresSoeursMere);
        }
        onclesTantes.remove(pere);
        onclesTantes.remove(mere);
    
        return new Vector<>(onclesTantes);
    }
    

    public Vector<Personne> trouverNeveuxNieces(Personne personne) {
        Set<Personne> neveuxNieces = new HashSet<>();
        Vector<Personne> freresSoeurs = trouverFreresSoeurs(personne);

        for (Personne frereSoeur : freresSoeurs) {
            Vector<Personne> enfants = frereSoeur.getListEnfant();
            neveuxNieces.addAll(enfants);
        }

        Vector<Personne> enfantsPersonne = personne.getListEnfant();
        neveuxNieces.removeAll(enfantsPersonne);

        return new Vector<>(neveuxNieces);
    }


    public Vector<Personne> trouverGrandsParents(Personne personne) {
        Vector<Personne> grandsParents = new Vector<>();
        if (personne.getPere() != null) {
            if (personne.getPere().getPere() != null) {
                grandsParents.add(personne.getPere().getPere());
            }
            if (personne.getPere().getMere() != null) {
                grandsParents.add(personne.getPere().getMere());
            }
        }
        if (personne.getMere() != null) {
            if (personne.getMere().getPere() != null) {
                grandsParents.add(personne.getMere().getPere());
            }
            if (personne.getMere().getMere() != null) {
                grandsParents.add(personne.getMere().getMere());
            }
        }
        return grandsParents;
    }

    public Vector<Personne> trouverPetitsEnfants(Personne personne) {
        Vector<Personne> petitsEnfants = new Vector<>();
        for (Personne enfant : trouverEnfants(personne)) {
            petitsEnfants.addAll(trouverEnfants(enfant));
        }
        return petitsEnfants;
    }


    public String trouverConjoint(Personne personne) {
        if (personne instanceof Homme) {
            Femme epouse = ((Homme) personne).getConjoint();
            return (epouse != null) ? epouse.getPrenom() : null;
        } else if (personne instanceof Femme) {
            Homme epoux = ((Femme) personne).getConjoint();
            return (epoux != null) ? epoux.getPrenom() : null;
        }
        return null;
    }


    public boolean Maries(Personne personne1, Personne personne2) {
        if (personne1 instanceof Homme && personne2 instanceof Femme) {
            Homme epoux = (Homme) personne1;
            Femme epouse = (Femme) personne2;
            return epoux.getConjoint() == epouse && epouse.getConjoint() == epoux;
        } else if (personne1 instanceof Femme && personne2 instanceof Homme) {
            Femme epouse = (Femme) personne1;
            Homme epoux = (Homme) personne2;
            return epouse.getConjoint() == epoux && epoux.getConjoint() == epouse;
        }
        return false;
    }

    public boolean ParentEnfant(Personne personne1, Personne personne2) {
        if (personne1 instanceof Homme) {
            return ((Homme) personne1).getListEnfant().contains(personne2);
        } else if (personne1 instanceof Femme) {
            return ((Femme) personne1).getListEnfant().contains(personne2);
        } else if (personne2 instanceof Homme) {
            return ((Homme) personne2).getListEnfant().contains(personne1);
        } else if (personne2 instanceof Femme) {
            return ((Femme) personne2).getListEnfant().contains(personne1);
        }
        return false;
    }
    

    public boolean FreresSoeurs(Personne personne1, Personne personne2) {
        if ((personne1.getPere() != null && personne1.getPere() == personne2.getPere()) 
            || (personne1.getMere() != null && personne1.getMere() == personne2.getMere())) {
            return true;
        }
        return false;
    }

    public boolean Cousins(Personne personne1, Personne personne2) {
        if (personne1.getPere() != null && personne2.getPere() != null) {
            if (FreresSoeurs(personne1.getPere(), personne2.getPere())) return true;
            if (FreresSoeurs(personne1.getPere(), personne2.getMere())) return true;
        }
        if (personne1.getMere() != null && personne2.getMere() != null) {
            if (FreresSoeurs(personne1.getMere(), personne2.getPere())) return true;
            if (FreresSoeurs(personne1.getMere(), personne2.getMere())) return true;
        }
        return false;
    }

    public boolean OncleNeveu(Personne personne1, Personne personne2) {
        if (personne1.getPere() != null) {
            if (FreresSoeurs(personne1.getPere(), personne2.getPere()) || FreresSoeurs(personne1.getPere(), personne2.getMere())) {
                return true;}
        }else if (personne1.getMere() != null) {
            if (FreresSoeurs(personne1.getMere(), personne2.getPere()) || FreresSoeurs(personne1.getMere(), personne2.getMere())) {
                return true;}
        }else  if (personne2.getPere() != null) {
            if (FreresSoeurs(personne2.getPere(), personne1.getPere()) || FreresSoeurs(personne2.getPere(), personne1.getMere())) {
                return true; }
        }else if (personne2.getMere() != null) {
            if (FreresSoeurs(personne2.getMere(), personne1.getPere()) || FreresSoeurs(personne2.getMere(), personne1.getMere())) {
                return true;}
        } return false;
    }
    

    public boolean GpPe(Personne personne1, Personne personne2) {
        if ((personne1.getPere() != null && ParentEnfant(personne1, personne2.getPere())) ||
                (personne1.getMere() != null && ParentEnfant(personne1, personne2.getMere()))) {
            return true;
        } else if ((personne2.getPere() != null && ParentEnfant(personne2, personne1.getPere())) ||
                (personne2.getMere() != null && ParentEnfant(personne2, personne1.getMere()))) {
            return true;
        }
        return false;
    }
}
