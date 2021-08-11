package com.nk.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nk.dao.FoodDAO;
import com.nk.dto.FoodDto;


@WebServlet("/FoodImageViewerController")
public class FoodImageViewerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	FoodDAO fooddao = null;
	fooddao = new FoodDAO();
		List<FoodDto> list =  fooddao.getData();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewfoods.jsp");
		dispatcher.forward(req, resp);
	}
}
