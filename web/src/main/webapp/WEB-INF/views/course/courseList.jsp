<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/30/15
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>List of Courses</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
</head>
<body>
<%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">
  <div class="form-group input-group ">
    <a href="${pageContext.request.contextPath}/course/add" class="btn btn-primary ">添加课程</a>
    <button type="button" class="btn btn-default btn " onclick="delete_all_selected_users()">批量删除</button>
  </div>
  <div class="form-group input-group ">
    <input type="search" class="form-control" />
        <span class="input-group-btn ">
            <button class="btn btn-default" type="button">Search</button>
        </span>
  </div>
</div>
<div class="container">
  <small>${message}</small>

  <table class="table table-bordered" id="user-table">
    <thead>
    <tr>
      <th><input type="checkbox" onchange="select_all_or_select_none(this)"/></th>
      <th>Id</th>
      <th>Name</th>
      <th>Coach</th>
      <th>Time</th>
      <th>Customers</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
      <tr class="user_line">
        <td><input type="checkbox" name="selected_user_id" value="${course.id}" /></td>
        <td>${course.id}</td>
        <td>${course.name}</td>
        <td>${course.coach.name}</td>
        <td>
          <c:forEach var="coursetime" items="${course.courseTimes}">
            ${coursetime.time}；
          </c:forEach>
        </td>
        <td>
           <c:forEach var="customer" items="${course.customers}">
             ${customer.name}；
           </c:forEach>
        </td>
        <td>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/course/${course.id}/edit">修改</a>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/course/${course.id}/delete">删除</a>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/course/${course.id}/addTime">添加时间</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<script src="../lib/js/jquery-1.11.1.min.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
<script src="../lib/js/underscore.min.js"></script>
<script src="../js/jquery_webmvc/select_all_users.js"></script>


</body>
</html>
