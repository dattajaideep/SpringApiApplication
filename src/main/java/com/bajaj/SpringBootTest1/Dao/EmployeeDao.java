package com.bajaj.SpringBootTest1.Dao;

import com.bajaj.SpringBootTest1.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeEntity,Integer>{
    EmployeeEntity findById(int eid);
}
