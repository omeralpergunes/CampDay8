package kodlamaio.hrms1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms1.entities.concretes.Employees;

public interface EmployeesDao extends JpaRepository<Employees, Integer>{

}
