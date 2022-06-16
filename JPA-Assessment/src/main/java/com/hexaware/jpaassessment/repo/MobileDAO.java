package com.hexaware.jpaassessment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.jpaassessment.models.Mobile;

@Repository("mobileDao")
@Transactional
public interface MobileDAO extends JpaRepository<Mobile, Integer> {
	
	boolean existsMobileByMobileCompany(String company);
	
	Mobile getMobileByMobileCompany(String company);

}
