<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/3/2
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--JSP 声明--%>
<!-- JSP 声明-->
<h1>JSP 声明</h1>
<%! int count = 100; %>
<%! String getColor() {
    return "red";
} %>

<%--JSP 小脚本--%>
<!-- JSP 小脚本-->
<h1>JSP 小脚本</h1>

<%
    int a = 1, b = 2;
    int c = a + b;
    out.println(c);

    // 取出JSP声明中定义的数据
    out.println("count:\t"+count);
    out.println("color:\t"+getColor());
%>

<%--JSP 表达式--%>
<!-- JSP 表达式-->
<h1>JSP 表达式</h1>

<%=LocalDate.now()%>

<%=count%>

<%=getColor()%>

</body>
</html>