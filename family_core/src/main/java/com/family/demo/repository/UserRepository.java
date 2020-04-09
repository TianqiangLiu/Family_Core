package com.family.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.family.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUserName(String userName);

}
