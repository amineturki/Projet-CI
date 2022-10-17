package tn.esprit.rh.achat.services.facture;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class FactureServiceImpTest {
	
	@Autowired
	IFactureService us;
	@Test
	@Order(1)
	public void testRetrieveAllFactures() {
	List<Facture> listproduits = us.retrieveAllFactures();
	Assertions.assertEquals(0, listproduits.size());
	}
	
	
	@Test
	@Order(2)
	public void testAddFacture() {
		Date C = new Date();
		Date M = new Date();
	Facture f = new Facture(2500, 21300,C ,M, true);
	Facture FactureAdded = us.addFacture(f);
	Assertions.assertEquals(f.getIdFacture(), FactureAdded.getIdFacture());
	}
	
	
	@Test
	@Order(3)
	public void testRetrieveFacture() {
	Facture factureRetrived = us.retrieveFacture(1L);
	Assertions.assertEquals(1L, factureRetrived.getIdFacture());
	
	}
	

}
