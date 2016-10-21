package com.rean.controllers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rean.dao.StudentDao;
import com.rean.model.Student;

@Controller
public class HomeController {
	
	@Autowired
	private StudentDao studentDao;

	/*@RequestMapping(value="/", method = RequestMethod.GET)
	public String homepage(Model model){
		model.addAttribute("Message", "Bora");
		return "home";
	}*/
	
	@RequestMapping(value="/studentjson", method = RequestMethod.GET) // get data as json
	public ResponseEntity<Map<String, Object>> getStudent(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		model.addAttribute("Message", "Bora");
		map.put("student", studentDao.getStudent());
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET) // return the data to view
	public String getAllStudent(Map<String, Object> map){
		
		map.put("allStudent", studentDao.getStudent());
		return "home";
	}
	
	
	@RequestMapping(value="/deletestudent/{stuId}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable("stuId") Integer stuId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deteletstudent", studentDao.deleteStudent(stuId)) ;
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/searchstudent", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> searchStudent(@RequestParam(value="stuId") Integer stuId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("student", studentDao.searchStudent(stuId));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updatestudent/{stuId}", method = RequestMethod.POST)
	public @ResponseBody boolean updateProduct(Student student, @PathVariable("stuId") Integer stuid) {
		
		return studentDao.updateStudent(student, stuid);
	}

	@RequestMapping(value="/insertstudent", method = RequestMethod.POST)
	public @ResponseBody boolean insertStudent(Student student){
		System.out.println("student" + student.getStuid());
		return studentDao.insertStudent(student);
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editStudentInforForm (Student student){
		
		//map.put("allStudent", studentDao.getStudent());
		return "home";
	}
	
/*	@RequestMapping(value="/editstudent", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> editStudent( @RequestBody Map<String, Object> jsonRequestData
			@RequestParam(value="stuid") Integer stuId,
			@RequestParam(value="stuname") String stuname,  --> send vai form, so you get this param
			@RequestParam(value="lvlyear") String lvlyear,
			@RequestParam(value="score") BigDecimal score
			 
			){
		
		// validation goes here 0001
	    Student student = new Student();
		
		student.setStuid(Integer.parseInt(jsonRequestData.get("stuid").toString()));
		student.setStuname(jsonRequestData.get("stuname").toString());
		student.setLvlyear(jsonRequestData.get("lvlyear").toString());
		student.setScore(new BigDecimal(jsonRequestData.get("score").toString())); 
	
		 if(studentDao.editStudent(student)){
			 return new ResponseEntity<Map<String,Object>>(jsonRequestData,HttpStatus.OK);
		 }
		return new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
}
