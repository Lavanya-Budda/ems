package com.ems.repository;

import com.ems.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee,String> {

    Employee findAllById(String empId);
  //@Query(value = "select e from Employee e where e.empId=:empId")
    List<Employee> findByEmpId(Long empId);


//    Employee findByEmpId(Long empId);

    List<Employee> findByEmpName(String name);

    String deleteById(Long empId);
}
