package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminPOJO getAdmin() {

		AdminPOJO adminPOJO = adminRepository.getAdmin();
		return adminPOJO;
	}

	public AdminPOJO createAccount(String username, String password) {

		AdminPOJO adminPOJO = adminRepository.createAccount(username, password);
		return adminPOJO;
	}

	public AdminPOJO login(String username, String password) {

		AdminPOJO adminPOJO = adminRepository.login(username, password);
		return adminPOJO;
	}

}
