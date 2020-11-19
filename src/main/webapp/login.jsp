<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!--
    Template 2105 Input
    http://www.tooplate.com/view/2105-input
    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
    <link rel="stylesheet" href="bin/css/bootstrap.min.css">
    <link rel="stylesheet" href="bin/css/materialize.min.css">
    <link rel="stylesheet" href="bin/css/tooplate.css">
</head>

<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
try{
if ((Boolean) session.getAttribute("user")) {
response.sendRedirect("/Groc/index.jsp");
}
}
catch(Exception e){
System.out.println("Error on login.jsp :"+ e.getMessage());
}
%>

<body id="login">
<div class="topnav">
    <a href="/Groc/index.jsp">HOME</a>
    <a href="/Groc/grocery" >GROCERY</a>
    <a href="/Groc/fruits">FRUITS</a>
    <a href="/Groc/vegetables">VEGETABLES</a>
    <a href="#">CHECK OUT</a>
    <%
        try {
            if ((Boolean) session.getAttribute("user")) {
                out.write("        <a href=\"/Groc/logout\" >LOG OUT</a>\r\n");
            } else {
                out.write("        <a href=\"/Groc/logout\" >LOG IN</a>\r\n");
            }
        } catch (Exception e) {
            out.write("        <a href=\"login.jsp\" >LOG IN</a>\r\n");
        }
        out.flush();
    %>
</div>
<div class="container">
    <div class="row tm-register-row tm-mb-35">
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-login-l">

            <form action="login" method="post" class="tm-bg-black p-5 h-100">
                ${error0}<br>
                <div class="input-field">
                    <input placeholder="Username" id="username" name="username" type="text" class="validate">
                </div>
                ${error1}<br>
                <div class="input-field mb-5">
                    <input placeholder="Password" id="password" name="password" type="password" class="validate">
                </div>
                ${error2}<br>
                <div class="tm-flex-lr">
                    <a href="#" class="white-text small">Forgot Password?</a>
                    <button type="submit" class="waves-effect btn-large btn-large-white px-4 black-text rounded-0">
                        Login
                    </button>
                </div>
            </form>
        </div>
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-login-r">
            <header class="font-weight-light tm-bg-black p-5 h-100">
                <h3 class="mt-0 text-white font-weight-light">Your Login</h3>
                <p>Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>
                <p class="mb-0">Vestibulum neque neque, porttitor quis lacinia eu, iaculis id dui. Mauris quis velit
                    lectus.</p>
            </header>
        </div>
    </div>
    <div class="row">
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 ml-auto mr-0 text-center">
            <a href="signup.jsp" class="waves-effect btn-large btn-large-white px-4 black-text rounded-0">Create New
                Account</a>
        </div>
    </div>
</div>
</body>

</html>