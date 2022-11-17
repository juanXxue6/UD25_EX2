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


import com.UD25_spring.ex2.dto.Empleados;
import com.UD25_spring.ex2.service.EmpleadosServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadosController {
	
	@Autowired
	EmpleadosServiceImpl empleadoServiceImpl;
	
	@GetMapping("/empleados")
	public List<Empleados> listarClientes(){
		return empleadoServiceImpl.listarEmpleados();
	}
	
	@PostMapping("/empleados")
	public Empleados salvarEmpleados(@RequestBody Empleados empleado) {
		System.out.println(empleado.toString());
		return empleadoServiceImpl.guardarEmpleados(empleado);
	}
	
	@GetMapping("/empleados/{id}")
	public Empleados EmpleadosXID(@PathVariable(name="id") Long id) {
		
		Empleados empleados_xid= new Empleados();
		
		empleados_xid = empleadoServiceImpl.EmpleadosXDNI(id);
		
		System.out.println("empleados XDN: "+ empleados_xid);
		
		return empleados_xid;
	}
	
	@PutMapping("/Empleados/{id}")
	public Empleados actualizarEmpleados(@PathVariable(name="id")Long id,@RequestBody Empleados Empleados) {
		
		Empleados empleado_seleccionado= new Empleados();
		Empleados empleado_actualizado= new Empleados();
		
		empleado_seleccionado= empleadoServiceImpl.EmpleadosXDNI(id);
		
		empleado_seleccionado.setNombre(Empleados.getNombre());
		empleado_seleccionado.setApellidos(Empleados.getApellidos());
		empleado_seleccionado.setDepartamentos(Empleados.getDepartamentos());
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El Empleado actualizado es: "+ empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	@DeleteMapping("/Empleados/{id}")
	public void eleiminarEmpleados(@PathVariable(name="id")Long id) {
		empleadoServiceImpl.eliminarArticulos(id);
	}
	
	
}
