<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

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


    <div class="add-PBI">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <a href="./ListProjectController" class="btn btn-light">
                        Back to Project List
                    </a>
                    <h4 class="display-4 text-center">Add Project Task</h4>
                    <!-- <p class="lead text-center">Project Name + Project Code</p> -->
                    <br>
                    <form method="post" action="./CreateProjectTaskController?projectId=${projectId}">
                    
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="summary" placeholder="Project Task summary" required/>
                        </div>
                        
                        <div class="form-group">
                            <textarea class="form-control form-control-lg" placeholder="Acceptance Criteria" name="acceptanceCriteria" required></textarea>
                        </div>
                        
<%--                          <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="developerId" placeholder="Developer ID" value="${projectTask.developerId}" required/>
                        </div> --%>
                        
                        
                        <div class="form-group">
                            <select class="form-control form-control-lg" name="developerId" required>
                                <option value={0}>Select Developers</option>
                                <c:forEach items="${sessionScope.developers}" var="developer">
                                <option value="${developer.id}">${developer.developerName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        
                        <h6>Due Date</h6>
                        <div class="form-group">
                            <input type="date" class="form-control form-control-lg" name="dueDate" required/>
                        </div>
                        <div class="form-group">
                            <select class="form-control form-control-lg" name="priority" required>
                                <option value="">Select Priority</option>
                                <option value="High">High</option>
                                <option value="Medium">Medium</option>
                                <option value="Low">Low</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <select class="form-control form-control-lg" name="status" required>
                                <option value="">Select Status</option>
                                <option value="TO_DO" selected="selected">TO DO</option>
                                <option value="IN_PROGRESS">IN PROGRESS</option>
                                <option value="DONE">DONE</option>
                            </select>
                        </div>

                        <input type="submit" class="btn btn-primary btn-block mt-4" />
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- CREATE / UPDATE PROJECT TASK FORM ENDS HERE -->


    <!-- Spring Boot / React Students please ignore below -->

	<jsp:include page="commonjsplib.jsp"/>
</body>

</html>