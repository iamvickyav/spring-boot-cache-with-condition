package com.iamvickyav.CacheDemo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Column(name = "emp_id")
    @Id
    Integer id

    @Column(name = "emp_name")
    String name

    @Column(name = "emp_age")
    Integer age

    @Enumerated
    @Column(name= "emp_type")
    EmpType empType
}
