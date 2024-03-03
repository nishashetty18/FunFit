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
            <li><b><a href="<%=request.getContextPath()%>/list">Back</a></b></li>
          
        </ul>
    </nav>
    </header>
    <br />
    <br />
    <br />
    <br />
  	<div class="container col-md-4">
  		<div class="card">
  			<div class="card-body"style="background-color:#C2CAD0">
  				<c:if test="${part != null}">
					<form action="update" method="post">
  				</c:if>
  				<c:if test="${part==null}">
  					<form action="insert" method="post">
  				</c:if>
  				
  				<caption>
  					<h2 style="text-align:center;">
  						<c:if test="${part!=null}">
  						Edit Participant
  						</c:if>
  						<c:if test="${part==null}">
  						Add New Participant
  						</c:if>
  					</h2>
  				</caption>
  				
  				<c:if test="${part != null}">
  				<input type="hidden" name="id"value="<c:out value="${part.id}" />" />
  				</c:if>
  				
  				<fieldset class="form-group">
	  				<label>Name</label>
	  				<input type="text" value="<c:out value="${part.name}" />" class="form-control" name="name" required="required">
  				</fieldset>
  				<br>
  					<fieldset class="form-group">
	  				<label>Gender</label>
	  				
				    <div class="form-check">
				        <input class="form-check-input" type="radio" name="gender" id="male" value="Male" <c:if test="${part.gender == 'male'}">checked</c:if>>
				        <label class="form-check-label" for="male">
				            Male
				        </label>
				    </div>
				    <div class="form-check">
				        <input class="form-check-input" type="radio" name="gender" id="female" value="Female" <c:if test="${part.gender == 'female'}">checked</c:if>>
				        <label class="form-check-label" for="female">
				            Female
				        </label>
				    </div>
					  				
					
  				</fieldset>
  					<br>
  				<fieldset class="form-group">
	  				<label>Location</label>
	  				<input type="text" value="<c:out value="${part.location }" />" class="form-control" name="location" required="required">
  				</fieldset>
  					<br>
  				<fieldset class="form-group">
	  				<label>Phone</label>
	  				<input type="text" value="<c:out value="${part.phone }" />" class="form-control" name="phone" required="required">
  				</fieldset>
  					<br>
  				<fieldset class="form-group">
	  				<label>Batch Id</label>
	  				<input type="number" value="<c:out value="${part.batch_id}" />" class="form-control" name="batch_id" required="required">
  				</fieldset>
  					<br>
  				<button style="text-align:center;" type="submit" class="btn btn-success">Save</button>
  			
  				
  				
  			</form>
  			
  			
  			</div>
  		
  		
  		</div>
  		
  		</div>

  <%if (session.getAttribute("username")==null){
    	response.sendRedirect("login.jsp");}
    	%>

</body>
</html>