package com.andy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.andy.dto.Credential;
import com.andy.model.Employee;
import com.andy.model.Reimbursement;
import com.andy.services.EmployeeServiceImpl;
import com.andy.services.IEmployeeService;
import com.andy.services.IReimbursementService;
import com.andy.util.ResponseMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ReimbursementController {
	private IReimbursementService ReimbServ = IReimbursementService.currentImplamentation;
	private ObjectMapper om = new ObjectMapper();
	private IReimbursementService reimbService = IReimbursementService.currentImplamentation;
	void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String method = req.getMethod();
		System.out.println(method);
		switch (method) {
		case "GET":
			processGet(req, resp);
			break;
		case "POST":
			processPost(req, resp);
			break;
		case "OPTIONS":
			return;
		default:
			resp.setStatus(404);
			break;
		}
	}



	private void processGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uri = req.getRequestURI();
		String context = "Project1";
		uri = uri.substring(context.length() + 2, uri.length());
		String[] uriArray = uri.split("/");
		if (uri.equals("employee/reimbursement")) {
			List<Reimbursement> reimb = ReimbServ.findByUsername(req.getSession().getAttribute("username").toString());
			ResponseMapper.convertAndAttach(reimb, resp);
			return;
		} else if (uriArray.length == 2) {
			try {
				
				int id = Integer.parseInt(uriArray[1]);
//				log.info("retreiving user with id: " + id);
				List<Reimbursement> reimb = ReimbServ.findAllByEmployeeId(id);
				ResponseMapper.convertAndAttach(reimb, resp);
				return;
			} catch (NumberFormatException e) {
				resp.setStatus(400);
				return;
			}
		} else {
			resp.setStatus(404);
		}
	}


	private void processPost(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		String uri = req.getRequestURI();
		String context = "Project1";
		uri = uri.substring(context.length() + 2, uri.length());
		String[] uriArray = uri.split("/");
		Reimbursement newReimb = om.readValue(req.getReader(), Reimbursement.class);
		System.out.println(newReimb.getTypeId());
		reimbService.saveReimbursement(req,newReimb);
		resp.setStatus(200);
		return;
		//need to finish cradentails first
	}

}
