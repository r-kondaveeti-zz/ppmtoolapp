<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">



<link rel="stylesheet" href="style.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<title>PPM Tool</title>
</head>
<!-- Spring Boot / React Students please ignore above -->

<body>


	<jsp:include page="navbar.jsp"></jsp:include>

	<!-- Dashboard Component (Project Item included) -->

	<div class="projects">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="display-4 text-center">Personal Project Management</h1>
					<br> <br>
					<blockquote class="blockquote text-center">Create your
						account to join active projects or create your own</blockquote>
					<hr>

					<div class="container">
						<div class="row">
							<div class="col text-center">
								<a href="register.jsp" class="btn btn-lg btn-info">Sign up</a>
								<a href="login.jsp" class="btn btn-lg btn-info">Login</a>
							</div>
						</div>
					</div>





					<!-- Project Item Component -->
					<!--
                    <div class="container">
                        <div class="card card-body bg-light mb-3">
                            <div class="row">
                                <div class="col-2">
                                    <span class="mx-auto">REACT</span>
                                </div>
                                <div class="col-lg-6 col-md-4 col-8">
                                    <h3>Spring / React Project</h3>
                                    <p>Project to create a Kanban Board with Spring Boot and React</p>
                                </div>
                                <div class="col-md-4 d-none d-lg-block">
                                    <ul class="list-group">
                                        <a href="#">
                                            <li class="list-group-item board">
                                                <i class="fa fa-flag-checkered pr-1">Project Board </i>
                                            </li>
                                        </a>
                                        <a href="#">
                                            <li class="list-group-item update">
                                                <i class="fa fa-edit pr-1">Update Project Info</i>
                                            </li>
                                        </a>
                                        <a href="">
                                            <li class="list-group-item delete">
                                                <i class="fa fa-minus-circle pr-1">Delete Project</i>
                                            </li>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    -->
					<!-- End of Project Item Component -->







				</div>
			</div>
		</div>
	</div>

	<!-- End of Dashboard Component -->



	<!-- Spring Boot / React Students please ignore below -->


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>

</html>