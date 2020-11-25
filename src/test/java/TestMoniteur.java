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
import FFSSM.Moniteur;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Stéphane
 */
public class TestMoniteur {
    
    private Club club1;
    
    private Moniteur m1;
    
    
    @BeforeEach
    public void setUp() {
        m1 = new Moniteur("INSEE002", "Dune", "Damien", "Bordeaux", "0202020202", LocalDate.of(1989, 8, 10), BMOINS, 4, 245);
        
        club1 = new Club(m1, "Fontaineville", "0404040404");
    }
    
    @Test
    public void testNouvelleEmbauche() throws FFSSMException {
        m1.nouvelleEmbauche(club1, LocalDate.of(2020, 1, 2));
        m1.terminerEmbauche(LocalDate.now());
        
        m1.nouvelleEmbauche(club1, LocalDate.now());
        
        assertEquals(2, m1.emplois().size(), "Le moniteur a exactement 2 emploi");
    }
    
    @Test
    public void testExceptionNouvelleEmbauche() throws FFSSMException {
        assertThrows(FFSSMException.class, () -> {
        		m1.terminerEmbauche(LocalDate.now()); 
                }, "Cet appel doit lever une exception");
        
        m1.nouvelleEmbauche(club1, LocalDate.now());
        
        assertThrows(FFSSMException.class, () -> {
        		m1.nouvelleEmbauche(club1, LocalDate.now()); 
                }, "Cet appel doit lever une exception");
    }
    
    @Test
    public void testDateInvalide() throws FFSSMException {
        m1.nouvelleEmbauche(club1, LocalDate.of(2020, 1, 1));
        
        assertThrows(IllegalArgumentException.class, () -> {
        		m1.terminerEmbauche(LocalDate.of(2019, 12, 31)); 
                }, "Cet appel doit lever une exception");
    }
    
    @Test
    public void testTerminerEmbaucheInvalide() throws FFSSMException {
        assertThrows(FFSSMException.class, () -> {
        		m1.terminerEmbauche(LocalDate.of(2019, 12, 31)); 
                }, "Cet appel doit lever une exception");
    }
    
    @Test
    public void testEmbaucheActuelleException() throws FFSSMException {
        assertThrows(FFSSMException.class, () -> {
        		m1.getEmbaucheActuelle(); 
                }, "Cet appel doit lever une exception");
    }
    
    @Test
    public void testAttributsActuelleException() throws FFSSMException {
        m1.nouvelleEmbauche(club1, LocalDate.of(2020, 1, 1));
        
        assertEquals(club1, m1.getEmbaucheActuelle().getEmployeur());
        assertEquals(m1, m1.getEmbaucheActuelle().getEmploye());
        assertEquals(LocalDate.of(2020, 1, 1), m1.getEmbaucheActuelle().getDebut());
        
        assertEquals(false, m1.getEmbaucheActuelle().estTerminee());
        assertEquals(null, m1.getEmbaucheActuelle().getFin());
    }
    
    @Test
    public void testEmployeurActuel() throws FFSSMException {
        assertEquals(Optional.empty(), m1.employeurActuel());
        
        m1.nouvelleEmbauche(club1, LocalDate.of(2020, 1, 1));
        assertEquals(Optional.of(club1), m1.employeurActuel());
        
        m1.terminerEmbauche(LocalDate.now());
        assertEquals(Optional.empty(), m1.employeurActuel());
    }
    
}
