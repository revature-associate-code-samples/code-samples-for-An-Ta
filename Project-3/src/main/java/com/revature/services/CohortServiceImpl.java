package com.revature.services;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dto.CohortUserListInputDto;
import com.revature.dto.CohortUserListOutputDto;
import com.revature.models.Cohort;
import com.revature.models.User;
import com.revature.repos.CohortRepo;
import com.revature.utils.CognitoUtil;

@Service
public class CohortServiceImpl implements CohortService {

	@Autowired
	CohortRepo cohortRepo;

	@Autowired
	UserService userService;

	@Autowired
	CognitoUtil cognitoUtil;

	Logger log = Logger.getRootLogger();

	public Cohort saveCohort(Cohort cohort) {
		if (cohortRepo.findOneByCohortName(cohort.getCohortName()) == null) {
			System.out.println("saving cohort");
			return cohortRepo.save(cohort);
		}
		return null;
	}

	@Override
	public List<Cohort> findAllByTrainerId(int id) {
		return cohortRepo.findByTrainerUserId(id);
	}

	@Override
	public Cohort findOneByCohortId(int id) {
		return cohortRepo.findOneByCohortId(id);
	}

	@Override
	public List<Cohort> findAll() {
		return cohortRepo.findAll();
	}


}
