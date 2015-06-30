<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/29/15
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Add employee page</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
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
      </ul>
    </div>
  </div>
</div>
<div class="container">
  <h1>新增雇员</h1>

  <form:form method="post" commandName="employee" role="form">
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="type">Type:</label>
      <form:input path="type" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="user.id">UserID:</label>
      <form:input path="user.id" class="form-control" />
    </div>
    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="新增" />
      <a href="${pageContext.request.contextPath}/employee/">返回</a>
    </div>
  </form:form>
</div>

<p></p>
</body>
</html>
