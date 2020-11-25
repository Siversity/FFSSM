/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import static FFSSM.GroupeSanguin.APLUS;
import static FFSSM.GroupeSanguin.AMOINS;
import static FFSSM.GroupeSanguin.BPLUS;
import static FFSSM.GroupeSanguin.BMOINS;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Stéphane
 */
public class TestClub {
    
    private Moniteur president;
    private Moniteur m1;
    private Moniteur m2;
    
    private Plongeur p3;
    private Plongeur p4;
    private Plongeur p5;
    private Plongeur p6;
    
    private Club club1;
    
    private Site site1;
    private Site site2;
    
    private Plongee conforme1;
    private Plongee conforme2;
    private Plongee nonConforme3;
    
    
    @BeforeEach
    public void setUp() {
        president = new Moniteur("INSEE001", "Dupont", "Jean", "Paris", "0101010101", LocalDate.of(1966, 11, 12), APLUS, 9, 748);
        m1 = new Moniteur("INSEE002", "Dune", "Damien", "Bordeaux", "0202020202", LocalDate.of(1989, 8, 10), BMOINS, 4, 245);
        m2 = new Moniteur("INSEE003", "Rack", "Tom", "Toulouse", "0303030303", LocalDate.of(1992, 5, 28), AMOINS, 4, 329);
        
        p3 = new Plongeur("INSEE004", "Clark", "Damien", "Marseille", "0404040404", LocalDate.of(1998, 4, 1), APLUS, 0);
        p4 = new Plongeur("INSEE005", "Daniels", "Matt", "Marseille", "0505050505", LocalDate.of(1998, 11, 24), BPLUS, 1);
        p5 = new Plongeur("INSEE006", "Boiron", "Patrick", "Nantes", "0606060606", LocalDate.of(1990, 12, 7), BMOINS, 1);
        p6 = new Plongeur("INSERT007", "Tan", "Bertrand", "Bordeaux", "0707070707", LocalDate.of(1971, 3, 12), BPLUS, 9);
        
        p3.ajouteLicence("003", LocalDate.of(2020,5, 1), club1);
        p4.ajouteLicence("004", LocalDate.of(2019, 12, 20), club1);
        p5.ajouteLicence("005", LocalDate.of(2019, 1, 1), club1);
        p6.ajouteLicence("006", LocalDate.of(2020, 2, 11), club1);
        
        site1 = new Site("Baie large", "Facile d'accès, pour débutants");
        site2 = new Site("Grotte sous-marine", "Difficile d'accès, pour confirmés");
        
        conforme1 = new Plongee(site1, m1, LocalDate.of(2020, 2, 5), 20, 3);
        conforme1.ajouteParticipant(p3);
        conforme1.ajouteParticipant(p4);
        
        conforme2 = new Plongee(site2, m2, LocalDate.of(2020, 7, 15), 100, 4);
        conforme2.ajouteParticipant(p6);
        
        nonConforme3 = new Plongee(site1, m2, LocalDate.of(2020, 8, 31), 15, 3);
        nonConforme3.ajouteParticipant(p5);
        nonConforme3.ajouteParticipant(p6);
        
        club1 = new Club(president, "Fontaineville", "0404040404");
    }
    
    
    @Test
    public void testOrganisePlongee() {
        club1.organisePlongee(conforme1);
        club1.organisePlongee(conforme2);
        club1.organisePlongee(nonConforme3);
        
        assertEquals(3, club1.getListePlongees().size(), "Le club doit avoir organisé exactelent 3 plongées");
    }
    
    @Test
    public void testPlongeesNonConformes() {
        club1.organisePlongee(conforme1);
        club1.organisePlongee(conforme2);
        club1.organisePlongee(nonConforme3);
        
        assertEquals(1, club1.plongeesNonConformes().size(), "Le club a organisé exactement 1 plongée non conforme");
    }
    
    @Test
    public void testSettersGetters() {
        assertEquals("Club{" + "président=" + club1.getPresident() + ", nom=" + club1.getNom() + ", adresse=" + club1.getAdresse() + ", telephone=" + club1.getTelephone() + "}", club1.toString());
        
        club1.setAdresse("Lille");
        club1.setNom("Club maritime de Lille");
        club1.setPresident(m1);
        club1.setTelephone("0102030405");
        
        assertEquals("Club{" + "président=" + club1.getPresident() + ", nom=Club maritime de Lille" + ", adresse=Lille" + ", telephone=0102030405" + "}", club1.toString());
    }

}
