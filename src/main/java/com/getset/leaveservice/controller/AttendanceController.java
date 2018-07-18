package com.getset.leaveservice.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getset.leaveservice.dto.AttendanceDTO;
import com.getset.leaveservice.entity.Attendance;
import com.getset.leaveservice.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(path = "/log_in_attendance")
	public Attendance logInAttendance(@RequestBody AttendanceDTO attendance) {
		return (Attendance) attendanceService.logInAttendance(modelMapper.map(attendance, Attendance.class));
	}
	
	@PostMapping(path = "/log_out_attendance")
	public Attendance logOutAttendance(@RequestBody AttendanceDTO attendance) {
		return (Attendance) attendanceService.logOutAttendance(modelMapper.map(attendance, Attendance.class));
	}
	
	@GetMapping(path = "/fetch_log_in_info")
	public List<Attendance> fetchLogIn() {
		return attendanceService.fetchLogIn();
	}
	
}
