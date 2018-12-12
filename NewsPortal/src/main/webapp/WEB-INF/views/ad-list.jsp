<%@ page import="ru.shcheglov.geekbrains.hw.hw5.model.Ad" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="ADS" />
</jsp:include>

<h1>ADS MANAGEMENT</h1>

<table width="100%" cellspacing="10" cellpadding="10" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="60" nowrap="nowrap" align="center">№</th>
        <th width="200" nowrap="nowrap" align="left">ID</th>
        <th width="300" nowrap="nowrap" align="left">NAME</th>
        <th width="100%" nowrap="nowrap" align="left">DESCRIPTION</th>
        <th width="80" nowrap="nowrap" align="center">VIEW</th>
        <th width="80" nowrap="nowrap" align="center">EDIT</th>
        <th width="80" nowrap="nowrap" align="center">REMOVE</th>
    </tr>
</table>

<c:forEach var="ad" items="${ads}" varStatus="status">
    <tr>
        <td align="center" nowrap="nowrap">${status.index + 1}</td>
        <td align="left">${ad.id}</td>
        <td align="left">${ad.name}</td>
        <td align="left">${ad.description}</td>
        <td align="center" nowrap="nowrap">
            <a href="/ad-view/${ad.id}">VIEW</a>
        </td>
        <td align="center" nowrap="nowrap">
            <a href="/ad-edit/${ad.id}">EDIT</a>
        </td>
        <td align="center" nowrap="nowrap">
            <a href="/ad-delete/${ad.id}">REMOVE</a>
        </td>
    </tr>
</c:forEach>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td nowrap="nowrap">
            <form action="/ad-create">
                <button type="submit" class="green">CREATE AD</button>
            </form>
        </td>
        <td width="20" nowrap="nowrap">
            &nbsp;
        </td>
        <td>
            <form>
                <input type="hidden" name="time" value="<%=System.currentTimeMillis()%>">
                <button type="submit" class="gray">REFRESH</button>
            </form>
        </td>
        <td width="100%">
            &nbsp;
        </td>
    </tr>
</table>

<jsp:include page="footer.jsp" />
