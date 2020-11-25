/**
 * @(#) Site.java
 */

package FFSSM;

public class Site {
    
    // Attributs
    private String nom;
    private String details;
    
    
    // Constructeur
    public Site(String nom, String details) {
	this.nom = nom;
	this.details = details;
    }
    
    
    // Getters
    public String getNom() {
        return nom;
    }
    
    public String getDetails() {
        return details;
    }
    
    
    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    

    // toString()
    @Override
    public String toString() {
	return "Site{" + "nom=" + nom + ", details=" + details + '}';
    }
    
}
