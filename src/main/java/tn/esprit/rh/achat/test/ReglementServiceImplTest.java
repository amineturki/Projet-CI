package tn.esprit.rh.achat.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ReglementServiceImplTest {
	
	@Autowired
	IReglementService rs;
	@Test
	@Order(1)
	public void testRetrieveAllReglments() {
	List<Reglement> listReglements = rs.retrieveAllReglements();
	Assertions.assertEquals(0, listReglements.size());
	}
	
}
