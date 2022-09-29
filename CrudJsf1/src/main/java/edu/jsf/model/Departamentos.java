package edu.jsf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;


@Entity
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_departamento;

    private int departamento_codigo;
    private String nombre_departamento;
    private Date fecha_hora_crea;
    private Date fecha_hora_modifica;

    public Departamentos() {
    }

    public Departamentos(Integer id_departamento, int departamento_codigo, String nombre_departamento, Date fecha_hora_crea, Date fecha_hora_modifica) {
        this.id_departamento = id_departamento;
        this.departamento_codigo = departamento_codigo;
        this.nombre_departamento = nombre_departamento;
        this.fecha_hora_crea = fecha_hora_crea;
        this.fecha_hora_modifica = fecha_hora_modifica;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getDepartamento_codigo() {
        return departamento_codigo;
    }

    public void setDepartamento_codigo(int departamento_codigo) {
        this.departamento_codigo = departamento_codigo;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public Date getFecha_hora_crea() {
        Calendar c1 = GregorianCalendar.getInstance();
        return c1.getTime();
    }

    public void setFecha_hora_crea(Date fecha_hora_crea) {
        this.fecha_hora_crea = fecha_hora_crea;
    }

    public Date getFecha_hora_modifica() {
        Calendar c1 = GregorianCalendar.getInstance();
        return c1.getTime();
    }

    public void setFecha_hora_modifica(Date fecha_hora_modifica) {
        this.fecha_hora_modifica = fecha_hora_modifica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamentos that = (Departamentos) o;
        return departamento_codigo == that.departamento_codigo && id_departamento.equals(that.id_departamento) && nombre_departamento.equals(that.nombre_departamento) && fecha_hora_crea.equals(that.fecha_hora_crea) && fecha_hora_modifica.equals(that.fecha_hora_modifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_departamento, departamento_codigo, nombre_departamento, fecha_hora_crea, fecha_hora_modifica);
    }
}
