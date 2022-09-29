package com.proyecto_ciclo3.proyecto_ciclo3.Repository;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public Transaction findByTransactionId(Long id);
    public List<Transaction> findByEmployeeEmployeeId(Long employeeId);

    public List<Transaction> findAllByOrderByTransactionIdAsc();

    @Query(value = "select sum(amount) from transaction;", nativeQuery = true)
    public Long sumAmounts();

    @Query(value = "select sum(amount) from transaction where amount > 0;", nativeQuery = true)
    public Long sumposAmounts();

    @Query(value = "select sum(amount) from transaction where amount < 0;", nativeQuery = true)
    public Long sumnegAmounts();

//    @Query(value = "SELECT * \n" +
//            "FROM employee \n" +
//            "INNER JOIN transaction ON transaction.employee_employee_id = employee.employee_id ;", nativeQuery = true)
//    public List<Employee> findByTransactionTransactionId();

}
