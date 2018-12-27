<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Add category" />
</jsp:include>

<form:form method="post" action="/admin/category-create" modelAttribute="category">
    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>

    <table class="viewTable" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="20%" align="left" style="padding-right: 10px">CATEGORY</td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td width="20%" align="left" style="padding-right: 10px">PARENT</td>
            <td>
                <form:select path="parent.id" size="1">
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />