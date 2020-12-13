package com.blog.dao.impl;

import com.blog.bean.User;
import com.blog.dao.UserDAO;
import com.blog.dao.exception.DAOException;
import com.blog.dao.exception.UserExistsDAOException;
import com.blog.dao.impl.connection.ConnectionPool;
import com.blog.dao.impl.connection.ConnectionPoolException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class SQLUserDAO implements UserDAO{

    private static final String DB_COLUMN_EMAIL = "email";
    private static final String DB_COLUMN_ROLE = "roleName";
    private static final String DB_COLUMN_ID = "id";
    private static final String DB_COLUMN_FIRSTNAME = "firstname";
    private static final String DB_COLUMN_LASTNAME = "lastname";
    private static final String DB_COLUMN_LOGIN = "login";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_USER_SQL = "INSERT blogdb.users(login, pass_hash, firstname, lastame, email, role) VALUES (?,?,?,?,?,?)";
    private static final String SIGN_IN_SQL = "SELECT u.*, r.name as roleName FROM blogdb.users u INNER JOIN blogdb.roles r ON u.role = r.id where u.login = ? and u.pass_hash = ?";

    public SQLUserDAO() {}

    private static String getSHAHash(byte[] password) throws NoSuchAlgorithmException {
        String generatedPasswordHash = null;

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password);

        StringBuilder sb = new StringBuilder();
        for (byte aByte : hash) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        generatedPasswordHash = sb.toString();
        return generatedPasswordHash;
    }


    @Override
    public User signIn(String login, byte[] password) throws DAOException {

        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            PreparedStatement ps = connection.prepareStatement(SIGN_IN_SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, login);
            ps.setString(2, getSHAHash(password));

            ResultSet rs = ps.executeQuery();

            if(rs == null)
                return null;

            rs.last();
            if(rs.getRow() == 1) {
                User user =  new User(rs.getInt(DB_COLUMN_ID),
                        rs.getString(DB_COLUMN_LOGIN),
                        rs.getString(DB_COLUMN_FIRSTNAME),
                        rs.getString(DB_COLUMN_LASTNAME),
                        rs.getString(DB_COLUMN_EMAIL),
                        rs.getString(DB_COLUMN_ROLE)
                );
                ps.close();
                rs.close();
                return user;
            }
        }
        catch (ConnectionPoolException e) {
            throw new DAOException("Error in connection pool while authorizing user", e);
        }
        catch (SQLException e) {
            throw new DAOException("Error while authorizing user", e);
        }
        catch (NoSuchAlgorithmException e) {
            throw new DAOException("Password hashing error", e);
        }
        finally {
            connectionPool.returnConnection(connection);
        }
        return null;
    }

    @Override
    public void registration(String login, byte[] password, String firstname, String lastname, String email, int roleID) throws DAOException {
        Connection connection = null;

        try {
            connection = connectionPool.takeConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL);
            ps.setString(1, login);
            ps.setString(2, getSHAHash(password));
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(6, email);

            ps.executeUpdate();
            ps.close();
        }
        catch (ConnectionPoolException e) {
            throw new DAOException("Error in connection pool while registering a new user", e);
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new UserExistsDAOException("Login already exists", e);
        }
        catch (SQLException e) {
            throw new DAOException("Error while registering a new user", e);
        }
        catch (NoSuchAlgorithmException e) {
            throw new DAOException("Password hashing error", e);
        }
        finally {
            connectionPool.returnConnection(connection);
        }
    }
}
