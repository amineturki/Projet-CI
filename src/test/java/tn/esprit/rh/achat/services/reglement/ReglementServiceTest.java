package com.esprit.examen.services;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;

import org.junit.jupiter.api.*;


import static org.junit.Assert.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperateurServiceImplTest {
	@Autowired
	IOperateurService OperateurService;

	
    @Test
    @Order(1)
    public void testRetrieveAllOperateurs() {
        List<Operateur> listOperateurs = OperateurService.retrieveAllOperateurs();
        Assertions.assertEquals(0, listOperateurs.size());
    }
    @Test
    @Order(2)
     void testAddOperateur() {
    	Operateur o = new Operateur("ahmed","ahmed","aaaaaa");
    	Operateur savedStock= OperateurService.addOperateur(o);
    assertEquals(o.getIdOperateur(), savedStock.getIdOperateur());
    }
    
    @Test
    @Order(3)
     void testRetrieveOperateur() {
    	Operateur o = OperateurService.retrieveOperateur((long) 1);
    assertEquals("1", o.getIdOperateur().toString());
}
}
