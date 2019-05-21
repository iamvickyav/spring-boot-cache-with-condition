package com.iamvickyav.CacheDemo.model

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