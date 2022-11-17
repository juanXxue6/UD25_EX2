package com.UD25_spring.ex2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="empleados")
public class Empleados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	
	@Column(name = "apellidos")//no hace falta si se llama igual
	private String apellidos;
	
	@ManyToOne
    @JoinColumn(name="departamento") //FK
    private Departamentos departamentos;

	
	public Empleados(Long dni, String nombre, String apellidos, Departamentos departamentos) {
		this.id = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamentos = departamentos;
	}

	public Empleados() {
		
	}

	public Long getDni() {
		return id;
	}

	public void setDni(Long dni) {
		this.id = dni;
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

	public Departamentos getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	@Override
	public String toString() {
		return "Empleados [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", departamentos="
				+ departamentos + "]";
	}
	
	
	
}
