package com.nk.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nk.dao.*;
import com.nk.dto.*;


@WebServlet("/ImageViewerController")
public class ImageViewerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productdao = null;
		productdao = new ProductDAO();
		List<ProductDto> list =  productdao.getData();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewproducts.jsp");
		dispatcher.forward(req, resp);
	}
}
