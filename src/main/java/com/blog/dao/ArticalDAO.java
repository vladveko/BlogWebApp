package com.blog.dao;

import com.blog.bean.Article;

public interface ArticalDAO {
    void addArtical(Article article);
    void deleteArtical(long idArtical);
    void delete(Article article);
}
