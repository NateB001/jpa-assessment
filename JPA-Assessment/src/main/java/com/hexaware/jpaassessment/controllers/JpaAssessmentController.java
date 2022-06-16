package com.hexaware.jpaassessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.jpaassessment.models.App;
import com.hexaware.jpaassessment.models.AppJson;
import com.hexaware.jpaassessment.models.Mobile;
import com.hexaware.jpaassessment.services.JpaAssessmentService;

@RestController("jpaAssessmentController")
@RequestMapping("/assessment") //http://localhost:8000/assessment
public class JpaAssessmentController {
	
	@Autowired
	private JpaAssessmentService service;
	
	@PostMapping(value = "/addMobile")
	public Mobile addMobile(@RequestBody Mobile mobile) {
		mobile = service.addMobile(mobile);
		
		return mobile;
	}
	
	@PostMapping(value = "/addApp")
	public App addApp(@RequestBody AppJson jsonApp) {
		App app = new App();
		
		app.setAppName(jsonApp.getAppName());
		app = service.addApp(app, jsonApp.getMobileId());
		
		return app;
	}
	
	@GetMapping(value = "/getNames")
	public List<String> getAllNames() {
		return service.getAllMobileAndAppNames();
	}
	
	@GetMapping(value = "/searchByCompany")
	public List<String> searchByCompany(@RequestParam String company) {
		return service.getMobileNameAndAppNamesByMobileCompany(company);
	}
	
	public JpaAssessmentController() {
		super();
	}

}
