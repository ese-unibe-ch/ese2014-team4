<!DOCTYPE html>
<html lang="en">

<head>
	<meta name="viewport" content="width=1024"  charset="utf-8" />

	<!-- <link rel="stylesheet" type="text/css" href="/share-a-flat/css/main.css" media="all" /> -->
	<link rel="stylesheet" type="text/css" href="/share-a-flat/css/bootstrap.min.css" media="all" />

	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/test.js"></script>
	
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
          <a class="navbar-brand" href="home"><img src="img/logo3.png" alt="logo" style="width: 120px; height: 35px"></a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">

          	<li <%= isActive("my-page", request) %>><a href="my-page">My Page</a></li>
            <li <%= isActive("favorites", request) %>><a href="favorites">My Favorites</a></li>
            <li <%= isActive("search-list", request) %>><a href="search-list">Search</a></li>
            <li <%= isActive("createAd", request) %>><a href="createAd">Create an ad</a></li>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">          
            <li <%= isActive("logout", request) %>><a href="logout">Logout</a></li>

          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
	
<div class="container">

     <div class="container theme-showcase">

