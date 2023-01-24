package com.SystemFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SystemFinal.entity.User;
@Repository("UserRepository")
public interface UserRepository extends CrudRepository<User, Integer>{

}
