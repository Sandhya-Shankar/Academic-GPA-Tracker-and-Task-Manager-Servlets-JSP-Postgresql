<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style>
.welcome {
	background-color: yellow;
	margin-right: 1150px;
	border-radius: 5px;
	border-style: solid;
}
body{
    background-image: url(img/welcome-background.jpg); 
    background-size: cover;
    background-repeat: no-repeat;
}
.tasks{
	margin-left: 600px;
}

.myBtn{ 
height: 150px; 
width: 300px; 
padding: 10px 15px; 
background-color: yellow;
font-size: 30px;
cursor: pointer;
border-radius: 5px;
text-align: center;

} 
.myBtn:hover {
  background-color: black;
  color: white;
  border-color: white;
  border: 2;
}
.loutbtn{
height: 50px; 
width: 100px; 
padding: 10px 15px; 
cursor: pointer;
border-radius: 5px;
text-align: center;
background-color: black;
color: white;
padding: 10px 15px;
margin-left: 120px;
}



</style>
</head>
<body>

    <div class="tasks">
	<button type="submit" class="myBtn"><a href="addtask.jsp" style="text-decoration:none;">Add Task</a></button><br><br>
	<button type="submit" class="myBtn" ><a href="ViewTask.jsp" style="text-decoration:none; ">View Tasks</a></button><br><br>
	</div>

</body>
</html>
