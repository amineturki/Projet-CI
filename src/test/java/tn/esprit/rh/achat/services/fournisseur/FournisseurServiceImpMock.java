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

import tn.esprit.rh.achat.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class Fournisseur1ServiceImplMock {

	
	@Mock
	FactureRepository factureRepository;
	
	@InjectMocks
	FournisseurServiceImpl FournisseurService;
	
	
	Fournisseur f = new Fournisseur(1000, nbhiyy,dtttt ,ORDINAIRE);
	
	List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>() {
		{
		add(new Fournisseur(2000, cccc,lllll ,ORDINAIRE));
		add(new Fournisseur(3000, ffff,rrrr ,ORDINAIRE));
		}
	};
	
	@Test
	public void testRetrieveFournisseur() {
		Mockito.when(FournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Fournisseur Fournisseur1 = FournisseurService.retrieveFournisseur(2L);
		Assertions.assertNotNull(Fournisseur1);
	}
	
}
