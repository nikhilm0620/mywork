package com.nk.user;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nk.dao.*;


@WebServlet("/ImageDownloader")
public class ImageDownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ProductDAO dao = null;
	ServletOutputStream outputStream = null;
	String id = req.getParameter("id");
	dao = new ProductDAO();
	byte[] image = dao.getImage(id);
	outputStream = resp.getOutputStream();
	outputStream.write(image);
	outputStream.close();
}
}
