package com.yash.ppmtoolapp.daoimpl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtoolapp.domain.Developer;
import com.yash.ppmtoolapp.util.JDBCUtil;
import com.yash.ppmtoolapp.dao.DeveloperDAO;

public class DeveloperDAOImpl extends JDBCUtil implements DeveloperDAO {
	
	
	public List<Developer> findAllDevelopers(){
		List<Developer> developers = new ArrayList<>();
		String sql = "SELECT * from users WHERE role=3";

		PreparedStatement pstmt = createPreparedStatement(sql);		
		try {
			ResultSet rs = pstmt.executeQuery();
			Developer developer = null;
			while (rs.next()) {
				developer = new Developer();
				developer.setId(rs.getInt("id"));;
				developer.setDeveloperName(rs.getString("name"));
				
				developers.add(developer);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		releaseResources();
		return developers;
	}
	
	
}
