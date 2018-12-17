<%@ page import="ru.shcheglov.model.Company" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/ad-list">
    <button type="submit">ADS</button>
</form>

<h1>COMPANY LIST</h1>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td nowrap="nowrap">
            <form action="/company-add" method="get">
                <button type="submit">
                    <img src="../../../resources/images/icons/icon_add.png" alt="add" width="20"/>
                </button>
            </form>
        </td>
        <td width="0" nowrap="nowrap">&nbsp;</td>
        <td>
            <form>
                <input type="hidden" name="time" value="<%=System.currentTimeMillis()%>">
                <button type="submit">
                    <img src="../../../resources/images/icons/icon_refresh.png" alt="refresh" width="20"/>
                </button>
            </form>
        </td>
        <td width="100%">&nbsp;</td>
    </tr>
</table>

<table width="100%" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="50" nowrap="nowrap" align="center">№</th>
        <th width="200" nowrap="nowrap" align="center">ID</th>
        <th width="300" nowrap="nowrap" align="center">NAME</th>
        <th width="100%" nowrap="nowrap" align="center">DESCRIPTION</th>
        <th width="150" nowrap="nowrap" align="center">ADDRESS</th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
    </tr>
    <c:forEach var="company" items="${companies}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="left">${company.id}</td>
            <td align="left">${company.name}</td>
            <td align="left">${company.description}</td>
            <td align="left">${company.address}</td>
            <td align="center" nowrap="nowrap">
                <a href="/company-view/${company.id}">
                    <img src="../../../resources/images/icons/icon_view.png" alt="view" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/company-edit/${company.id}">
                    <img src="../../../resources/images/icons/icon_edit.png" alt="edit" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/company-delete/${company.id}">
                    <img src="../../../resources/images/icons/icon_delete.png" alt="delete" width="20" />
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
