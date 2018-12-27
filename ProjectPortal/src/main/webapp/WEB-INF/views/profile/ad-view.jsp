<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Ad view" />
</jsp:include>

<form action="<c:url value="/profile/ad-list"/>">
    <button type="submit">
        <img src="../../../resources/images/icons/icon_back.png" alt="Edit" width="20"/>
    </button>
</form>

<table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="200" align="left" nowrap="nowrap">CAPTION</th>
        <th width="400" align="left" nowrap="nowrap">VALUE</th>
    </tr>

    <tr>
        <td>Id</td>
        <td>${ad.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${ad.name}</td>
    </tr>
    <tr>
        <td>Content</td>
        <td>${ad.content}</td>
    </tr>
    <tr>
        <td>Date placed</td>
        <td>${ad.formattedDateTime}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${ad.price}</td>
    </tr>
    <tr>
        <td>Category</td>
        <td>${ad.category.name}</td>
    </tr>
</table>

<jsp:include page="../footer.jsp" />