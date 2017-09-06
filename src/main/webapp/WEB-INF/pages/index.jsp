<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        .wrapper {
            background: url(${pageContext.request.contextPath}/static/img/lunopark/robot.png) no-repeat;
        }
    </style>

    <link href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/resetcss.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/MainStyle.css">

</head>
<body>

<div class="wrapper wrapper_FirstPage">

    <header class="header_firstPage">
        <div class="loginBlock">
            <ul>
                <li class="log_button_block">
                    <a class="log_button" href="/login">Login</a>
                </li>

                <li class="log_button_block">
                    <a class="log_button" href="/register">Register</a>
                </li>
            </ul>
        </div>
    </header>

    <div class="content">
        <h1>
            <a href="/books">Read books</a>
        </h1>
    </div>


    <!-- data-allowfullscreen="true" -->
    <%--<div class="fotorama--wrapper">--%>

    <%--<div class="fotorama"--%>
    <%--data-width="1200px"--%>
    <%--data-height="600px"--%>
    <%--data-nav="thumbs"--%>

    <%--data-transition="crossfade"--%>

    <%--data-hash="true"--%>

    <%--data-loop="true"--%>

    <%--data-autoplay="10000"--%>

    <%--data-keyboard="true"--%>
    <%-->--%>

    <%--<img src="${pageContext.request.contextPath}/static/img/lunopark/cover.jpg"--%>
    <%--data-caption="Lunopark dlya smelchakov" id="T-1">--%>
    <%--<img src="${pageContext.request.contextPath}/static/img/Pohishenie/cover.jpg" data-caption="Pohishenie">--%>

    <%--</div>--%>
    <%--</div>--%>

    <%--</div>--%>


    <div class="row banner hidden-xs hidden-sm">
        <div class="col-xs-12">
            <div id="carousel-example-generic" class="carousel slide wi" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">


                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/static/img/Pohishenie/cover.jpg" alt="..."
                             class="center-block with_for_carusel">

                        <div class="carousel-caption">
                            <!-- <h1>op-op</h1> -->
                        </div>

                    </div>

                    <div class="item">
                        <img src="${pageContext.request.contextPath}/static/img/lunopark/cover.jpg" alt="..." class="center-block with_for_carusel">

                        <div class="carousel-caption">
                            <!-- <h1>hello world</h1> -->
                        </div>
                    </div>

                    <div class="item">
                        <img src="${pageContext.request.contextPath}/static/img/lunopark/cover.jpg" alt="..."
                             class="center-block with_for_carusel">

                        <div class="carousel-caption">
                            <!-- <h1>hello world</h1> -->
                        </div>
                    </div>

                    <!-- <h2>under-text</h2> -->
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>

</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</body>
</html>
