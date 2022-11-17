package com.UD25_spring.ex2.service;

import java.util.List;

import com.UD25_spring.ex2.dto.Empleados;



public interface IEmpleadosService {
	public List<Empleados> listarEmpleados(); 
	
	public Empleados guardarEmpleados(Empleados empleados);	
	
	public Empleados EmpleadosXDNI(Long dni); 
	
	public Empleados actualizarEmpleado(Empleados empleados); 
	
	public void eliminarArticulos(Long id);
	
}
