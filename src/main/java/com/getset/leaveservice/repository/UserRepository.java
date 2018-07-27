package com.getset.leaveservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getset.leaveservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUserName(String userName);

	User findByUserName(String userName);

	User findByEmailId(String emailId);

	List<User> findAll();

	@Transactional
	void deleteByUserName(String userName);

}