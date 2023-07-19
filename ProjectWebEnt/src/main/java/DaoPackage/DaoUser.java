package DaoPackage;

import java.sql.*;

import EntPackage.User;

public class DaoUser {
	private Connection con;

	private String query;
    private PreparedStatement ps;
    private ResultSet rs;

	public DaoUser(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from userLogin where email=? and password=?";
            ps = this.con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}