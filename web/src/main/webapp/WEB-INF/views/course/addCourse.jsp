<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/30/15
  Time: 4:54 PM
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
  <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
  <script src="/web/lib/js/jquery-1.11.3.min.js"></script>
  <script src="/web/lib/js/bootstrap-3.3.5.js"></script>
  <script>
    $(document).on('click', '.dropdown-menu li', function() {
      $('#datebox').val($(this).attr('value'));
      $('#choose_coach').html($(this).find(":first-child").html()+' <span class="caret" ></span>');
    });
  </script>
</head>
<body>

 <%@include file="/WEB-INF/views/commonNavigation.jsp"%>

<div class="container">
  <h1>新增课程</h1>

  <form:form method="post" commandName="course" role="form">

    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
    </div>

    <div class="form-group">
      <label for="coach.id">Coach:</label>
      <form:input  path="coach.id"  id="datebox" class="form-control"  type="hidden"/>
        <div class="dropdown">
          <button class="btn btn-default dropdown-toggle" type="button" id="choose_coach" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            Choose coach:
            <span class="caret" ></span>
          </button>
          <ul class="dropdown-menu" role="menu" aria-labelledby="choose_coach">
            <c:forEach var="coach" items="${coaches}">
              <li role="presentation" value="${coach.id}"><a role="menuitem" tabindex="-1" >${coach.name}</a></li>
            </c:forEach>
          </ul>
         </div>
      </div>

    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="新增" />
      <a href="${pageContext.request.contextPath}/course/">返回</a>
    </div>

  </form:form>
</div>
<p></p>
</body>
</html>