package com.cg.frs.dao;

import java.util.ArrayList;

import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;



public interface IRoomRegistrationDAO {
	public int addBookingDetails(FlatRegistrationDTO details) throws RoomRegistrationException;

	public ArrayList<FlatRegistrationDTO> retrieveDetails();


}
