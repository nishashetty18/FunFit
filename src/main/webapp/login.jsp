<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>

body{
margin:0;
padding:0;
font-family:montserrat;
background: linear-gradient(120deg,#FFD8F0,#FFD8F0,#2980b9,#FFD8F0,#2980b9,#FFD8F0,#FFD8F0);
height:100vh;
overflow: hidden;
}
.center{
position: absolute;
top:50%;
left:50%;
transform:translate(-50%, -50%);
width:400px;
background:white;
border-radius:10px;
}
.center h1{
text-align:center;
padding:0 0 20px 0;
border-bottom:1px solid silver;
}
.center form{
padding:0 30px;

}
form.txt_field{
position:relative;
border-bottom:2px solid #adadad;
margin:30px 0;
}
.txt_field input{
width:100%
padding:0 5px;
height:40px;
fomt-size:16px;
border-radius:14px;
}

</style>
</head>
<body>
<div class="center">
<h1>Login</h1>
<form method="post" action="login">

<div style="text-align:center;class="txt_field">
<label class="form-group">Username</label>
<br>
<input type="text" name="username"  class="form-control">

</div>
<div style="text-align:center;class="txt_field">
<label class="form-group">Password </label>
<br>
<input type="password" name="password"  class="form-control" >

</div>
<br>
<div style="text-align:center;">
<input  type="submit" value="Login" class="btn btn-success">
<input type="reset" value="Reset" class="btn btn-danger">
<p style="color: red;">${errorMsg}</p>
</div>
</form>

</div>
</body>



















