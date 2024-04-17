package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {

		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// add Page controller
	@GetMapping("/add")
	public String addPage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
				return "Add";
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// Add Student controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {
			StudentPOJO pojo = service.addStudent(name, email, contact, address);

			// success
			if (pojo != null) {
				map.addAttribute("msg", "Data inserted successfully...!");
				List<StudentPOJO> students = service.findAllStudents();
				map.addAttribute("students", students);
				return "Add";
			}
			// Failure
			map.addAttribute("msg", "Data not inserted...!");
			List<StudentPOJO> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";

	}

	// search page controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// search student controller
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {
			StudentPOJO pojo = service.searchStudent(id);

			// success
			if (pojo != null) {
				map.addAttribute("student", pojo);
				map.addAttribute("masg", "Student Data Found...!");
				return "Search";
			}

			// Failure
			map.addAttribute("msg", "Student Data Not Present...!");
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// Remove page controller
	@GetMapping("/remove")
	public String removePage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();

			// success
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
				return "Remove";
			}
			// Failure
			map.addAttribute("msg", "No data present...!");
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// Remove Student controller
	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {
			StudentPOJO pojo = service.removeStudent(id);
			List<StudentPOJO> students = service.findAllStudents();

			// success
			if (!students.isEmpty()) {
				map.addAttribute("msg", "Data Removed Successfully...!");
				map.addAttribute("students", students);
				return "Remove";
			}

			// Failure
			map.addAttribute("msg", "Data not exists...!");
			map.addAttribute("students", students);
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// Update page controller
	@GetMapping("/update")
	public String updatePage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// Update form controller
	@PostMapping("/update")
	public String updateForm(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {
			StudentPOJO pojo = service.searchStudent(id);

			// success
			if (pojo != null) {
				map.addAttribute("student", pojo);
				return "Update";
			}

			// Failure
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students", students);
			map.addAttribute("msg", "Student Data Not Present...!");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}

	// Update student controller
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long contact, @RequestParam String address, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {
			StudentPOJO pojo = service.updateStudent(id, name, email, contact, address);

			// success
			if (pojo != null) {
				List<StudentPOJO> students = service.findAllStudents();
				map.addAttribute("msg", "Data Updated Successfully...!");
				map.addAttribute("students", students);
				return "Update";
			}
			// failure
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("msg", "Data not Updated...!");
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed...!");
		return "Login";
	}
}
