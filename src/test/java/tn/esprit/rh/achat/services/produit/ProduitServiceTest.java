package tn.esprit.rh.achat.services.produit;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;

    @Test
    @Order(1)
    public void testRetrieveAllProduits() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }

    
       @Test
    @Order(2)
    public void testAddProduit() {
        Date date = new Date();
        Produit p = new Produit("ss","ss",100,date,date);
    	Produit savedStock= ps.addProduit(p);
    assertEquals(p.getLibelleProduit(), savedStock.getLibelleProduit());
    }
    
    @Test
    @Order(3)
    public void testRetrieveProduit() {
    	Produit p = ps.retrieveProduit((long) 1);
    assertEquals("1", p.getIdProduit().toString());
    }
    @Test
    @Order(4)
    public void testDeleteProduit() {
    	ps.deleteProduit((long) 1);
    assertNull(ps.retrieveProduit((long) 1).toString());
    }

}
