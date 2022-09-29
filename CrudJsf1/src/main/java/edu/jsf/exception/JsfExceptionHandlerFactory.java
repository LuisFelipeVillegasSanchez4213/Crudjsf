package edu.jsf.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class JsfExceptionHandlerFactory extends ExceptionHandlerFactory{

	private ExceptionHandlerFactory parent;
	
	public JsfExceptionHandlerFactory() {}
	public JsfExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}
	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler result = new JsfExceptionHandler(parent.getExceptionHandler());
		return result;
	}

	
}
