package com.iamvickyav.CacheDemo.service

import com.iamvickyav.CacheDemo.dao.EmployeeRepo
import com.iamvickyav.CacheDemo.model.EmpType
import com.iamvickyav.CacheDemo.model.Employee
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Slf4j
@Service
class EmployeeService {

    @Autowired
    EmployeeRepo repo

    @Cacheable(cacheNames = ["emp_cache"])
    Employee getEmployeeDetail(Integer id) {
        log.info("Reading from DB: Employee with Id=${id}")
        Employee employee = repo.findById(id).get()
        return employee
    }

    @Cacheable(cacheNames = ["young_emp_cache"], key = "#age", condition = "#age < 30")
    List<Employee> getEmployeesByAge(Integer age) {
        log.info("Reading from DB: Employee with age < ${age}")
        List<Employee> list = repo.findAllByAgeLessThan(age)
        return list
    }

    @Cacheable(cacheNames = ["temp_emp_cache"], unless = "#result.empType.isPermanent()")
    Employee getAllEmployees(Integer id) {
        log.info("Reading from DB: Employee with id=${id}")
        repo.findById(id).get()
    }
}
