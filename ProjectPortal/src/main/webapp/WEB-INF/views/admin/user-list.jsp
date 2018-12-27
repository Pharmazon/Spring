<%@ page import="ru.shcheglov.model.user.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Users" />
</jsp:include>

<jsp:include page="../menu.jsp">
    <jsp:param name="action" value="/admin/user-add" />
</jsp:include>

<table class="listTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="50" nowrap="nowrap" align="center">№</th>
        <th width="200" nowrap="nowrap" align="center">Login</th>
        <th width="300" nowrap="nowrap" align="center">E-mail</th>
        <th width="50" nowrap="nowrap" align="center">Role</th>
        <th width="70" nowrap="nowrap" align="center">Enabled</th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
    </tr>
    <c:forEach var="user" items="${users}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="left">${user.user.login}</td>
            <td align="left">${user.email}</td>
            <td align="left">${user.role.name}</td>
            <td align="left">${user.user.enabled}</td>
            <td align="center" nowrap="nowrap">
                <a href="/admin/user-view/${user.id}">
                    <img src="../../../resources/images/icons/icon_view.png" alt="view" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/admin/user-edit/${user.id}">
                    <img src="../../../resources/images/icons/icon_edit.png" alt="edit" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/admin/user-delete/${user.id}">
                    <img src="../../../resources/images/icons/icon_delete.png" alt="delete" width="20" />
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../footer.jsp" />
