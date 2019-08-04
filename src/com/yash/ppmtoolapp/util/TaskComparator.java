package com.yash.ppmtoolapp.util;

import java.util.Comparator;

import com.yash.ppmtoolapp.domain.ProjectTask;

public class TaskComparator implements Comparator<ProjectTask>{


	/**
	 * This assignPriority takes a task's priority string and 
	 * assigns it an integer value. 3 = Low 2=Medium 0 = High
	 * @param s the string representation of the priority
	 * @return the integer value of the priority.
	 * 
	 * TODO: Move this code to a Util class of its own?
	 */
	public int assignPriority(String s) {
		int ret = 0;
		switch (s) {
		case "Low":
			ret = 3;
			break;
		case "Medium":
			ret = 2;
			break;
		default:
			break;
		}

		return ret;
	}

	@Override
	public int compare(ProjectTask task1, ProjectTask task2) {

		Integer t1Priority = assignPriority(task1.getPriority());
		System.out.println("this is comparator");
		Integer t2Priority = assignPriority(task2.getPriority());

		
		return t1Priority.compareTo(t2Priority);
	}

}

