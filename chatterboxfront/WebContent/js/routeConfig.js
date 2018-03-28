
/*var app = angular.module("routeModule",["ngRoute"])
				.config(function($routeProvider, $locationProvider)
				{
					$locationProvider.hashPrefix('');
					console.log("hii");
					$routeProvider.
					when("/home/",{templateUrl:"home.jsp"}).
					when("/login/",{templateUrl:"./views/login.html"})
				});*/


var app = angular
			.module("routeModule",["ngRoute"])
			.config(function($routeProvider)
			{
				$routeProvider
				.when("/", {
					templateUrl : "views/login.html"
				})
				.when("/home", {
					templateUrl : "views/home.html"
				})
				.when("/register", {
					templateUrl : "views/register.html"
				})
				.when("/blog", {
					templateUrl : "views/blog.html"
				})
				
			});