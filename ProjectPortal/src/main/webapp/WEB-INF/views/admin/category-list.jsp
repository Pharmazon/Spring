<%@ page import="ru.shcheglov.model.Category" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Categories" />
</jsp:include>

<jsp:include page="../menu.jsp">
    <jsp:param name="action" value="/admin/category-add" />
</jsp:include>

<table class="listTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="50" nowrap="nowrap" align="center">№</th>
        <th width="200" nowrap="nowrap" align="center">Parent category</th>
        <th width="400" nowrap="nowrap" align="center">Sub-category</th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
    </tr>
    <c:forEach var="category" items="${categories}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="left">${category.parent.name}</td>
            <td align="left">${category.name}</td>
            <td align="center" nowrap="nowrap">
                <a href="/admin/category-edit/${category.id}">
                    <img src="../../../resources/images/icons/icon_edit.png" alt="edit" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/admin/category-delete/${category.id}">
                    <img src="../../../resources/images/icons/icon_delete.png" alt="delete" width="20" />
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../footer.jsp" />
