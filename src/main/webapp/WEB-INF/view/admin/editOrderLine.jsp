
<div class="container">
    <div class="row ">
        <div class="card w-100">
            <div class="card-header">
               <h2>Edit Order Lines</h2>
            </div>
        <div class="card-body">    
            <sform:form class="form-horizontal" method="POST" action="${contextRoot}/admin/saveOrderLine" modelAttribute="orderLine">
                    
                    <div class="form-group" style="display:none">
                        <label for="id">ID</label>
                        <sform:input path="id" class="form-control" value="${orderLine.id}" />
                    </div>
                    <div class="form-group" style="display:none">
                        <label for="orderId">Order ID</label>
                        <sform:input path="order" class="form-control" value="${orderLine.order.id}" />
                    </div>
                    <div class="form-group" style="display:none">
                        <label for="productId">Product ID</label>
                        <sform:input path="product" class="form-control" value="${orderLine.product.id}" />
                    </div>
                    
                    <div class="form-group">
                        <label for="productPrice">Product ID</label>
                        <sform:input path="product" class="form-control" value="${orderLine.product.price}" />
                    </div>
                    
                    <div class="form-group" style="display:none">
                        <label for="quantity">Quantity</label>
                        <sform:input path="quantity" class="form-control" value="${orderLine.quantity}"/>
                    </div>

                    <button type="submit" class="btn btn-primary" id="submit" value="submit">Submit</button>
                    <a href="${contextRoot}/admin/manageOrders/manageOrderLines/${orderLine.id}" class="btn btn-danger" > Cancel </a>
                    
                </sform:form>
                
                
            </div>
        </div>

    </div>

</div>