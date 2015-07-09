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
  <script>
    $(document).on('click', '.dropdown-menu li', function() {
      //$('#datebox').val($(this).html());
      $('#datebox').val($(this).attr('value'));
      $('#select_course').html($(this).find(":first-child").html()+'<span class="caret" ></span>');
    });
  </script>
</head>
<body>

<%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">
  <h1>添加课程</h1>

  <form:form method="post" commandName="course" role="form">

    <div class="form-group">
      <label for="id">Choose_course:</label>
      <form:input type="hidden" path="id"  id="datebox" class="form-control"/>
      <div class="dropdown">
        <button class="btn btn-default dropdown-toggle" type="button" id="select_course" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
          Select course:
          <span class="caret" ></span>
        </button>
        <ul class="dropdown-menu" role="menu" aria-labelledby="select_course:">
          <c:forEach var="course" items="${courses}">
            <li role="presentation" value="${course.id}"><a role="menuitem" tabindex="-1" >${course.name}</a></li>
          </c:forEach>
        </ul>
      </div>
    </div>

    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="新增" />
      <a href="${pageContext.request.contextPath}/customer/">返回</a>
    </div>
  </form:form>
</div>

<p></p>
</body>
</html>


