package com.UD25_spring.ex2.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="departamentos")
public class Departamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	
	@Column(name = "presupuesto")//no hace falta si se llama igual
	private String presupuesto;
	
    @OneToMany
    @JoinColumn(name="id")
    private List<Empleados> empleados;

	public Departamentos(Long id, String nombre, String presupuesto, List<Empleados> empleados) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.empleados = empleados;
	}

	public Departamentos() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}


	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleados")
	public List<Empleados> getArticulos() {
		return empleados;
	}

	/**
	 * @param video the video to set
	 */
	public void setArticulos(List<Empleados> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Departamentos [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", empleados="
				+ empleados + "]";
	}

}
