package com.UD25_spring.ex2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UD25_spring.ex2.dao.IDepartamentosDAO;
import com.UD25_spring.ex2.dto.Departamentos;

@Service
public class DepartamentosServiceImpl implements IDepartamentosService {

	@Autowired
	IDepartamentosDAO IdepartamentosDAO;
	
	@Override
	public List<Departamentos> listarDepartamentos() {
		// TODO Auto-generated method stub
		return IdepartamentosDAO.findAll();
	}
	
	@Override
	public Departamentos guardarDepartamentos(Departamentos departamentos) {
		// TODO Auto-generated method stub
		return IdepartamentosDAO.save(departamentos);
	}

	@Override
	public Departamentos departamentosXID(Long dni) {
		// TODO Auto-generated method stub
		return IdepartamentosDAO.findById(dni).get();
	}

	@Override
	public Departamentos actualizarDepartamentos( Departamentos departamentos) {
		// TODO Auto-generated method stub
		return IdepartamentosDAO.save(departamentos);
	}

	@Override
	public void eliminarDepartamentos(Long id) {
		// TODO Auto-generated method stub
		IdepartamentosDAO.deleteById(id);
	}



}
