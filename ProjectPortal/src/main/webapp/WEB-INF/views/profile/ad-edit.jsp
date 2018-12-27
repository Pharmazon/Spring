<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Edit ad" />
</jsp:include>

<form:form method="post" action="/profile/ad-save" modelAttribute="ad">
    <form:hidden path="id" />
    <form:hidden path="dateTime" />
    <form:hidden path="user.id" />

    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>

    <table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
        <tr>
            <th width="200" align="left" nowrap="nowrap">CAPTION</th>
            <th width="300" align="left" nowrap="nowrap">VALUE</th>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">NAME</td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">CONTENT</td>
            <td>
                <form:input path="content" />
            </td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">PRICE</td>
            <td>
                <form:input path="price" />
            </td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">CATEGORY</td>
            <td>
                <form:select path="category.id" size="1">
                    <form:option value="---Select category:---" disabled="true" />
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />