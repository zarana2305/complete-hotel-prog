package com.cg.orb.dto;

public class FlatRegistrationDTO {
	private int room_no;
	private int hotel_id;
	private int roomtype;
	private long area;
	private double rent_amt;
	private double paid_amt;
	
	public FlatRegistrationDTO(int room_no, int hotel_id, int roomtype,
			long area, double rent_amt, double paid_amt) {
		super();
		this.room_no = room_no;
		this.hotel_id = hotel_id;
		this.roomtype = roomtype;
		this.area = area;
		this.rent_amt = rent_amt;
		this.paid_amt = paid_amt;
	}
	
	
	
	

	@Override
	public String toString() {
		return "FlatRegistrationDTO [hotel_id=" + hotel_id + ", roomtype="
				+ roomtype + ", area=" + area + ", rent_amt=" + rent_amt
				+ ", paid_amt=" + paid_amt + ", room_no=" + room_no + "]";
	}
	public FlatRegistrationDTO(int hotel_id, int roomtype, long area,
			double rent_amt, double paid_amt) {
		super();
		this.hotel_id = hotel_id;
		this.roomtype = roomtype;
		this.area = area;
		this.rent_amt = rent_amt;
		this.paid_amt = paid_amt;
	}
	public FlatRegistrationDTO() {
		
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(int roomtype) {
		this.roomtype = roomtype;
	}
	public long getArea() {
		return area;
	}
	public void setArea(long area) {
		this.area = area;
	}
	public double getRent_amt() {
		return rent_amt;
	}
	public void setRent_amt(double rent_amt) {
		this.rent_amt = rent_amt;
	}
	public double getPaid_amt() {
		return paid_amt;
	}
	public void setPaid_amt(double paid_amt) {
		this.paid_amt = paid_amt;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

}
