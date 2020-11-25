/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.FFSSMException;
import static FFSSM.GroupeSanguin.APLUS;
import static FFSSM.GroupeSanguin.BMOINS;
import FFSSM.Moniteur;
import FFSSM.Plongeur;
import java.time.LocalDate;
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
public class TestPersonne {
    
    private Moniteur m1;
    
    private Plongeur p1;
    

    @BeforeEach
    public void setUp() {
        m1 = new Moniteur("INSEE002", "Dune", "Damien", "Bordeaux", "0202020202", LocalDate.of(1989, 8, 10), BMOINS, 4, 245);
        
        p1 = new Plongeur("INSEE004", "Clark", "Damien", "Marseille", "0404040404", LocalDate.of(1998, 4, 1), APLUS, 0);
    }
    
    
    @Test
    public void testPlongeurPersonne() {
        p1.setNumeroINSEE("123");
        p1.setNom("Cogne");
        p1.setPrenom("Mathieu");
        p1.setAdresse("Paris");
        p1.setTelephone("1234567890");
        p1.setNaissance(LocalDate.of(2000, 1, 1));
        
        p1.setGP(BMOINS);
        p1.setNiveau(8);
        
        assertEquals("123", p1.getNumeroINSEE());
        assertEquals("Cogne", p1.getNom());
        assertEquals("Mathieu", p1.getPrenom());
        assertEquals("Paris", p1.getAdresse());
        assertEquals("1234567890", p1.getTelephone());
        assertEquals(LocalDate.of(2000, 1, 1), p1.getNaissance());
        assertEquals(BMOINS, p1.getGP());
        assertEquals(8, p1.getNiveau());
    }
    
    @Test
    public void testMoniteurPersonne() {
        assertEquals("INSEE002", m1.getNumeroINSEE());
        assertEquals("Dune", m1.getNom());
        assertEquals("Damien", m1.getPrenom());
        assertEquals("Bordeaux", m1.getAdresse());
        assertEquals("0202020202", m1.getTelephone());
        assertEquals(LocalDate.of(1989, 8, 10), m1.getNaissance());
        assertEquals(BMOINS, m1.getGP());
        assertEquals(4, m1.getNiveau());
        assertEquals(245, m1.getNumeroDiplome());
        
        m1.setNumeroDiplome(11);
        
        assertEquals(11, m1.getNumeroDiplome());
    }
    
    @Test
    public void testSetNumeroINSEEException() {
        assertThrows(IllegalArgumentException.class, () -> {
        		p1.setNumeroINSEE(null); 
                }, "Cet appel doit lever une exception");
    }
    
    @Test
    public void testSetNumeroDiplomeException() {
        assertThrows(IllegalArgumentException.class, () -> {
        		m1.setNumeroDiplome(-254); 
                }, "Cet appel doit lever une exception");
    }
 
}
