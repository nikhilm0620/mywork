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
<%@page import="com.nk.dto.ProductDto"%>
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
<%
List<ProductDto> list = (ArrayList<ProductDto>)request.getAttribute("list");
%>


</thead>
<h2 style="text-align:center;color:#669900;font-family: 'Times New Roman', serif">Please select the following Baby Products</h2>
<br>
<br>
<%
for(int i=0;i<list.size();i++){
ProductDto dto = list.get(i);
String id = dto.getId();
String name = dto.getName();
%>
<br>
<br>

<div class="card">
 <br>
 <br>
  <h2  style="color:#669900;font-family: Helvetica, sans-serif"><b><%=name%></b></h2>
  
   <img src="./ImageDownloader?id=<%=id%>" style="height:20%;width:20%">
 <p class="price"><b><h4>$20.6</h4></b></p>
  <p><b><i>The products in this website are authentic and genuine. They provide good quality and helps you in serving the baby. You can add the products to add cart.</i></b></p>
  <button onclick="location.href='addcart.html'" style="background-color: #669900; /* Green */
  border: none;
  color: white;
  padding: 15px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  position:relative;
  width:10%;
  left:600px;" >Add to Cart</button>
  <br><br><br>
</div>
<%}
%>

</table>
</center>
</body>
</html>