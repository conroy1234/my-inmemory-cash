package my.inmemory.cash.service;

import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import my.inmemory.cash.data.SourceData;
import my.inmemory.cash.model.Customer;

@Service
public class CustomerService {
	
	public Set<Entry<String, Customer>> findAllCustomers() {
		return SourceData.getInstance().findAllWithTwoFirsValuesRemoved();
	}

	public Customer getByKey(String key) {
		return SourceData.getInstance().findOneCustomerBykey(key);
	}
	
	public Set<Entry<String, Customer>> findAllbeforeCashe() {
		return SourceData.getInstance().findAllBeforeCasheRemoved();
	}

}