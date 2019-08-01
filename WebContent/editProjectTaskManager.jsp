    
    <!-- CREATE / UPDATE PROJECT TASK FORM STARTS HERE -->


    <div class="add-PBI">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <a href="./ListProjectController" class="btn btn-light">
                        Back to Project Board
                    </a>
                    <h4 class="display-4 text-center">Update: </h4>
                    <p class="lead text-center">Project:  - Project ID: </p>
                    <form method="get" action="./UpdateProjectTaskController">
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="summary" value="${projectTask.summary}"placeholder="Project Task summary" required/>
                        </div>
                        <div class="form-group">
                            <input type="hidden" class="form-control form-control-lg" name="id" value="${projectTask.id}" required/>
                        </div>
                        <div class="form-group">
                            <textarea class="form-control form-control-lg" placeholder="Acceptance Criteria" name="acceptanceCriteria" required>${projectTask.acceptanceCriteria}</textarea>
                        </div>
                        
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="developerId" placeholder="Developer ID" value="${projectTask.developerId}" required/>
                        </div>
                        
                        <h6>Due Date</h6>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="dueDate" placeholder="Date" value="${projectTask.dueDate}" required/>
                        </div>
                        <div class="form-group">
                            <select class="form-control form-control-lg" name="priority" required>
                                <option value={0}>Select Priority</option>
                                <option selected="selected" value="${projectTask.priority}">${projectTask.priority}</option>
                                <option value="High">High</option>
                                <option value="Medium">Medium</option>
                                <option value="Low">Low</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <select class="form-control form-control-lg" name="status" required>
                            <option selected="selected" value="${projectTask.status}">${projectTask.status}</option>
                                <option value="">Select Status</option>
                                <option value="TO_DO">TO DO</option>
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