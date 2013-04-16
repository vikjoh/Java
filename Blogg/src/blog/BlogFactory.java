package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class BlogFactory {
	
	public static Post getPost(int id)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/vicolsson";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM blogginlagg WHERE id=" + id);
		
			if (rs.next()) {
				String titel = rs.getString("sHeader");
				String body = rs.getString("sBody");
				
				Timestamp tempStamp = rs.getTimestamp("dDatePosted");
				Calendar tempCal = new GregorianCalendar();
				tempCal.setTime(tempStamp);
				
				Author tempAuth = new Author(rs.getString("sNamePoster"));
				
				Post post = new Post(titel, body, tempAuth, tempCal);
				post.setNumberOfComments(rs.getInt("iNumberOfComments"));
				post.setSqlID(rs.getInt("iID"));
				return post;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}

		return null;
	}
	public static List<Post> getAllPosts()
	{
		List<Post> ret = new ArrayList<Post>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/vicolsson";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM blogginlagg WHERE bDeleted=0");

			while (rs.next()) {
				String titel = rs.getString("sHeader");
				String body = rs.getString("sBody");
				
				Timestamp tempStamp = rs.getTimestamp("dDatePosted");
				Calendar tempCal = new GregorianCalendar();
				tempCal.setTime(tempStamp);
				
				Author tempAuth = new Author(rs.getString("sNamePoster"));
				
				Post post = new Post(titel, body, tempAuth, tempCal);
				post.setNumberOfComments(rs.getInt("iNumberOfComments"));
				post.setSqlID(rs.getInt("iID"));
				ret.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	public static List<Comment> getAllCommentsOfPost(int id)
	{
		List<Comment> ret = new ArrayList<Comment>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/vicolsson";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM bloggcomments WHERE iPostID=" + id + " AND bDeleted=0");

			while (rs.next()) {
				String body = rs.getString("sBody");

				Timestamp tempStamp = rs.getTimestamp("dDatePosted");
				Calendar tempCal = new GregorianCalendar();
				tempCal.setTime(tempStamp);
				
				Author tempAuth = new Author(rs.getString("sNamePoster"));
				
				Comment com = new Comment(tempAuth, body, tempCal);
				
				ret.add(com);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	public static void addPost(String header, String body, Author auth)
	{
		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/vicolsson";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			
			Calendar tempCal = new GregorianCalendar();
			java.sql.Date sqlDate = new java.sql.Date(tempCal.getTime().getTime());
			
			String tempSQLString = "INSERT INTO blogginlagg (sHeader, sBody, dDatePosted, sNamePoster) VALUES (?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(tempSQLString);
			stmt.setString(1, header);
			stmt.setString(2, body);
			stmt.setDate(3, sqlDate);
			stmt.setString(4, auth.getName());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deletePost(int id)
	{
		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/vicolsson";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			
			String tempSQLString = "UPDATE blogginlagg SET bDeleted=1 WHERE iID=?";
			
			PreparedStatement stmt = con.prepareStatement(tempSQLString);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
