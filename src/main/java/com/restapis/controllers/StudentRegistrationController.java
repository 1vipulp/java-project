package com.restapis.controllers;

import org.springframework.stereotype.Controller;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.restapis.beans.Student;
import com.restapis.beans.StudentRegistration;
import com.restapis.beans.StudentRegistrationReply;
import com.restapis.connections.DbOperations;

@Controller
public class StudentRegistrationController {

  @RequestMapping(method = RequestMethod.POST, value = "/register/student")
  @ResponseBody
  public StudentRegistrationReply registerStudent(@RequestBody Student student) {
    System.out.println("In registerStudent");
    
    StudentRegistrationReply stdregreply = new StudentRegistrationReply();
    StudentRegistration.getInstance().add(student);
    
    // We are setting the below value just to reply a message back to the caller
    stdregreply.setName(student.getUsername());
    stdregreply.setAge(student.getAge());
    stdregreply.setRegistrationNumber(student.getAddress());
    stdregreply.setRegistrationStatus("Successful");
    
    DbOperations dbOperations = new DbOperations();
    
    dbOperations.insertDocument(student);
    
    KieServices ks = KieServices.Factory.get();
    KieContainer kContainer = ks.getKieClasspathContainer();
    KieSession kSession = kContainer.newKieSession("ksession-rules");
    kSession.insert(student);
    kSession.fireAllRules();
    
    return stdregreply;
  }
}
