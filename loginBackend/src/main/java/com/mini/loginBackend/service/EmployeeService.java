package com.mini.loginBackend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mini.loginBackend.dto.EmployeeDTO;
import com.mini.loginBackend.dto.LoginDTO;
import com.mini.loginBackend.dto.SignupDTO;
import com.mini.loginBackend.dto.UpdateEmployeeByAdminDTO;
import com.mini.loginBackend.dto.UpdateEmployeeDTO;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployees();

	ResponseEntity<EmployeeDTO> getEmployeeById(Long id);

	ResponseEntity<String> signUp(SignupDTO signUpDTO);

	ResponseEntity<String> login(LoginDTO loginDTO);

	ResponseEntity<UpdateEmployeeDTO> updateEmployee(Long id, UpdateEmployeeDTO updateEmployeeDTO);

	ResponseEntity<EmployeeDTO> loginSample2(LoginDTO loginDTO);

	ResponseEntity<String> deleteEmployee(Long id);

	ResponseEntity<UpdateEmployeeByAdminDTO> updateEmployeeByAdmin(Long id, UpdateEmployeeByAdminDTO updateEmployeeByAdminDTO);

}
