package com.mini.loginBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.loginBackend.dto.EmployeeDTO;
import com.mini.loginBackend.dto.LoginDTO;
import com.mini.loginBackend.dto.SignupDTO;
import com.mini.loginBackend.dto.UpdateEmployeeByAdminDTO;
import com.mini.loginBackend.dto.UpdateEmployeeDTO;
import com.mini.loginBackend.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employees/signup")
	public ResponseEntity<String> signUp(@RequestBody SignupDTO signUpDTO){
		return employeeService.signUp(signUpDTO);
	}
	
	@PostMapping("/employees/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
		return employeeService.login(loginDTO);
	}
	
	@PostMapping("/employees/login2")
	public ResponseEntity<EmployeeDTO> loginSample2(@RequestBody LoginDTO loginDTO){
		return employeeService.loginSample2(loginDTO);
	}
	
	@PutMapping("/employees/update/{id}")
	public ResponseEntity<UpdateEmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateEmployeeDTO){
		return employeeService.updateEmployee(id, updateEmployeeDTO);
	}
	
	@PutMapping("/employees/admin/update/{id}")
	public ResponseEntity<UpdateEmployeeByAdminDTO> updateEmployeeByAdmin(@PathVariable Long id, @RequestBody UpdateEmployeeByAdminDTO updateEmployeeByAdminDTO){
		return employeeService.updateEmployeeByAdmin(id, updateEmployeeByAdminDTO);
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
	
	
}
