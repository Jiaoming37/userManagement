<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/30/15
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <title>Edit customer page</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css" />
</head>
<body>

<%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">

  <h1>Edit customer page</h1>
  <form:form method="post" commandName="customer">
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <form:input path="email" class="form-control" />
    </div>
    <div class="form-group">
      <label for="PrivateCoach.id">Private_coach:</label>
      <form:input path="PrivateCoach.id" class="form-control"/>
    </div>
    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="更新" />
      <a href="${pageContext.request.contextPath}/customer/">返回</a>
    </div>
  </form:form>
</div>
</body>
</html>
