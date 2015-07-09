<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/29/15
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java"  pageEncoding="utf-8"%>
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

<%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">
  <h1>新增雇员</h1>

  <form:form method="post" commandName="employee" role="form">
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="user.name">userName:</label>
      <form:input path="user.name" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="user.password">Password:</label>
      <form:input path="user.password" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="user.email">Email:</label>
      <form:input path="user.email" class="form-control" />
    </div>
    <div class="form-group">
      <label for="user.age">Age:</label>
      <form:input path="user.age" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="type">Type:</label>
      <form:input path="type" class="form-control"/>
    </div>
    <div class="form-group" style="display: none">
      <label for="user.id" >userId:</label>
      <form:input path="user.id" class="form-control"/>
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
