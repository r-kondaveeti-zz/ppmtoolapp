<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
   
   <c:set var="to_do_tasks" value="${requestScope.to_do_tasks }"/>
   <c:set var="in_progress_tasks" value="${requestScope.in_progress_tasks }"/>
   <c:set var="done_tasks" value="${requestScope.done_tasks }"/>
   <c:set var="projectId" scope="session" value="${requestScope.id}"/>
   
    <!-- Project Board Starts Here MIND OTHER COMPONENTS WHEN COPY AND PASTING -->
    <div class="container">
    	<c:if test="${sessionScope.user.userType !=3 }">
        <a href="./RedirectController?projectId=${projectId}" class="btn btn-primary mb-3">
            <i class="fas fa-plus-circle"> Create Project Task</i>
        </a>
        </c:if>
        <br />
        <hr />
        <!-- Backlog STARTS HERE -->
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card text-center mb-2">
                        <div class="card-header bg-secondary text-white">
                            <h3>TO DO</h3>
                        </div>
                    </div>
               
                <%--  <c:if test="${task.status eq 'TO_DO' }">--%>
				<c:forEach items="${requestScope.to_do_tasks}" var="task">
				
				     <div class="card mb-1 bg-light">
				<%-- 	<c:forEach items="${requestScope.tasks}" var="task"> --%>
				
				
						<c:if test="${task.priority eq 'Low'}">
							<div class="card-header bg-light text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
						
						<c:if test="${task.priority eq 'Medium'}">
							<div class="card-header bg-warning text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
						
						<c:if test="${task.priority eq 'High'}">
							<div class="card-header bg-danger text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
                        
                        <div class="card-body bg-light">
                            <h5 class="card-title">${task.summary}</h5>
                            <p class="card-text text-truncate ">
                                ${task.acceptanceCriteria}
                            </p>
                            <a href="./EditProjectTaskController?id=${task.id}" class="btn btn-primary">
                                View / Update
                            </a>

                          
                            
                         	<c:if test="${sessionScope.user.userType != 3}"> 
                            <a href="#" onclick="myFunction()" class="btn btn-danger ml-4">
                                       Delete
                            </a>
                            </c:if>
                            <script>
                            function myFunction(){	
                            	if (confirm('Are you sure you want to delete this project? ')){
                            		
                            		window.location.href = "./DeleteProjectTaskController?id=${task.id}"
                            	}        
                            }       
                            </script>
                            
                            
                        </div>
                        
                  	
                    </div>

                </c:forEach>
                
            <%--IN PROGRESS TASKS --%>
                </div>
                <div class="col-md-4">
                    <div class="card text-center mb-2">
                        <div class="card-header bg-primary text-white">
                            <h3>In Progress</h3>
                        </div>
                    </div>
                  
                  		<c:forEach items="${requestScope.in_progress_tasks}" var="task">
				
				     <div class="card mb-1 bg-light">
				<%-- 	<c:forEach items="${requestScope.tasks}" var="task"> --%>
						
                        <c:if test="${task.priority eq 'Low'}">
							<div class="card-header bg-light text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
						
						<c:if test="${task.priority eq 'Medium'}">
							<div class="card-header bg-warning text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
						
						<c:if test="${task.priority eq 'High'}">
							<div class="card-header bg-danger text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
                       
                        <div class="card-body bg-light">
                            <h5 class="card-title">${task.summary}</h5>
                            <p class="card-text text-truncate ">
                                ${task.acceptanceCriteria}
                            </p>
                            <a href="./EditProjectTaskController?id=${task.id}" class="btn btn-primary">
                                View / Update
                            </a>

                          
                            
                          <c:if test="${sessionScope.user.userType != 3}"> 
                            <a href="#" onclick="myFunction()" class="btn btn-danger ml-4">
                                       Delete
                            </a>
                            </c:if>
                            <script>
                          
                            function myFunction(){	
                            	if (confirm('Are you sure you want to delete this project? ')){
                            		
                            		window.location.href = "./DeleteProjectTaskController?id=${task.id}"
                            	}        
                            }       
                            </script>
                            
                         
                            
                        </div>
                        
                  	<%--     </c:forEach>--%>
                    </div>

                </c:forEach>
                    <!-- SAMPLE PROJECT TASK STARTS HERE -->

                    <!-- SAMPLE PROJECT TASK ENDS HERE -->
                </div>
                <div class="col-md-4">
                    <div class="card text-center mb-2">
                        <div class="card-header bg-success text-white">
                            <h3>Done</h3>
                        </div>
                    </div>
                    <%-- <c:if test="${task.status == 'DONE' }"> --%>
                    <c:forEach items="${requestScope.done_tasks}" var="task">
				
				     <div class="card mb-1 bg-light">
				<%-- 	<c:forEach items="${requestScope.tasks}" var="task"> --%>
						
                       <c:if test="${task.priority eq 'Low'}">
							<div class="card-header bg-light text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
						
						<c:if test="${task.priority eq 'Medium'}">
							<div class="card-header bg-warning text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
						
						<c:if test="${task.priority eq 'High'}">
							<div class="card-header bg-danger text-black">
                            Task ID: ${task.id}  -- Task Priority: ${task.priority }
                        </div>
						</c:if>
                        
                        
                        <div class="card-body bg-light">
                            <h5 class="card-title">${task.summary}</h5>
                            <p class="card-text text-truncate ">
                                ${task.acceptanceCriteria}
                            </p>
                            <a href="./EditProjectTaskController?id=${task.id}" class="btn btn-primary">
                                View / Update
                            </a>

                          
                            
                            <c:if test="${sessionScope.user.userType != 3}">
                            <a href="#" onclick="myFunction()" class="btn btn-danger ml-4">
                                       Delete
                            </a>
                            
                            </c:if>
                            <script>
                            function myFunction(){	
                            	if (confirm('Are you sure you want to delete this project? ')){
                            		
                            		window.location.href = "./DeleteProjectTaskController?id=${task.id}"
                            	}        
                            }       
                            </script>
       
                         
                            
                        </div>
                        
                  	<%--     </c:forEach>--%>
                    </div>

                </c:forEach>
                    <!-- SAMPLE PROJECT TASK STARTS HERE -->

                    <!-- SAMPLE PROJECT TASK ENDS HERE -->
                </div>
            </div>
        </div>

        <!-- Backlog ENDS HERE -->
    </div>

    <!-- PROJECT BOARD ENDS HERE -->
    <!-- Spring Boot / React Students please ignore below -->


    <jsp:include page="commonjsplib.jsp"/>
</body>

</html>