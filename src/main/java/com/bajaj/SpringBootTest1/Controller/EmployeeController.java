package com.bajaj.SpringBootTest1.Controller;

import com.bajaj.SpringBootTest1.Bean.EmployeeBean;
import com.bajaj.SpringBootTest1.Entity.EmployeeEntity;
import com.bajaj.SpringBootTest1.Service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//
public class EmployeeController{
    @Autowired
    private EmployeeServiceImplementation serviceImplementation;
    @GetMapping("/allRecords")
    public List<EmployeeEntity> allRecords(){
        List<EmployeeEntity> msg=serviceImplementation.allRecords();
        return msg;
    }
    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeBean> addEmployee(@RequestBody EmployeeBean employeeBean){
        return serviceImplementation.addEmployee(employeeBean);
    }
    @DeleteMapping("/deleteRecordId/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return serviceImplementation.deleteEmployee(id);
    }
    @GetMapping("/updateEmployee")
    public String updateEmployee(){

        return serviceImplementation.updateEmployee();
    }
    @RequestMapping("*")
    public String error(){
        return "ERROR";
    }
}