package com.proyecto_ciclo3.proyecto_ciclo3.Repository;


import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    public Enterprise findByEnterpriseId(Long id);
    public List<Enterprise> findAllByOrderByEnterpriseIdAsc();

//    @Query(value = "SELECT name FROM employee;", nativeQuery = true)
//    public List<Enterprise> findAllEnt();





}
