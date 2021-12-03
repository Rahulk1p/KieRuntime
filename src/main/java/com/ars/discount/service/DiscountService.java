package com.ars.discount.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.internal.command.CommandFactory;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import org.springframework.context.annotation.Configuration;

import com.myspace.discount.Customer;

@Configuration
public class DiscountService {
	
	//private static final String URL = "http://ec2-54-172-177-210.compute-1.amazonaws.com:8080/kie-server-7.35.0.Final-ee7/services/rest/server";
	private static final String URL = "http://ec2-54-81-11-177.compute-1.amazonaws.com:8080/kie-server-7.35.0.Final-ee7/services/rest/server";
	private static final String USERID="kieserver";
	private static final String PASSWORD = "password1!";
	
	private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;
	
	private static final String CONTAINERID = "DiscountProject-1-1-13";
	private static String CLASS_NAME="Customer";
	
	private KieServicesConfiguration config = null;
	private RuleServicesClient client = null;
	List<Command<?>> cmds = null;
	KieCommands commands = null;
	
	
	
	public DiscountService() {
		
	}
	
	@PostConstruct
	public void initService() {
		if(config == null) {
			config = KieServicesFactory.newRestConfiguration(URL, USERID,PASSWORD);
			config.setMarshallingFormat(FORMAT);
		}
		if(client == null) {
			client = KieServicesFactory.newKieServicesClient(config).getServicesClient(RuleServicesClient.class);
		}
		
		if(commands == null) {
			commands = KieServices.Factory.get().getCommands();
		}
	}
	public Customer getDiscount(Customer customer) {
		cmds = new ArrayList<Command<?>>();
		cmds.add(commands.newInsert(customer,CLASS_NAME));
		cmds.add(commands.newFireAllRules());
		
		BatchExecutionCommand myCommands = CommandFactory.newBatchExecution(cmds);
		ServiceResponse<ExecutionResults> response = client.executeCommandsWithResults(CONTAINERID, myCommands);
		return (Customer) response.getResult().getValue(CLASS_NAME);
	}
			
	

}
