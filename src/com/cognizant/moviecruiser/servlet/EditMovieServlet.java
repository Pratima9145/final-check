package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieItemDao;
import com.cognizant.moviecruiser.dao.MovieItemDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieItemDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EditMovieServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
			long id = Long.parseLong(request.getParameter("movieItemId"));
			String title = request.getParameter("txtTitle");
			long gross = Long.parseLong(request.getParameter("txtGross"));
			boolean active = request.getParameter("rd3").equals("yes");
			Date dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
			String genre = request.getParameter("genre");
			boolean hasTeaser = request.getParameter("check") != null;
			MovieItem movieItem = new MovieItem(id, title, gross, active, dateOfLaunch, genre, hasTeaser);
			
			movieItemDao.modifyMovieItem(movieItem);
			request.setAttribute("msg", "Movie details saved successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			ex.getMessage();

		}
	}

}
