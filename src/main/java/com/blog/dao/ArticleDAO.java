package com.blog.dao;

import com.blog.bean.Article;
import com.blog.bean.ArticleInformation;
import com.blog.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;

public interface ArticleDAO {
    void addArtical(Article article) throws DAOException;
    void deleteArtical(long idArtical) throws DAOException;
    void delete(Article article) throws DAOException;
    ArrayList<ArticleInformation> getHeaders() throws DAOException;
    Article getArticle(long id) throws DAOException;
}
