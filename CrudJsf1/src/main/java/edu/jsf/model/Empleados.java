package edu.jsf.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class Empleados implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String documento_tipo;
	private int documento_numero;
	private String nombre;
	private String apellidos;

	/*Aqui se le colocaria la relacion que seria @OneToMany(mappedBy = "id_departamento", cascade = CascadeType.ALL,orphanRemoval = true)
	pero por algun tipo de error no la carga correctamente por tanto se deja como tipo int mientras tanto*/
	private int departamento;

	private String ciudad;
	private String direccion;
	private String email;
	private String telefono;
	private Date fecha_hora_crea;
	private Date fecha_hora_modifica;

	public Empleados() {
	}

	public Empleados(Integer id, String documento_tipo, int documento_numero, String nombre, String apellidos, int departamento, String ciudad, String direccion, String email, String telefono, Date fecha_hora_crea, Date fecha_hora_modifica) {
		this.id = id;
		this.documento_tipo = documento_tipo;
		this.documento_numero = documento_numero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.fecha_hora_crea = fecha_hora_crea;
		this.fecha_hora_modifica = fecha_hora_modifica;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento_tipo() {
		return documento_tipo;
	}

	public void setDocumento_tipo(String documento_tipo) {
		this.documento_tipo = documento_tipo;
	}

	public int getDocumento_numero() {
		return documento_numero;
	}

	public void setDocumento_numero(int documento_numero) {
		this.documento_numero = documento_numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
}
