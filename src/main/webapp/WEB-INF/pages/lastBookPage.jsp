<%--
  Created by IntelliJ IDEA.
  User: HardWorker
  Date: 21.06.2017
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/resetcss.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/MainStyle.css">
    <title>Book</title>
</head>
<body>

<div class="wrapper">

    <header class="header">
        <p>menu</p>
    </header>

    <div class="mainContent">


        <div class="bookPage">
            <div class="book">

                <div class="page">
                    <h1>
                        The end.
                    </h1>
                </div>

                <div class="bookButtons">
                    <form class="bookButton" action="/${page.getBookName()}/page/${page.getNumber()-1}" method="get">
                        <input class="bookButton-view" type="submit" class="button" id="pre-page-button" value="<<<"/>
                    </form>

                    <form class="bookButton" action="/${page.getBookName()}/page/${page.getNumber()+1}" method="get"
                          id="nextPage">
                        <input class="bookButton-view" type="submit" class="button" id="next-page-button" value=">>>"/>
                    </form>
                </div>

            </div>
        </div>
        <div class="choiceButtons">

            <c:forEach items="${links}" var="link" varStatus="count">
                <form action="/${page.getBookName()}/page/${link.getPage()}" method="get" id="link">
                    <input type="submit" class="button" id="choice-1-page-button" value="${link.getLinkDescription()}"/>
                </form>
            </c:forEach>

        </div>
    </div>
</div>
</body>
</html>
