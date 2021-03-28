package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.LoanDetails;


public interface LoanDetailsRepository extends CrudRepository<LoanDetails,Long> {

}
