<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Forum</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,500,600,700,700i|Montserrat:300,400,500,600,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="css/style.css" rel="stylesheet">

  <!-- =======================================================
    Theme Name: Rapid
    Theme URL: https://bootstrapmade.com/rapid-multipurpose-bootstrap-business-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body>
  <!--==========================
  Header
  ============================-->
  <header id="header">

    <div id="topbar">
      <div class="container">
        <div class="social-links">
          <a href="https://twitter.com/i/flow/login?input_flow_data=%7B%22requested_variant%22%3A%22eyJsYW5nIjoiZW4ifQ%3D%3D%22%7D" class="twitter"><i class="fa fa-twitter"></i></a>
          <a href="https://www.facebook.com/" class="facebook"><i class="fa fa-facebook"></i></a>
          <a href="https://www.linkedin.com/login" class="linkedin"><i class="fa fa-linkedin"></i></a>
          <a href="https://www.instagram.com/accounts/login/" class="instagram"><i class="fa fa-instagram"></i></a>
       </div>
      </div>
    </div>

    <div class="container">

      <div class="logo float-left">
        <!-- Uncomment below if you prefer to use an image logo -->
       <!--  <h2 class="text-light"><a href="#intro" class="scrollto"><span>Arts Stack Overflow</span></a></h2>
        --> <!-- <a href="#header" class="scrollto"><img src="img/logo.png" alt="" class="img-fluid"></a> -->
      </div>
      <nav class="main-nav float-right d-none d-lg-block">
        <ul>
          <li class="index.html"><a href="AdminHome.jsp">Home</a></li>
           <li><a href="Request.jsp">Request</a></li>
            <li class="drop-down"><a href="">Users</a>
            <ul>
             <li><a href="AuthorisedUser.jsp">Authorised User</a></li>
              <li><a href="UnAuthorisedUser.jsp">UnAuthorised User</a></li>
            </ul>
          </li>
          <li><a href="TrendingQuestions.jsp">Trending Questions</a></li>
           <li><a href="AllFeedbacks.jsp">Feedback</a></li>
           <li><a href="index.html">Sign Out</a></li>
        </ul>
      </nav><!-- .main-nav -->
      
    </div>
  </header><!-- #header -->

  <!--==========================
    Intro Section
  ============================-->
  <section id="intro" class="clearfix">
    <div class="container d-flex h-100">
      <div class="row justify-content-center align-self-center">
        <div class="col-md-6 intro-info order-md-first order-last">
           <h2>WELCOME ADMIN<br>Problem Shared is a <span>Problem Solved !</span></h2>
          <div>
            <a href="#about" class="btn-get-started scrollto">Get Started</a>
          </div>
        </div>
  
        <div class="col-md-6 intro-img order-md-last order-first">
          <img src="img/intro-img.svg" alt="" class="img-fluid">
        </div>
      </div>

    </div>
  </section><!-- #intro -->

  <main id="main">

    <!--==========================
      About Us Section
    ============================-->
    <section id="about">

      <div class="container">
        <div class="row">

          <div class="col-lg-5 col-md-6">
            <div class="about-img">
              <img src="img/about-img.jpg" alt="">
            </div>
          </div>

          <div class="col-lg-7 col-md-6">
            <div class="about-content">
             <!--  <h2>USER LOGIN</h2>
							<form method="post" action="UserReg">
							<input type="text" name="name" id="email" value="" placeholder="Enter Name" class="panel-title" width="700px;"/>
							<input type="text" name="email" id="email" value="" placeholder="Enter Mail ID" class="panel-title" width="700px;"/>
							<br><br>
							<input type="password" name="password" id="password" value="" placeholder="Enter Password" class="panel-title"/>
					<br><br>
					<div class="text-center"><button type="submit" title="Register">Register</button></div>
					<div class="text-center"><button type="reset" title="Reset">Reset</button></div>
							</form>
            </div> -->
            
             <div class="form">
              <% String uid=(String)session.getAttribute("name"); %>
              <h4><b>Welcome <%=uid %></b></h4>
              <!-- <form action="" method="post" role="form" class="contactForm">
                <div class="form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control" name="password" data-rule="required" data-msg="Please write something for us" placeholder="Password"></textarea>
                  <div class="validation"></div>
                </div>

                <div id="sendmessage">Your message has been sent. Thank you!</div>
                <div id="errormessage"></div>

                <div class="text-center"><button type="submit" title="Send Message">Register</button></div>
              </form>
            </div> -->
          </div>
        </div>
      </div>

    </section><!-- #about -->
  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
  <!-- Uncomment below i you want to use a preloader -->
  <!-- <div id="preloader"></div> -->

  <!-- JavaScript Libraries -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/mobile-nav/mobile-nav.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/waypoints/waypoints.min.js"></script>
  <script src="lib/counterup/counterup.min.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="lib/isotope/isotope.pkgd.min.js"></script>
  <script src="lib/lightbox/js/lightbox.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>

</body>
</html>
