package com.cg.frs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.orb.DBUtil.RoomDBUtil;
import com.cg.orb.Exception.RoomRegistrationException;
import com.cg.orb.dto.FlatRegistrationDTO;
import com.cg.orb.service.IRoomRegistrationService;



public class RoomRegistrationDAOImpl implements IRoomRegistrationDAO {

	
//Connection conn=null;
	
	public int addBookingDetails(FlatRegistrationDTO p) throws RoomRegistrationException {
		
		int result=0;
		int result1=0; 
		Connection conn=null;
		
		PropertyConfigurator.configure("log4j.properties");
		Logger logger=Logger.getRootLogger();
		
		try{
		conn=RoomDBUtil.getConnection();
		String insertQuery="Insert into Room_Registration values(room_SEQ.nextval,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertQuery);
		
		
		
		ps.setInt(1,p.getHotel_id());
		ps.setInt(2,p.getRoomtype());
		ps.setLong(3,p.getArea());
		ps.setDouble(4, p.getRent_amt());
		ps.setDouble(5, p.getPaid_amt());
		result = ps.executeUpdate();	//use executeUpdate when inserting data in the table
		System.out.println(result);
		
		String sql="Select room_SEQ.currval from Room_Registration";
		Statement ps1=conn.createStatement();
		ResultSet rs=ps1.executeQuery(sql);//use executeQuery when retrieving data in the table
		//to get the room number 
		while(rs.next()){
		result1=rs.getInt(1);//gets the value of column 1 value
		}
		logger.info("Executed");
		}
		
		catch(IOException a){
			a.printStackTrace();
			logger.error("Error occured"+a.getMessage());

		}
		catch(SQLException e){

			throw new RoomRegistrationException("zarana");
		}
		return result1;
		}

	@Override
	public ArrayList<FlatRegistrationDTO> retrieveDetails()//dao layer method name
	{
		PropertyConfigurator.configure("log4j.properties");
		Logger logger=Logger.getRootLogger();
		
		ArrayList<FlatRegistrationDTO> list=new ArrayList<FlatRegistrationDTO>();
		try{
			
		Connection conn=RoomDBUtil.getConnection();
		String sql="select * from Room_Registration";
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next()){
			int room_no=rs.getInt(1);
			int hotel_id=rs.getInt(2);
			int roomtype=rs.getInt(3);
			long area=rs.getLong(4);
			double rent_amt=rs.getDouble(5);
			double paid_amt=rs.getDouble(6);
			list.add(new FlatRegistrationDTO(room_no,hotel_id,roomtype,area,rent_amt,paid_amt));
			logger.info("Executed");
		}
	}
		catch(SQLException|IOException b)
		{
			logger.error("Error occured"+b.getMessage());
			System.out.println(b.getMessage());
		}
		return list;
		
		
	}



	


	}



	
	
	

