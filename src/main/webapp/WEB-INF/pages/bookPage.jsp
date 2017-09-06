<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
         language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/resetcss.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/MainStyle.css">
    <title>Book</title>
</head>
<body>
<div class="wrapper">

    <header class="header">
        <h2><a href="/books">Go back to books</a></h2>
    </header>

    <div class="mainContent">

        <div class="pageTextContainer">
            <div class="book">


                <div class="page">

                    <div class="pageImg">
                        <img id="pImg" width="220px"
                             src="${pageContext.request.contextPath}/static/img/${page.getBookName()}/${page.getPageImgName()}"
                             alt="#">
                    </div>

                    <div id="pageText" class="pageText">
                        <p>Page number: ${page.getNumber()}</p>
                        <p>img: ${page.getPageImgName()}</p>
                        <p>${page.getText()}</p>
                    </div>

                </div>
                <div class="bookButtons">
                    <form class="bookButton" action="/${page.getBookName()}/page/${page.getNumber()-1}" method="get">
                        <input class="bookButton-view" type="submit" class="button" id="pre-page-button" value="<<<"/>
                    </form>

                    <!--  <form class="bookButton" action="/${page.getBookName()}/page/${page.getNumber()+1}" method="get"
                            id="nextPage">
                            <input class="bookButton-view" type="submit" class="button" id="next-page-button" value=">>>"/>
                        -->


                    <div class="choiceButtons">

                        <c:forEach items="${links}" var="link" varStatus="count">
                            <form action="/${page.getBookName()}/page/${link.getPage()}" method="get" id="link">
                                <input type="submit" class="button" id="choice-1-page-button"
                                       value="${link.getLinkDescription()}"/>
                            </form>
                        </c:forEach>
                    </div>
                    </form>

                </div>

                <div class="pageNumber">
                    <span>Page number: ${page.getNumber()}</span>
                </div>
                <br>
                <a href="javascript:history.back();">Вернутьс я назад</a>

            </div>


        </div>
    </div>

</div>

<script type="text/javascript">
//    var elem = document.getElementById("nextPage");
//    var element2 = document.getElementById("link");
//    if (element2 !== null) {
//        elem.parentNode.removeChild(elem);
//    }

    var nodes = document.images,
    i = nodes.length - 1,
    img;
    for (; img = nodes[i--];)
    if (!img.complete || "naturalWidth" in new Image && !img.naturalWidth) {
        img.parentNode.removeChild(img);

        var el = document.getElementById("pImg");
        if (el === null) {
            document.getElementById("pageText").style.width = "100%";
        }
    }

//    window.addEventListener("load", function () {
//        var nodes = document.images,
//            i = nodes.length - 1,
//            img;
//        for (; img = nodes[i--];)
//            if (!img.complete || "naturalWidth" in new Image && !img.naturalWidth) {
//                img.parentNode.removeChild(img);
//                var el = document.getElementById("pImg");
//                if (el === null) {
//                    document.getElementById("pageText").style.width = "100%";
//                }
//            }
//    });

</script>


</body>
</html>
