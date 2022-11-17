package com.UD25_spring.ex2.service;

import java.util.List;

import com.UD25_spring.ex2.dto.Departamentos;


public interface IDepartamentosService {
	
	public List<Departamentos> listarDepartamentos(); 
	
	public Departamentos guardarDepartamentos(Departamentos departamentos);	
	
	public Departamentos departamentosXID(Long dni); 
	
	public Departamentos actualizarDepartamentos(Departamentos departamentos); 
	
	public void eliminarDepartamentos(Long id);

}
