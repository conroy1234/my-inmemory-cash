package my.inmemory.cash.data;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Component;

import my.inmemory.cash.CustomerInmemoryCash;
import my.inmemory.cash.exception.CustomerNotFoundException;
import my.inmemory.cash.model.Customer;

@Component
public class SourceData {

	private SourceData() {

	}

	private static SourceData instance;

	public static SourceData getInstance() {
		instance = new SourceData();
		return instance;
	}

	private LinkedHashMap<String, Customer> cashe = CustomerInmemoryCash.getInstance(6);

	public LinkedHashMap<String, Customer> getByKey() {

		cashe.put("customer1", new Customer("Jain Downing", "079303145256", LocalDateTime.now(), "bedford"));
		cashe.put("customer2", new Customer("Stephen Thomas", "58754", LocalDateTime.now(), "Dagenham London"));
		cashe.put("customer3", new Customer("Craig Bailey", "079303145256", LocalDateTime.now(), "Manchester"));
		cashe.put("customer4", new Customer("Mike Wayne", "079303145256", LocalDateTime.now(), "Liverpool"));
		cashe.put("customer5", new Customer("Jessica Craige", "079303145256", LocalDateTime.now(), "London"));
		cashe.put("customer6", new Customer("Philip Taylor", "079303145256", LocalDateTime.now(), "kent"));

		return cashe;

	}

	// return all the values while removing the first two
	public Set<Entry<String, Customer>> findAllBeforeCasheRemoved() {
		getByKey();
		return cashe.entrySet();
	}

	// return all the values while removing the first two
	public Set<Entry<String, Customer>> findAllWithTwoFirsValuesRemoved() {
		this.cashe = CustomerInmemoryCash.newInstance(4);
		getByKey();
		return cashe.entrySet();
	}

	// return the search value if exist
	public Customer findOneCustomerBykey(String key) {
		Customer customer = getByKey().get(key);
		if(customer==null) {
			throw new CustomerNotFoundException(" no value to be return for "+key);
		}
		return customer;

	}

}
