<%@taglib prefix="sformRegAdmin" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="row ">
        <div class="card w-100">
            <div class="card-header">
                <h2>User Registration</h2>
            </div>
            <div class="card-body">


                <sformRegAdmin:form class="form-horizontal" method="POST" action="saveUser" modelAttribute="user">

                    <div class="form-group" style="display:none">
                        <label for="id">ID</label>
                        <sformRegAdmin:input path="id" class="form-control" />
                    </div>

                    <div class="form-group">
                        <label for="username">Username</label>
                        <sformRegAdmin:input path="username" class="form-control" placeholder="Enter Username"/>

                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <sformRegAdmin:input type="password" path="password" class="form-control" placeholder="Enter Password"/>
                    </div>

                    <div class="form-group">
                        <label class="checkbox-inline custom-control" name="label">Set Is Admin:

                            <sformRegAdmin:checkbox path="isAdmin" data-toggle="toggle" id="checkIfAdmin" />  
                           
                            
                        </label>
                    </div>


                    <button type="submit" class="btn btn-primary" id="submit" value="submit">Submit</button>

                </sformRegAdmin:form>

            </div>
        </div>
    </div>
</div>