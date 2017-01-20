
package com.techm.bm.address.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.techm.bm.address.services.wrapper.IAddressWrapper;

@org.springframework.stereotype.Service
public class AddressService {
	private static final Logger LOG = LoggerFactory.getLogger(AddressService.class);

	@Autowired
	private IAddressWrapper genericWrapper;

	public List<Object> find(String criteria) {
		LOG.info("AddressService : find started...");
		return genericWrapper.find(criteria);
	}
	
	public List<Object> findAll() {
		LOG.info("AddressService : findAll started...");
		return genericWrapper.findAll();
	}


	public Object save(List<Object> list) {
		LOG.info("AddressService :save started...");
		return genericWrapper.save(list);
	}
	
	public Object delete(List<Object> list) {
		LOG.info("AddressService :delete started...");
		return genericWrapper.delete(list);
	}
}
