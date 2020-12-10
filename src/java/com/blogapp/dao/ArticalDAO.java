package com.blogapp.dao;

import com.blogapp.bean.Artical;

public interface ArticalDAO {
    void addArtical(Artical artical);
    void deleteArtical(long idArtical);
    void delete(Artical artical);
}
