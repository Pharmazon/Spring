<%@ page import="ru.shcheglov.model.user.Role" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />

<title>Roles list</title>

<h1>ROLE LIST</h1>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td nowrap="nowrap">
            <form action="/role-add" method="get">
                <button type="submit">
                    <img src="../../resources/images/icons/icon_add.png" alt="add" width="20"/>
                </button>
            </form>
        </td>
        <td width="0" nowrap="nowrap">&nbsp;</td>
        <td>
            <form>
                <input type="hidden" name="time" value="<%=System.currentTimeMillis()%>">
                <button type="submit">
                    <img src="../../resources/images/icons/icon_refresh.png" alt="refresh" width="20"/>
                </button>
            </form>
        </td>
        <td width="100%">&nbsp;</td>
    </tr>
</table>

<table class="listTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="50" nowrap="nowrap" align="center">№</th>
        <th width="350" nowrap="nowrap" align="center">ID</th>
        <th width="200" nowrap="nowrap" align="center">NAME</th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
    </tr>
    <c:forEach var="role" items="${roles}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="left">${role.id}</td>
            <td align="left">${role.name}</td>
            <td align="center" nowrap="nowrap">
                <a href="/role-view/${role.id}">
                    <img src="../../resources/images/icons/icon_view.png" alt="view" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/role-edit/${role.id}">
                    <img src="../../resources/images/icons/icon_edit.png" alt="edit" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/role-delete/${role.id}">
                    <img src="../../resources/images/icons/icon_delete.png" alt="delete" width="20" />
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
