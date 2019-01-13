<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>회원가입 페이지</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="resources/css/style.css">

  
</head>

<body>

  <div class="container">
  <button id="login-button">Sign up</button>
  <div class="login-container">
    <form action="signup_on" class="login-form" method="post">
      <input type="text" placeholder="Userid" name="id" value="${id}">
      <input type="password" placeholder="Password" name="pw" value="${pw}">
      <input type="text" placeholder="UserName" name="name" value="${name}">
      <input type="text" placeholder="UserPhone" name="phone" value="${phone}">
      <input type="text" placeholder="UserEmail" name="email" value="${email}">
      <input type="text" placeholder="UserBirthdate" name="birthdate" value="${birthdate}">
      
        <input type="submit" value="SUBMIT" />
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="resources/js/index.js"></script>




</body>
</html>