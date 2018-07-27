package com.getset.leaveservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getset.leaveservice.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	boolean existsByEmailId(String emailId);

	List<Attendance> findAll();

	@org.springframework.data.jpa.repository.Query(value = "SELECT * FROM attendance WHERE DATE(LOG_IN) = DATE(NOW()) and EMAIL_ID = ?1 limit 1", nativeQuery = true)
	Attendance findEntryByEmailAndDate(String emailId);
	
	@org.springframework.data.jpa.repository.Query(value = "SELECT * FROM attendance WHERE EMAIL_ID = ?1", nativeQuery = true)
	List<Attendance> findByEmailId(String emailId);
}
