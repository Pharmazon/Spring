<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Edit category" />
</jsp:include>

<form:form method="post" action="/admin/category-save" modelAttribute="category">
    <form:hidden path="id" />

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
            <td align="left" style="padding-right: 10px">PARENT-CATEGORY</td>
            <td>
                <form:select path="parent.id" size="1">
                    <form:option value="---Select parent:---" disabled="true" />
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">SUB-CATEGORY</td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />