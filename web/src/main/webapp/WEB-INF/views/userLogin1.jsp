<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/23/15
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>User login page</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../lib/css/bootstrap.min.css" />
  <script type="text/javascript" src="../../lib/js/jquery-1.4.3.js"></script>

  <script type="text/javascript" language="javascript">
    var f = $(function(){
      alert("ddd");
    });

    var ff=$(function(){
      var f=false;
      $("#email").blur(function(){
        var name=$("#name").val();
        var email=$(this).val();
        $.post("log",{"name":name,"email":email},function(data){
          console.log(data);
          if(data){
            f=true;
          }else{
            alert("name or email is wrong ,please login again!");
            f=false;
          }
        });
      });

      $("#submit").bind("click",function(){
        if(f){
          $("#logForm").submit();
        }
      });
    });
  </script>

</head>
<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">

  <h1>Login page</h1>
  <form:form method="post" commandName="user" id="logForm">
    <div class="form-group">
      <label >Name:</label>
      <input path="name" class="form-control" id="name"/>
    </div>
    <div class="form-group">
      <label >Email:</label>
      <input path="email" class="form-control" id="email"/>
      <span id="error" style="display: none"></span>
    </div>
    <div class="form-group">
      <button class="btn btn-primary" id="submit" onclick="f();" >Login</button>
      <a class="btn btn-primary"  href="javascript:f();">Login</a>
    </div>
  </form:form>

</div>
</body>
</html>