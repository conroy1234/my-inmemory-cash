package my.inmemory.cash.data;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.inmemory.cash.exception.CustomerNotFoundException;
import my.inmemory.cash.model.Customer;

class SourceDataTest {
Logger logger = LoggerFactory.getLogger(SourceDataTest.class);
	
	SourceData sourceData = SourceData.getInstance();

	@Test
	public void when_find_all() {

		LinkedHashMap<String, Customer> data = sourceData.getByKey();
		Set<Entry<String, Customer>> entrySet = data.entrySet();
		entrySet.forEach(k -> {
			String customer = k.getValue().toString();
			logger.info(customer.toString());
		});

		assertEquals(entrySet.size(), 6);
	}

	@Test
	public void when_find_all_with_first_two_removed() {

		Set<Entry<String, Customer>> entrySet = sourceData.findAllWithTwoFirsValuesRemoved();
		entrySet.forEach(k -> {
			String customer = k.getValue().toString();
			logger.info(customer.toString());
		});

		assertEquals(entrySet.size(), 4);
	}

	@Test
	public void when_find_customer_one() {

		Customer customer = sourceData.findOneCustomerBykey("customer1");
		assertEquals(customer.getName(), "Jain Downing");
		assertEquals(customer.getNumber(), "079303145256");
		assertEquals(customer.getAddress(), "bedford");
		logger.info(customer.toString());
	}

	@Test
	public void when_find_customer_two() {

		Customer customer = sourceData.findOneCustomerBykey("customer2");
		assertEquals(customer.getName(), "Stephen Thomas");
		assertEquals(customer.getNumber(), "58754");
		assertEquals(customer.getAddress(), "Dagenham London");
		logger.info(customer.toString());
	}
	
	@Test
	public void when_find_customer_three() {
		
		Customer customer = sourceData.findOneCustomerBykey("customer3");
		assertEquals(customer.getName(), "Craig Bailey");
		assertEquals(customer.getNumber(), "079303145256");
		assertEquals(customer.getAddress(), "Manchester");
		logger.info(customer.toString());
	}
	
	@Test
	public void when_find_customer_four() {

		Customer customer = sourceData.findOneCustomerBykey("customer4");
		assertEquals(customer.getName(), "Mike Wayne");
		assertEquals(customer.getNumber(), "079303145256");
		assertEquals(customer.getAddress(), "Liverpool");
		logger.info(customer.toString());
	}


}
