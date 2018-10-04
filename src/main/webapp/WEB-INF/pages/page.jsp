<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Price of Iphone XS 256gb</title>
</head>

<body>
    <h2>Stylus.ua Iphone XS 256 gb Space Grey ${stylusPrice}</h2>
    <h2>Royal-Service.store Iphone XS 256 gb Space Grey ${royalServiceStorePrice}</h2>
    <h2>eStore.ua Iphone XS 256 gb Space Grey ${eStorePrice}</h2><br>
    <a href="http://localhost:8080/view">update prices</a><br><br>
    <h2>Your Email ${recipientMail}</h2><br>
    <form action="alert" method="post">
        <select name="enable">
            <option value="1">Subscribe</option>
            <option value="0">Unsubscribe</option>
        </select>
        Email <input type="email" name="recipientMail"><br>
        <input type="submit" value="OK">
    </form>
</body>
</html>