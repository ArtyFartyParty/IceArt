<!DOCTYPE html>

<!--
    Pakkinn view geymir allar .jsp skrár sem segja til um hvað er á vefnum.
    Þessi klasi geymir uppbyggingu notendaviðmóts á viðburðum

    Höfundar

    Ása Júlía Aðalsteinsdóttir - aja11@hi.is
    Melkorka Mjöll Jóhannesdóttir - mmj8@hi.is
    Sigurlaug Þórðardóttir - sth301@hi.is
    Valgerður Sigfinnsdóttir - vas30@hi.is
-->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="is">

<head>
    <meta charset="UTF-8">
    <title>Bæta við viðburði - IceArt</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static.css/main.css"/>"/>
    <link rel="shortcut icon" type="image/x-icon" href="../resources/picture/icon.png" sizes="16x16">
</head>

<body>

<div class="navbar">
    <a href="/">Forsíða</a>

    <c:if test="${currentUser != null}"><a href="/event/add">Skrá viðburð</a></c:if>

    <c:if test="${currentUser != null}"><a href="/location/add">Skrá staðsetningu</a></c:if>

    <c:if test="${currentUser != null}"><a href="/artist/add">Skrá listamann</a></c:if>

    <c:choose>
        <c:when test="${currentUser == null}"><a href="/user/login">Innskrá</a></c:when>
        <c:otherwise><a href="/user/logout">Útskrá</a></c:otherwise>
    </c:choose>
</div>

<div class="addDiv">
    <h1>Skrá nýjan viðburð</h1>

    <form id="addEvent" action="/event/event" method="POST" class="form-horizontal">
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">Nafn:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="Nafn" id="title" name="title" pattern=".{1,50}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="location" class="col-sm-2 control-label">Staðsetning:</label>
            <div class="col-sm-10">
                <c:choose>
                    <c:when test="${not empty locations}">
                        <select name="location" id = "location" class="form-control">
                            <c:forEach var="location" items="${locations}">
                                <option value="${location.getId()}">${location.getName()}</option>
                            </c:forEach>
                        </select>
                    </c:when>
                    <c:otherwise>
                        Engar staðsetningar hafa verið skráðar.<br>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="form-group">
            <label for="artist" class="col-sm-2 control-label">Listamaður:</label>
            <div class="col-sm-10">
                <c:choose>
                    <c:when test="${not empty artists}">
                        <select name="artist" id="artist" class="form-control">
                            <c:forEach var="artist" items="${artists}">
                                <option value="${artist.getId()}">${artist.getName()}</option>
                            </c:forEach>
                        </select><br>
                    </c:when>
                    <c:otherwise>
                        Enginn listamaður hefur verið skráður.<br>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">Dagsetning:</label>
            <div class="col-sm-10">
                <div class="form-group row">
                    <div class="col-md-4">
                        <input type="date" class="form-control" id="dateBegin" name="dateBegin" value="${todayDate}">
                    </div>
                    <label for="dateEnd" class="col-md-1 control-label"> - </label>
                    <div class="col-md-4">
                        <input type="date" class="form-control" id="dateEnd" name="dateEnd" value="${inWeekDate}">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">Tími:</label>
            <div class="col-sm-10">
                <div class="form-group row">
                    <div class="col-md-4">
                        <input type="time" class="form-control" id="timeBegin" name="timeBegin" value="${todayTime}">
                    </div>
                    <label for="timeEnd" class="col-md-1 control-label"> - </label>
                    <div class="col-md-4">
                        <input type="time" class="form-control" id="timeEnd" name="timeEnd" value="${inWeekTime}">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="category" class="col-sm-2 control-label">Tegund:</label>
            <div class="col-sm-10">
                <c:choose>
                    <c:when test="${not empty categories}">
                        <select name="category" id="category" class="form-control">
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.getId()}">${category.getTitle()}</option>
                            </c:forEach>
                        </select><br>
                    </c:when>
                    <c:otherwise>
                        Enginn flokkur hefur verið skráður.<br>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">Stutt lýsing:</label>
            <div class="col-sm-10">
                <textarea form="addEvent" class="form-control" placeholder="..." name="description" id="description" cols="35" wrap="soft"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Skrá</button>
            </div>
        </div>
    </form>

</div>

</body>

</html>