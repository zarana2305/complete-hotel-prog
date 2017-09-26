package com.cg.orb.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;


public interface IRoomRegistrationService {

	int addBookingDetails(FlatRegistrationDTO details) throws RoomRegistrationException, IOException, SQLException;

	

	boolean validate_amt(double rent_amt, double paid_amt);



 ArrayList<Integer> getallownerid() throws SQLException, IOException;



	boolean validateHotelId(int hotel_id, ArrayList<Integer> hotel_ids);


	public ArrayList<FlatRegistrationDTO> retrieveDetails();

	

	

	
	}