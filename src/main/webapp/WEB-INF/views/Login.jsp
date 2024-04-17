<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
        <script
            src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <style type="text/css">
            body {
    			font-family: "Lato", sans-serif;
                background-image: linear-gradient( 174.2deg,  rgba(255,244,228,1) 7.1%, rgba(240,246,238,1) 67.4% );
}



.main-head{
    height: 150px;
    background: #FFF;
}

.sidenav {
    height: 100%;
    background-color: #000;
    overflow-x: hidden;
    padding-top: 20px;
}


.main {
    padding: 0px 10px;
    
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
    .login-form{
        margin-top: 10%;
    }

    .register-form{
        margin-top: 10%;
    }
}

@media screen and (min-width: 768px){
    .main{
        margin-left: 40%; 
    }

    .sidenav{
        width: 40%;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
    }

    .login-form{
        margin-top: 80%;
    }

    .register-form{
        margin-top: 20%;
    }
}


.login-main-text{
    margin-top: 44%;
    padding: 60px;
    color: #fff;
}

.login-main-text h2{
    font-weight: 300;
}

.btn-black{
    background-color: #000 !important;
    color: #fff;
}

form a{
	color: white;
	text-decoration: none;
}
        </style>
    </head>
    <body>

        <div class="sidenav">
            <div class="login-main-text">
                <h2>Login Page</h2>
                <p>Login from here to access.</p>
            </div>
        </div>
        <div class="main">
            <div class="col-md-6 col-sm-12">
                <div class="login-form">
                    <%
                    if (msg != null) {
                    %>
                    <h2><%=msg%></h2>
                    <%
                    }
                    %>
                    <form action="./login" method="post">
                        <div class="form-group">
                            <label>User Name</label>
                            <input type="text" class="form-control"
                                placeholder="User Name" name="username">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control"
                                placeholder="Password" name="password">
                        </div>
                        <button type="submit"
                            class="btn btn-black">Login</button>
                        <button type="submit"
                            class="btn btn-secondary"><a href="http://localhost:8082/springmvc/createAccount">
				Create Account</a></button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>