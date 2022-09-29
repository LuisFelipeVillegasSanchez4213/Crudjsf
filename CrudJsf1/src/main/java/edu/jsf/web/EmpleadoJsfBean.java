package edu.jsf.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.jsf.model.Empleados;

@ManagedBean
@ViewScoped
public class EmpleadoJsfBean extends BaseCrudJsfBean<Empleados>{

	public Empleados getEmpleado(){
		return getCrudObj();
	}
	
	public void setEmpleado(Empleados empleado) {
		setCrudObj(empleado);
	}
	
	public List<Empleados> getPeople(){
		return getCrudList();
	}
	
	public void setPeople(List<Empleados> people) {
		setCrudList(people);
	}
}
