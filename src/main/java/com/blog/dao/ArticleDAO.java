package com.blog.dao;

import com.blog.bean.Article;
import com.blog.bean.ArticleInformation;
import com.blog.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;

public interface ArticleDAO {
    void addArticle(Article article) throws DAOException;
    void deleteArticle(int idArtical) throws DAOException;
    ArrayList<ArticleInformation> getHeaders() throws DAOException;
    Article getArticle(int id) throws DAOException;
}
