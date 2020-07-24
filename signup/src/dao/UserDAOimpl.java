package dao;

import java.sql.*;
import java.util.ArrayList;

import db.DB;
import dto.UserDTO;

public class UserDAOimpl implements UserDAO {

	



//입력
	@Override
	public void insert(UserDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn();
			String sql = "INSERT INTO num (id, pw, email, phone, date) VALUES(?, ?, ? ,?, CURDATE())";
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 binding
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPhone());

			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
