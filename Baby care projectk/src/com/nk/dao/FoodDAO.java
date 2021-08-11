package com.nk.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.nk.dao.FoodDAO;
import com.nk.dto.FoodDto;

import com.nk.user.*;

public class FoodDAO {
private final String GET_DATA = "select name,id from babyfood";
private final String GET_IMAGE_QUERY = "select foodimage from babyfood where id=?";
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

public List<FoodDto> getData(){
	FoodDto foodDto = null;
	List<FoodDto> imageList = new ArrayList<FoodDto>();
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(GET_DATA);
		rs = ps.executeQuery();
		while(rs.next()) {
			foodDto = new FoodDto();
			foodDto.setName(rs.getString(1));
			foodDto.setId(rs.getString(2));
			imageList.add(foodDto);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return imageList;
}

public byte[] getImage(String id){
	byte[] image = null;
	try {
	con = DBConnection.getConnection();
	ps = con.prepareStatement(GET_IMAGE_QUERY);
	ps.setString(1, id);
	rs = ps.executeQuery();
	if(rs.next()) {
	image = rs.getBytes(1);
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return image;
}
}












