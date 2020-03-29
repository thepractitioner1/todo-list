<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.misan.utils.Mappings" %>


<html>
<head>
    <title> Todo item</title>
</head>

<body>
<div align="center">
    <c:url var="itemlistUrl" value="${Mappings.ITEMS}"/>
    <a href="${itemlistUrl}">Show Item</a>

    <table border="1" cellpadding="5">

        <caption><h2> Todo Item</h2></caption>

        <tr>

            <th>Title</th>
            <th>Deadline</th>
            <th>Edit</th>
            <th>Details</th>

        </tr>



            <tr>
                <td><c:out value="${todoItem.id}"/></td>
                <td><c:out value="${todoItem.title}"/></td>
                <td><c:out value="${todoItem.deadline}"/></td>
                <td><c:out value="${todoItem.details}"/></td>

            </tr>


    </table>

</div>

</body>

</html>

