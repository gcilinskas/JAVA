<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="card w-100">
            <div class="jumbotron">
                <h1 class="display-4">Welcome</h1>
                <p class="lead"></p>
                <hr class="my-4">
                <h5>${userModel.username}</h5>
                <security:authorize access="isAnonymous()">
                <h5>${anonymousUserModel.username} = Session ID</h5>
                 <div id="postResultDiv"></div>
                </security:authorize>
            </div>
        </div>   
    </div>
</div>