package tn.esprit.rh.achat.test;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class ProduitServiceImpTest {
	
	@Autowired
	IProduitService us;
	@Test
	@Order(1)
	public void testRetrieveAllProduits() {
	List<Produit> listproduits = us.retrieveAllProduits();
	Assertions.assertEquals(0, listproduits.size());
	}

}
