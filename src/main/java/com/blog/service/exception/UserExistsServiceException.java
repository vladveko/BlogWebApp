package com.blog.service.exception;

public class UserExistsServiceException extends ServiceException {
    public UserExistsServiceException() {
        super();
    }

    public UserExistsServiceException(String message) {
        super(message);
    }

    public UserExistsServiceException(String message, Throwable cause) {
        super(message, (Exception) cause);
    }

    public UserExistsServiceException(Throwable cause) {
        super(cause);
    }
}
