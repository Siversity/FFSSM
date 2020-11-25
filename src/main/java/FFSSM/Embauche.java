package FFSSM;

import java.time.LocalDate;

public class Embauche {

    // Attributs
    private LocalDate debut;
    private LocalDate fin;
    private final Moniteur employe;
    private final Club employeur;

    
    // Constructeur
    public Embauche(LocalDate debut, Moniteur employe, Club employeur) {
        this.debut = debut;
        this.employe = employe;
        this.employeur = employeur;
    }

    
    // terminer()
    public void terminer(LocalDate dateFin) {
        // Exception : on vérifie si la fin est antérieure au début
        if (dateFin.compareTo(debut) < 0) {
            throw new IllegalArgumentException("La date de fin d'embauche ne peut pas être antérieure à celle de début d'embauche");
        }
        // On fixe la date de fin d'embauche
        this.setFin(dateFin);
    }
    
    
    // estTerminee()
    public boolean estTerminee() {
        return (fin != null);
    }
    
    
    // Getters
    public Club getEmployeur() {
        return employeur;
    }

    public Moniteur getEmploye() {
        return employe;
    }

    public LocalDate getFin() {
        return fin;
    }
    
    public LocalDate getDebut() {
        return debut;
    }

    
    // Setters
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
    
}
