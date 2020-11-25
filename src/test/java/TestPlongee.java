/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import static FFSSM.GroupeSanguin.APLUS;
import static FFSSM.GroupeSanguin.BMOINS;
import static FFSSM.GroupeSanguin.BPLUS;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Stéphane
 */
public class TestPlongee {
    
    private Moniteur m1;
    
    private Plongeur p1;
    private Plongeur p2;
    private Plongeur p3;
    private Plongeur p4;
    
    private Site site1;
    
    private Plongee plongee1;
    
    
    @BeforeEach
    public void setUp() {
        m1 = new Moniteur("INSEE002", "Dune", "Damien", "Bordeaux", "0202020202", LocalDate.of(1989, 8, 10), BMOINS, 4, 245);
        
        site1 = new Site("Baie large", "Facile d'accès, pour débutants");
        
        p1 = new Plongeur("INSEE004", "Clark", "Damien", "Marseille", "0404040404", LocalDate.of(1998, 4, 1), APLUS, 0);
        p2 = new Plongeur("INSEE005", "Daniels", "Matt", "Marseille", "0505050505", LocalDate.of(1998, 11, 24), BPLUS, 1);
        p3 = new Plongeur("INSEE006", "Boiron", "Patrick", "Nantes", "0606060606", LocalDate.of(1990, 12, 7), BMOINS, 1);
        p4 = new Plongeur("INSERT007", "Tan", "Bertrand", "Bordeaux", "0707070707", LocalDate.of(1971, 3, 12), BPLUS, 9);
        
        plongee1 = new Plongee(site1, m1, LocalDate.of(2021, 4, 25), 20, 3);
    }
    
    @Test
    public void testAjouteParticipant() {
        plongee1.ajouteParticipant(p1);
        plongee1.ajouteParticipant(p2);
        plongee1.ajouteParticipant(p3);
        plongee1.ajouteParticipant(p4);
        
        assertEquals(4, plongee1.getListePlongeurs().size());
    }
    
    @Test
    public void testEstConforme() {
        Club club1 = new Club(m1, "Fontaineville", "0404040404");
        
        plongee1.ajouteParticipant(p1);
        plongee1.ajouteParticipant(p2);
        plongee1.ajouteParticipant(p3);
        plongee1.ajouteParticipant(p4);
        
        p1.ajouteLicence("003", LocalDate.of(2020,5, 1), club1);
        p2.ajouteLicence("004", LocalDate.of(2019, 12, 20), club1);
        p3.ajouteLicence("005", LocalDate.of(2019, 1, 1), club1);
        p4.ajouteLicence("006", LocalDate.of(2020, 2, 11), club1);
        
        assertEquals(false, plongee1.estConforme(), "Cette plongée n'est pas conforme");
    }
    
    @Test
    public void testGetDate() {
        assertEquals(LocalDate.of(2021, 4, 25), plongee1.getDate());
    }
    
}
