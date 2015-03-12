<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.orm.hibernate3.LocalSessionFactoryBean"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%
 WebApplicationContext wac= WebApplicationContextUtils.getRequiredWebApplicationContext(application);
 SessionFactory sessionFactory=(SessionFactory)wac.getBean("sessionFactory");
 sessionFactory.openSession();
%>
<html lang="en">
<head>
	<title>微贴</title>
	<meta charset="utf-8" />
	
	<link rel="stylesheet" href="style.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body class="body">
	
	<header class="mainHeader">
		<img src="img/logo.gif">
		<nav><ul>
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">主页</a></li>
			<li><a href="#">图库</a></li>
			<li><a href="#">关于</a></li>
			<li><a href="login/toLogin">登录</a></li>
		</ul></nav>
	</header>
		
	<div class="mainContent">
		<div class="content">	
				<article class="topcontent">	
					<header>
						<h2><a href="#" rel="bookmark" title="Permalink to this POST TITLE">Second article</a></h2>
					</header>
					
					<footer>
						<p class="post-info">This was posted on the 2nd of March 2013 by Christian Vasile</p>
					</footer>
					
					<content>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </p>
						<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.</p>
					</content>
					
				</article>

				<article class="bottomcontent">	
					<header>
						<h2><a href="login" rel="bookmark" title="Permalink to this POST TITLE">First post</a></h2>
					</header>

					<footer>
						<p class="post-info">This was posted on the 5th of March 2013 by Christian Vasile</p>
					</footer>
					
					<content>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					</content>
				
				</article>
		</div>
			
				<aside class="top-sidebar">
					<article>
					<h2>Top Sidebar</h2>
					<p>Discover how to use new techniques to achieve an outstanding, cross-browser HTML5.</p>
				    </article>
				</aside>
				
				<aside class="middle-sidebar">
					<article>
					<h2>Middle Sidebar</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				    </article>
				</aside>				

				<aside class="bottom-sidebar">
					<article>
					<h2>Bottom Sidebar</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod expedita distinctio.</p>
				    </article>
				</aside>	
	</div>
	
	<footer class="mainFooter">
		<p>Copyright &copy; 2013 <a href="http://1stwebdesigner.com">1stwebdesigner</a></p>
	</footer>

</body>
</html>
