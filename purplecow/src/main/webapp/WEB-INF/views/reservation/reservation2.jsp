<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>퍼플카우-쉬운 차량 공유 플랫폼</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon"
	href="../../res/assets/img/cow.ico">

<!-- CSS here -->
<link rel="stylesheet" href="../../res/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../res/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="../../res/assets/css/slicknav.css">
<link rel="stylesheet" href="../../res/assets/css/animate.min.css">
<link rel="stylesheet" href="../../res/assets/css/hamburgers.min.css">
<link rel="stylesheet" href="../../res/assets/css/magnific-popup.css">
<link rel="stylesheet"
	href="../../res/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="../../res/assets/css/themify-icons.css">
<link rel="stylesheet" href="../../res/assets/css/slick.css">
<link rel="stylesheet" href="../../res/assets/css/nice-select.css">
<link rel="stylesheet" href="../../res/assets/css/style.css">
<link rel="stylesheet" href="../../res/assets/css/feeInfo.css">


</head>
<body>
	<!-- ? Preloader Start -->
	<div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="../../res/assets/img/logo/cow_loader.png" alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Preloader Start -->
	<header>
		<!-- Header Start -->
		<div class="header-area header-transparent">
			<div class="main-header ">
				<div class="header-bottom  header-sticky">
					<div class="container-fluid">
						<div class="row align-items-center">
							<!-- Logo -->
							<div class="col-xl-2 col-lg-2">
								<div class="logo">
									<a href="index.html"><img
										src="../../res/assets/img/logo/purplecow1.png" alt=""></a>
								</div>
							</div>
							<div class="col-xl-10 col-lg-10">
								<div
									class="menu-wrapper d-flex align-items-center justify-content-end">
									<!-- Main-menu -->
									<div class="main-menu d-none d-lg-block">
										<nav>
											<ul id="navigation">
												<li><a href="/usageGuide">소개하기</a>
													<ul class="submenu">
														<li><a href="/usageGuide">이용 안내</a></li>
														<li><a href="/feeInfo">요금 안내</a></li>
													</ul></li>
												<li><a href="/reservation">예약하기</a>
													<ul class="submenu">
														<li><a href="blog.html">왕복 예약</a></li>
														<li><a href="blog_details.html">편도 예약</a></li>
														<li><a href="elements.html">부름예약</a></li>
													</ul></li>
												<li><a href="/return">반납 하기</a>
													<ul class="submenu">
														<li><a href="blog.html">바로 반납</a></li>
														<li><a href="blog.html">반납 연장</a></li>
													</ul></li>
												<li><a href="/mypage">마이페이지</a>
													<ul class="submenu">
														<li><a href="/accountMgt">계정 관리</a></li>
														<li><a href="/payInfo">결제 및 할인</a></li>
														<li><a href="/resvHistory">예약 내역</a></li>
													</ul></li>
												<!-- Button -->
												<li class="button-header margin-left "><a
													href="/registration" class="btn">Sign Up</a></li>
												<li class="button-header"><a href="/login" class="btn3">Sign
														In</a></li>
											</ul>
										</nav>
									</div>
								</div>
							</div>
							<!-- Mobile Menu -->
							<div class="col-12">
								<div class="mobile_menu d-block d-lg-none"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header End -->
	</header>
	<main>
		<!-- Slider Area Start-->
		<div class="slider-area slider-bg ">
			<!-- Single Slider -->
			<div class="single-slider d-flex align-items-center slider-height3">
				<div class="container">
					<div class="row align-items-center justify-content-center">
						<div class="col-xl-8 col-lg-9 col-md-12 ">
							<div class="hero__caption hero__caption3 text-center">
								<h1 data-animation="fadeInLeft" data-delay=".6s ">차량 예약하기</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Slider Shape -->
			<div class="slider-shape d-none d-lg-block">
				<img class="slider-shape1"
					src="../../res/assets/img/hero/top-left-shape.png" alt="">
			</div>
		</div>
		<!-- Slider Area End -->


		<section class="button-area">

			<div class="container box_1170 border-top-generic ">

				<div class="col-sm-12">

					<div class="row">

						<div class="col-sm-6">
							<h3>예약 선택</h3>
						</div>
						<div class="col-sm-6">
							<h3>반납 선택</h3>
						</div>

					</div>

				</div>


				<div class="col-sm-12">

					<div class="row">

						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" type="datetime-local">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" type="datetime-local">
							</div>
						</div>

					</div>

				</div>

				<br>
				<!-- 테이블 시작 -->
				<table class="type10">
					<thead>
						<tr>
							<th scope="cols">퍼플존</th>
							<th scope="cols">이름</th>
							<th scope="cols">주소</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<!-- 테이블 끝 -->
				<hr>


				<div style="margin-top: 80px">
					<button
						class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
						id="modal_btn" style="font-size: 120%;" type="submit"
						onClick="location.href='/carList'">예약하기</button>

				</div>

			</div>


		</section>



	</main>
	<footer>
		<div class="footer-wrappr "
			data-background="../../res/assets/img/gallery/footer-bg.png">
			<div class="footer-area footer-padding ">
				<div class="container">
					<div class="row d-flex justify-content-between">
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="single-footer-caption mb-50">
								<!-- logo -->
								<div class="footer-logo mb-25">
									<a href="index.html"><img
										src="../../res/assets/img/logo/logo2_footer.png" alt=""></a>
								</div>
								<div class="footer-tittle mb-50">
									<p>Subscribe our newsletter to get updates about our
										services</p>
								</div>
								<!-- Form -->
								<div class="footer-form">
									<div id="mc_embed_signup">
										<form target="_blank"
											action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
											method="get" class="subscribe_form relative mail_part"
											novalidate="true">
											<input type="email" name="EMAIL" id="newsletter-form-email"
												placeholder=" Email Address "
												class="placeholder hide-on-focus"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Your email address'">
											<div class="form-icon">
												<button type="submit" name="submit" id="newsletter-submit"
													class="email_icon newsletter-submit button-contactForm">
													Subscribe</button>
											</div>
											<div class="mt-10 info"></div>
										</form>
									</div>
								</div>
								<!-- social -->
								<div class="footer-social mt-50">
									<a href="#"><i class="fab fa-twitter"></i></a> <a
										href="https://bit.ly/sai4ull"><i class="fab fa-facebook-f"></i></a>
									<a href="#"><i class="fab fa-pinterest-p"></i></a>
								</div>
							</div>
						</div>
						<div class="col-xl-1 col-lg-1 col-md-1 col-sm-1"></div>
						<div class="col-xl-2 col-lg-2 col-md-4 col-sm-5">
							<div class="single-footer-caption mb-50">
								<div class="footer-tittle">
									<h4>Company</h4>
									<ul>
										<li><a href="#">Why choose us</a></li>
										<li><a href="#"> Review</a></li>
										<li><a href="#">Customers</a></li>
										<li><a href="#">Blog</a></li>
										<li><a href="#">Carrier</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-xl-2 col-lg-2 col-md-4 col-sm-5">
							<div class="single-footer-caption mb-50">
								<div class="footer-tittle">
									<h4>Products</h4>
									<ul>
										<li><a href="#">Why choose us</a></li>
										<li><a href="#"> Review</a></li>
										<li><a href="#">Customers</a></li>
										<li><a href="#">Blog</a></li>
										<li><a href="#">Carrier</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-xl-2 col-lg-2 col-md-4 col-sm-5">
							<div class="single-footer-caption mb-50">
								<div class="footer-tittle">
									<h4>Support</h4>
									<ul>
										<li><a href="#">Technology</a></li>
										<li><a href="#"> Products</a></li>
										<li><a href="#">Customers</a></li>
										<li><a href="#">Quality</a></li>
										<li><a href="#">Sales geography</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- footer-bottom area -->
			<div class="footer-bottom-area">
				<div class="container">
					<div class="footer-border">
						<div class="row">
							<div class="col-xl-12">
								<div class="footer-copy-right text-center">
									<p>
										<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
										Copyright &copy;
										<script>
											document.write(new Date()
													.getFullYear());
										</script>
										All rights reserved | This template is made with <i
											class="fa fa-heart" aria-hidden="true"></i> by <a
											href="https://colorlib.com" target="_blank">Colorlib</a>
										<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
									</p>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Scroll Up -->
	<div id="back-top">
		<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>

	<!-- JS here -->

	<script src="./../../res/assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="./../../res/assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./../../res/assets/js/popper.min.js"></script>
	<script src="./../../res/assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="./../../res/assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./../../res/assets/js/owl.carousel.min.js"></script>
	<script src="./../../res/assets/js/slick.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="./../../res/assets/js/wow.min.js"></script>
	<script src="./../../res/assets/js/animated.headline.js"></script>
	<script src="./../../res/assets/js/jquery.magnific-popup.js"></script>

	<!-- Date Picker -->
	<script src="./../../res/assets/js/gijgo.min.js"></script>
	<!-- Nice-select, sticky -->
	<script src="./../../res/assets/js/jquery.nice-select.min.js"></script>
	<script src="./../../res/assets/js/jquery.sticky.js"></script>

	<!-- counter , waypoint,Hover Direction -->
	<script src="./../../res/assets/js/jquery.counterup.min.js"></script>
	<script src="./../../res/assets/js/waypoints.min.js"></script>
	<script src="./../../res/assets/js/jquery.countdown.min.js"></script>
	<script src="./../../res/assets/js/hover-direction-snake.min.js"></script>

	<!-- contact js -->
	<script src="./../../res/assets/js/contact.js"></script>
	<script src="./../../res/assets/js/jquery.form.js"></script>
	<script src="./../../res/assets/js/jquery.validate.min.js"></script>
	<script src="./../../res/assets/js/mail-script.js"></script>
	<script src="./../../res/assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./../../res/assets/js/plugins.js"></script>
	<script src="./../../res/assets/js/main.js"></script>

	<!-- 예약페이지 관련 js -->
	<script src="./../../res/assets/js/reservation2.js"></script>



</body>
</html>