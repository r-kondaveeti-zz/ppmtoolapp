<!-- SAMPLE PROJECT TASK STARTS HERE -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card mb-1 bg-light">
	<%-- 	<c:forEach items="${requestScope.tasks}" var="task"> --%>

	<div class="card-header text-primary">Task ID:
		${request.getParam("task").task.id} -- Task Priority: ${task.priority }
	</div>

	<div class="card-body bg-light">
		<h5 class="card-title">${task.summary}</h5>
		<p class="card-text text-truncate ">${task.acceptanceCriteria}</p>
		<a href="./EditProjectTaskController?id=${task.id}"
			class="btn btn-primary"> View / Update </a>

		<button href="#" class="btn btn-danger ml-4" onclick="myFunction()">
			Delete</button>

		<%--   <c:if test="${user.role != 3}"> --%>

		<%-- 
                            <a href="#" onclick="myFunction()"class="btn btn-danger ml-4">
                                       Delete
                            </a>
                            
                           --%>
		<script>
			function myFunction() {

				if (confirm('Are you sure you want to delete this project? ')) {

					window.location.href = "./DeleteProjectTaskController?id=${task.id}"

				}
			}
		</script>

		<%--    </c:if> --%>

	</div>

	<%--     </c:forEach>--%>
</div>

<!-- SAMPLE PROJECT TASK ENDS HERE -->