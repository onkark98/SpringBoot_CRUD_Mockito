package net.javaguides.SpringbootBackend.repository;

import net.javaguides.SpringbootBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all crud methods will be coming up
}
