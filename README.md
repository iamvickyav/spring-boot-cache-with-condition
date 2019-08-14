# SpringBoot Cache with Condition

## Employee Model Class

```java
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

enum EmpType {

    PERMANENT('PERMANENT'),
    CONTRACTOR('CONTRACTOR')

    String empType

    EmpType(String empType) {
        this.empType = empType
    }

    boolean isPermanent() {
        this == PERMANENT
    }
}
```

## Get List of Employees whose age is less than given age
### Cache List of Employee only if their age is less than 30

```java
@Cacheable(cacheNames = ["young_emp_cache"], key = "#age", condition = "#age < 30")
List<Employee> getEmployeesByAge(Integer age) {
}
```

## Find Employee by ID
### Cache Employee unless he is Permanent

```java
@Cacheable(cacheNames = ["temp_emp_cache"], unless = "#result.empType.isPermanent()")
Employee getAllEmployees(Integer id) {
}
```

