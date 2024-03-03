<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Fun Fit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }

        nav {
            width: 100%;
            height: 75px;
            line-height: 75px;
            padding: 0px 100px;
            position: fixed;
            background-color: #A1C3D1;
        }

        nav .logo {
            font-family: Georgia, 'Times New Roman', Times, serif;
            position: relative;
            font-size: 35px;
            font-weight: 700;
            color: white;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        span {
            color: #E64398;
        }

        nav ul {
            float: right;
        }

        nav li {
            display: inline-block;
            list-style: none;
        }

        nav li a {
            font-size: 18px;
            text-transform: uppercase;
            padding: 0px 30px;
            color: black;
            text-decoration: none;
        }

        nav li a:hover {
            color: #C5C6C7;
            transition: all 0.4s ease 0s;
        }

        body {
            background: #FFD8F0;
            position: relative; /* Make sure the body is positioned */
        }
		.center-text {
            position: absolute; /* Position the text absolutely */
            margin-top: 15%; /* Place it 50% from the top */
            margin-left: 50%; /* Place it 50% from the left */
            transform: translate(-50%, -50%); /* Translate it -50% horizontally and vertically to center */
            font-size: 100px; /* Adjust font size as needed */
            color: black; /* Set text color */
            font-family:Georgia, 'Times New Roman', cursive; /* Set font family */
        }
       
    </style>
</head>

<body>
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
      <br/>  <br/>  <br/>  <br/>
	<div class="center-text">Zumba Classes</div>
	  



    <%if (session.getAttribute("username")==null){
    	response.sendRedirect("login.jsp");}
    	%>

 
</html>
