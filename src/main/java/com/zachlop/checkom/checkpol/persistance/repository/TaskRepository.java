package com.zachlop.checkom.checkpol.persistance.repository;

import com.zachlop.checkom.checkpol.persistance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Customer, Long> {

}
