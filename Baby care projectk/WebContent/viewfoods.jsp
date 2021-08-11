<html>
<head>
<link rel="stylesheet" type="text/css" href="foradminviewstyles.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">


<div class="logo1">


<a  href="index.html" style="color: #555;">
  <img src="https://d22s7xnafxduco.cloudfront.net/logos/NewbornCareSolutionsLOGO.jpg" alt="logo" height="100" width="100"/ >
</a>
</div>
<h1>BABY CARE SOLUTIONS</h1>

<button class="btn">Find a store <i class='fas fa-map-marker-alt'></i></button>
<button class="btn1">Download now </button>
</div>
<div class="search-container">
  <input type="text" class="search-box" placeholder="Search For a Product">
  <button class="search-button">Go</button>
        </div>
        <div id="navbar">
          <ul>
                            <li><a  href="namesview.html">VIEW BABY NAMES</a></li>
                            <li><a href="addbabytips.html">VIEW TIPS</a></li>

                            <li><a  href="home.jsp"> VIEW PRODUCTS</a></li>
                            <li><a  href="home2.jsp">VIEW FOOD</a></li>
                            <li><a  href="index.html">LOGOUT </a></li>
                          </ul>
         </div>

       <br>  
       <br>
       <br>
       <br>
 
<%@page import="java.util.ArrayList"%>
<%@page import="com.nk.dto.FoodDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Image</title>
</head>
<body>
<center>
<h2 style="text-align:center;color:#669900;font-family: 'Times New Roman', serif">Please select the following Baby Foods</h2>
<br>
<br>
<br>
<%
List<FoodDto> list = (ArrayList<FoodDto>)request.getAttribute("list");
%>

<table border=1 cellpadding=10 style="width:100%;height:10%;background-color:white;font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;">
<thead>
<tr><td style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>ID</td><td style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>NAME</td><td style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>IMAGE</td><td style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>Check Out</td></tr>
</thead>
</thead>

<%
for(int i=0;i<list.size();i++){
FoodDto dto = list.get(i);
String id = dto.getId();
String name = dto.getName();
%>

<% System.out.println("Id"+id); %>
<tr><td style="border: 1px solid #ddd;
  padding: 8px";><%=id%></td><td style="border: 1px solid #ddd;
  padding: 8px";><%=name %></td><td ><img src="./FoodImageDownloader?id=<%=id%>" height="150" width="100"/></td><td style="border: 1px solid #ddd;
  padding: 8px";>  <button onclick="location.href='addcart.html'" type="button" class="cancelbtn"> ADD TO CART </button>   </tr>
<%}
%>

</table>
</center>
</body>
</html>