<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
<nav class="navbar navbar-default">
      <div class="container">
	<div class="container">
		<div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <a class="navbar-brand">Selected Products </a> 
           
              
        </div>

      </div>
      </div>
    </nav>
    </br >
<div class="panel panel-default">

  <div class="panel-body">
  <form action = "decisionShopping" method= "get">
  <input type="hidden" name="action" value="Add">
		<table class="table table-striped">
<thead>

			<tr>
			     <th>ProductID</th>
				<th>ProductName</th>
				<th>UnitPrice</th>
		         <th>Quantity</th>
			</tr>
</thead>
<tbody>
           <tr>
				<td>${selectedProduct.getProductId()}</td>
				<td>${selectedProduct.getProductName()}</td>
				<td>${selectedProduct.getProductPrice()}</td>
				<td><input type = "text" size=2 value = "1" name ="quantity"></td>
			</tr>


</tbody>
		</table>
		


  <input type = "hidden" value = "${selectedProduct.getProductId()}" name ="productID">
  <input type = "hidden" value = "${selectedProduct.getProductName()}" name ="productName">
   <input type = "hidden" value = "${selectedProduct.getProductPrice()}" name ="productPrice">
 <input type = "hidden" value = "${selectedProduct.getProductDate()}" name ="productDate">
 <input type = "hidden" value = "${selectedProduct.getProductDescription()}" name ="productDescription">
  
  <button type="submit" class="btn btn-info">Add</button>
  </form>	
  </div>
  </div>
  </div>

 
  
   
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>
   
</body>