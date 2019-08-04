package com.yash.ppmtoolapp.daoimpl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtoolapp.dao.ProjectDAO;
import com.yash.ppmtoolapp.domain.Project;
import com.yash.ppmtoolapp.util.JDBCUtil;

public class ProjectDAOImpl extends JDBCUtil implements ProjectDAO {


	
	
	@Override
	public void save(Project project) {
		String sql = "INSERT INTO " +
					"project(name, description, start_date, end_date, unique_id, manager_id)" + 
					" VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = createPreparedStatement(sql);		
		try {			
			pstmt.setString(1, project.getName());
			pstmt.setString(2, project.getDescription());
			pstmt.setDate(3, project.getStartDate());
			pstmt.setDate(4, project.getEndDate());
			pstmt.setString(5, project.getUniqueProjectId());
			pstmt.setInt(6, project.getManagerId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseResources();		
	}

	

	
	@Override
	public void update(Project project) {
		String sql = "UPDATE project SET name=?, description=?, start_date=?, end_date=?, unique_id=?, manager_id=? WHERE id="+project.getId()+";";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.setString(1, project.getName());
			pstmt.setString(2, project.getDescription());
			pstmt.setDate(3, project.getStartDate());
			pstmt.setDate(4, project.getEndDate());
			pstmt.setString(5, project.getUniqueProjectId());
			pstmt.setInt(6, project.getManagerId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseResources();
	}

	
	
	
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM project WHERE id=?";
		
		PreparedStatement pstmt = createPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		releaseResources();
		
	}

	@Override
	public void delete(Project project) {
		String sql = "DELETE FROM projects WHERE id="+project.getId();
		
		PreparedStatement pstmt = createPreparedStatement(sql);		
		try {
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		releaseResources();			
	}

	
	
	
	
	@Override
	public Project findById(int id) {
		
		Project project = new Project();
		String sql = "SELECT * from project WHERE id =" + id;	
		try {
			
			PreparedStatement pstmt = createPreparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { 			
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getDate("start_date"));
				project.setEndDate(rs.getDate("end_date"));
				project.setUniqueProjectId(rs.getString("unique_id"));
				project.setManagerId(rs.getInt("manager_id"));
			}
			
		} catch (SQLException e) {  
			e.printStackTrace();
		}
		
		releaseResources();
		return project;
	}

	
	
	
	
	
	@Override
	public List<Project> findAll() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT * from project";

		PreparedStatement pstmt = createPreparedStatement(sql);
		
		try {
			ResultSet rs = pstmt.executeQuery();
			Project project = null;
			while (rs.next()) {
				project = new Project();
				project.setId(rs.getInt("id"));;
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getDate("start_date"));
				project.setEndDate(rs.getDate("end_date"));
				project.setUniqueProjectId(rs.getString("unique_id"));
				project.setManagerId(rs.getInt("manager_id"));
				
				projects.add(project);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		releaseResources();
		return projects;
	}

}
