<%@taglib prefix="sformReg" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="row ">
        <div class="card w-100">
            <div class="card-header">
                <h2>Registration</h2>
            </div>
            
            <div id="postResultDiv"></div>
            <div class="card-body">


                <sformReg:form class="form-horizontal" method="POST" action="save" modelAttribute="user" id="formR">

                    <div class="form-group" style="display:none">
                        <label for="id">ID</label>
                        <sformReg:input path="id" class="form-control" />
                    </div>

                    <div class="form-group">
                        <label for="username">Username</label>
                        <sformReg:input path="username" class="form-control" placeholder="Enter Username" id="registerUsernameInput"/>

                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <sformReg:input type="password" path="password" class="form-control" placeholder="Enter Password"/>
                    </div>

                    <div class="form-group" style="display:none">
                        <label for="isAdmin">Administrator Rights</label>
                        <sformReg:input path="isAdmin" class="form-control" value="false"/>
                    </div>


                    <button type="submit" class="btn btn-primary" id="submit" value="submit">Submit</button>

                </sformReg:form>

            </div>
        </div>
    </div>
</div>