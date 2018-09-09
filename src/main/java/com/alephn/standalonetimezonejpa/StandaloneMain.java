package com.alephn.standalonetimezonejpa;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alephn.standalonetimezonejpa.dao.CallDAO;
import com.alephn.standalonetimezonejpa.model.Call;

public class StandaloneMain {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StandaloneMain.class);

	public static void main(String[] args) {
		
		try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Unable to load the class. Exiting.");
            System.exit(1);
        }
		
		StandaloneMain m = new StandaloneMain();
		m.start();
		
		System.exit(0);
	}
	
	public void start() {
		
		CallDAO callDAO = new CallDAO();
		
		Call call = new Call();
		call.setId(UUID.randomUUID().toString());
		call.setFromNumber("305-34527764");
		call.setToNumber("305-78569842");
		call.setZonedDateTime(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("-04:00")));
		
		LOGGER.info("Inserting new call {}", call);
		
		callDAO.addCall(call);
		
	}

}
