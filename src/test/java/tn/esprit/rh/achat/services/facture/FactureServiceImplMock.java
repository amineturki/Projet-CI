package tn.esprit.rh.achat.services.facture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class FactureServiceImplMock {

	
	@Mock
	FactureRepository factureRepository;
	
	@InjectMocks
	FactureServiceImpl factureService;
	
	Date C = new Date();
	Date M = new Date();
	Facture f = new Facture(2500, 21300,C ,M, true);
	
	List<Facture> listFacture = new ArrayList<Facture>() {
		{
		add(new Facture(2420, 72200,C ,M, false));
		add(new Facture(110, 120,C ,M, false));
		}
	};
	
	@Test
	public void testRetrieveFacture() {
		Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Facture facture1 = factureService.retrieveFacture(2L);
		Assertions.assertNotNull(facture1);
	}
	
}
