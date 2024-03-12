package net.javaguides.SpringbootBackend;

import net.javaguides.SpringbootBackend.exception.ResourceNotFoundException;
import net.javaguides.SpringbootBackend.model.Employee;
import net.javaguides.SpringbootBackend.repository.EmployeeRepository;
import net.javaguides.SpringbootBackend.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootBackendApplicationTests {

    @Autowired
    private EmployeeServiceImpl service;

    @MockBean
    private EmployeeRepository repository;

    @Test
    public void getAllEmployee(){
        when(repository.findAll()).thenReturn(Stream.of(new Employee(14, "Ron@g.com","Ron","Wis")).collect(Collectors.toList()));
        assertEquals(1,service.getAllEmployee().size());
    }

/*    public void getEmployeeById()
    {
        long id =1;
        //when(repository.findById(id)).thenReturn(Stream.of(new Employee(14, "Ron@g.com","Ron","Wis")).collect(Collectors.toList()));
        when(repository.findById(id)).thenReturn(Optional.of(new Employee(14, "Ron@g.com","Ron","Wis")));
        assertEquals(1,service.getEmployeeById(id).size());
    }*/

    @Test
    public void saveEmployee()
    {
        Employee employee = new Employee(18, "John", "Cena", "jonh@gb.com");
        when(repository.save(employee)).thenReturn(employee);
        assertEquals(employee, service.saveEmployee(employee));
    }


}
