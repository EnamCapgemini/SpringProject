package com.cg.mts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.StaffCredentials;

@Repository
public interface StaffCredentialsRepository extends CrudRepository<StaffCredentials, Integer> {

}
