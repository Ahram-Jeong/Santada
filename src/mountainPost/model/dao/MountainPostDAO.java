package mountainPost.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import mountainPost.model.vo.MountainPost;
import mountainPost.model.vo.MtFileData;

public class MountainPostDAO {

	public int insertMountainPost(Connection conn, MountainPost mPost) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MOUNTAIN_POST VALUES(SEQ_MOUNTAIN_POST.NEXTVAL,?,?,?,?,DEFAULT,?,?,?,?,?,?,?,0,DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mPost.getMountainName());
			pstmt.setString(2, mPost.getMountainPostWriter());
			pstmt.setString(3, mPost.getMountainPostSubject());
			pstmt.setString(4, mPost.getMountainPostContents());
			pstmt.setString(5, mPost.getMountainRegion());
			pstmt.setString(6, mPost.getMountainCourse());
			pstmt.setInt(7, mPost.getMountainTime());
			pstmt.setInt(8, mPost.getMountainParty());
			pstmt.setInt(9, mPost.getMountainLevel());
			pstmt.setString(10, mPost.getMountainCaution());
			pstmt.setString(11, mPost.getMountainNeed());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<MountainPost> selectAllmPost(Connection conn, int currentPage) {
		List<MountainPost> mList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY MOUNTAIN_POST_NO DESC) AS NUM, MOUNTAIN_POST_NO, MOUNTAIN_POST_SUBJECT, USER_ID, MOUNTAIN_REG_DATE, MOUNTAIN_POST_STATE FROM MOUNTAIN_POST) WHERE NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = (currentPage * viewCountPerPage) - (viewCountPerPage - 1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			mList = new ArrayList<MountainPost>();
			while(rset.next()) {
				MountainPost mPost = new MountainPost();
				mPost.setMountainPostNo(rset.getInt("MOUNTAIN_POST_NO"));
				mPost.setMountainPostSubject(rset.getString("MOUNTAIN_POST_SUBJECT"));
				mPost.setMountainPostWriter(rset.getString("USER_ID"));
				mPost.setMountainPostDate(rset.getDate("MOUNTAIN_REG_DATE"));
				mList.add(mPost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int viewCountPerPage = 10;
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn);
		int pageTotalCount = 0;
		int pageTotalCountMod = viewTotalCount / viewCountPerPage;
		if(pageTotalCountMod > 0) {
			pageTotalCount = viewTotalCount / viewCountPerPage + 1;
		} else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		int startNavi = ((currentPage - 1) / pageCountPerView) * pageCountPerView + 1;
		int endNavi = startNavi + pageCountPerView -1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/mountainPost/list?currentPage=" + (startNavi-1) + "'> [이전] </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i + " ");
			} else {
				sb.append("<a href='/mountainPost/list?currentPage=" + i + "'> " + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/mountainPost/list?currentPage=" + (endNavi+1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	private int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MOUNTAIN_POST";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return totalValue;
	}

	public MountainPost selectOneByNo(Connection conn, int mtPostNo) {
		MountainPost mOne = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOUNTAIN_POST WHERE MOUNTAIN_POST_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mtPostNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mOne = new MountainPost();
				mOne.setMountainPostNo(rset.getInt("MOUNTAIN_POST_NO"));
				mOne.setMountainName(rset.getString("MOUNTAIN_NAME"));
				mOne.setMountainPostWriter(rset.getString("USER_ID"));
				mOne.setMountainPostSubject(rset.getString("MOUNTAIN_POST_SUBJECT"));
				mOne.setMountainPostContents(rset.getString("MOUNTAIN_POST_CONTENTS"));
				mOne.setMountainPostDate(rset.getDate("MOUNTAIN_REG_DATE"));
				mOne.setMountainRegion(rset.getString("MOUNTAIN_REGION"));
				mOne.setMountainCourse(rset.getString("MOUNTAIN_COURSE"));
				mOne.setMountainTime(rset.getInt("MOUNTAIN_TIME"));
				mOne.setMountainParty(rset.getInt("MOUNTAIN_PARTY"));
				mOne.setMountainLevel(rset.getInt("MOUNTAIN_LEVEL"));
				mOne.setMountainCaution(rset.getString("MOUNTAIN_CAUTION"));
				mOne.setMountainNeed(rset.getString("MOUNTAIN_NEED"));
				mOne.setMountainRecommend(rset.getInt("MOUNTAIN_RECOMMEND"));
				mOne.setMountainPostState(rset.getString("MOUNTAIN_POST_STATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mOne;
	}

	public int deleteMountainPost(Connection conn, int mPostNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MOUNTAIN_POST WHERE MOUNTAIN_POST_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mPostNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateMountainPost(Connection conn, MountainPost mPost) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MOUNTAIN_POST SET MOUNTAIN_NAME = ?, MOUNTAIN_POST_SUBJECT = ?, MOUNTAIN_POST_CONTENTS = ?, MOUNTAIN_REGION = ?, MOUNTAIN_COURSE = ?, MOUNTAIN_TIME = ?, MOUNTAIN_PARTY = ?, MOUNTAIN_LEVEL = ?, MOUNTAIN_CAUTION = ?, MOUNTAIN_NEED =? WHERE MOUNTAIN_POST_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mPost.getMountainName());
			pstmt.setString(2, mPost.getMountainPostSubject());
			pstmt.setString(3, mPost.getMountainPostContents());
			pstmt.setString(4, mPost.getMountainRegion());
			pstmt.setString(5, mPost.getMountainCourse());
			pstmt.setInt(6, mPost.getMountainTime());
			pstmt.setInt(7, mPost.getMountainParty());
			pstmt.setInt(8, mPost.getMountainLevel());
			pstmt.setString(9, mPost.getMountainCaution());
			pstmt.setString(10, mPost.getMountainNeed());
			pstmt.setInt(11, mPost.getMountainPostNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectPostNo(Connection conn, MountainPost mPost) {
		int mPostNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOUNTAIN_POST WHERE MOUNTAIN_NAME = ? AND MOUNTAIN_POST_SUBJECT = ? AND MOUNTAIN_POST_CONTENTS = ? AND MOUNTAIN_REGION = ? AND MOUNTAIN_COURSE = ? AND MOUNTAIN_TIME = ? AND MOUNTAIN_PARTY = ? AND MOUNTAIN_LEVEL = ? AND MOUNTAIN_CAUTION = ? AND MOUNTAIN_NEED =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mPost.getMountainName());
			pstmt.setString(2, mPost.getMountainPostSubject());
			pstmt.setString(3, mPost.getMountainPostContents());
			pstmt.setString(4, mPost.getMountainRegion());
			pstmt.setString(5, mPost.getMountainCourse());
			pstmt.setInt(6, mPost.getMountainTime());
			pstmt.setInt(7, mPost.getMountainParty());
			pstmt.setInt(8, mPost.getMountainLevel());
			pstmt.setString(9, mPost.getMountainCaution());
			pstmt.setString(10, mPost.getMountainNeed());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mPostNo = rset.getInt("MOUNTAIN_POST_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mPostNo;
	}

}
