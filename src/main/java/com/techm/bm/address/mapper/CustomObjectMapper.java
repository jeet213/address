package com.techm.bm.address.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

@Component
public class CustomObjectMapper extends ObjectMapper {
	
	private static final Logger LOG = LoggerFactory
			.getLogger(CustomObjectMapper.class);

	public CustomObjectMapper() {
		super();

		LOG.info("CustomObjectMapper invoked....");
		final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		this.setAnnotationIntrospector(introspector);
	}   
	   
}


