<%--
    author: 悟空非空也（B站/知乎/公众号） 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/DoLoginServlet" method="post">
  用户名：<input type="text" name="user"><br>
  密码：<input type="password" name="password" ><br>
  <input type="submit" value="登录">
</form>
<span>${loginFail }</span>
</body>
</html>
