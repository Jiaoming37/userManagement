<%--
  Created by IntelliJ IDEA.
  User: jiaoming
  Date: 7/9/15
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<div class="navbar navbar-default navbar-static-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">管理界面</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.request.contextPath}/user/">用户管理</a></li>
        <li><a href="${pageContext.request.contextPath}/employee/">雇员管理</a></li>
        <li><a href="${pageContext.request.contextPath}/customer/">顾客管理</a></li>
        <li><a href="${pageContext.request.contextPath}/course/">课程管理</a></li>
        <li><a href="${pageContext.request.contextPath}/courseTime/">时间管理</a></li>
      </ul>
    </div>
  </div>
</div>
