 <c:if test="${userClickAdminSection == true}">
          <%@include file="./admin/adminSection.jsp" %>
      </c:if>

      <c:if test="${userClickAdminSectionAdd == true}">
          <%@include file="./admin/addProduct.jsp" %>
      </c:if>
     
      <c:if test="${userClickAdminSectionEdit == true}">
          <%@include file="./admin/editProduct.jsp" %>
      </c:if>
     
      <c:if test="${userClickAdminSectionManage == true}">
          <%@include file="./admin/manageProducts.jsp" %>
      </c:if>
          
      <c:if test="${userClickAdminSectionManageOrders == true}">
          <%@include file="./admin/manageOrders.jsp" %>
      </c:if>
      
       <c:if test="${userClickAdminSectionManageOrderLines == true}">
          <%@include file="./admin/manageOrderLines.jsp" %>
      </c:if>
      
      <c:if test="${userClickAdminSectionEditOrder == true}">
          <%@include file="./admin/editOrder.jsp" %>
      </c:if>
          
      <c:if test="${userClickAdminSectionEditOrderLine == true}">
          <%@include file="./admin/editOrderLine.jsp" %>
      </c:if>
          
          
      <c:if test="${userClickAdminSectionAddOrder == true}">
          <%@include file="./admin/addOrder.jsp" %>
      </c:if>  
          
      <c:if test="${userClickAdminSectionAddOrderForm == true}">
          <%@include file="./admin/addOrderForm.jsp" %>
      </c:if> 
          
      <c:if test="${userClickAdminSectionManageCarts == true || userClickAdminSectionManagePurchasedCarts == true || userClickAdminSectionManageNotPurchasedCarts == true
            || userClickAdminSectionManageNotPurchasedEmptyCarts == true || userClickAdminSectionManageNotPurchasedFullCarts
            || userClickAdminSectionManageAnonymousCarts == true || userClickAdminSectionManageUsersCarts == true}">
          <%@include file="./admin/manageCarts.jsp" %>
      </c:if> 

          
      <c:if test="${userClickAdminSectionManageCartLines == true}">
          <%@include file="./admin/manageCartLines.jsp" %>
      </c:if>
          
      <c:if test="${userClickAdminSectionManageUsers == true}">
          <%@include file="./admin/manageUsers.jsp" %>
      </c:if>
          
      <c:if test="${userClickAdminSectionManageUserCarts == true}">
          <%@include file="./admin/userCarts.jsp" %>
      </c:if>
        
      <c:if test="${userClickAdminSectionAddUser  == true}">
          <%@include file="./admin/addUser.jsp" %>
      </c:if>