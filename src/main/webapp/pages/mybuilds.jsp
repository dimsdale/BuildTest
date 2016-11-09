<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Contacts</title>
    <script src="/pages/js/bootstrap.min.js"></script>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <style>
        .row{margin-top: 100px;}
    </style>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <c:redirect url="/"/>
</sec:authorize>
<div class="container">
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
                        <li><a href="/new">New build</a> </li>
                        <li><a href="/logout">Logout</a></li>
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
<div class="container">
    <div class="row">
        <sec:authorize access="isAuthenticated()">
            <c:if test="${!empty mybuilds}">
                <table class="" width=80%>
                    <tr>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${mybuilds}" var="build">
                        <tr>
                            <td>${build.description}</td>
                            <td><a href="my/${build.id}">Views</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </sec:authorize>
    </div>

    <div class="navbar-fixed-bottom row-fluid">
        <div class="navbar-inner">
            <div class="container text-center">
                @Dmitriy Smirnov 2016
            </div>
        </div>
    </div>
</div>
</body>
</html>