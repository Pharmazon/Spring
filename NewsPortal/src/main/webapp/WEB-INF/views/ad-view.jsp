<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="VIEW AD" />
</jsp:include>

<h1>VIEW AD</h1>

<table>
    <tr>
        <th width="300" align="left" nowrap="nowrap">CAPTION</th>
        <th width="100%" align="left" nowrap="nowrap">VALUE</th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${ad.id}</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>${ad.name}</td>
    </tr>
    <tr>
        <td>DESCRIPTION</td>
        <td>${ad.description}</td>
    </tr>
</table>

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