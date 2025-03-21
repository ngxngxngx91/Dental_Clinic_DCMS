<%-- 
    Document   : contact
    Created on : Jul 27, 2024, 10:00:01 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Service" %>
<%@ page import="dal.DAO" %>
<%@ page import="java.util.List" %>

<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>DentCare - Dental Clinic Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />
        <link href="lib/twentytwenty/twentytwenty.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary m-1" role="status">
                <span class="sr-only">Loading...</span>
            </div>
            <div class="spinner-grow text-dark m-1" role="status">
                <span class="sr-only">Loading...</span>
            </div>
            <div class="spinner-grow text-secondary m-1" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->
        <!-- Navbar Start -->
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm px-5 py-3 py-lg-0">
            <a href="home1.jsp" class="navbar-brand p-0">
                <h1 class="m-0 text-primary"><i class="fa fa-tooth me-2"></i>DCMS</h1>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto py-0">
                    <a href="home1.jsp" class="nav-item nav-link active">Home</a>
                    <a href="about.jsp" class="nav-item nav-link">About</a>
                    <a href="service.jsp" class="nav-item nav-link">Service</a>

                    <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                </div>
                <!--                <button type="button" class="btn text-dark" data-bs-toggle="modal" data-bs-target="#searchModal"><i class="fa fa-search"></i></button>-->

                <c:if test="${sessionScope.account==null}">
                    <a href="login.jsp" class="btn btn-primary py-2 px-4 ms-3">Login</a>
                    <a href="register.jsp" class="btn btn-primary py-2 px-4 ms-3">Register</a>
                </c:if> 
                <c:if test="${sessionScope.account!=null}">
                    <a href="appointment" class="btn btn-primary py-2 px-4 ms-3">Appointment</a>
                    <a href="#" onclick="viewPatientAppointment(${sessionScope.account.userID})" class="btn btn-primary py-2 px-4 ms-3">Your Appointment</a>
                    <a href="profile.jsp" class="btn btn-primary py-2 px-4 ms-3">Profile</a>
                    <a href="changePassword.jsp" class="btn btn-primary py-2 px-4 ms-3">Change Password</a>
                    <a href="logout" class="btn btn-primary py-2 px-4 ms-3">Logout</a>
                </c:if>
            </div>
        </nav>
        <!-- Navbar End -->


        <!-- Full Screen Search Start -->
        <div class="modal fade" id="searchModal" tabindex="-1">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" style="background: rgba(9, 30, 62, .7);">
                    <div class="modal-header border-0">
                        <button type="button" class="btn bg-white btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center justify-content-center">
                        <div class="input-group" style="max-width: 600px;">
                            <input type="text" class="form-control bg-transparent border-primary p-3" placeholder="Type search keyword">
                            <button class="btn btn-primary px-4"><i class="bi bi-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Full Screen Search End -->


        <!-- Hero Start -->
        <div class="container-fluid bg-primary py-5 hero-header mb-5">
            <div class="row py-3">
                <div class="col-12 text-center">
                    <h1 class="display-3 text-white animated zoomIn">Contact Us</h1>
                    <a href="" class="h4 text-white">Home</a>
                    <i class="far fa-circle text-white px-2"></i>
                    <a href="" class="h4 text-white">Contact</a>
                </div>
            </div>
        </div>
        <!-- Hero End -->


        <!-- Contact Start -->
        <div class="container-fluid py-5">
            <div class="container">
                <div class="row g-5">
                    <div class="col-xl-6 col-lg-6 wow slideInUp" data-wow-delay="0.1s">
                        <div class="bg-light rounded h-100 p-5">
                            <div class="section-title">
                                <h5 class="position-relative d-inline-block text-primary text-uppercase">Contact Us</h5>
                                <h1 class="display-6 mb-4">Feel Free To Contact Us</h1>
                            </div>
                            <div class="d-flex align-items-center mb-2">
                                <i class="bi bi-geo-alt fs-1 text-primary me-3"></i>
                                <div class="text-start">
                                    <h5 class="mb-0">Our Office</h5>
                                    <span>Khu Giáo dục và Đào tạo – Khu Công nghệ cao Hòa Lạc – Km29 Đại lộ Thăng Long, H. Thạch Thất, TP. Hà Nội</span>
                                </div>
                            </div>
                            <div class="d-flex align-items-center mb-2">
                                <i class="bi bi-envelope-open fs-1 text-primary me-3"></i>
                                <div class="text-start">
                                    <h5 class="mb-0">Email Us</h5>
                                    <span>daihocfpt@fpt.edu.vn</span>
                                </div>
                            </div>
                            <div class="d-flex align-items-center">
                                <i class="bi bi-phone-vibrate fs-1 text-primary me-3"></i>
                                <div class="text-start">
                                    <h5 class="mb-0">Call Us</h5>
                                    <span>024 7300 1866</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xl-6 col-lg-12 wow slideInUp" data-wow-delay="0.6s">
                        <iframe class="position-relative rounded w-100 h-100"
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3001156.4288297426!2d-78.01371936852176!3d42.72876761954724!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4ccc4bf0f123a5a9%3A0xddcfc6c1de189567!2sNew%20York%2C%20USA!5e0!3m2!1sen!2sbd!4v1603794290143!5m2!1sen!2sbd"
                                frameborder="0" style="min-height: 400px; border:0;" allowfullscreen="" aria-hidden="false"
                                tabindex="0"></iframe>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact End -->


        <!-- Newsletter Start -->

        <c:choose>
            <c:when test="${sessionScope.account != null && sessionScope.account.role == 'patient'}">
                <div class="container-fluid position-relative pt-5 wow fadeInUp" data-wow-delay="0.1s" style="display: none;">
                    <div class="container">
                        <div class="bg-primary p-5">
                            <form class="mx-auto" style="max-width: 600px;">
                                <div class="input-group">
                                    <input type="text" class="form-control border-white p-3" placeholder="Your Email">
                                    <a href="register.jsp" class="btn btn-dark px-4">Sign Up</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${sessionScope.account != null && sessionScope.account.role == 'doctor' || sessionScope.account != null && sessionScope.account.role == 'nurse' }">
                <div class="container-fluid position-relative pt-5 wow fadeInUp" data-wow-delay="0.1s" style="display: none;">
                    <div class="container">
                        <div class="bg-primary p-5">
                            <form class="mx-auto" style="max-width: 600px;">
                                <div class="input-group">
                                    <input type="text" class="form-control border-white p-3" placeholder="Your Email">
                                    <a href="register.jsp" class="btn btn-dark px-4">Sign Up</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${sessionScope.account != null && sessionScope.account.role == 'admin'}">
                <div class="container-fluid position-relative pt-5 wow fadeInUp" data-wow-delay="0.1s" style="display: none;">
                    <div class="container">
                        <div class="bg-primary p-5">
                            <form class="mx-auto" style="max-width: 600px;">
                                <div class="input-group">
                                    <input type="text" class="form-control border-white p-3" placeholder="Your Email">
                                    <a href="register.jsp" class="btn btn-dark px-4">Sign Up</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${sessionScope.account == null }">
                <div class="container-fluid position-relative pt-5 wow fadeInUp" data-wow-delay="0.1s" style="z-index: 1;">
                    <div class="container">
                        <div class="bg-primary p-5">
                            <form class="mx-auto" style="max-width: 600px;">
                                <div class="input-group">
                                    <input type="text" class="form-control border-white p-3" placeholder="Your Email">
                                    <a href="register.jsp" class="btn btn-dark px-4">Sign Up</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:when>
        </c:choose>
        <!-- Newsletter End -->


        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-light py-5 wow fadeInUp" data-wow-delay="0.3s" style="margin-top: -75px;">
            <div class="container pt-5">
                <div class="row g-5 pt-4">
                    <div class="col-lg-3 col-md-6">
                        <h3 class="text-white mb-4">DentCare</h3>
                        <p>A genuine smile comes from the heart, but a healthy smile needs good dental care</p>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h3 class="text-white mb-4">Popular Links</h3>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-light mb-2" href="#"><i class="bi bi-arrow-right text-primary me-2"></i>Home</a>

                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h3 class="text-white mb-4">Get In Touch</h3>
                        <p class="mb-2"><i class="bi bi-geo-alt text-primary me-2"></i>Khu Giáo dục và Đào tạo – Khu Công nghệ cao Hòa Lạc – Km29 Đại lộ Thăng Long, H. Thạch Thất, TP. Hà Nội</p>
                        <p class="mb-2"><i class="bi bi-envelope-open text-primary me-2"></i>daihocfpt@fpt.edu.vn</p>
                        <p class="mb-0"><i class="bi bi-telephone text-primary me-2"></i>024 7300 1866</p>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h3 class="text-white mb-4">Follow Us</h3>
                        <div class="d-flex">
                            <a class="btn btn-lg btn-primary btn-lg-square rounded me-2" href="#"><i class="fab fa-twitter fw-normal"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square rounded me-2" href="#"><i class="fab fa-facebook-f fw-normal"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square rounded me-2" href="#"><i class="fab fa-linkedin-in fw-normal"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square rounded" href="#"><i class="fab fa-instagram fw-normal"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded back-to-top"><i class="bi bi-arrow-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
        <script src="lib/twentytwenty/jquery.event.move.js"></script>
        <script src="lib/twentytwenty/jquery.twentytwenty.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>
