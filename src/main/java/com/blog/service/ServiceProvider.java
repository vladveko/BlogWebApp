package com.blog.service;

import com.blog.service.impl.BlogServiceImpl;
import com.blog.service.impl.ReaderServiceImpl;

public final class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {}

    private ReaderService readerService = new ReaderServiceImpl();
    private BlogService blogService = new BlogServiceImpl();

    public static ServiceProvider getInstance() {
        return instance;

    }

    public ReaderService getReaderService() {
        return readerService;

    }

    public BlogService getBlogService() {
        return blogService;
    }
}
