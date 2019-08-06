<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">



    <link rel="stylesheet" href="App.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
        crossorigin="anonymous">

    <title>PPM Tool</title>
</head>
<!-- Spring Boot / React Students please ignore above -->

<body>


    <jsp:include page="loggedInNavbar.jsp"/>


	

<!-- Notification end -->

	<!-- Dashboard Component (Project Item included) -->
    <div class="projects">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="display-4 text-center">Projects</h1>
                    <br />
                    
                    <c:if test="${sessionScope.user.userType == 1 }">
	                  	<a href="createProject.jsp" class="btn btn-lg btn-info">
	                        Create a Project
	                    </a>
                    </c:if>
                    
                    <br />
                    
                    <hr />

                    <jsp:include page="projectItem.jsp"/>

                </div>
            </div>
        </div>
    </div>


    <!-- End of Dashboard Component -->
    
    

   <jsp:include page="commonjsplib.jsp"/>
</body>

</html>