/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    // Attributs
    private Personne possesseur;
    private String numero;
    private LocalDate delivrance;
    private int niveau;
    private Club club;

    
    // Constructeur
    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    
    // Getters
    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }
    
    
    // estValide()
    public boolean estValide(LocalDate d) {
        LocalDate dateLimite = delivrance.plusYears(1);
        if (d.compareTo(dateLimite) < 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
