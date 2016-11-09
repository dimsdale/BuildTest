<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Build</title>
    <style>
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body>
div class="container">
<div class="row">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target="#menu">
                    <span class="sr-only">Open navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

            </div>
            <div class="collapse navbar-collapse" id="menu">
                <ul class="nav navbar-nav">
                    <li><a href="/">Main</a> </li>
                    <li><a href="/new">New Build</a> </li>
                    <li><a href="/logout">Logout</a></li>
                    <li><a href="/my">My Builds</a></li>
                </ul>
                <form class="navbar-form pull-right" action="search" method="post">
                    <input type="text" class="span2 search-query" placeholder="Input text of search" />
                    <button type="submit" class="btn">Search</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/main"/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<div class="container">
    <div class="row">
        <div class="well span4 offset4">

            <spring:form action="addBuild" method="post" modelAttribute="build">
                <h2>Insert data</h2>
                <spring:input path="description" id="description" placeholder="description"/>
                <spring:errors path="description" cssClass="error" />
                <input type="submit" id="submitBuild"  value="Add" class="btn btn-success">
            </spring:form>
        </div>
        </div>
    </div>
</sec:authorize>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container text-center">
            @Dmitriy Smirnov 2016
        </div>
    </div>
</div>
</body>
</html>
