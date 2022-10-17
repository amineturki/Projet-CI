package tn.esprit.rh.achat.services.reglement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ReglementServiceMok {

		
		@Mock
		ReglementRepository regRepository;
		
		@InjectMocks
		ReglementServiceImpl regService;
		
		Date date = new Date();
        Reglement r = new Reglement((float)100,(float)111,true,date);
		
		List<Reglement> listReglement = new ArrayList<Reglement>() {
			{
			add(new Reglement((float)100,(float)111,false,date));
			add(new Reglement((float)200,(float)222,true,date));
			}
		};
		
		@Test
		public void testRetrieveReglement() {
			Mockito.when(regRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(r));
			Reglement reg1 = regService.retrieveReglement(2L);
			Assertions.assertNotNull(reg1);
		}
		
}
