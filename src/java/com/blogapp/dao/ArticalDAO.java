package com.blogapp.dao;

import com.blogapp.bean.Article;

public interface ArticalDAO {
    void addArtical(Article article);
    void deleteArtical(long idArtical);
    void delete(Article article);
}
