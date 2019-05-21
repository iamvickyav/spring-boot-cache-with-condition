package com.iamvickyav.CacheDemo.dao

import com.iamvickyav.CacheDemo.model.EmpType
import com.iamvickyav.CacheDemo.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByAgeLessThan(Integer age)
}