<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 6/23/15
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>User login page</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
</head>
<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">

  <h1>login page</h1>

  <form:form method="post" commandName="user" role="form">
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="password">password:</label>
      <form:input path="password" class="form-control" />
    </div>
    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="Login" />
    </div>
  </form:form>
</div>

<p></p>
</body>
</html>