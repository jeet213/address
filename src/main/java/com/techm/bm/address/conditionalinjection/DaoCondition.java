package com.techm.bm.address.conditionalinjection;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DaoCondition implements Condition{
 
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
	  //return context.getEnvironment().getProperty("adapter.type").contains("DAO");
	  //return Application.getAdapterType().contains("DAO");
	  return true;
  }
}

