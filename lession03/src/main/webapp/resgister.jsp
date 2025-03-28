<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="register-container">
    <h2>注册</h2>
    <form action="resgister" method="post">
        <input type="text" name="username" placeholder="用户名" required><br>
        <input type="password" name="password" placeholder="密码" required><br>
        <input type="submit" value="注册">
    </form>
    <p>已有账号？<a href="login.jsp">登录</a></p>
</div>
</body>
</html>