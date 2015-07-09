<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/29/15
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <title>List of Employees</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
</head>
<body>

<%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">
  <div class="form-group input-group ">
    <a href="${pageContext.request.contextPath}/employee/add" class="btn btn-primary ">添加雇员</a>
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
      <th>ID</th>
      <th>用户名</th>
      <th>职位</th>
      <th>关联用户</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
      <tr class="user_line">
        <td><input type="checkbox" name="selected_user_id" value="${employee.id}" /></td>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>
          <c:choose>
            <c:when test="${employee.type==0}">
              OPs
            </c:when>
            <c:when test="${employee.type==1}">
              COACH
            </c:when>
            <c:when test="${employee.type==2}">
              HR
            </c:when>
          </c:choose>
        </td>
        <td>${employee.user.name}</td>
        <td>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/employee/${employee.id}/edit">修改</a>
          <a class="btn btn-default" href="${pageContext.request.contextPath}/employee/${employee.id}/delete">删除</a>
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
