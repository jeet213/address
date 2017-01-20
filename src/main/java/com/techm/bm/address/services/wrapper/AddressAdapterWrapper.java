package com.techm.bm.address.services.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techm.bm.mongodb_adapter.Customer;
import com.techm.bm.mongodb_adapter.CustomerRepository;

public class AddressAdapterWrapper extends IAddressWrapper {

	private static final Logger LOG = LoggerFactory.getLogger(AddressAdapterWrapper.class);

	// Mongodb adapter template code 
	@Autowired private CustomerRepository documentRepository;
	
	// SOAP adapter template code
	//@Autowired private SoapClient soapClient;
	
	public List<Object> find(String criteria) {
		
		LOG.info("AddressAdapterWrapper : find started...");
		List<Object> list = new ArrayList<Object>();
		
		//Generic code template
		/*String msg = "Resources for a given Criteria";
		list.add((Object)msg);*/
		
		// Mongodb adapter template code
		list.add(documentRepository.findById(criteria));
		
		return list;
	}
	
	public List<Object> findAll() {
		LOG.info("AddressAdapterWrapper : findAll started...");
		List<Object> list = new ArrayList<Object>();
		
		//Generic code template
		/*String msg = "All Resources";
		list.add((Object)msg);
		*/
		//Mongodb adapter template code
		list.addAll(documentRepository.findAll());
		
		//SOAP adapter template code
		/*Request request = new Request();
		request.setCustomerId("1");
		list.add(soapClient.invokeService(request));*/
		
		return list;
	}


	public Object save(List<Object> list) {
		LOG.info("AddressAdapterWrapper : save started...");
		
		//Generic code template
	//	return "Save a Resource";
		
		//Mongodb adapter template code
		
	/*	ObjectMapper objectMapper = new ObjectMapper();

	    List<Customer> navigation = objectMapper.readValue(
	    		list,
	            objectMapper.getTypeFactory().constructCollectionType(
	                    List.class, Customer.class));*/

		
		List<Customer> documentList = (List<Customer>)(List<?>) list;
		
		return documentRepository.save(documentList);

	}
	
	public Object delete(List<Object> list) {
		LOG.info("AddressAdapterWrapper : delete started$$::");
		
		//Generic code template
	//	return "Success";
				
		//Mongodb adapter template code
		List<Customer> documentIdList = (List<Customer>)(List<?>) list;
		
		
		
		//documentRepository.delete(documentRepository.findAll(documentIdList));
		documentRepository.delete(documentIdList);
		return "Success";
	}
		
}
