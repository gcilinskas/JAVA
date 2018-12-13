<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <div class="row ">
        <div class="card w-100">
            <div class="card-header">
               <h2>Edit Order</h2>
            </div>
        <div class="card-body">    
            <sform:form class="form-horizontal" method="POST" action="${contextRoot}/admin/saveOrder" modelAttribute="order">
                    
                    <div class="form-group" style="display:none">
                        <label for="id">ID</label>
                        <sform:input path="id" class="form-control" value="${order.id}" />
                    </div>
                    
                    <div class="form-group">
                        <label for="info">Order Info</label>
                        <sform:input path="info" class="form-control" value="${order.info}"/>

                    </div>
                    <div class="form-group">
                        <label for="dateAdded">Date Added</label>
                        <fmt:formatDate value="${order.dateAdded}" var="dateString" pattern="yyyy-MM-dd" />
                        
                       <sform:input type="date" class="form-control" path="dateAdded" value="${dateString}"/>
                    </div>

                    <button type="submit" class="btn btn-primary" id="submit" value="submit">Submit</button>
                    <a href="${contextRoot}/admin/manageOrders" class="btn btn-danger" > Cancel </a>
                    
                </sform:form>
                
                
            </div>
        </div>

    </div>

</div>