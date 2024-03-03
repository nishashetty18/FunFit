<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>

<title>Fun Fit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
*{
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
    
}
nav{
    width: 100%;
    height: 75px;
    line-height: 75px;
    padding: 0px 100px;
    position: fixed;
    background-color:#A1C3D1;                       
}
nav .logo {
   font-family:Georgia, 'Times New Roman', Times, serif;
	position:relative;
    font-size: 35px;
    font-weight: 700;
    color: white;
    text-transform: uppercase;
    letter-spacing: 2px;
}
span{
	color:#E64398;
	
}
nav ul{
    float: right;

}
nav li{
    display: inline-block;
    list-style: none;
}
nav li a{
    font-size: 18px;
    text-transform: uppercase;
    padding: 0px 30px;
    color:#0B0C10;
    text-decoration: none;
}
nav li a:hover{
    color: #C5C6C7;;
    transition: all 0.4s ease 0s;
}
</style>
</head>

<body style="background:#FFD8F0">
<header>
<nav>
        
           <label for="logo" class="logo"><span>fun</span>fit</label>
        
        <ul>
            <li><b><a href="<%=request.getContextPath()%>/list">Participants</a></b></li>
            <li><b><a href="<%=request.getContextPath()%>/batches">Batches</a></b></li> 
            <li><b><a href="<%=request.getContextPath()%>/logout">Logout</a></b></li>
            
        </ul>
    </nav>
    </header>
   
    <div class="container-fluid">
     <br />
    	<br /><br /><br />
    <div class="row">
   
    		<h3 class="text-center"style="color:#36455F;"><b>List of  Batches</b></h3>
    	
    		<div class="container text-left">
    			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/new2" class="btn btn-primary"style="background-color:#36455F;margin-left:7%">Add New Batch</a>
    		</div>
    		<br><br /><br />
    		<div class="row">
    		<div class="col-md-1"></div>
    		<div class="col-md-10">
    		<table class="table table-bordered" style="text-align:center;--bs-table-bg:#C5C6C7;">
    			<thead style="--bs-table-bg:#FF6090;">
    			
    				<tr>
    					<th>Id</th>
    					<th>Name</th>
    					<th>Timings</th>
    					<th>Instructor Name</th>
    					<th>Actions</th>
    				</tr>
    			</thead>
    			<tbody>
    				<c:forEach var="bch" items="${viewlist2}">
    					<tr>
    						<td><c:out value="${bch.id }"/></td>
    						<td><c:out value="${bch.name }"/></td>
    						<td><c:out value="${bch.time }"/></td>
    						<td><c:out value="${bch.instructor }"/></td>
    					
    						<td><a class="btn btn-success" style="background-color:#36455F"href="edit2?id=<c:out value='${bch.id}'/>" >Edit</a>
    						&nbsp;&nbsp;&nbsp;&nbsp;
    						<a class="btn btn-danger"href="delete2?id=<c:out value='${bch.id}'/>" >Delete</a></td>
    					</tr>
    				</c:forEach>
    			</tbody>
    		</table>
    		</div>
    		<div class="col-md-1"></div>
    		</div>
    	
    	</div>
    
    </div>
    
  <%if (session.getAttribute("username")==null){
    	response.sendRedirect("login.jsp");}
    	%>
</body>
</html>