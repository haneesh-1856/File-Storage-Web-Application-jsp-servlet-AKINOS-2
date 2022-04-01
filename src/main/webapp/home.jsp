<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
    <link rel="stylesheet" type="text/css" 
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
  

  <h2 id="asd" class="asd" onclick="myFunction()">ASD</h2>
    <script>
      function myFunction() {
        if (document.getElementById("asd").innerHTML == "ASD")
          document.getElementById("asd").innerHTML = "AKINOS STORAGE DRIVE";
        else document.getElementById("asd").innerHTML = "ASD";
      }
    </script>
</head>
<body >


<h3 style="color:white;font-size:40px;margin-top:3%;margin-left:5%;">welcome ${username}</h3>
  <div class="container">
    <div class="login-box">
    <div class="row">
      <div class="col-md-6 login-left">
        <h2>Files uploaded</h2>
        <br>
        <button type="submit" class="btn btn-primary"><a href=allfiles.php?name=true" style="text-decoration:none;">Files</a></button>
</div>
      <div class="col-md-6 login-right">
        <h2>View Important Files</h2><br>
          <button type="submit" class="btn btn-primary"><a href=impfiles.php?name=true"  style="text-decoration:none;">Click</a></button>
</div>
<button  class="btn btn-primary" >ALL FILES</button>
</div>
</div>

<form action="UploadServlet" method="post" enctype="multipart/form-data" class="select">
	
	<input type="file" name="my_image" style="color:black;">
  	<input type="submit" name="submit" value="Upload">

</form><br><br>
<form action="./Logout">
<button  class="logout" > LOGOUT</button>
 </form>
</div><br>


</body>

<style>
  .asd{
    color:white;
    text-align:center;
    margin-top:4%;
    font-size:35px;
  }
  .select{
    margin-left:35%;
    margin-top:-7%
  }
  .select input{
    color: grey;
  }
  .all_files{
    text-decoration:none;
    background-color:rgb(0,0,255),0.63;
    color: white;
  }
  .container{
    margin-top: -5%
  }
  .img_files{
    border: none;
    padding: 3%;
  }
  body{
    background: linear-gradient(rgba(0,0,50,0.5),rgba(0,0,50,0.5)),url(img.jpg);
    background-size: cover;
    background-position: center;
  }
  .float-right{
    text-decoration:none;
  }
  .login-box{
    max-width: 1000px;
    floag:none;
    margin: 150px auto; 
  }
  h2{
    color: black;
  }
  .form-group label{
    color: getservbyname;
    font-size:larger;
  }
  .login-left{
    background-color: rgba(211,211,211,0.5);
    padding: 30px
  }
  .login-right{
    background-color: #ffff;
    padding: 30px;
  }
  .form-control{
    background-control: transparent !important;
  }
  a{
    color: white;
    margin-top: -200px !important; 
  }
  h1{
    color: white;
    margin-top: 200px !important;
    text-align: left;
    text-transform: uppercase;
    margin-left: 4%
  }
  
  .logout{
    border:none;
    background-color: #5959ff;
    margin-left:45%;
    padding: 10px 20px;
    border-radius:20px;
  }
</style>
</html>