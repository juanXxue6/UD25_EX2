package com.UD25_spring.ex2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.UD25_spring.ex2.dto.Departamentos;
import com.UD25_spring.ex2.service.DepartamentosServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentosController {
	@Autowired
	DepartamentosServiceImpl departamentosServiceImpl;
	
	@GetMapping("/departamentos")
	public List<Departamentos> listarClientes(){
		return departamentosServiceImpl.listarDepartamentos();
	}
	
	@PostMapping("/departamentos")
	public Departamentos salvarCliente(@RequestBody Departamentos departamentos) {
		
		return departamentosServiceImpl.actualizarDepartamentos(departamentos);
	}
	
	@GetMapping("/departamentos/{id}")
	public Departamentos clienteXID(@PathVariable(name="id") Long id) {
		
		Departamentos departamentos_xid= new Departamentos();
		
		departamentos_xid = departamentosServiceImpl.departamentosXID(id);
		
		System.out.println("departamentos XDN: "+ departamentos_xid);
		
		return departamentos_xid;
	}
	
	@PutMapping("/departamentos/{id}")
	public Departamentos actualizarCliente(@PathVariable(name="id")Long id,@RequestBody Departamentos departamentos) {
		
		Departamentos departamentop_seleccionado= new Departamentos();
		Departamentos departamento_actualizado= new Departamentos();
		
		departamentop_seleccionado= departamentosServiceImpl.departamentosXID(id);
		
		departamentop_seleccionado.setNombre(departamentos.getNombre());
		departamentop_seleccionado.setPresupuesto(departamentos.getPresupuesto());

		
		departamento_actualizado = departamentosServiceImpl.actualizarDepartamentos(departamentop_seleccionado);
		
		System.out.println("El departamento actualizado es: "+ departamento_actualizado);
		
		return departamento_actualizado;
	}
	
	@DeleteMapping("/departamentos/{id}")
	public void eleiminarCliente(@PathVariable(name="id")Long id) {
		departamentosServiceImpl.eliminarDepartamentos(id);
	}
	
	
}
