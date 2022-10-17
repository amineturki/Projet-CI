package tn.esprit.rh.achat.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class OperateurServiceTest {
	
	@Autowired
	IOperateurService ss;
	@Test
	@Order(1)
	public void testRetrieveAllOperateurs() {
	List<Operateur> listoperateurs = ss.retrieveAllOperateurs();
	Assertions.assertEquals(0, listoperateurs.size());
	}

}
