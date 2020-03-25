package my.inmemory.cash.controller;

import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.inmemory.cash.model.Customer;
import my.inmemory.cash.service.CustomerService;

@RestController
@RequestMapping(value="/")
public class CashingApi {
	
@Autowired
CustomerService customerService;

/**
 * 
 * @return
 * find all data from cache
 */
@GetMapping(value="api/customer/cashing/removed")
public Set<Entry<String, Customer>> findAll(){
	Set<Entry<String, Customer>> customers = customerService.findAllCustomers();
	return customers;
}

/**
 * 
 * @return
 * find all data before cache removed
 */
@GetMapping(value="api/customer/cashing")
public Set<Entry<String, Customer>> findAllBeforeCashe(){
	
	return customerService.findAllbeforeCashe();
}

/**
 * 
 * @param key
 * @return
 * find data by key
 */

@GetMapping(value="api/customer/cashing/{key}")
public Customer findbyKey(@PathVariable String key){
	Customer customer = customerService.getByKey(key);
	return customer;
}
}
