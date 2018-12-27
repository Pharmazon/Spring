<%@ page import="ru.shcheglov.model.Ad" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Ads" />
</jsp:include>

<jsp:include page="../menu.jsp">
    <jsp:param name="action" value="/profile/ad-add" />
</jsp:include>

<table class="listTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="50" nowrap="nowrap" align="center">№</th>
        <th width="200" nowrap="nowrap" align="center">Name</th>
        <th width="300" nowrap="nowrap" align="center">Content</th>
        <th width="50" nowrap="nowrap" align="center">Price</th>
        <th width="70" nowrap="nowrap" align="center">Category</th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
    </tr>
    <c:forEach var="ad" items="${ads}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="left">${ad.name}</td>
            <td align="left">${ad.content}</td>
            <td align="left">${ad.price}</td>
            <td align="left">${ad.category.name}</td>
            <td align="center" nowrap="nowrap">
                <a href="/profile/ad-view/${ad.id}">
                    <img src="../../../resources/images/icons/icon_view.png" alt="view" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/profile/ad-edit/${ad.id}">
                    <img src="../../../resources/images/icons/icon_edit.png" alt="edit" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/profile/ad-delete/${ad.id}">
                    <img src="../../../resources/images/icons/icon_delete.png" alt="delete" width="20" />
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../footer.jsp" />
