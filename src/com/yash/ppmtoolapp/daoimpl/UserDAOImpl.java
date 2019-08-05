package com.yash.ppmtoolapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtoolapp.dao.UserDAO;
import com.yash.ppmtoolapp.domain.User;
import com.yash.ppmtoolapp.util.JDBCUtil;


public class UserDAOImpl extends JDBCUtil implements UserDAO {

	@Override
	public void save(User user) {
		String sql = "INSERT INTO users(name, email, password, role) values (?,?,?,?)";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try{
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, 3);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users WHERE email ='"+user.getEmail() + "'";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE * FROM users WHERE id="+id;
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String email) {
		String sql = "DELETE * FROM users WHERE email= '" + email + "'";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findByEmail(String email) {
//		System.out.println("The user email is in findByEmail and the value is "+email);

		User sqlUser = null;
		String sql = "SELECT * FROM users WHERE email ='"+email+"'";
		try {
			PreparedStatement pstmt = createPreparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				sqlUser = new User();
				sqlUser.setId(rs.getInt("id"));
				sqlUser.setName(rs.getString("name"));
				sqlUser.setEmail(rs.getString("email"));
				sqlUser.setPassword(rs.getString("password"));
				sqlUser.setUserType(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sqlUser;
	}

	List<User> aUser = new ArrayList();
	
	

	@Override
	public List<User> findAll() {
		User newUser = new User();
		String sql = "Select * FROM users";
		try {
			PreparedStatement pstmt = createPreparedStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				newUser.setName(rs.getString("name"));
				newUser.setEmail(rs.getString("email"));
				newUser.setPassword(rs.getString("password"));
				newUser.setUserType(rs.getString("role"));
				aUser.add(newUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aUser;
	}

}
