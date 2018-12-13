<%-- 
    Document   : page
    Created on : Dec 4, 2018, 5:52:07 PM
    Author     : Moe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Store</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <link href="${css}/myapp.css" rel="stylesheet">

    <!-- Custom styles for this template -->
<!--    <link href="/myapp.css" rel="stylesheet">-->

  </head>

  <body>
      
      <div class="wrapper" >
      
      
      <%@include file="./shared/navbar.jsp" %>
      
      <div class="content">
           
      <%@include file="pageAdmin.jsp" %>
      
      <c:if test="${userClickHome == true}">
          <%@include file="home.jsp" %>
      </c:if>
      
      <!--only when user clicks products-->
      <c:if test="${userClickProducts == true || userClickCartAdd == true}">
          <%@include file="products.jsp" %>
      </c:if>
      
       <!--only when user clicks cart-->
      <c:if test="${userClickCart == true }">
          <%@include file="cart.jsp" %>
      </c:if>
       
       <!--only when user clicks login-->
      <c:if test="${userClickLogin == true}">
          <%@include file="login.jsp" %>
      </c:if>
       
      <!--only when user clicks Register-->
      <c:if test="${userClickRegister == true}">
          <%@include file="register.jsp" %>
      </c:if>
          
      <c:if test="${userClickShowPurchases  == true}">
          <%@include file="./purchases.jsp" %>
      </c:if>
          
      <c:if test="${userClickShowPurchasedProducts  == true}">
          <%@include file="./purchasedProducts.jsp" %>
      </c:if>
          
         
          
          
      <c:if test="${userClickError == true}">
          <%@include file="error.jsp" %>
      </c:if>
          
      
      
      </div>
      
      <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/myapp.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

    
    </div>
  </body>

</html>

