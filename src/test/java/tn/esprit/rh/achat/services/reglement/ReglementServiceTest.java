package tn.esprit.rh.achat.services.reglement;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReglementServiceTest {
	
    @Autowired
    IReglementService rs;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Reglement> listReglements = rs.retrieveAllReglements();
        Assertions.assertEquals(0, listReglements.size());
    }
    @Test
    @Order(2)
     void testAddRegelemnt() {
        Date date = new Date();
        Reglement r = new Reglement((float)100,(float)111,true,date);
    	Reglement savedStock= rs.addReglement(r);
    assertEquals(r.getIdReglement(), savedStock.getIdReglement());
    }
    
    @Test
    @Order(3)
     void testRetrieveReglement() {
    	Reglement r = rs.retrieveReglement((long) 1);
    assertEquals("1", r.getIdReglement().toString());
    }


}
