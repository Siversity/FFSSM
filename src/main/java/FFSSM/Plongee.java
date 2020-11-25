/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;

public class Plongee {

    // Attributs
    private Site lieu;
    private Moniteur chefDePalanquee;
    private LocalDate date;
    private int profondeur;
    private int duree;
    private HashSet<Plongeur> listePlongeurs;
    
    
    // Constructeur
    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
	this.lieu = lieu;
	this.chefDePalanquee = chefDePalanquee;
	this.date = date;
	this.profondeur = profondeur;
	this.duree = duree;
        this.listePlongeurs = new HashSet<>();
	}
    
    
    // Getters
    public LocalDate getDate() {
        return date;
    }
    
    public HashSet<Plongeur> getListePlongeurs() {
        return listePlongeurs;
    }

    
    // ajouterParticipant()
    public void ajouteParticipant(Plongeur participant) {
	listePlongeurs.add(participant);
    }


    // estConforme()
    public boolean estConforme() {
	for (Plongeur participant : listePlongeurs) {
            if (participant.getLicence().estValide(date) == false) {
                return false;
            }
        }
        return true;
    }

}
