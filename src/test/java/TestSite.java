/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Site;
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
public class TestSite {
    
    private Site site1;

    @BeforeEach
    public void setUp() {
        site1 = new Site("Baie des Lagons", "Zone fermée dangereuse, uniquement pour les plongeurs confirmés (niveau > 10)");
    }
    
    
    @Test
    public void testSite() {
        site1.setNom("Gorges du Lac");
        
        assertEquals("Gorges du Lac", site1.getNom());
        
        site1.setDetails("Grotte sous-marine facile d'accès, pour les débutants et touristes");
        
        assertEquals("Grotte sous-marine facile d'accès, pour les débutants et touristes", site1.getDetails());
    }
    
    @Test
    public void testToString() {
        String affichage = "Site{nom=Baie des Lagons, details=Zone fermée dangereuse, uniquement pour les plongeurs confirmés (niveau > 10)}";
        assertEquals(affichage, site1.toString());
    }

}
