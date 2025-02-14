def sac_a_dos_tor_approximation(objets, C):
    """
    Algorithme de 1/2-approximation pour le sac à dos TOR.
    
    :param objets: Liste de tuples (utilité, coût), où utilité = u_i et coût = c_i.
    :param C: Capacité maximale du sac à dos.
    :return: Utilité maximale obtenue.
    """
    # Étape 1 : Trouver l'objet individuel avec la plus grande utilité respectant la contrainte
    utilite_max_individuelle = 0
    for utilite, cout in objets:
        if cout <= C:
            utilite_max_individuelle = max(utilite_max_individuelle, utilite)
    
    # Étape 2 : Appliquer l'algorithme glouton
    # Trier les objets par ratio utilité/coût décroissant
    objets_trie = sorted(objets, key=lambda x: x[0] / x[1], reverse=True)
    
    utilite_glouton = 0
    capacite_restante = C
    
    for utilite, cout in objets_trie:
        if cout <= capacite_restante:
            utilite_glouton += utilite
            capacite_restante -= cout
    
    # Étape 3 : Comparer les deux solutions
    return max(utilite_max_individuelle, utilite_glouton)



objets = [(60, 10), (100, 20), (120, 30)]
C = 50