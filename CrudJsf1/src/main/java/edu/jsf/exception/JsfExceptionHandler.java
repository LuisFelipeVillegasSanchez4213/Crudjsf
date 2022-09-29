package edu.jsf.exception;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.lang3.exception.ExceptionUtils;
import java.util.Iterator;

public class JsfExceptionHandler extends ExceptionHandlerWrapper{
	private ExceptionHandler wrapped;
	
	public JsfExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}
	
	@Override
	public void handle() throws FacesException{
		Iterator<ExceptionQueuedEvent> i =  getUnhandledExceptionQueuedEvents().iterator();
		while(i.hasNext()) {
			ExceptionQueuedEvent event = (ExceptionQueuedEvent)i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			
			Throwable t = context.getException();
			try {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ExceptionUtils.getRootCauseMessage(t), null));
				
			}finally {
				i.remove();
			}
		}
		
		getWrapped().handle();
	}
}
