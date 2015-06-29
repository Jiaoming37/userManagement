<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/29/15
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <title>Edit employee page</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../lib/css/bootstrap.min.css" />
</head>
<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">管理界面</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">雇员管理</a></li>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
      </ul>
    </div>
  </div>
</div>
<div class="container">

  <h1>Edit user page</h1>
  <form:form method="post" commandName="employee">
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="type">Type:</label>
      <form:input path="type" class="form-control" />
    </div>
    <div class="form-group">
      <label for="user.id">UserID:</label>
      <form:input path="user.id" class="form-control"/>
    </div>
    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="更新" />
      <a href="${pageContext.request.contextPath}/employee/">返回</a>
    </div>
  </form:form>
</div>
</body>
</html>
