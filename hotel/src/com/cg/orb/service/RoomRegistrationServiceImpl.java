package com.cg.orb.service;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cg.frs.dao.IRoomRegistrationDAO;
import com.cg.frs.dao.RoomRegistrationDAOImpl;
import com.cg.orb.DBUtil.RoomDBUtil;
import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService {
	
	
	IRoomRegistrationDAO dao=null;

	public int addBookingDetails(FlatRegistrationDTO details) throws RoomRegistrationException, IOException, SQLException
	{
		dao=new RoomRegistrationDAOImpl();
		return dao.addBookingDetails(details);
	}

	
	public boolean validate_amt(double rent_amt,double paid_amt) {
		if(paid_amt>rent_amt){
			return true;
		}
		else{
			System.out.println("paid amt must be greater than rent amount");
			return false;
			
		}
	}

	@Override
	public ArrayList<Integer> getallownerid() throws SQLException, IOException {
		ArrayList<Integer> list=new ArrayList<Integer>();
		Connection conn=null;
		conn=RoomDBUtil.getConnection();
		String sql="Select hotel_id FROM hotel_owners";
		Statement ps1=conn.createStatement();
		ResultSet rs=ps1.executeQuery(sql);
		while(rs.next()){
			list.add(rs.getInt(1));
		}
		return list;
	}


	
	public boolean validateHotelId(int hotel_id, ArrayList<Integer> hotel_ids) {
		boolean flag=false;
		for(Integer out:hotel_ids){
			if(out==hotel_id)//compare the user input with element of list(out)
				{
				flag=true;
				break;
				}
			}
		
		
		return flag;
	}


	@Override
	public ArrayList<FlatRegistrationDTO> retrieveDetails() {
		IRoomRegistrationDAO dao1=new RoomRegistrationDAOImpl();
		return dao1.retrieveDetails();
	}


	/*public boolean validateid(int hotel_id){
		int a=hotel_id;
		if(a==1|2|3){
			return true;
		}
		else{
			System.out.println("Please enter valid data");
			return false;
		}*/

}




