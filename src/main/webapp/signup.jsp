<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign up</title>
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
    <div class="row">
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
            <header class="mb-5">
                <h3 class="mt-0 white-text">Sign-up Form</h3>
                <p class="grey-text mb-4">Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
                    inceptos himenaeos.</p>
                <p class="grey-text">Vestibulum neque neque, porttitor quis lacinia eu, iaculis id dui. Mauris quis
                    velit lectus.
                </p>
            </header>
        </div>
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
            <form action="signup" method="post" class="tm-signup-form">
                ${error0}<br>
                <div class="input-field">
                    <input placeholder="Username" id="username" name="username" type="text" class="validate">
                </div>
                ${error1}<br>
                <div class="input-field">
                    <input placeholder="Password" id="password" name="password" type="password" class="validate">
                </div>
                ${error2}<br>
                <div class="input-field">
                    <input placeholder="Re-type Password" id="password2" name="password2" type="password"
                           class="validate">
                </div>
                <div class="input-field">
                    <input placeholder="Email" id="email" name="email" type="email" class="validate">
                </div>
                ${error3}<br>
                <div class="input-field">
                    <input placeholder="Phone" id="phone" name="phone" type="tel" class="validate">
                </div>
                <div class="text-right mt-4">
                    <button type="submit" class="waves-effect btn-large btn-large-white px-4 tm-border-radius-0">Sign
                        Up
                    </button>
                </div>
            </form>
        </div>
    </div>

</div>
</body>