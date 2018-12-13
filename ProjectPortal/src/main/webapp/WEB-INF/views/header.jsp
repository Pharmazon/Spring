<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.title}</title>
    <style>
        body {
            margin: 0;
            padding: 0;
        }

        a {
            color: black;
        }

        button {
            font-size: 1.1em;
            background-color: darkgreen;
            border: none;
            color: white;
            padding: 10px 28px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        .green {background-color: darkgreen;}
        .blue {background-color: blue;}
        .red {background-color: red;}
        .gray {background-color: gray;}
        .black {background-color: black;}

        input[type="text"], input[type="date"] {
            border: 1px solid black;
            border-radius: 3px;
            background: white !important;
            outline: none;
            height: 34px;
            width: 350px;
            font-family: 'RobotoLight', serif;
            color: black;
            font-size: 1.6em;
        }
    </style>
</head>
<body>
<jsp:include page="main-menu.jsp" />
<table width="100%" cellpadding="0" cellspacing="0" border="1" style="...">
    <tr>
        <td width="20" nowrap="nowrap">&nbsp;</td>
        <td width="100%">
