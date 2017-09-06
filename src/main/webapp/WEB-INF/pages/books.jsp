<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/resetcss.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/books.css">

    <title>Book</title>

    
</head>
<body>
    <div class="wrapper">

       <header class="header">
        <div class="loginBlock">
            <ul>
                <li>user name</li>
                <li>
                    <%--spring 3--%>
                    <%--<c:url value="/j_spring_security_logout" var="logoutUrl" />--%>
                    <%--<a href="${logoutUrl}">Log Out</a>--%>

                        <c:url var="logoutUrl" value="/logout"/>
                        <form action="${logoutUrl}" method="post">
                            <input type="submit" value="Logout"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                </li>
            </ul>
        </div>
    </header>

    <div class="books_content">

            <c:forEach items="${books}" var="book" varStatus="count">

                <div class="book">
                
                    <div class="book_IMG">
                        <a href="/${book.getName()}/page/1">
                            <img width="150px" class="coverImg" src="${pageContext.request.contextPath}/static/img/${book.getName()}/${book.getBookCoverName()}" alt="#">
                        </a>
                    </div>

                    <div class="img_description">
                        <p>
                            Name: <a class="bookNameLink" href="/${book.getName()}/page/1">${book.getName()}</a>
                        </p>

                        <p>
                            Autor: ${book.getAuthor()}
                        </p>

                        <p>
                            Description: ${book.getBookDescription()}
                        </p>
                    </div>
                </div>
            </c:forEach>
    </div>
    <footer>
        <div class="footer">
            imaginato.com
        </div>
    </footer>

</div>
</body>
</html>
