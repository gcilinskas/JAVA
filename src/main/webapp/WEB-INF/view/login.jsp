<%@taglib prefix="sformLog" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="row ">
        <div class="card w-100">
            <div class="card-header">
                <h2>Login</h2>
            </div>
            <div class="card-body">


                <sformLog:form class="form-horizontal" method="POST" action="log" modelAttribute="user">

                    <div class="form-group">
                        <label for="username">Username</label>
                        <sformLog:input path="username" class="form-control" placeholder="Enter Username"/>

                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <sformLog:input type="password" path="password" class="form-control" placeholder="Enter Password"/>
                    </div>

                    <button type="submit" class="btn btn-primary" id="submit" value="submit">Submit</button>

                </sformLog:form>

                <c:if test = "${errors != null}">
                    <div class="alert alert-warning" role="alert">
                        ${errors}
                    </div>
                </c:if>

            </div>
        </div>
    </div>
</div>