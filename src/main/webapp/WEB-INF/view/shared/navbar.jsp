<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!--NAVIGATION-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${contextRoot}/home"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${contextRoot}/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item" id="products">
                <a class="nav-link" href="${contextRoot}/products">Products</a>
            </li>

            <li class="nav-item" id="cart">
                <a class="nav-link" href="${contextRoot}/cart/show">Cart</a>
            </li>

            <security:authorize access="isAuthenticated()">
            <li class="nav-item" id="orders">
                <a class="nav-link" href="${contextRoot}/cart/purchases">My Purchases</a>
            </li>
            </security:authorize>


            <c:if test="${userModel.isAdmin}">
                <li class="nav-item" id="adminSection">
                    <a class="nav-link" href="${contextRoot}/admin/main">Admin Section</a>
                </li>        
            </c:if>

        </ul>



        <div class="navbar-collapse collapse w-50 order-3 navbar-collapse">
            <ul class="navbar-nav ml-auto">


                <security:authorize access="isAnonymous()">
                    <li class="nav-item" id="login">
                        <a class="nav-link" href="${contextRoot}/login">Login</a>
                    </li>
                    <li class="nav-item" id="register">
                        <a class="nav-link" href="${contextRoot}/users/register">Register</a>
                    </li>
                </security:authorize>


                <security:authorize access="isAuthenticated()">
                    <li class="nav-item" id="logout">
                        <a class="nav-link" href="${contextRoot}/logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">${userModel.username}</a>
                    </li>
                </security:authorize>




            </ul>
        </div>



    </div>
</nav>