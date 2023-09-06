package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// @RequestMapping(path="/home", method=RequestMethod.GET)
	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	// add Page controller
	@GetMapping("/add")
	public String addPage(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		if (!students.isEmpty()) {
			map.addAttribute("students", students);
			return "Add";
		}
		return "Add";
	}

	// Add Student controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map) {

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

	// search page controller
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}

	// search student controller
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id, ModelMap map) {

		StudentPOJO pojo = service.searchStudent(id);

		// success
		if (pojo != null) {
			map.addAttribute("student", pojo);
			map.addAttribute("masg", "Student Data Found...!");
			return "Search";
		}

		// Failure
		map.addAttribute("masg", "Student Data Not Present...!");
		return "Search";
	}

	// Remove page controller
	@GetMapping("/remove")
	public String removePage(ModelMap map) {
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

	// Remove Student controller
	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id, ModelMap map) {

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

	// Update page controller
	@GetMapping("/update")
	public String updatePage(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		return "Update";
	}

	// Update form controller
	@PostMapping("/update")
	public String updateForm(@RequestParam int id, ModelMap map) {

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

	// Update student controller
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long contact, @RequestParam String address, ModelMap map) {

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

	// logout page controller
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}
}
