package com.yash.ppmtoolapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtoolapp.dao.ProjectTaskDAO;
import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.util.JDBCUtil;

public class ProjectTaskDAOImpl extends JDBCUtil implements ProjectTaskDAO {

	@Override
	public void saveProjectTask(ProjectTask projectTask) {
		String sql = "Insert into new_table (summary, acceptance_criteria, due_date, priority, status, project_id, developer_id) values (?,?,?,?,?,?,?)";
			
		PreparedStatement psmt = createPreparedStatement(sql);
		try{
			psmt.setString(1, projectTask.getSummary());
			psmt.setString(2, projectTask.getAcceptanceCriteria());
			psmt.setDate(3, projectTask.getDueDate());
			psmt.setString(4, projectTask.getPriority());
			psmt.setString(5, projectTask.getStatus());
			psmt.setInt(6, projectTask.getProjectId());
			psmt.setInt(7, projectTask.getDeveloperId());
			psmt.execute();		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
	}

	@Override
	public void deleteProjectTask(ProjectTask projectTask) {
		String sql = "Delete from new_table where id=?";
		PreparedStatement psmt = createPreparedStatement(sql);
		try {
			psmt.setInt(1, projectTask.getId());
			psmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
	}

	@Override
	public void updateProjectTask(ProjectTask projectTask) {
		String sql = "UPDATE new_table SET summary = ?, acceptance_criteria = ?, due_date=?, priority=?, status=?, developer_id=? WHERE id = ?";
		PreparedStatement psmt = createPreparedStatement(sql);
		try {
			psmt.setInt(7, projectTask.getId());
			psmt.setString(1, projectTask.getSummary());
			psmt.setString(2, projectTask.getAcceptanceCriteria());
			psmt.setDate(3, projectTask.getDueDate());
			psmt.setString(4, projectTask.getPriority());
			psmt.setString(5, projectTask.getStatus());
			psmt.setInt(6, projectTask.getDeveloperId());
			pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		releaseResources();
	}

	@Override
	public void deleteProjectTask(int id) {
		String sql = "DELETE FROM new_table WHERE id=?;";
		
		PreparedStatement pstmt = createPreparedStatement(sql);	
		try {
			pstmt.setInt(1, id);;
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
		
	}

	
	@Override
	public ProjectTask findProjectTaskById(int id) {
		ProjectTask projectTask = new ProjectTask();
		String sql = "SELECT * from new_table WHERE id =" + id;
		try {
			
			PreparedStatement pstmt = createPreparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { 			
				projectTask.setSummary(rs.getString("summary"));
				projectTask.setAcceptanceCriteria(rs.getString("acceptance_criteria"));
				projectTask.setDueDate(rs.getDate("due_date"));
				projectTask.setPriority(rs.getString("priority"));
				projectTask.setStatus(rs.getString("status"));
				projectTask.setProjectId(rs.getInt("project_id"));
				projectTask.setDeveloperId(rs.getInt("developer_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
		return projectTask;
	}

	@Override
	public List<ProjectTask> findAllProjectTask(int id, int developerId) {
		
		List<ProjectTask> projectTasks = new ArrayList<>();
		String sql=null;
		if (developerId==3) {
			sql = "SELECT * FROM new_table WHERE project_id="+id+" AND developer_id="+developerId;
		}else {
			sql = "SELECT * FROM new_table WHERE project_id="+id;
		}	
		PreparedStatement pstmt = createPreparedStatement(sql);
		
		try {
			ResultSet rs = pstmt.executeQuery();
			ProjectTask projectTask = null;
			while (rs.next()) {
				projectTask = new ProjectTask();
				projectTask.setId(rs.getInt("id"));;
				projectTask.setSummary(rs.getString("Summary"));
				projectTask.setAcceptanceCriteria(rs.getString("acceptance_criteria"));
				projectTask.setDueDate(rs.getDate("due_date"));
				projectTask.setPriority(rs.getString("priority"));
				projectTask.setStatus(rs.getString("status"));
				projectTask.setProjectId(rs.getInt("project_id"));
				projectTask.setDeveloperId(rs.getInt("developer_id"));
				
				projectTasks.add(projectTask);							
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
		return projectTasks;
	}
	
	@Override
	public List<ProjectTask> findAllProjectTask(int developerId) {
		
		List<ProjectTask> projectTasks = new ArrayList<>();
		String sql = "SELECT * FROM new_table WHERE developer_id="+developerId;
		PreparedStatement pstmt = createPreparedStatement(sql);
		
		try {
			ResultSet rs = pstmt.executeQuery();
			ProjectTask projectTask = null;
			while (rs.next()) {
				projectTask = new ProjectTask();
				projectTask.setId(rs.getInt("id"));;
				projectTask.setSummary(rs.getString("Summary"));
				projectTask.setAcceptanceCriteria(rs.getString("acceptance_criteria"));
				projectTask.setDueDate(rs.getDate("due_date"));
				projectTask.setPriority(rs.getString("priority"));
				projectTask.setStatus(rs.getString("status"));
				projectTask.setProjectId(rs.getInt("project_id"));
				projectTask.setDeveloperId(rs.getInt("developer_id"));
				
				projectTasks.add(projectTask);							
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
		return projectTasks;
	}
	
//This method is present only in this file
	public void deleteProjectTasksByProjectId(int id) {
		String sql = "DELETE FROM new_table WHERE project_id=?;";
		
		PreparedStatement pstmt = createPreparedStatement(sql);	
		try {
			pstmt.setInt(1, id);;
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
		
	}
}

