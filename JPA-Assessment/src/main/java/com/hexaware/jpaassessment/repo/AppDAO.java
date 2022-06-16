package com.hexaware.jpaassessment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.jpaassessment.models.App;
import com.hexaware.jpaassessment.models.Mobile;

@Repository("appDao")
@Transactional
public interface AppDAO extends JpaRepository<App, Integer> {
	
	List<App> getAppByMobile(Mobile mobile);

}
