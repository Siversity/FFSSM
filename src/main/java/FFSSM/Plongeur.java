package FFSSM;

import java.time.LocalDate;

public class Plongeur extends Personne {
    
    // Attributs
    protected int niveau;
    protected GroupeSanguin gp;
    protected Licence licence;
    
    
    // Constructeur
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin gp, int niveau) {
    super(numeroINSEE, nom, prenom, adresse, telephone, naissance);        
        // Exception, on vérifie si le niveau est positif
        if (niveau < 0) {
            throw new IllegalArgumentException("Le niveau du plongeur ne peut pas être négatif");
        }
        this.gp = gp;
        this.niveau = niveau;
    }
    
    
    // Getters
    public Licence getLicence() {
        return licence;
    }
    
    public GroupeSanguin getGP() {
        return gp;
    }
    
    public int getNiveau() {
        return niveau;
    }
    
    
    // Setters
    public void setGP(GroupeSanguin gp) {
        this.gp = gp;
    }
    
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
    // ajouteLicence()
    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        // On vérifié si le plongeur a déjà une licence
        if (licence == null) {
            licence = new Licence(this, numero, delivrance, club);
        }
        else {
            // On enlève l'ancienne licence des données du plongeur
            licence = null;
            // On ajouter la nouvelle licence aux données du plongeur
            licence = new Licence(this, numero, delivrance, club);
        }
    }

}
