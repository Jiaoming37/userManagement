<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 7/8/15
  Time: 4:44 PM
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
  <title>Add customer page</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css" />
  <script src="/web/lib/js/jquery-1.11.3.min.js"></script>
  <script src="/web/lib/js/bootstrap-3.3.5.js"></script>
</head>
<body>

<%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">
  <h1>添加课程时间</h1>

  <form:form method="post" commandName="courseTime" role="form">

    <div class="form-group">
      <label for="time">add_time:</label>
      <form:input path="time"  id="datebox" class="form-control"/>
    </div>

    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="新增" />
      <a href="${pageContext.request.contextPath}/customer/">返回</a>
    </div>

  </form:form>

</div>

</body>
</html>


