package com.blog.dao.exception;

public class UserExistsDAOException extends DAOException {

    public UserExistsDAOException(String message, Exception e) {
        super(message, e);
    }

    public UserExistsDAOException() {
        super();
    }

    public UserExistsDAOException(String message) {
        super(message);
    }

    public UserExistsDAOException(Throwable cause) {
        super(cause);
    }

    public UserExistsDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
