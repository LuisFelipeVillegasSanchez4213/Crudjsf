package edu.jsf.web;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import edu.jsf.service.CrudService;
import edu.jsf.util.ReflectionUtil;

public abstract class BaseCrudJsfBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected List<T> crudList;
	protected T crudObj;
	
	@ManagedProperty(value= "#{crudService}")
	protected CrudService crudService;
	
	@ManagedProperty("#{i18n}")
	private ResourceBundle i18n;
	
	public void setI18n(ResourceBundle i18n) {
		this.i18n = i18n;
	}
	
	public T getCrudObj() {
		return crudObj;
	}
	
	public void setCrudObj(T crudObj) {
		this.crudObj = crudObj;
	}
	
	public List<T> getCrudList() {
        return crudList;
    }

    public void setCrudList(List<T> crudList) {
        this.crudList = crudList;
    }
    
    public void setCrudService(CrudService crudService) {
        this.crudService = crudService;
    }
    
    /* encontramos lista*/
    
    protected void listAll() {
    	crudList = crudService.findAll(getCrudClass());
    }
    
    public Class getCrudClass() {
    	ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
    	return (Class) pt.getActualTypeArguments()[0];
    }
    
    @PostConstruct
    public void init() {
    	listAll();
    	createNewCrudObj();
    }
    
    public void createNewCrudObj() {
    	try {
    		crudObj = (T) getCrudClass().newInstance();
    	}catch(Exception ex) {
    		throw new RuntimeException(ex);
    	}
    }
    
    public void save() {
    	saveCrudObj();
    	showSuccessSaveMessage();
    	postSave();
    }
    
    protected void saveCrudObj() {
    	crudObj = crudService.save(crudObj);
    }
    protected void showSuccessSaveMessage() {
    	info("Registro guardado correctamemte");
    }
    
	public void editCrudObj(T obj){
		crudObj = obj;
	}
	
	public void deleteCrudObj(T obj){
		crudService.delete(obj);
		showSuccessDeleteMessage();
		postDelete();
	}
	
	protected void showSuccessDeleteMessage(){
		info("Registro eliminado correctamente");
	}
	
	protected void postDelete(){
		reloadCrudList();
		createNewCrudObj();
	}
    public void info(String message) {
    	getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message,null));
    }
    
    public FacesContext getFacesContext() {
    	return FacesContext.getCurrentInstance();
    }
    
    protected void postSave() {
    	reloadCrudObj();
    	reloadCrudList();
    }
    
    
    protected void reloadCrudObj() {
    	crudObj = (T) crudService.find(getCrudClass(), ReflectionUtil.getPKValue(crudObj));
    }
    protected void reloadCrudList() {
    	listAll();
    }
}
