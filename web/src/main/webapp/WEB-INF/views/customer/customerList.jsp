<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/30/15
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>List of Customers</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
</head>
<body>
<%@include file="/WEB-INF/views/commonNavigation.jsp"%>
<div class="container">
  <div class="form-group input-group ">
    <a href="${pageContext.request.contextPath}/customer/add" class="btn btn-primary ">添加顾客</a>
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
      <th>Email</th>
      <th>Private_coach</th>
      <th>Courses</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
      <tr class="user_line">
        <td><input type="checkbox" name="selected_user_id" value="${customer.id}" /></td>
        <td>${customer.id}</td>
        <td>${customer.name}</td>
        <td>${customer.email}</td>
        <td>姓名:${customer.privateCoach.name}； 邮箱:${customer.privateCoach.user.email}； 年龄:${customer.privateCoach.user.age}；</td>
        <td>
          <c:forEach var="course" items="${customer.courses}">
              ${course.name}；
          </c:forEach>
        </td>
        <td>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/customer/${customer.id}/edit">修改信息</a>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/customer/${customer.id}/delete">删除顾客</a>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/customer/${customer.id}/select">顾客选课</a>
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
