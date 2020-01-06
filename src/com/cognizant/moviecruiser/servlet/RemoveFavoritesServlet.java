package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieItem;

/**
 * Servlet implementation class RemoveFavoritesServlet
 */
@WebServlet({ "/RemoveFavoritesServlet", "/RemoveFavorites" })
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RemoveFavoritesServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
			long movieItemId = Long.parseLong(request.getParameter("movieItemId"));
			favoritesDao.removeFavoritesItems(1, movieItemId);
			List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1L);
			request.setAttribute("movieItemListCustomer", movieItemListCustomer);
			request.setAttribute("msg", "Movie removed from favorites successfully ");
			request.getRequestDispatcher("ShowFavorites").forward(request, response);
		} catch (Exception ex) {
			request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
