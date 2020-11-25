/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;

public class Club {

    // Attributs
    private Moniteur president;
    private String nom;
    private String adresse;
    private String telephone;
    private HashSet<Plongee> listePlongees;
    
    
    // Constructeur
    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
        this.listePlongees = new HashSet<>();
    }

    
    // plongeesNonConformes()
    public HashSet<Plongee> plongeesNonConformes() {
        HashSet<Plongee> listePlongeesNonConformes = new HashSet<>();
         for (Plongee plongeeOrganisee : listePlongees) {
             // On vérifie si la plongée est conforme pour l'ajouter dans la liste
             if (plongeeOrganisee.estConforme() == false) {
                 listePlongeesNonConformes.add(plongeeOrganisee);
             }
         }
         return listePlongeesNonConformes;
    }

    //organisePlongee()
    public void organisePlongee(Plongee nouvellePlongee) {
        listePlongees.add(nouvellePlongee);
    }
    
    
    // Getters
    public Moniteur getPresident() {
        return president;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public HashSet<Plongee> getListePlongees() {
        return listePlongees;
    }

    
    // Setters
    public void setPresident(Moniteur président) {
        this.president = président;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    // toString()
    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + "}";
    }

}
