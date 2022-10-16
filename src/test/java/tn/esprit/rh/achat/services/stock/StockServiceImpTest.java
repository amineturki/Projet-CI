package tn.esprit.rh.achat.services.stock;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StockServiceImpTest {

	@Autowired
	IStockService stockService;
	
	@Test
	@Order(1)
	public void testRetrieveALLStocks() {
		List<Stock> allStocks = stockService.retrieveAllStocks();
		Assertions.assertEquals(0,allStocks.size());
	}
	
	@Test
	@Order(2)
	public void testAddStock() {
		Stock s = new Stock("stock test",100,10);
		Stock savedStock = stockService.addStock(s);
		Assertions.assertEquals(s.getLibelleStock(),savedStock.getLibelleStock());
	}
	
	@Test
	@Order(3)
	public void testRetrieveStock() {
		Stock stock =  stockService.retrieveStock(1L);
		Assertions.assertEquals(1L,stock.getIdStock().longValue());
	}
	
	@Test
	@Order(4)
	public void testDeleteStock() {
		stockService.deleteStock(1L);
		Assertions.assertNull(stockService.retrieveStock(1L));
	}
	
	
}
