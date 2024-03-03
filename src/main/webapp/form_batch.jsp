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
            <li><b><a href="<%=request.getContextPath()%>/batches">Back</a></b></li>
          
        </ul>
    </nav>
    </header>
    <div class="container-fluid"></div>
    <br />
    <br />
    <br />
    <br />
    
  	<div class="container col-md-4">
  		<div class="card" style="background-color:#C2CAD0">
  			<div class="card-body">
  				<c:if test="${bch != null}">
					<form action="update2" method="post">
  				</c:if>
  				<c:if test="${bch==null}">
  					<form action="insert2" method="post">
  				</c:if>
  				
  				<caption>
  					<h2 style="text-align:center;">
  						<c:if test="${bch!=null}">
  						Edit Batch
  						</c:if>
  						<c:if test="${bch==null}">
  						Add New Batch
  						</c:if>
  					</h2>
  				</caption>
  				
  				<c:if test="${bch != null}">
  				<input type="hidden" name="id"value="<c:out value="${bch.id}" />" />
  				</c:if>
  				
  				<fieldset class="form-group">
	  				<label>Name</label>
	  				<input type="text" value="<c:out value="${bch.name}" />" class="form-control" name="name" required="required">
  				</fieldset>
  				<br>
  					<fieldset class="form-group">
	  				<label>Timeings</label>
	  				 <input type="text" value="<c:out value="${bch.time}" />"class="form-control" name="time" placeholder="HH:MM AM/PM" pattern="(0[1-9]|1[0-2]):[0-5][0-9] [APap][mM]" title="Enter time in HH:MM AM/PM format">
	  				
					  				 
  				</fieldset>
  					<br>
  				<fieldset class="form-group">
	  				<label>Instructor Name</label>
	  				 
	  				<input type="text" value="<c:out value="${bch.instructor}" />" class="form-control" name="instructor" required="required">
  				</fieldset>
  				
  				
  					<br>
  				<button style="text-align:center;" type="submit" class="btn btn-success">Save</button>
  				
  			</form>
  			
  			
  			</div>
  		
  		
  		</div>
  		
  		</div>

</div>
  <%if (session.getAttribute("username")==null){
    	response.sendRedirect("login.jsp");}
    	%>
</body>
</html>