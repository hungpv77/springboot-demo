package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

/**
 * @author Hung V. PHAM
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
