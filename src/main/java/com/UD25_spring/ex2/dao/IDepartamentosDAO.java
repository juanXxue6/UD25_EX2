package com.UD25_spring.ex2.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.UD25_spring.ex2.dto.Departamentos;

public interface IDepartamentosDAO extends JpaRepository<Departamentos, Long>  {

}
