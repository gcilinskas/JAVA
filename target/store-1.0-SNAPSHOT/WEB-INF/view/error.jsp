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

    <!-- Custom styles for this template -->
<!--    <link href="/myapp.css" rel="stylesheet">-->

  </head>

  <body>
      
      <div class='wrapper'>
      
      
      <%@include file="./shared/navbar.jsp" %>
      <script>
          window.menu='${title}';
      </script>
      
      <div class="content">
      
     
          
          
          <div class="container">

    <div class="row">

        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Sorry!</h1>
                <p class="lead"></p>
                <hr class="my-4">

                <h5>${error}</h5>
             
                    <h5>${errorSolution}</h5> 
            
                <p class="lead">

                </p>
            </div>

        </div>   


    </div>
    <!-- /.row -->

</div>
      
      
      </div>
      
      <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/myapp.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

    
    </div>
  </body>

</html>

