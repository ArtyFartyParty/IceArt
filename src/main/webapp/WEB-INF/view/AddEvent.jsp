<!DOCTYPE html>

/**
* @author Ása Júlía Aðalsteinsdóttir - aja11@hi.is
* @date September 2017
* Háskóli Íslands
*
*
*/

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="is">

<head>
    <meta charset="UTF-8">
    <title>Add event</title>
</head>
<body>

<h1>Add a new event</h1>

<form action="/event/add" method="get">
    Title: <input type="text" name="title"\>
    Location: <input type="text" name="location"\>
    Name of artist: <input type="text" name="artist"\>
    Time begin: <input type="text" name="timeBegin"\>
    Time end: <input type="text" name="timeEnds"\>
    Description: <textarea type="text" name="description"\></textarea>

    <input type="submit" value="Submit"/>
</form>

</body>

</html>