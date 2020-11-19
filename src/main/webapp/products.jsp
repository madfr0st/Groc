<%@ page import="java.util.ArrayList" %>
<%@ page import="com.frost.groc.DBMS.Pair" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Products</title>

    <!-- Bootstrap core CSS -->
    <link href="bin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="bin/assets/css/fontawesome.css">
    <link rel="stylesheet" href="bin/assets/css/tooplate-main.css">
    <link rel="stylesheet" href="bin/assets/css/owl.css">

    <!--
    Tooplate 2114 Pixie
    https://www.tooplate.com/view/2114-pixie
    -->
</head>

<body>


<div class="topnav">
    <a href="/Groc/index.jsp">HOME</a>
    <a href="/Groc/grocery">GROCERY</a>
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

<form class="form" action="addToCart" method="post">

    <%
        ArrayList<Pair<String, Pair<String, Integer>>> list = (ArrayList<Pair<String, Pair<String, Integer>>>) request.getAttribute("products");
        ArrayList<String> images = (ArrayList<String>) request.getAttribute("images");

        int items = list.size();
        int row = items / 4;
        int rest = items - row * 4;
        int count = 0;


        for (int i = 0; i < row; i++) {
            out.write("    <div class =\"whole\">\r\n");
            out.write("    <div class=\"three-group\">\r\n");
            for (int j = 0; j < 4; j++) {
                count++;
                out.write("        <div class=\"single-item\">\r\n");
                out.write("            <div class=\"imgbox\">\r\n");
                out.write("            <img class=\"img\" src=\"" + images.get(count - 1) + "\" alt=\"" + images.get(count - 1) + "\">\r\n");
                out.write("            </div>\r\n");
                out.write("            <div class=\"info\">\r\n");
                out.write("                <l>" + list.get(count - 1).a + "</l><br>\r\n");
                out.write("                <l> Order in " + list.get(count - 1).b.a + "</l>  \r\n");
                out.write("            </div>\r\n");
                out.write("            <div class=\"lowkey\">\r\n");
                out.write("             <input class=\"amount\" type=number step=100 min=0 max=10000 name=" + list.get(count - 1).a + ">\r\n");
                out.write("            </div>\r\n");
                out.write("        </div>\r\n");
            }
            out.write("        </div>\r\n");
            out.write("    </div>\r\n");
        }
        if (rest > 0) {
            out.write("    <div class =\"whole\">\r\n");
            out.write("    <div class=\"three-group\">\r\n");
            for (int j = 0; j < rest; j++) {
                count++;
                out.write("        <div class=\"single-item\">\r\n");
                out.write("            <div class=\"imgbox\">\r\n");
                out.write("             <img class=\"img\" src=\"" + images.get(count - 1) + "\" alt=\"" + images.get(count - 1) + "\">\r\n");
                out.write("            </div>\r\n");
                out.write("            <div class=\"info\">\r\n");
                out.write("                <l>" + list.get(count - 1).a + "</l><br>\r\n");
                out.write("                <l> Order in " + list.get(count - 1).b.a + "</l>  \r\n");
                out.write("            </div>\r\n");
                out.write("            <div class=\"lowkey\">\r\n");
                out.write("             <input class=\"amount\" type=number step=100 min=0 max=10000 name=" + list.get(count - 1).a + ">\r\n");
                out.write("            </div>\r\n");
                out.write("        </div>\r\n");
            }
            out.write("        </div>\r\n");
            out.write("    </div>\r\n");
        }


    %>

    <style>
        .cartButton {
            background-color: #0f9d58;
            margin: auto;
            display: block;
            width: 190px;

        }

        .tm-flex-lr {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .btn-large {
            padding: 0 77px;
            border-radius: 5px;
            background-color: black;
            text-transform: capitalize;
            font-size: 1rem;
        }

        .btn-large-white {
            background-color: greenyellow;
            height: 50px;
            width: 200px;
            color: black;
            font-size: 1.1rem;
        }
    </style>

    ${cart}
    <div class="cartButton">
        <div class="tm-flex-lr">
            <button type="submit" class="waves-effect btn-large btn-large-white px-4 black-text rounded-0">
                ADD TO CART
            </button>
        </div>
    </div>
</form>

<!-- Subscribe Form Starts Here -->
<div class="subscribe-form">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>Subscribe on PIXIE now!</h1>
                </div>
            </div>
            <div class="col-md-8 offset-md-2">
                <div class="main-content">
                    <p>Godard four dollar toast prism, authentic heirloom raw denim messenger bag gochujang put a bird
                        on it celiac readymade vice.</p>
                    <div class="container">
                        <form id="subscribe" action="" method="get">
                            <div class="row">
                                <div class="col-md-7">
                                    <fieldset>
                                        <input name="email" type="text" class="form-control" id="email"
                                               onfocus="if(this.value == 'Your Email...') { this.value = ''; }"
                                               onBlur="if(this.value == '') { this.value = 'Your Email...';}"
                                               value="Your Email..." required="">
                                    </fieldset>
                                </div>
                                <div class="col-md-5">
                                    <fieldset>
                                        <button type="submit" id="form-submit" class="button">Subscribe Now!</button>
                                    </fieldset>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Subscribe Form Ends Here -->


<!-- Footer Starts Here -->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="logo">
                    <img src="assets/images/header-logo.png" alt="">
                </div>
            </div>
            <div class="col-md-12">
                <div class="footer-menu">
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Help</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">How It Works ?</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-12">
                <div class="social-icons">
                    <ul>
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-rss"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Ends Here -->


</body>

</html>