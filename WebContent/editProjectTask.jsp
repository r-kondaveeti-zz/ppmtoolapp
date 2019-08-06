<!doctype html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous">



    <link rel="stylesheet" href="App.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
        crossorigin="anonymous">

    <title>Kanban Tool</title>
</head>
<!-- Spring Boot / React Students please ignore above -->

<body>

	<jsp:include page="loggedInNavbar.jsp"/>
    
    <!-- CREATE / UPDATE PROJECT TASK FORM STARTS HERE -->

	<c:if test="${sessionScope.user.userType != 3 }">
		<jsp:include page="editProjectTaskManager.jsp"/>
	</c:if>
	<c:if test="${sessionScope.user.userType == 3 }">
		<jsp:include page="editProjectTaskDev.jsp"/>
	</c:if> 

    <!-- CREATE / UPDATE PROJECT TASK FORM ENDS HERE -->


    <!-- Spring Boot / React Students please ignore below -->

	<jsp:include page="commonjsplib.jsp"/>
</body>

</html>