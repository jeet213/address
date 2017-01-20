package com.techm.bm.address.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techm.bm.address.errors.ErrorCodes;
import com.techm.bm.address.services.AddressService;
import com.techm.bm.mongodb_adapter.Customer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 *
 * @author TechMahindra
 */
@RestController
@RequestMapping("/bsi/Address")
public class AddressController {

	@Autowired
	private AddressService service;

	private static final Logger LOG = LoggerFactory.getLogger(AddressController.class);

	@ApiOperation(value = "Fetch All Address", notes = "Fetch All Address(s)")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returns the list of Address(s)"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/v1" }, method = { RequestMethod.GET }, produces = { "application/json" })
	public ResponseEntity<?> getAllAddresss() {
		try {
			LOG.info("AddressController:: getAll method started ");
			List<Object> fetchedAddresss = service.findAll();
			return new ResponseEntity<List<Object>>(fetchedAddresss, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(),
					HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

	
	@ApiOperation(value = "Create New Address(s)", notes = "Create New Address(s)")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created new Address(s) Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/v1" }, method = RequestMethod.POST)
	public ResponseEntity<?> createAddress(@RequestBody List<Customer> list) {  
		try {
			
			//Generic template code
			//Object response = service.save(list);

			// Mongodb template code
			list.forEach(cust -> System.out.println("::"+cust));
			List<Object> documentList = new ArrayList<Object>();
			documentList.addAll(list);
			Object response = service.save(documentList);
			
			
			return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(),
					HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

	@ApiOperation(value = "Update Existing Address(s)", notes = "Update Existing Address(s)")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated Existing Address(s) Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/v1" }, method = RequestMethod.PUT)
	public ResponseEntity<?> updateAddress(@RequestBody List<Customer> list) {  
		try {
			
			//Generic template code
			//Object response = service.save(list);

			// Mongodb template code
			List<Object> documentList = new ArrayList<Object>();
			  documentList.addAll(list);
			  Object response = service.save(documentList);
			
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(),
					HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@ApiOperation(value = "Delete Address(s)", notes = "Delete Address(s) for list of input ids")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Deleted Address(s) Successfully"),
							@ApiResponse(code = 500, message = "Internal Server Error")
						})	 
	  @RequestMapping(value={"/v1"}, method=RequestMethod.DELETE)
	  public ResponseEntity<?> delete(@RequestBody List<Customer> list) {
		  try {
			  List<Object> documentList = new ArrayList<Object>();
			  documentList.addAll(list);
			  service.delete(documentList);
			  return new ResponseEntity<String>("Success", HttpStatus.OK);
		  } catch (Exception e) {
			  e.printStackTrace();
			  return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(), HttpStatus.INTERNAL_SERVER_ERROR));
		  }
		  
	  }

	} // class ServiceController
