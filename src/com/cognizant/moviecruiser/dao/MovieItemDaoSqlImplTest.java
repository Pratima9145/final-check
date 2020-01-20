package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoSqlImplTest {
	public static void main(String[] args) throws SQLException {
		try {
			System.out.println("\n---- Admin List ---");
			testGetMovieItemListAdmin();
			System.out.println("\n--- Customer List ---");
			testGetMovieItemListCustomer();
			System.out.println("\n--- Modified ---");
			testModifyMovieItem();
			testGetMovieItemListAdmin();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void testModifyMovieItem() {
		MovieItemDao movieItemDao;
		try {
			movieItemDao = new MovieItemDaoCollectionImpl();
			MovieItem mn = new MovieItem(1, "The Gentlemen", 1523698741, true, DateUtil.convertToDate("22/04/2017"),
					"Action Crime", true);
			movieItemDao.modifyMovieItem(mn);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static void testGetMovieItemListAdmin() {
		MovieItemDao movieItemDao;
		try {
			movieItemDao = new MovieItemDaoCollectionImpl();
			movieItemDao.getMovieItemListAdmin();
			List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();
			for (MovieItem x : movieItemList) {
				System.out.println(x);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void testGetMovieItemListCustomer() {
		MovieItemDao movieItemDao;
		try {
			movieItemDao = new MovieItemDaoCollectionImpl();
			movieItemDao.getMovieItemListCustomer();
			List<MovieItem> customerList = movieItemDao.getMovieItemListCustomer();

			for (MovieItem x : customerList) {
				System.out.println(x);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
