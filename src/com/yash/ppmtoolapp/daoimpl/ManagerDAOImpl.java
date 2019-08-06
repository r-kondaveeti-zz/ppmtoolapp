package com.yash.ppmtoolapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtoolapp.dao.ManagerDAO;
import com.yash.ppmtoolapp.domain.Manager;
import com.yash.ppmtoolapp.util.JDBCUtil;

public class ManagerDAOImpl extends JDBCUtil implements ManagerDAO {
	
	public List<Manager> findAllManagers(){
		List<Manager> managers = new ArrayList<>();
		String sql = "SELECT * from users WHERE role=2";

		PreparedStatement pstmt = createPreparedStatement(sql);		
		try {
			ResultSet rs = pstmt.executeQuery();
			Manager manager = null;
			while (rs.next()) {
				manager = new Manager();
				manager.setId(rs.getInt("id"));;
				manager.setManagerName(rs.getString("name"));
				
				managers.add(manager);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		releaseResources();
		return managers;
	}
	
}
