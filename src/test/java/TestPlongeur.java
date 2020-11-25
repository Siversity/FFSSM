/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.FFSSMException;
import static FFSSM.GroupeSanguin.AMOINS;
import static FFSSM.GroupeSanguin.APLUS;
import static FFSSM.GroupeSanguin.BMOINS;
import static FFSSM.GroupeSanguin.BPLUS;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongeur;
import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Stéphane
 */
public class TestPlongeur {
    
    private Club club1;
    
    private Moniteur m1;
    
    private Plongeur p1;
    private Plongeur p2;
    private Plongeur p3;
    
    private Licence l1;
    private Licence l2;
    
    @BeforeEach
    public void setUp() {
        m1 = new Moniteur("INSEE001", "Mason", "David", "Dunkerque", "0101010101", LocalDate.of(1989, 6, 25), AMOINS, 7, 572);
        
        p1 = new Plongeur("INSEE004", "Clark", "Damien", "Marseille", "0404040404", LocalDate.of(1998, 4, 1), APLUS, 0);
        p2 = new Plongeur("INSEE005", "Daniels", "Matt", "Marseille", "0505050505", LocalDate.of(1998, 11, 24), BPLUS, 1);
        
        club1 = new Club(m1, "Club maritime de Marseille", "0909090909");
    }
    
    @Test
    public void testConstructeurPlongeur() {
        assertThrows(IllegalArgumentException.class, () -> {
        		p3 = new Plongeur("INSEE006", "Dam", "Jean", "Nantes", "0606060606", LocalDate.of(1997, 3, 30), BMOINS, -2); 
                }, "Cet appel doit lever une exception");
    }
    
    @Test
    public void testajouteLicence() {
        assertEquals(null, p1.getLicence(), "Le plongeur n'a actuellement aucune licence");
        
        p1.ajouteLicence("008", LocalDate.of(2020, 8, 1), club1);
        l1 = p1.getLicence();
        
        p1.ajouteLicence("009", LocalDate.of(2020, 10, 1), club1);
        l2 = p1.getLicence();
        
        assertFalse(l1.equals(l2), "Les 2 licences sont différentes");
    }
    
    @Test
    public void testLicence() {
        p1.ajouteLicence("008", LocalDate.of(2020, 8, 1), club1);
        l1 = p1.getLicence();
        
        assertEquals("008", l1.getNumero());
        assertEquals(LocalDate.of(2020, 8, 1), l1.getDelivrance());
        assertEquals(club1, l1.getClub());
        assertEquals(p1, l1.getPossesseur());
    }
    
}
