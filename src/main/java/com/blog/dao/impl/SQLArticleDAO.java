package com.blog.dao.impl;

import com.blog.bean.Article;
import com.blog.bean.ArticleInformation;
import com.blog.dao.ArticleDAO;
import com.blog.dao.exception.DAOException;
import com.blog.dao.impl.connection.ConnectionPool;
import com.blog.dao.impl.connection.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLArticleDAO implements ArticleDAO {

    private static final String DB_COLUMN_ID = "id";
    private static final String DB_COLUMN_AUTHOR = "author";
    private static final String DB_COLUMN_HEADING = "heading";
    private static final String DB_COLUMN_SUBHEADING = "subheading";
    private static final String DB_COLUMN_BODY = "body";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String GET_ARTICLE_BY_ID = "SELECT * FROM blogdb.articles WHERE id = ?";
    private static final String GET_ARTICLES_HEADERS = "SELECT id, author, heading FROM blogdb.articles";

    @Override
    public void addArticle(Article article) throws DAOException{

    }

    @Override
    public void deleteArticle(int idArticle) throws DAOException{

    }

    @Override
    public ArrayList<ArticleInformation> getHeaders() throws DAOException {
        Statement st = null;
        Connection connection = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            st = connection.createStatement();

            rs = st.executeQuery(GET_ARTICLES_HEADERS);

            if (rs == null) {
                return null;
            }

            ArrayList<ArticleInformation> headers = new ArrayList<>();

            if(rs.next()){
                headers.add(new ArticleInformation(
                        rs.getInt(DB_COLUMN_ID),
                        rs.getString(DB_COLUMN_AUTHOR),
                        rs.getString(DB_COLUMN_HEADING),
                        rs.getString(DB_COLUMN_SUBHEADING)
                ));
            }
            return headers;

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while find Items", e);
        } catch (SQLException e) {
            throw new DAOException("Error while find Items", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public Article getArticle(int id) throws DAOException {
        PreparedStatement ps = null;
        Connection connection = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(GET_ARTICLE_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }

            Article article = null;

            if(rs.next()){
                article = new Article(
                        rs.getInt(DB_COLUMN_ID),
                        rs.getString(DB_COLUMN_AUTHOR),
                        rs.getString(DB_COLUMN_HEADING),
                        rs.getString(DB_COLUMN_SUBHEADING),
                        rs.getString(DB_COLUMN_BODY)
                );
            }
            return article;

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while find Items", e);
        } catch (SQLException e) {
            throw new DAOException("Error while find Items", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
