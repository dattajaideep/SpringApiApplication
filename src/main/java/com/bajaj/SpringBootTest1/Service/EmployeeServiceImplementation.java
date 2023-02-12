package com.bajaj.SpringBootTest1.Service;

import com.bajaj.SpringBootTest1.Bean.EmployeeBean;
import com.bajaj.SpringBootTest1.Dao.EmployeeDao;
import com.bajaj.SpringBootTest1.Entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation {
    @Autowired
    private EmployeeDao employeeDao;
    public ResponseEntity<EmployeeBean> addEmployee(EmployeeBean employeeBean) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employeeBean , employeeEntity);
        employeeDao.save(employeeEntity);
        System.out.println("record Saved");
        return new ResponseEntity<EmployeeBean>(employeeBean, HttpStatus.OK);
    }
    public String deleteEmployee(int id){
        employeeDao.deleteById(id);
        return "Employee Deleted"+id;
    }

    public List<EmployeeEntity> allRecords() {
        return employeeDao.findAll();

    }
    public String updateEmployee(){
        EmployeeEntity employeeEntity=employeeDao.findById(102);
        employeeEntity.setFirstName("Rohith");
        employeeDao.save(employeeEntity);
        return employeeEntity.getFirstName();
    }

}