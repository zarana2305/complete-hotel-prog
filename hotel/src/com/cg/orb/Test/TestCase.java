package com.cg.orb.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.frs.dao.IRoomRegistrationDAO;
import com.cg.frs.dao.RoomRegistrationDAOImpl;
import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;

//checks for null value

public class TestCase {

	static IRoomRegistrationDAO dao=null;
	static FlatRegistrationDTO bean=null;
	
	@BeforeClass
	public static void initialize() throws RoomRegistrationException
	{
		System.out.println("hi");
		dao=new RoomRegistrationDAOImpl();
		bean=new FlatRegistrationDTO();}
	
	@Test
	public void test() {
		bean.setHotel_id(1);
		bean.setRoomtype(1);
		bean.setArea(10);
		bean.setRent_amt(126);
		bean.setPaid_amt(1000);
	}
//in test case, use try-catch block for the methods(dont use throws declaration)
	@Test
	public void testAddDetails()  {
		try {
			assertNotNull(dao.addBookingDetails(bean));
		} 
		catch (RoomRegistrationException a) {
			a.printStackTrace();
		}// value shouldnt be null
	}
		public void getDetails() throws RoomRegistrationException {
			assertNotNull(dao.retrieveDetails());
		}
}
