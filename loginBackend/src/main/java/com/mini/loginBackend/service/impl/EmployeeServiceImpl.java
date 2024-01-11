package com.mini.loginBackend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mini.loginBackend.dto.EmployeeDTO;
import com.mini.loginBackend.dto.LoginDTO;
import com.mini.loginBackend.dto.SignupDTO;
import com.mini.loginBackend.dto.UpdateEmployeeByAdminDTO;
import com.mini.loginBackend.dto.UpdateEmployeeDTO;
import com.mini.loginBackend.entity.Employee;
import com.mini.loginBackend.repository.EmployeeRepository;
import com.mini.loginBackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		 List<Employee> employees = employeeRepository.findAll();
		 List<EmployeeDTO> employeesDTO = new ArrayList<>();
		 for(Employee employee : employees) {
			 EmployeeDTO emp = new EmployeeDTO();
			 BeanUtils.copyProperties(employee, emp);
			 employeesDTO.add(emp);
		 }
		 return employeesDTO;
	}

	@Override
	public ResponseEntity<EmployeeDTO> getEmployeeById(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employee, employeeDTO);
			return ResponseEntity.ok(employeeDTO);
		}
		return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<String> signUp(SignupDTO signUpDTO) {
		Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByEmailId(signUpDTO.getEmailId());
		if(optionalEmployee.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("EmailId Already Exists !");
		} else {
			if(signUpDTO.getRole().equalsIgnoreCase("user")) {
				Employee employee = new Employee();
				employee.setName(signUpDTO.getName());
				employee.setEmailId(signUpDTO.getEmailId());
				employee.setPassword(signUpDTO.getPassword());
				employee.setRole(signUpDTO.getRole());
				employeeRepository.save(employee);
				return ResponseEntity.ok("Employee created successfull!");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot create admin! Try as user");
		}
	}
	
//	@Override
//	public ResponseEntity<EmployeeDTO> loginSample2(LoginDTO loginDTO) {
//		Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByEmailId(loginDTO.getEmailId());
//		if(optionalEmployee.isPresent()) {
//			Employee employee = optionalEmployee.get();
//			EmployeeDTO edto = new EmployeeDTO();
//			edto.setId(employee.getId());
//			edto.setName(employee.getName());
//			edto.setEmailId(employee.getEmailId());
//			edto.setRole(employee.getRole());
//			return ResponseEntity.ok(edto);
//		}
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
	
	@Override
	public ResponseEntity<EmployeeDTO> loginSample2(LoginDTO loginDTO) {
		Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByEmailId(loginDTO.getEmailId());
		if(optionalEmployee.isPresent()) {
			Employee employeeDB = optionalEmployee.get();
			if(loginDTO.getRole().equalsIgnoreCase("user")) {
				if((employeeDB.getPassword().equals(loginDTO.getPassword())) && employeeDB.getRole().equals(loginDTO.getRole())) {
					EmployeeDTO edto = new EmployeeDTO();
					edto.setId(employeeDB.getId());
					edto.setName(employeeDB.getName());
					edto.setEmailId(employeeDB.getEmailId());
					edto.setRole(employeeDB.getRole());
					return ResponseEntity.ok(edto);
				} else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			} else if(loginDTO.getRole().equalsIgnoreCase("admin")) {
				if((employeeDB.getPassword().equals(loginDTO.getPassword())) && employeeDB.getRole().equals(loginDTO.getRole())) {
					EmployeeDTO edto = new EmployeeDTO();
					edto.setId(employeeDB.getId());
					edto.setName(employeeDB.getName());
					edto.setEmailId(employeeDB.getEmailId());
					edto.setRole(employeeDB.getRole());
					return ResponseEntity.ok(edto);
				}else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<String> login(LoginDTO loginDTO) {
		Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByEmailId(loginDTO.getEmailId());
		if(optionalEmployee.isPresent()) {
			Employee employeeDB = optionalEmployee.get();
			if(loginDTO.getRole().equalsIgnoreCase("user")) {
				if((employeeDB.getPassword().equals(loginDTO.getPassword())) && employeeDB.getRole().equals(loginDTO.getRole())) {
					return ResponseEntity.ok("User Login Success"); 
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
				}
			} else if(loginDTO.getRole().equalsIgnoreCase("admin")) {
				if((employeeDB.getPassword().equals(loginDTO.getPassword())) && employeeDB.getRole().equals(loginDTO.getRole())) {
					return ResponseEntity.ok("Admin Login Success"); 
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
				}
			} 
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found! Signup First");
	}
	
	@Override
	public ResponseEntity<UpdateEmployeeDTO> updateEmployee(Long id, UpdateEmployeeDTO updateEmployeeDTO) {
		System.out.println("id"+id+","+"upd"+updateEmployeeDTO);
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			Employee employeeDB = optionalEmployee.get();
			employeeDB.setName(updateEmployeeDTO.getName());
			employeeDB.setEmailId(updateEmployeeDTO.getEmailId());
			employeeDB.setPassword(updateEmployeeDTO.getPassword());
			
			Employee employee = employeeRepository.save(employeeDB);
			UpdateEmployeeDTO update = new UpdateEmployeeDTO();
			BeanUtils.copyProperties(employee, update);
			return ResponseEntity.ok(update);
		}
		return  new ResponseEntity<UpdateEmployeeDTO>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<UpdateEmployeeByAdminDTO> updateEmployeeByAdmin(Long id,UpdateEmployeeByAdminDTO updateEmployeeByAdminDTO) {
		System.out.println("id"+id+","+"upd"+updateEmployeeByAdminDTO);
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			Employee employeeDB = optionalEmployee.get();
			employeeDB.setName(updateEmployeeByAdminDTO.getName());
			employeeDB.setEmailId(updateEmployeeByAdminDTO.getEmailId());
			employeeDB.setRole(updateEmployeeByAdminDTO.getRole());
			
			Employee employee = employeeRepository.save(employeeDB);
			UpdateEmployeeByAdminDTO update = new UpdateEmployeeByAdminDTO();
			BeanUtils.copyProperties(employee, update);
			return ResponseEntity.ok(update);
		}
		return  new ResponseEntity<UpdateEmployeeByAdminDTO>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<String> deleteEmployee(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			return ResponseEntity.ok("Employee Deleted Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
	}



	
	

}
