package com.springBootCode.springbootcode.controller;

import com.springBootCode.springbootcode.entity.Department;
import com.springBootCode.springbootcode.error.DepartmentNotFoundException;
import com.springBootCode.springbootcode.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
        department =
                Department.builder().
                departmentId(1L).
                departmentName("IT").
                departmentAddress("Mumbai").
                departmentEmployeeCode("IT-01").
                build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment =
                Department.builder().
                        departmentName("IT").
                        departmentAddress("Mumbai").
                        departmentEmployeeCode("IT-01").
                        build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).
                thenReturn(department);
        mockMvc.perform(post("/departments").
                contentType(MediaType.APPLICATION_JSON).
                content("{\n" +
                        "\t\n" +
                        "\t\"departmentName\":\"IT\",\n" +
                        "\t\"departmentAddress\":\"Mumbai\",\n" +
                        "\t\"departmentEmployeeCode\":\"IT-01\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void fetchingDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchingDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}