package com.hexaware.jpaassessment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.jpaassessment.models.App;
import com.hexaware.jpaassessment.models.Mobile;
import com.hexaware.jpaassessment.repo.AppDAO;
import com.hexaware.jpaassessment.repo.MobileDAO;

@Service("jpaAssessmentService")
public class JpaAssessmentService {
	
	private MobileDAO mobileDao;
	private AppDAO appDao;
	
	public JpaAssessmentService(@Autowired MobileDAO mobileDao, @Autowired AppDAO appDao) {
		super();
		this.mobileDao = mobileDao;
		this.appDao = appDao;
	}
	
	public Mobile addMobile(Mobile mobile) {
		mobile = mobileDao.save(mobile);
		
		return mobile;
	}
	
	public App addApp(App app, int id) {
		Mobile mobile = mobileDao.getReferenceById(id);
		
		app.setMobile(mobile);
		
		app = appDao.save(app);
		
		return app;
	}
	
	public List<Mobile> getAllMobiles() {
		return mobileDao.findAll();
	}
	
	public List<App> getAllApps() {
		return appDao.findAll();
	}
	
	public Mobile getMobileByCompany(String company) {
		return mobileDao.getMobileByMobileCompany(company);
	}
	
	public List<App> getAppListByMobile(Mobile mobile) {
		return appDao.getAppByMobile(mobile);
	}
	
	public List<String> getAllMobileAndAppNames() {
		List<String> allNames = new ArrayList<>();
		
		allNames.add("Mobile Names:");
		
		List<Mobile> allMobiles = getAllMobiles();
		allMobiles.forEach(mobile -> allNames.add(mobile.getMobileName()));
		
		allNames.add("App Names:");
		
		List<App> allApps = getAllApps();
		allApps.forEach(app -> allNames.add(app.getAppName()));
		
		return allNames;
	}
	
	public List<String> getMobileNameAndAppNamesByMobileCompany(String company) {
		List<String> allNames = new ArrayList<>();
		
		Mobile mobile = mobileDao.getMobileByMobileCompany(company);
		
		allNames.add("Name of Company:");
		allNames.add(mobile.getMobileName());
		allNames.add("Names of Apps:");
		
		List<App> allApps = appDao.getAppByMobile(mobile);
		allApps.forEach(app -> allNames.add(app.getAppName()));
		
		return allNames;
	}

}
