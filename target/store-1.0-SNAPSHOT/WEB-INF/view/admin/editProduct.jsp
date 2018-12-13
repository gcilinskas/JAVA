<div class="container">


    <div class="row ">

        <div class="card w-100">
            <div class="card-header">
               <h2>Edit Product</h2>
            </div>
        <div class="card-body">
                
                
            <sform:form class="form-horizontal" method="POST" action="save" modelAttribute="product">
                    
                    <div class="form-group" style="display:none">
                        <label for="id">ID</label>
                        <sform:input path="id" class="form-control" value="${product.id}" />
                    </div>
                    
                    <div class="form-group">
                        <label for="title">Product Title</label>
                        <sform:input path="title" class="form-control" value="${product.title}"/>

                    </div>
                    <div class="form-group" style="display:none">
                        <label for="quantity">Product Quantity</label>
                       <sform:input type="number" path="quantity" class="form-control" value="${product.quantity}"/>
                    </div>

                    <div class="form-group">
                        <label for="price">Product Price</label>
                       <sform:input path="price" type="number" step="0.01" class="form-control" value="${product.price}"/>
                    </div>

                    <button type="submit" class="btn btn-primary" id="submit" value="submit">Submit</button>
                    
                </sform:form>
                
                
            </div>
        </div>

    </div>

</div>