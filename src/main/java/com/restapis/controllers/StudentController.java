package com.restapis.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.restapis.beans.Student;
import com.restapis.beans.StudentRegistration;

@Controller
public class StudentController {

  @RequestMapping(method = RequestMethod.GET, value = "/get/student")
  
  @ResponseBody
  public List<Student> getAllStudents() {
    return StudentRegistration.getInstance().getStudentRecords();
  }
}
