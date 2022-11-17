package com.UD25_spring.ex2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UD25_spring.ex2.dao.IEmpleadosDAO;
import com.UD25_spring.ex2.dto.Empleados;

@Service
public class EmpleadosServiceImpl implements IEmpleadosService {

	@Autowired
	IEmpleadosDAO iEmpleadosDAO;
	
	@Override
	public List<Empleados> listarEmpleados() {
		// TODO Auto-generated method stub
		return iEmpleadosDAO.findAll();
	}

	@Override
	public Empleados guardarEmpleados(Empleados empleados) {
		// TODO Auto-generated method stub
		return iEmpleadosDAO.save(empleados);
	}

	@Override
	public Empleados EmpleadosXDNI(Long dni) {
		// TODO Auto-generated method stub
		return iEmpleadosDAO.findById(dni).get();
	}

	@Override
	public Empleados actualizarEmpleado(Empleados empleados) {
		// TODO Auto-generated method stub
		return iEmpleadosDAO.save(empleados);
	}

	@Override
	public void eliminarArticulos(Long id) {
		// TODO Auto-generated method stub
		iEmpleadosDAO.deleteById(id);
	}

}
