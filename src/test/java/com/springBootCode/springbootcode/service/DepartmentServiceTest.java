package com.springBootCode.springbootcode.service;

import com.springBootCode.springbootcode.entity.Department;
import com.springBootCode.springbootcode.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setup(){
        Department department =
                Department.builder().
                        departmentName("IT").
                        departmentAddress("Mumbai").
                        departmentEmployeeCode("IT-06").
                        departmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).
                thenReturn(department);
    }
    @Test
    @DisplayName("Get Data based on valid Department Name")
    @Disabled                         // this annotation will disable this method.
    public void whenValidDepartName_theDepartmentShouldFound(){
        String departmentName = "IT";
        Department found  =
                departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());

    }

}