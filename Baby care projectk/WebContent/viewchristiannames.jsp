<html>
<head>
  <title>Book Query</title>
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
 
  <h3 style=" color :#669900 ;text-aligin:center ">Christian Baby Names</h3>
 <br>
 
  <%@ page import = "java.sql.*" %>
  <%
      Connection conn = DriverManager.getConnection(
    		  "jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger"); // <== Check!
      // Connection conn =
      //    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
      Statement stmt = conn.createStatement();
 
      String sqlStr = "select * from babynames where religion='Christian'";
 
      ResultSet rset = stmt.executeQuery(sqlStr);
  %>
      <hr>
    
        <table border=1 cellpadding=10 style="width:100%;height:10%;background-color:white;font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;">
          <tr>
            <th  style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>Name</th>
            <th style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>Meaning</th>
            <th style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>Gender</th>
            <th style="padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #669900;
  color: white";>Religion</th>
            
          </tr>
  <%
      while (rset.next()) {
       
  %>
          <tr>
           
            <td  style="border: 1px solid #ddd;
  padding: 8px";
}><%= rset.getString("name") %></td>
            <td style="border: 1px solid #ddd;
  padding: 8px";><%= rset.getString("meaning") %></td>
            <td style="border: 1px solid #ddd;
  padding: 8px";><%= rset.getString("sex") %></td>
            <td style="border: 1px solid #ddd;
  padding: 8px";><%= rset.getString("religion") %></td>
          </tr>
  <%
      }
  %>
        </table>
        <br>
       
 
</body>
</html>