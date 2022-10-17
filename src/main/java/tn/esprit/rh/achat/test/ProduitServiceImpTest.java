package tn.esprit.rh.achat.test;


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

import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.services.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class FournisseurServiceImpTest {
	
	@Autowired
	IFournisseurService f;
	@Test
	@Order(1)
	public void testRetrieveAllFournisseurs() {
	List<Facture> listF = f.retrieveAllFournisseurs();
	Assertions.assertEquals(0, listF.size());
	}
	
	
	@Test
	@Order(2)
	public void testAddFournisseur() {
	Fournisseur fo = new Facture(2500, llll,libelle ,ORDINAIRE);
	Fournisseur FournisseurAdded = f.addFournisseur(fo);
	Assertions.assertEquals(fo.getIdFournisseure(), FournisseurAdded.getIdFournisseur());
	}
	
	
	@Test
	@Order(3)
	public void testRetrieveFournisseur() {
	Fournisseur FournisseurRetrived = us.Fournisseure(1L);
	Assertions.assertEquals(1L, FournisseurRetrived.getIdFournisseur());
	
	}
	

}
