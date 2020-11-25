/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Moniteur extends Plongeur {

    // Attributs
    private int numeroDiplome;
    private ArrayList<Embauche> listeEmbauches;

    
    // Constructeur
    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin gp, int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, gp, niveau);
        setNumeroDiplome(numeroDiplome);
        this.listeEmbauches = new ArrayList<>();
    }
    
    
    // Getters
    public int getNumeroDiplome() {
        return numeroDiplome;
    }
    
    
    // Setters
    public void setNumeroDiplome(int numeroDiplome) {
        if (numeroDiplome < 0) {
            throw new IllegalArgumentException("Le numéro du diplême ne peut pas être nul");
        }
        this.numeroDiplome = numeroDiplome;
    }


    // employeurActuel()
    public Optional<Club> employeurActuel() {
        int nbrEmbauches = 0 + listeEmbauches.size();
        // On vérifie si l'historique d'embauches du moniteur est vide
        if (nbrEmbauches == 0) {
            return Optional.ofNullable(null);
        }
        else {
            Embauche embaucheActuelle = listeEmbauches.get(nbrEmbauches - 1);
            Club employeur = embaucheActuelle.getEmployeur();
            // On vérifie si le dernier emploi est terminé
            if (embaucheActuelle.estTerminee() == true) {
                return Optional.ofNullable(null);
            }
            else {
                return Optional.of(embaucheActuelle.getEmployeur());
            }
        }
    }
    
    
    // getEmbaucheActuelle()
    public Embauche getEmbaucheActuelle() throws FFSSMException {
        // On vérifie si le moniteur a bien un emploi en cours
        int nbrEmbauches = listeEmbauches.size();
        if ((nbrEmbauches == 0) || (listeEmbauches.get(nbrEmbauches - 1).estTerminee() == true)) {
            throw new FFSSMException("Le moniteur n'a actuellement aucun emploi");
        }
        else {
            Embauche derniereEmbauche = listeEmbauches.get(nbrEmbauches - 1);
            return derniereEmbauche;
        }
    }
    
    
    
    // terminerEmbauche()
    public void terminerEmbauche(LocalDate dateFin) throws FFSSMException {
        // On vérifie si le moniteur a bien un emploi en cours
        int nbrEmbauches = listeEmbauches.size();
        if ((nbrEmbauches == 0) || (listeEmbauches.get(nbrEmbauches - 1).estTerminee() == true)) {
            throw new FFSSMException("Le moniteur n'a actuellement aucun emploi");
        }
        else {
            Embauche derniereEmbauche = this.getEmbaucheActuelle();
            derniereEmbauche.terminer(dateFin);
        }
    }
    
    
    // nouvelleEmbauche()
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) throws FFSSMException {
        // On vérifie si le moniteur n'est pas déjà affecté dans un club
        int nbrEmbauches = listeEmbauches.size();
        if ((nbrEmbauches >= 1) && (listeEmbauches.get(nbrEmbauches - 1).estTerminee() == false)) {
            throw new FFSSMException("Le moniteur a déjà une embauche en cours");
        }
        Embauche nouvelleEmbauche = new Embauche(debutNouvelle, this, employeur);
        listeEmbauches.add(nouvelleEmbauche);
    }
    
    
    // emplois()
    public ArrayList<Embauche> emplois() {
        return listeEmbauches;
    }
    
}
