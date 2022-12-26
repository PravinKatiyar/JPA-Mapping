package com.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	public Employee findById(long id);

	//fetching specific columns from a Employee table
	@Query("SELECT new com.company.EmployeeNameCodeDto(e.employeeName,e.employeeCode) FROM Employee e where e.id=?1")
	public EmployeeNameCodeDto findEmployeeNameCode(Long i);
	
	//fetching specific colums from Address & employee table by SQL JOIN
	@Query("SELECT new com.company.EmployeeNameAndCityDto(e.employeeName,a.city) FROM Employee e "
			+ "INNER JOIN Address a ON a.id=e.id where e.id=?1")
	public EmployeeNameAndCityDto findEmployeeNameAndCity(Long i);
		 
	
}
