package clubPost.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import club.model.vo.Club;
import club.model.vo.ClubManagement;
import clubPost.model.service.ClubPostService;
import clubPost.model.vo.ClubPost;
import clubPost.model.vo.ClubPostFile;
import clubPost.model.vo.PageData;

/**
 * Servlet implementation class WriteClubPostServlet
 */
@WebServlet("/clubPost/write")
public class ClubPostWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClubPostWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClubManagement cm = (ClubManagement) session.getAttribute("cm");
		Club club = (Club)session.getAttribute("club");
		request.setAttribute("cm", cm);
		request.setAttribute("club", club);
		request.getRequestDispatcher("/WEB-INF/views/club/clubPostWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ClubPost cPost = new ClubPost();
		String uploadFilePath = request.getServletContext().getRealPath("clubUpload");
		int uploadFileLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileLimit, encType,
				new DefaultFileRenamePolicy());
		String clubPostSubject = multi.getParameter("clubPost-subject");
		String clubPostContents = multi.getParameter("clubPost-contents");
		String userId = String.valueOf(session.getAttribute("userId"));
		cPost.setUserId(userId);
		cPost.setPostSubject(clubPostSubject);
		cPost.setPostContents(clubPostContents);

		// 2. clubUpload 폴더에 저장한 파일에 대한 정보를 DB에 저장하는 작업
		String fileName = multi.getFilesystemName("clubPost-file");
		if (fileName != null) {
			File uploadFile = multi.getFile("clubPost-file");
			String filePath = uploadFile.getPath();
			long fileSize = uploadFile.length();
			ClubPostFile cPostFile = new ClubPostFile();
			cPostFile.setFileName(fileName);
			cPostFile.setFilePath(filePath);
			cPostFile.setUserId(userId);
			cPostFile.setFileSize(fileSize);
			cPost.setClubPostFile(cPostFile);
		}
		int result = new ClubPostService().writeClubPost(cPost);
		if (result > 0) {
			response.sendRedirect("/clubPost/List");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/club/Error.html").forward(request, response);
		}
	}
}
