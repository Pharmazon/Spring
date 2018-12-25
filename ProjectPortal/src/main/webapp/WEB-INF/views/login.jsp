<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Login" />
</jsp:include>

<form name="login" method="post" action="/loginAction">
    <table width="300" cellspacing="0" cellpadding="5" border="0" style="margin-bottom: 5px">
        <tr>
            <td colspan="2" align="center">
                <h2 style="margin-bottom: 0">AUTHORIZATION</h2>
            </td>
        </tr>
        <tr>
            <td>USERNAME:</td>
            <td>
                <input type="text" name="login">
            </td>
        </tr>
        <tr>
            <td>PASSWORD:</td>
            <td>
                <input type="password" name="password" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">LOGIN</button>
            </td>
        </tr>
    </table>
</form>

<jsp:include page="footer.jsp" />

