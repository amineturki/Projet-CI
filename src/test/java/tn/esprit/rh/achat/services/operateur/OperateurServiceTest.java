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
	@Test
	@Order(2)
	public void testAddOperateur() {
		Operateur o = new Operateur("op","op","100");
		Operateur savedoperateur= ss.addOperateur(o);
	assertEquals(o.getNom(), savedoperateur.getNom());
	}
	@Test
	@Order(3)
	public void testRetrieveOperateur() {
		Operateur op = ss.retrieveOperateur((long) 1);
	assertEquals("1", op.getIdOperateur().toString());
	}
	@Test
	@Order(4)
	public void testDeleteOperateur() {
	ss.deleteOperateur(1L);
	assertNull(ss.retrieveOperateur(1L));
	}
	

	

}
