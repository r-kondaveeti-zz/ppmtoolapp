package com.yash.ppmtoolapp.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.domain.User;
import com.yash.ppmtoolapp.service.ProjectTaskService;
import com.yash.ppmtoolapp.serviceimpl.ProjectTaskServiceImpl;
import com.yash.ppmtoolapp.util.TaskComparator;

/**
 * This controller is called upon clicking the project board button
 */
@WebServlet("/ListProjectTaskController")
public class ListProjectTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProjectTaskService projectTaskService = new ProjectTaskServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		
		//Currently only letting managers see the tasks associated with their user id too
		int userid = -1;
		if (user.getId()>0) {
			userid = user.getId();
		}		
		List<ProjectTask> tasks = projectTaskService.getAllProjectTasks(Integer.parseInt(request.getParameter("id")),userid);
	
		/**
		 * This custom comparator allows the task lists to be sorted by
		 * priority High to Low
		 */
		Comparator<ProjectTask> c = new TaskComparator();

		
		tasks.sort(c);

		List<ProjectTask> to_do = new ArrayList<ProjectTask>();
		List<ProjectTask> in_progress = new ArrayList<ProjectTask>();
		List<ProjectTask> done = new ArrayList<ProjectTask>();

		for (ProjectTask p : tasks) {
			String status = p.getStatus();
			if (status.equals("DONE")) {
				done.add(p);
			} else if (status.equals("IN_PROGRESS")) {
				in_progress.add(p);
			} else {
				to_do.add(p);
			}
		}

		to_do.sort(c);
		in_progress.sort(c);
		done.sort(c);
		request.setAttribute("to_do_tasks", to_do);

		request.setAttribute("in_progress_tasks", in_progress);


		request.setAttribute("done_tasks", done);
		
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);

		getServletContext().getRequestDispatcher("/projectBoard.jsp").forward(request, response);
	}

}
