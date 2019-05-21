package com.iamvickyav.CacheDemo.controller

import com.iamvickyav.CacheDemo.model.EmpType
import com.iamvickyav.CacheDemo.model.Employee
import com.iamvickyav.CacheDemo.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController {

    @Autowired
    EmployeeService service

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    Employee getEmployee(@RequestParam Integer id) {
        //service.getEmployeeDetail(id)
        service.getAllEmployees(id)
    }

    @RequestMapping(value = "/emp/all", method = RequestMethod.GET)
    List<Employee> getAllEmployees(@RequestParam("age") Integer age) {
        service.getEmployeesByAge(age)
    }
}
