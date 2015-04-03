package dao;

import java.sql.SQLException;

public class LibraryDAOFactory {
	
	public LibraryDAO createLibraryDAO() throws SQLException {
		return new LibraryDAOImpl();
	}
	
	public LibraryDAO createLibraryHibernate(){
		return new LibraryDAOHibernate();
	}

}
