package com.nk.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.nk.dao.*;
import com.nk.dto.ProductDto;
import com.nk.user.*;

public class ProductDAO {
private final String GET_DATA = "select productid,productname from products";
private final String GET_IMAGE_QUERY = "select productimage from products where productid=?";
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

public List<ProductDto> getData(){
	ProductDto productDto = null;
	List<ProductDto> imageList = new ArrayList<ProductDto>();
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(GET_DATA);
		rs = ps.executeQuery();
		while(rs.next()) {
			productDto = new ProductDto();
			productDto.setId(rs.getString(1));
			productDto.setName(rs.getString(2));
			imageList.add(productDto);
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












