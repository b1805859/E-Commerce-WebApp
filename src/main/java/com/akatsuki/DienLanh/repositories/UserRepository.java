package com.akatsuki.DienLanh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akatsuki.DienLanh.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
