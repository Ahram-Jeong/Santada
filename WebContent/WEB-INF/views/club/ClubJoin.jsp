<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Yoga Studio Template">
    <meta name="keywords" content="Yoga, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Yummy | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
    <!-- Page Preloder -->

    <!-- Header Section Begin -->
    <header class="header-section-other">
        <div class="container-fluid">
			<div class="logo" style="height: 100%; width: 25%;">
				<a href="../index.jsp"><img src="../imgs/로고6.png"
					style="height: 100%; width: 60%;" alt=""></a>
			</div>
            <div class="nav-menu">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="about-me.html">등산인증</a></li>
                                <li><a href="club.html">등산후기</a></li>
                                <li><a href="recipe.html">랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="recipe.html">추천코스</a></li>
                        <li><a href="club.html">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="#">소모임가입</a></li>
                                <li><a href="#">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="#">쪽지작성</a></li>
                                <li><a href="#">보관함</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Hero Search Section Begin -->
    <section class="contact-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <form action="/club/join" method="post" class="contact-form">
                        <h3>소모임 가입</h3> <hr>
                        <b>소모임 명</b><input type="text" value="산타자" name="club-Name" id="" style="width: 300px; height: 50px;"> <br><br>
                        <b>나이</b><select name="age">
                             <option value="10">10대</option>
                             <option value="20">20대</option>
                             <option value="30">30대</option>
                             <option value="40">40대</option>
                             <option value="50">50대</option>
                             <option value="60">60대</option>
                            </select> 
                           
                            <br><br>
                        <b>자기소개</b><textarea name="introduce" id="" cols="30" rows="10">khuser02</textarea>
                        <b>가입 경로</b> <textarea name="joinRoute" id="" cols="30" rows="10">khuser02</textarea>
                        <br>
                        소모임 장의 승인 후에 소모임에 가입 완료됩니다. <br>
                         <input type="hidden" name="name" value="">
                        <button type="submit" style="background-color: deeppink; border: none;">가입신청</button> 
                    </form>
                </div>
            </div>
        </div>
    </section>

    <!-- Recipe Section Begin -->
    <!-- <section class="recipe-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-1.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>One Pot Weeknight Soup</h4>
                            </a>
                        
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-2.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Blueberries cake</h4>
                            </a>
                       
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-3.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Pork Steak with Onion</h4>
                            </a>
                        
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-4.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Pizza with salami</h4>
                            </a>
                           
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-5.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Pumpkin Chilli Soup</h4>
                            </a>
                        
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-6.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Salmon with veggies</h4>
                            </a>
                           
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-7.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Strawberry Chessecake</h4>
                            </a>
                       
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-8.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Key Lime Pie</h4>
                            </a>
                        
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-9.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Pizza with cheesse</h4>
                            </a>
                        
                        </div>
                    </div>
                </div>
            </div>
            <form class="create">
                <input id="create" type="submit" value="글쓰기">
            </form>
            <div class="row">
                <div class="col-lg-12">
                    <div class="recipe-pagination">
                        <a href="#" class="active">01</a>
                        <a href="#">02</a>
                        <a href="#">03</a>
                        <a href="#">04</a>
                        <a href="#">Next</a>
                    </div>
                </div>
            </div>
        </div> -->
    </section>
    <!-- Recipe Section End -->

    <!-- Categories Feature Recipe Section Begin -->
    <!-- <section class="categories-feature-recipe spad">
        <div class="section-title">
            <h5>Featured Recipes</h5>
        </div>
        <div class="container po-relative">
            <div class="plus-icon">
                <i class="fa fa-plus"></i>
            </div>
            <div class="row">
                <div class="col-lg-7">
                    <div class="cfr-item">
                        <div class="cfr-item-img set-bg" data-setbg="img/cat-feature/big-1.jpg">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="cfr-item-text">
                            <div class="cat-name">Vegan</div>
                            <a href="#">
                                <h4>One Pot Weeknight Lasagna Soup Recipe</h4>
                            </a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                                ut labore et dolore magna aliqua.</p>
                        </div>
                    </div>
                    <div class="cfr-item">
                        <div class="cfr-item-img set-bg" data-setbg="img/cat-feature/big-2.jpg">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="cfr-item-text">
                            <div class="cat-name">Meat Lover</div>
                            <a href="#">
                                <h4>Veggie soup with Mushrooms</h4>
                            </a>
                            <p>Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Lorem ipsum dolor sit amet.</p>
                        </div>
                    </div>
                    <div class="cfr-item">
                        <div class="cfr-item-img set-bg" data-setbg="img/cat-feature/big-3.jpg">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="cfr-item-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Caramel Ice Cream with Berries</h4>
                            </a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                                ut labore et dolore magna aliqua.</p>
                        </div>
                    </div>
                    <div class="cfr-item">
                        <div class="cfr-item-img set-bg" data-setbg="img/cat-feature/big-4.jpg">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="cfr-item-text">
                            <div class="cat-name">Desert</div>
                            <a href="#">
                                <h4>Freash Octopuse with lime juice</h4>
                            </a>
                            <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit
                                amet, consectetur adipiscing.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 offset-lg-1">
                    <div class="cfr-small-item">
                        <a href="#"><img src="img/cat-feature/small-1.jpg" alt=""></a>
                        <div class="cfr-small-text">
                            <div class="cat-name">Vegan</div>
                            <h6>One Pot Weeknight Lasagna Soup Recipe</h6>
                        </div>
                    </div>
                    <div class="cfr-small-item">
                        <a href="#"><img src="img/cat-feature/small-2.jpg" alt=""></a>
                        <div class="cfr-small-text">
                            <div class="cat-name">Vegan</div>
                            <h6>Lava Cake with a Tone of Chocolate</h6>
                        </div>
                    </div>
                    <div class="cfr-small-item">
                        <a href="#"><img src="img/cat-feature/small-3.jpg" alt=""></a>
                        <div class="cfr-small-text">
                            <div class="cat-name">Vegan</div>
                            <h6>One Pot Weeknight Lasagna Soup Recipe</h6>
                        </div>
                    </div>
                    <div class="cfr-small-item">
                        <a href="#"><img src="img/cat-feature/small-4.jpg" alt=""></a>
                        <div class="cfr-small-text">
                            <div class="cat-name">Vegan</div>
                            <h6>Smoked Salmon mini Sandwiches with Onion</h6>
                        </div>
                    </div>
                    <div class="cfr-small-item">
                        <a href="#"><img src="img/cat-feature/small-5.jpg" alt=""></a>
                        <div class="cfr-small-text">
                            <div class="cat-name">Vegan</div>
                            <h6>Asparagus with Pork Loin and Vegetables</h6>
                        </div>
                    </div>
                    <div class="cfr-small-item">
                        <a href="#"><img src="img/cat-feature/small-6.jpg" alt=""></a>
                        <div class="cfr-small-text">
                            <div class="cat-name">Vegan</div>
                            <h6>Dry Cookies with Corn</h6>
                        </div>
                    </div>
                    <div class="cfr-small-item">
                        <a href="#"><img src="img/cat-feature/small-7.jpg" alt=""></a>
                        <div class="cfr-small-text">
                            <div class="cat-name">Vegan</div>
                            <h6>Italian Tiramisu with Coffe</h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
    <!-- Categories Feature Recipe Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                   
                        <div class="logo">
    						<a href="../index.jsp">
                                <img src="../imgs/로고6.png" alt="">
                            </a>
                        <p>여기도 글씨 들어가요~</p>
                    </div>
                </div>
                <div class="col-lg-6 offset-lg-1">
       

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search model -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">+</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>