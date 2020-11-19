<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Welcome</title>

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
<!-- Navigation -->
<meta name="viewport" content="width=device-width, initial-scale=1">

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
                out.write("        <a href=\"login.jsp\" >LOG IN</a>\r\n");
            }
        } catch (Exception e) {
            out.write("        <a href=\"login.jsp\" >LOG IN</a>\r\n");
        }
        out.flush();
    %>
</div>

<!-- Page Content -->
<!-- Banner Starts Here -->
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="caption">
                    <h2>Welcome to Groc</h2>
                    <div class="line-dec"></div>
                    <p>Pixie HTML Template can be converted into your desired CMS theme. Total <strong>5 pages</strong>
                        included. You can use this Bootstrap v4.1.3 layout for any CMS.
                        <br><br>Please tell your friends about <a rel="nofollow"
                                                                  href="https://www.facebook.com/tooplate/">Tooplate</a>
                        free template site. Thank you. Photo credit goes to <a rel="nofollow"
                                                                               href="https://www.pexels.com">Pexels
                            website</a>.</p>
                    <div class="main-button">
                        <a href="/Groc/grocery">Order Now!</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner Ends Here -->


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
                    <p>Integer vel turpis ultricies, lacinia ligula id, lobortis augue. Vivamus porttitor dui id dictum
                        efficitur. Phasellus vel interdum elit.</p>
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
