<%--
  Created by IntelliJ IDEA.
  User: staszek
  Date: 31.08.18
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Bookstore</title>
</head>
<body>

<form>
    <fieldset>
        <input type="number" name="isbn" placeholder="isbn">
        <input type="text" name="title" placeholder="title">
        <input type="text" name="author" placeholder="author">
        <input type="text" name="publisher" placeholder="publisher">
        <input type="text" name="type" placeholder="type">
        <button name="submit">submit</button>
    </fieldset>
</form>


<ul id="books">
</ul>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./app.js"></script>
</body>
</html>
