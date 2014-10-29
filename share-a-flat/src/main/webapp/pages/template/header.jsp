<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	
	
	<!-- <link rel="stylesheet" type="text/css" href="/share-a-flat/css/main.css" media="all" /> -->
	<link rel="stylesheet" type="text/css" href="/share-a-flat/css/bootstrap.min.css" media="all" />
	
	<!-- <script type="text/javascript" src="dn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
	<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script> -->
	
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
	
	<style>
		body {
		  padding-top: 50px;
		}
		
		.starter-template {
		  padding: 40px 15px;
		  text-align: center;
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

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home"><img src="img/logo3.png" alt="logo" style="width: 95px; height: 35px"></a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li <%= isActive("my-page", request) %>><a href="my-page">My Page</a></li>
            <li <%= isActive("favorites", request) %>><a href="favorites">My Favorites</a></li>
            <li <%= isActive("search-list", request) %>><a href="search-list">Search</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

<!-- 	<div class="navbar"> -->
<!-- 		<div class="navbar-inner"> -->
<!-- 			<div class="container"> -->
<!-- 				<a class="brand" href="home"><img src="img/logo3.png" alt="logo" style="width: 180px; height: 60px"></a> -->
<!-- 				<ul class="nav"> -->
<%-- 					<li <%= isActive("home", request) %>><a href="home">Home</a></li> --%>
<%-- 					<li <%= isActive("my-page", request) %>><a href="my-page">My Page</a></li> --%>
<%-- 					<li <%= isActive("favorites", request) %>><a href="favorites">My Favorites</a></li> --%>
<%-- 					<li <%= isActive("search-list", request) %>><a href="search-list">Search</a></li> --%>
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

<%-- <!-- <%= request.getRequestURI() %> , nur damit wir wissen, ob url richtig eingelesen worden wird...--> --%>

<!-- 	<div id="centerDoc" class="container"> -->
	
<div class="container">

     <div class="container theme-showcase">
        <h2> username from principal: ${username}, welcome to RoofffmMate! </h2>
