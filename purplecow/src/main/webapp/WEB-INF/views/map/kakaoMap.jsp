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
									<a href="index.jsp"><img
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
												<li><a href="/">소개하기</a>
													<ul class="submenu">
														<li><a href="blog.html">이용 안내</a></li>
														<li><a href="blog_details.html">요금 안내</a></li>
													</ul></li>
												<li><a href="reservation.jsp">예약하기</a>
													<ul class="submenu">
														<li><a href="blog.html">왕복 예약</a></li>
														<li><a href="blog_details.html">편도 예약</a></li>
														<li><a href="elements.html">부름예약</a></li>
													</ul></li>

												<li><a href="#">반납하기</a>
													<ul class="submenu">
														<li><a href="blog.html">바로 반납하기</a></li>														
													</ul></li>
												<li><a href="#">마이페이지</a> <!-- Button -->
												<li class="button-header margin-left "><a
													href="register.html" class="btn">Sign Up</a></li>
												<li class="button-header"><a href="login.html"
													class="btn3">Sign In</a></li>
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
								<h1 data-animation="fadeInLeft" data-delay=".6s ">지도지도</h1>
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

		<!--? Start Button -->
		<p style="margin-top:-12px">
		    사용한 데이터를 보시려면 
		    <em class="link">
		       <a href="/download/web/data/chicken.json" target="_blank">여기를 클릭하세요!</a>
		    </em>
		</p>
		<!-- 지도 생성 위치 div -->
		<div id="map" style="width: 500px; height: 400px;"></div>
		
		<p> 
			<button onclick="panTo()">지도 중심좌표 부드럽게 이동시키기</button>
    	</p>
    	

		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a6a4b36d784da909ee182a145ec366a0"></script>
		<!-- services 라이브러리 불러오기 -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a6a4b36d784da909ee182a145ec366a0&libraries=services"></script>
		<script>
			var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
		    	
			// HTML5의 geolocation으로 사용할 수 있는지 확인합니다
			// 사용할 수 있으면 내 위치를 맵 시작위치로, 아니면 카카오 본사를
			if (navigator.geolocation) {
			    
			    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
				navigator.geolocation.getCurrentPosition(function(position) {
			       
			    	var lat = position.coords.latitude, // 위도
			            lon = position.coords.longitude; // 경도
			    });
			    
			} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
			    
				var lat = 33.450701, // 위도
					lon = 126.570667; // 경도
			}
			
			var mapOption = { 
				center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
				level: 3 // 지도의 확대 레벨
			};
			
			// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
			var map = new kakao.maps.Map(mapContainer, mapOption);
			
			// 지도 이동시키기 시작 --------------------------------------------
			function panTo() {
				// 이동할 위도 경도 위치를 생성합니다 
				var moveLatLon = new kakao.maps.LatLng(lat, lon);
							    
				// 지도 중심을 부드럽게 이동시킵니다
				// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
				map.panTo(moveLatLon);          
			}
			// 지도 이동시키기 끝 --------------------------------------------
						

			// 중심 좌표 변경 이벤트 
			// 이동 이벤트, 지도 이동시 이동된 화면의 중심 좌표를 가져온다 ( 시작 ) --------------------------
			// 마우스 드래그로 지도 이동이 완료되었을 때 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
			kakao.maps.event.addListener(map, 'dragend', function() {        
			    
			    // 지도 중심좌표를 얻어옵니다 
			    var latlng = map.getCenter(); 
			    
			    var resultDiv = document.getElementById('result');  
			    
			});
			// 이동 이벤트, 지도 이동시 이동된 화면의 중심 좌표를 가져온다 ( 끝 ) --------------------------

			// 마커 생성하기 시작 ---------------------------------------------
			// 마커가 표시될 위치입니다 
			/* var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
			    position: markerPosition
			}); */

			// 마커가 지도 위에 표시되도록 설정합니다
			/* marker.setMap(map); */

			// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
			// marker.setMap(null);
			// 마커 생성하기 끝  ---------------------------------------------
			
			// 마커를 표시할 위치와 title 객체 배열입니다 
			var positions = [
			    {
			        title: '카카오', 
			        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
			    },
			    {
			        title: '생태연못', 
			        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
			    },
			    {
			        title: '텃밭', 
			        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
			    },
			    {
			        title: '근린공원',
			        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
			    }
			];
			
			// 마커 이미지의 이미지 주소입니다
			//var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
			    
			for (var i = 0; i < positions.length; i ++) {
			    
			    // 마커 이미지의 이미지 크기 입니다
			    var imageSize = new kakao.maps.Size(24, 35); 
			    
			    // 마커 이미지를 생성합니다    
			    //var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			    
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng, // 마커를 표시할 위치
			        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			        //image : markerImage // 마커 이미지 
			    });
			}
			
			
			/* 마커 클러스터러 ( 마커 모음, 지도 축소시 몇개~ 라고 표시하는거)
			마커 클러스터러를 생성합니다
		    마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
		    클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
		    이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
		    클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다 */
		    var clusterer = new kakao.maps.MarkerClusterer({
		        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
		        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
		        minLevel: 10, // 클러스터 할 최소 지도 레벨
		        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
		    });
		
		    // 데이터를 가져오기 위해 jQuery를 사용합니다
		    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
		    $.get("/download/web/data/chicken.json", function(data) {
		        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
		        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
		        var markers = $(data.positions).map(function(i, position) {
		            return new kakao.maps.Marker({
		                position : new kakao.maps.LatLng(position.lat, position.lng)
		            });
		        });
		
		        // 클러스터러에 마커들을 추가합니다
		        clusterer.addMarkers(markers);
		    });
		
		    // 마커 클러스터러에 클릭이벤트를 등록합니다
		    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
		    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
		    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
		
		        // 현재 지도 레벨에서 1레벨 확대한 레벨
		        var level = map.getLevel()-1;
		
		        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
		        map.setLevel(level, {anchor: cluster.getCenter()});
		    });
			

			
			
		</script>
		
		
		
		
		
		
		<!-- End Button -->


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
	<script src="./../../res/assets/js/map.js"></script>

</body>
</html>