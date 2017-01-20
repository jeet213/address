package com.techm.bm.address.conditionalinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import com.techm.bm.address.services.wrapper.AddressAdapterWrapper;


@Configuration
public class InjectionConfiguration {
 
  @Bean
  @Conditional(DaoCondition.class)
  public AddressAdapterWrapper injectSoapAdapter () throws Exception{
	  System.out.println("***INJECTING Generic Adapter Wrapper...****");
	  return new AddressAdapterWrapper();
  }
  
}
