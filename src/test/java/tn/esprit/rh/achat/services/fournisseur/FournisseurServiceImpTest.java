package tn.esprit.rh.achat.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.services.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FournisseurServiceImpTest {
	
	@Autowired
	IFournisseurService f ;
	@Test
	@Order(1)
	public void testRetrieveAllF() {
	List<Fournisseur> listF = f. retrieveAllFournisseurs();
	Assertions.assertEquals(0, listF.size());
	}
	@Test
	@Order(2)
	public void testAddF() {
		Fournisseur fo = new Fournisseur("x0258","libelle","ORDINAIRE");
		Fournisseur savedF= f.addFournisseur(fo);
	assertEquals(o.getNom(), savedFournisseur.getNom());
	}
	@Test
	@Order(3)
	public void testDeleteF() {
	f.deleteFournisseur(1L);
	assertNull(f.retrieveFournisseur(1L));
	}
	

	

}
