<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>
    <link href="/pages/css/bootstrap.css"  rel="stylesheet">
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <c:redirect url="/index"/>
</sec:authorize>

<div class="container">
    <div class="row">
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                        <span class="sr-only">Open navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <%--<a class="navbar-brand" href="#">Company</a>--%>
                </div>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="nav navbar-nav">
                        <li><a href="/register">Register</a> </li>
                        <li><a href="/login">Login</a> </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <header>
        <h1>Welcome!</h1>
    </header>
</div>
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container text-center">
          @Dmitriy Smirnov 2016
        </div>
        </div>
    </div>
<script src="/pages/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</body>
</html>
