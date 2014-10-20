<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">


<link rel="stylesheet" type="text/css" href="/share-a-flat/css/main.css"
	media="all" />
<script type="text/javascript"
	src="dn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.1.min.js"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</div>


<style>
body {
	padding-top: 20px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
</head>

	<%!
  		String isActive(String ref, HttpServletRequest request) {
        	String components[] = request.getRequestURI().split("/");
         	String test = components[components.length - 1];
        	test = test.substring(0, test.length()-4);
        	
			if(ref.equals(test)) {
				return " class=\"active\" ";
            } 
           	return "";
        }
	 %>

<body>

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#"><img src="img/logo3.png" alt="logo"
					style="width: 180px; height: 60px"></a>
				<ul class="nav">
					<li <%= isActive("home", request) %>><a href="home">Home</a></li>
					<li <%= isActive("my-page", request) %>><a href="my-page">My Page</a></li>
					<li <%= isActive("favorites", request) %>><a href="favorites">My Favorites</a></li>
					<li <%= isActive("search-list", request) %>><a href="search-list">Search</a></li>
				</ul>
			</div>
		</div>
	</div>

<!-- <%= request.getRequestURI() %> , nur damit wir wissen, ob url richtig eingelesen worden wird...-->

	<div id="centerDoc" class="container">