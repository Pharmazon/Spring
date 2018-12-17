<%@ page import="ru.shcheglov.model.Category" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/ad-list">
    <button type="submit">ADS</button>
</form>

<h1>CATEGORY LIST</h1>

<table width="100%" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="60" nowrap="nowrap" align="center">№</th>
        <th width="200" nowrap="nowrap" align="center">ID</th>
        <th width="100%" nowrap="nowrap" align="center">NAME</th>
        <th width="80" nowrap="nowrap" align="center">VIEW</th>
        <th width="80" nowrap="nowrap" align="center">EDIT</th>
        <th width="80" nowrap="nowrap" align="center">REMOVE</th>
    </tr>
    <c:forEach var="category" items="${categories}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="center">${category.id}</td>
            <td align="center">${category.name}</td>
            <td align="center" nowrap="nowrap">
                <a href="/category-view/${category.id}">VIEW</a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/category-edit/${category.id}">EDIT</a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/category-delete/${category.id}">REMOVE</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td nowrap="nowrap">
            <form action="/category-add">
                <button type="submit" class="green">ADD</button>
            </form>
        </td>
        <td width="20" nowrap="nowrap">&nbsp;</td>
        <td>
            <form>
                <input type="hidden" name="time" value="<%=System.currentTimeMillis()%>">
                <button type="submit" class="gray">REFRESH</button>
            </form>
        </td>
        <td width="100%">&nbsp;</td>
    </tr>
</table>