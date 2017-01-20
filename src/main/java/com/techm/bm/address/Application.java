package com.techm.bm.address;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.fasterxml.jackson.annotation.JsonIgnore;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.techm.bm.address.*")
@EnableAutoConfiguration(exclude = {HypermediaAutoConfiguration.class}) 
//@EnableCaching
@EnableMongoRepositories(value = { "com.techm.bm.mongodb_adapter" })
public class Application {
  private static String adapterType;
  
  public static String getAdapterType(){
	  return adapterType;
  }
  
  public static void setAdapterType(String adapterType){
	  Application.adapterType = adapterType;
  }
  
  public static void main(String[] args) {
	  
	  if(args.length != 0){
		  Application.setAdapterType(args[0]);

	  }else{
		  Application.setAdapterType("DAO");
	  }
	  
	  SpringApplication.run(Application.class, args);
  }
  
  @Bean
  public Docket newsApi() {
      return new Docket(DocumentationType.SWAGGER_2)
              .groupName("Address")
              .apiInfo(apiInfo())
              .select()              
              .paths(regex("/bsi/.*"))
              .build()
              .directModelSubstitute(XMLGregorianCalendar.class, MixIn.class);
  }
  
  public static interface MixIn {
      @JsonIgnore
      public void setYear(int year);
  }
   
  private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
              .title("Address REST APIs")
              .description("Address REST APIs")
              .termsOfServiceUrl("http://....")
              .contact("TechMahindra")
              .license("TechMahindra Licensed")
              .licenseUrl("https://techmahindra.com")
              .version("2.0")
              .build();
  }


}
