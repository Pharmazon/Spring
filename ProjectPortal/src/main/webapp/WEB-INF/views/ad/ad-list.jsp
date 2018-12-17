<%@ page import="ru.shcheglov.model.Ad" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
      integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td>
            <form action="/company-list">
                <button type="submit">COMPANIES</button>
            </form>
        </td>
        <td width="20" nowrap="nowrap">&nbsp;</td>
        <td>
            <form action="/category-list">
                <button type="submit">CATEGORIES</button>
            </form>
        </td>
        <td width="100%">&nbsp;</td>
    </tr>
</table>

<h1>ADS MANAGEMENT</h1>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td nowrap="nowrap">
            <form action="/ad-add" method="get">
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
        <th width="30" nowrap="nowrap" align="center">№</th>
        <th width="90" nowrap="nowrap" align="center">CREATED</th>
        <th width="100" nowrap="nowrap" align="center">NAME</th>
        <th width="100%" nowrap="nowrap" align="center">CONTENT</th>
        <th width="100" nowrap="nowrap" align="center">NUMBER</th>
        <th width="100" nowrap="nowrap" align="center">CATEGORY</th>
        <th width="100" nowrap="nowrap" align="center">COMPANY</th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
        <th width="30" nowrap="nowrap" align="center"></th>
    </tr>
    <c:forEach var="ad" items="${ads}" varStatus="status">
        <tr>
            <td align="center" nowrap="nowrap">${status.index + 1}</td>
            <td align="center">${ad.formattedDateTime}</td>
            <td align="left">${ad.name}</td>
            <td align="left">${ad.content}</td>
            <td align="left">${ad.number}</td>
            <td align="left">${ad.category.name}</td>
            <td align="left">${ad.company.name}</td>
            <td align="center" nowrap="nowrap">
                <a href="/ad-view/${ad.id}">
                    <img src="../../../resources/images/icons/icon_view.png" alt="view" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/ad-edit/${ad.id}">
                    <img src="../../../resources/images/icons/icon_edit.png" alt="edit" width="20" />
                </a>
            </td>
            <td align="center" nowrap="nowrap">
                <a href="/ad-delete/${ad.id}">
                    <img src="../../../resources/images/icons/icon_delete.png" alt="delete" width="20" />
                </a>
            </td>
        </tr>
    </c:forEach>
</table>