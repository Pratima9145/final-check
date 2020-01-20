package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieItem;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	@Override
	public void addFavoritesItems(long userId, long movieItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "insert into favorites values(default,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieItemId);
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<MovieItem> getAllFavoritesItems(Long userId) throws FavoritesEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MovieItem> movieItemList = new ArrayList<MovieItem>();
		PreparedStatement ps;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		MovieItem movieItem = null;
		try {
			Favorites favorites = new Favorites();
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append(
					"SELECT movie_id,movie_title,movie_gross,movie_active,movie_date_of_launch,movie_genre,movie_has_teaser FROM movie_item ")
					.append("INNER JOIN favorites ON movie_item.movie_id = favorites.ft_pr_id WHERE favorites.ft_us_id = ?");
			ps = con.prepareStatement(sqlBuffer.toString());
			ps.setLong(1, userId);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int movieItemId = resultSet.getInt(1);
				String title = resultSet.getString(2);
				long gross = resultSet.getLong(3);
				String active = resultSet.getString(4);
				Date date_of_launch = resultSet.getDate(5);
				String genre = resultSet.getString(6);
				String hasTeaser = resultSet.getString(7);
				if (active != null && active.equals("Yes"))
					activeFlag = true;
				else
					activeFlag = false;
				if (hasTeaser != null && hasTeaser.equals("Yes"))
					hasTeaserFlag = true;
				else
					hasTeaserFlag = false;
				movieItem = new MovieItem(movieItemId, title, gross, activeFlag, date_of_launch, genre, hasTeaserFlag);
				movieItemList.add(movieItem);
			}
			favorites.setMovieItemList(movieItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (movieItemList.size() == 0) {
			throw new FavoritesEmptyException("Favorites List is Empty");
		}
		return movieItemList;
	}

	@Override
	public void removeFavoritesItems(long userId, long movieItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "delete from favorites \r\n" + "\r\n" + "where ft_us_id=? and  ft_pr_id=? limit 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieItemId);
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
