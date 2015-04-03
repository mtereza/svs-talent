package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.LibraryConnection;
import model.Book;

public class LibraryDAOImpl implements LibraryDAO {

	LibraryDAOImpl() throws SQLException {
		LibraryConnection.getConnection();
	}

	public void registerBooks(Book b) {
		// TODO Auto-generated method stub
		try (PreparedStatement stmt = LibraryConnection.getConnection()
				.prepareStatement(
						"INSERT INTO book(isbn, title) VALUES ( ?,  ?)");) {
			stmt.setString(1, b.getIsbn());
			stmt.setString(2, b.getTitle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		ArrayList<Book> books = new ArrayList<>();
		try (Connection con = LibraryConnection.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM book");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				books.add(new Book(rs.getString("isbn"), rs.getString("title")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public void updateBooks(String oldIsbn, String newIsbn, String title) {
		// TODO Auto-generated method stub
		try (PreparedStatement stmt = LibraryConnection
				.getConnection()
				.prepareStatement("UPDATE book SET isbn=?,title=? WHERE isbn=?")) {
			stmt.setString(1, newIsbn);
			stmt.setString(2, title);
			stmt.setString(3, oldIsbn);
			// System.out.println(query);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unregisterBooks(String isbn) {
		// TODO Auto-generated method stub
		try (PreparedStatement stmt = LibraryConnection.getConnection()
				.prepareStatement("DELETE FROM book WHERE isbn = ?")) {
			stmt.setString(1, isbn);
			int results = stmt.executeUpdate();
			if (results == 0) {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		ResultSet rs;
		try (PreparedStatement stmt = LibraryConnection.getConnection()
				.prepareStatement("SELECT * FROM book WHERE isbn=?")) {
			stmt.setString(1, isbn);
			rs = stmt.executeQuery();
			if (rs.next()) {
				//
			}
			// TODO Auto-generated catch block
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
