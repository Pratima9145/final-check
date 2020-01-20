package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public class MovieItemDaoSqlImpl implements MovieItemDao{

	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<MovieItem> movieItemList = new ArrayList<>();
		try {
			String sql = "select * from movie_item ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getLong(1));
				movie.setTitle(rs.getString(2));
				movie.setGross(rs.getLong(3));
				movie.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate(5));
				movie.setGenre(rs.getString(6));
				movie.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				movieItemList.add(movie);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return movieItemList;
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		List<MovieItem> movieItemList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from movie_item WHERE movie_active=? AND movie_date_of_launch <=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "Yes");
			java.util.Date d = new java.util.Date();
			ps.setDate(2, new java.sql.Date(d.getTime()));

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getLong(1));
				movie.setTitle(rs.getString(2));
				movie.setGross(rs.getLong(3));
				movie.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate(5));
				movie.setGenre(rs.getString(6));
				movie.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				movieItemList.add(movie);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return movieItemList;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "UPDATE movie_item SET movie_name=? , movie_price=?, movie_active=?, movie_date_of_launch=?,"
				+ "movie_category=?,movie_free_delivery=? WHERE movie_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieItem.getTitle());
			ps.setLong(2, movieItem.getGross());
			ps.setString(3, movieItem.isActive() ? "Yes" : "No");
			java.util.Date d = new java.util.Date();
			ps.setDate(4, new java.sql.Date(d.getTime()));
			ps.setString(5, movieItem.getGenre());
			ps.setString(6, movieItem.isHasTeaser() ? "Yes" : "No");
			ps.setLong(7, movieItem.getId());
			int result = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	public MovieItem getMovieItem(long movieItemId) {
		Connection con = ConnectionHandler.getConnection();

		MovieItem movie = null;
		try {
			
		String sql = "select * from movie_item where movie_id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, movieItemId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
          String title=rs.getString(2);
           long gross=rs.getLong(3);
           boolean active = rs.getString(4).equalsIgnoreCase("yes");
           Date dateOfLaunch=rs.getDate(5);
           String genre = rs.getString(6);
       boolean hasTeaser= rs.getString(7).equalsIgnoreCase("yes");

      movie=new MovieItem(movieItemId,title,gross,active,dateOfLaunch,genre,hasTeaser);
		}
		}catch(Exception ex){
			ex.printStackTrace();
			
		} finally {
			try {
				con.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 return movie;
	}


}

