<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td width="0" nowrap="nowrap">&nbsp;</td>
        <td>
            <form action="${param.get("action")}">
                <button type="submit">
                    <img src="../../resources/images/icons/icon_add.png" alt="add" width="20"/>
                </button>
            </form>
        </td>
        <td width="0" nowrap="nowrap">&nbsp;</td>
        <td>
            <form>
                <input type="hidden" name="time" value="<%=System.currentTimeMillis()%>">
                <button type="submit">
                    <img src="../../resources/images/icons/icon_refresh.png" alt="refresh" width="20"/>
                </button>
            </form>
        </td>
        <td width="100%">&nbsp;</td>
    </tr>
</table>