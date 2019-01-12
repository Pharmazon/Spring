<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
    <%@include file="../../resources/styles/styles.css"%>
</style>

<jsp:include page="main-menu.jsp" />

<title>${param.get("title")}</title>

<div class="content">
    <h1>${param.get("title")}</h1>
