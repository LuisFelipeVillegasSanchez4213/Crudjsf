package edu.jsf.web;

import edu.jsf.model.Departamentos;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

@ManagedBean
@ViewScoped
public class DepartamentoJsfBean extends BaseCrudJsfBean<Departamentos>{

    public Departamentos getDepartamento(){return getCrudObj();}

    public void setDepartamento(Departamentos departamento){setCrudObj(departamento);}


    public List<Departamentos> getPeople() {
        return getCrudList();
    }

    public void setPeople(List<Departamentos> listasD){setCrudList(listasD);}
}
