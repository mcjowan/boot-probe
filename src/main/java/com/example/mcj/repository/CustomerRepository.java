package com.example.mcj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.mcj.domain.Customer;

//JpaRepository isto moze
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
