package com.blog.service;

import com.blog.bean.Article;
import com.blog.bean.ArticleInformation;
import com.blog.service.exception.ServiceException;

import java.util.ArrayList;

public interface BlogService {
    void addNewArticle(Article article) throws ServiceException;
    void addEditedArticle(Article article) throws ServiceException;
    ArrayList<ArticleInformation> getHeaders() throws ServiceException;
    Article getArticle(int id) throws ServiceException;
}
