package com.getset.leaveservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.getset.leaveservice.entity.Attendance;
import com.getset.leaveservice.repository.AttendanceRepository;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;

	public Attendance logInAttendance(Attendance attendance) {
		String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
		Attendance attendanceModel = attendanceRepository.findEntryByEmailAndDate(emailId);
		if (attendanceModel == null) {
			attendance.setEmailId(emailId);
			attendance.setLogIn(new Date());
			return attendanceRepository.save(attendance);
		} else {
			attendanceModel.setLogIn(new Date());
			attendanceModel.setLogInLat(attendance.getLogInLat());
			attendanceModel.setLogInLag(attendance.getLogInLag());
			return attendanceRepository.save(attendanceModel);
		}
	}
	
	public Attendance logOutAttendance(Attendance attendance) {
		String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
		Attendance attendanceModel = attendanceRepository.findEntryByEmailAndDate(emailId);
		attendanceModel.setLogOut(new Date());
		attendanceModel.setLogOutLat(attendance.getLogOutLat());
		attendanceModel.setLogOutLag(attendance.getLogOutLag());
		return attendanceRepository.save(attendanceModel);
	}

	public List<Attendance> fetchLogIn() {
		String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
		return attendanceRepository.findByEmailId(emailId);
	}

}
