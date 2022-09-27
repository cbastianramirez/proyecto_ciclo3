package com.proyecto_ciclo3.proyecto_ciclo3.Repository;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmployeeId(Long id);
    public List<Employee> findByEnterpriseEnterpriseId(Long enterpriseId);
    public List<Employee> findAllByOrderByEmployeeIdAsc();

    public Employee findAllByEmail(String email);

    Employee findEmployeeByEmail(String email);

}
