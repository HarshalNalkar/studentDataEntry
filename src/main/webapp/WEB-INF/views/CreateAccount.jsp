<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

        <style>
        body {
            font-family: "Lato", sans-serif;
            background-image: linear-gradient( 174.2deg,  rgba(255,244,228,1) 7.1%, rgba(240,246,238,1) 67.4% );
        }

        .main-head {
            height: 150px;
            background: #FFF;
        }

        .sidenav {
            height: 100%;
            background-color: #000;
            overflow-x: hidden;
            padding-top: 20px;
            float: right; /* Adjusted */
        }

        .main {
            padding: 0px 10px;
            position: relative;
            left: 29%;
            bottom: 20%;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
        }

        @media screen and (max-width: 450px) {
            .login-form {
                margin-top: 10%;
            }

            .register-form {
                margin-top: 10%;
            }
        }

        @media screen and (min-width: 768px){
            .main {
                margin-right: 40%; /* Adjusted */
            }

            .sidenav {
                width: 40%;
                position: fixed;
                z-index: 1;
                top: 0;
                right: 0; /* Adjusted */
            }

            .login-form {
                margin-top: 80%;
            }

            .register-form {
                margin-top: 20%;
            }
        }

        .login-main-text {
            margin-top: 38%;
            padding: 60px;
            color: #fff;
        }

        .login-main-text h2 {
            font-weight: 300;
        }

        .btn-black {
            background-color: #000 !important;
            color: #fff;
        }
       
    </style>
    </head>
    <body>

        <div class="main">
            <div class="col-md-6 col-sm-12">
                <div class="login-form">
                    <form action="./createAccount" method="post">
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
                            class="btn btn-secondary">Register</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="sidenav">
            <div class="login-main-text">
                <h2>Create <br> Account Page</h2>
                <p>Create new account from here to access.</p>
            </div>
        </div>

    </body>
</html>
