package clubPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clubPost.model.service.ClubPostService;
import clubPost.model.vo.ClubPost;
import clubPost.model.vo.ClubPostFile;

/**
 * Servlet implementation class PrintDetailClutPostServlet
 */
@WebServlet("/clubPost/detail")
public class PrintDetailClutPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintDetailClutPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		ClubPost cpOne = new ClubPostService().printDetailClubPost(postNo);
		if(cpOne != null) {
			ClubPostFile cpFile = new ClubPostFile();
			cpFile = cpOne.getClubPostFile();
			request.setAttribute("cpOne", cpOne);
			request.setAttribute("cpFile", cpFile);
			request.getRequestDispatcher("/WEB-INF/views/club/PostDetail.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/club/Error.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
