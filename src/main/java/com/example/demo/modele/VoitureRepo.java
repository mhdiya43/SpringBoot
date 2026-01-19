package com.example.demo.modele;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoitureRepo extends CrudRepository<Voiture, Long> {

    // Sélectionner les voitures par marque
    List<Voiture> findByMarque(String marque);

    //  Sélectionner les voitures par couleur
    List<Voiture> findByCouleur(String couleur);

    //  Sélectionner les voitures par année
    List<Voiture> findByAnnee(int annee);

    //  Sélectionner les voitures par marque ET modèle
    List<Voiture> findByMarqueAndModele(String marque, String modele);

    //  Sélectionner les voitures par marque OU couleur
    List<Voiture> findByMarqueOrCouleur(String marque, String couleur);

    // Sélectionner les voitures par marque et trier par année (ASC)
    List<Voiture> findByMarqueOrderByAnneeAsc(String marque);

    // Même chose que findByMarque MAIS avec JPQL
    @Query("select v from Voiture v where v.marque = ?1")
    List<Voiture> chercherParMarque(String marque);

    // Marque qui se termine par une valeur (LIKE %x)
    @Query("select v from Voiture v where v.marque like %?1")
    List<Voiture> findByMarqueEndsWith(String marque);
}


