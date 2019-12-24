package com.cognizant.moviecruiser.dao;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoCollectionImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("\n* *  Admin list of movies * *");
			testGetMovieItemListAdmin();
			System.out.println("\n* *  Customer list of movies  * *");
			testGetMovieItemListCustomer();
			System.out.println("\n* *  Modified list of movies  * *");
			testModifyMovieItem();
			testGetMovieItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	private static void testGetMovieItemListAdmin() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}

	}

	private static void testGetMovieItemListCustomer() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> customerList = movieItemDao.getMovieItemListCustomer();
		NumberFormat num = NumberFormat.getInstance();
		num.setGroupingUsed(true);
		for (MovieItem x : customerList) {
			System.out.printf("%-20s $%-7s %-20s %-5s Add to favorite\n", x.getTitle(), num.format(x.getGross()),
					x.getGenre(), x.isHasTeaser() ? "Yes" : "No");
		}
	}

	private static void testModifyMovieItem() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		MovieItem movie = new MovieItem(2, "The Vow", 2786369452L, false, DateUtil.convertToDate("09/03/2017"),
				"Romance", false);
		movieItemDao.modifyMovieItem(movie);

	}

}
