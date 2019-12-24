package com.cognizant.moviecruiser.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieItem;

public class FavoritesDaoCollectionImpl implements FavoritesDao {
	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
			userFavorites.put(1l, new Favorites());

		}
	}

	@Override
	public void addFavoritesItems(long userId, long movieItemId) {
		try {
			MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
			MovieItem movieItem = movieItemDao.getMovieItem(movieItemId);

			if (userFavorites.containsKey(userId)) {
				Favorites favorite = userFavorites.get(userId);
				favorite.getMovieItemList().add(movieItem);
			} else {
				Favorites favorite = new Favorites();
				favorite.getMovieItemList().add(movieItem);
				userFavorites.put(userId, favorite);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<MovieItem> getAllFavoritesItems(Long userId) throws FavoritesEmptyException {
		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		Favorites favorite = userFavorites.get(userId);
		int noOfFavorites = 0;
		if (favorite == null || favorite.getMovieItemList() == null || movieItemList.isEmpty()) {
			throw new FavoritesEmptyException();

		} else {
			for (MovieItem movieItem : movieItemList) {
				noOfFavorites += movieItem.getGross();
			}
		}
		favorite.setNoOfFavorites(noOfFavorites);
		return movieItemList;
	}

	@Override
	public void removeFavoritesItems(long userId, long movieItemId) {
		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		int i = 0;
		for (; i < movieItemList.size(); i++) {
			if (movieItemList.get(i).getId() == movieItemId) {
				movieItemList.remove(i);
				break;
			}
		}
	}
}
