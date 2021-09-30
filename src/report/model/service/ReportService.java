package report.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import report.model.dao.ReportDAO;
import report.model.vo.Report;

public class ReportService {

private JDBCTemplate jdbcTemplate;
	
	public ReportService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	};
	
	public List<Report> printAllList(String studentId) {
		Connection conn = null;
		List<Report> sList = null;
		try {
			conn = jdbcTemplate.createConnection(); // 연결생성함
			sList = new ReportDAO().selectOneById(conn, studentId); // 연결 넘겨줌
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sList;
	}

}
