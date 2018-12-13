<div class="container">
    <div class="row ">
        <div class="card w-100">
            <div class="card-header">
                <h2>Select User ID To Add New Order</h2>
            </div>
            <div class="card-body">

                <form method="POST" action="addOrderForm">

                    <input type="number" name="userID" class="form-control w-25" id="quantityProduct" class="form-control w-25" />
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="SELECT"/>

                </form>


            </div>
        </div>

    </div>

</div>