<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 7/1/15
  Time: 4:11 PM
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
  <title>Add courseTime page</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
</head>
<body>
<%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">
  <h1>新增课程</h1>

  <form:form method="post" commandName="courseTime" role="form">
    <div class="form-group">
      <label for="course.id">Course_id:</label>
      <form:input path="course.id" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="time">Time:</label>
      <form:input path="time" class="form-control"/>
    </div>
    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="新增" />
      <a href="${pageContext.request.contextPath}/courseTime/">返回</a>
    </div>
  </form:form>
</div>
<p></p>
</body>
</html>