<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="login-container">
  <h2>登录</h2>
  <form action="login" method="post">
    <input type="text" name="username" placeholder="用户名" required><br>
    <input type="password" name="password" placeholder="密码" required><br>
    <input type="submit" value="登录">
  </form>
  <p>没有账号？<a href="resgister.jsp">注册</a></p>
</div>
</body>
</html>