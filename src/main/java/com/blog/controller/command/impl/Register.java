package com.blog.controller.command.impl;

import com.blog.controller.command.Command;
import com.blog.service.ReaderService;
import com.blog.service.ServiceProvider;
import com.blog.service.exception.ServiceException;
import com.blog.service.exception.UserExistsServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register implements Command {

    private static final String REQ_PARAM_FIRST_NAME = "firstname";
    private static final String REQ_PARAM_LAST_NAME = "lastname";
    private static final String REQ_PARAM_EMAIL = "email";
    private static final String REQ_PARAM_LOGIN = "login";
    private static final String REQ_PARAM_PASSWORD = "password";
    private static final int DEFAULT_USERROLE_ID = 2;

    private static final String REDIRECT_SUCCESS = "Controller?com=gotomain&regstate=success";
    private static final String REDIRECT_ERROR = "Controller?com=gotoreg&regstate=error";
    private static final String REDIRECT_DUPLICATE = "Controller?com=gotoreg&restate=exist";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter(REQ_PARAM_FIRST_NAME);
        String lastname = request.getParameter(REQ_PARAM_LAST_NAME);
        String email = request.getParameter(REQ_PARAM_EMAIL);
        String login = request.getParameter(REQ_PARAM_LOGIN);
        String password = request.getParameter(REQ_PARAM_PASSWORD);

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        ReaderService readerService = serviceProvider.getReaderService();

        boolean success;

        try{
            success = readerService.registration(login, password.getBytes(), firstname, lastname, email, DEFAULT_USERROLE_ID);

            if (success){
               response.sendRedirect(REDIRECT_SUCCESS);
            }
            else {
                response.sendRedirect(REDIRECT_ERROR);
            }
        }
        catch (UserExistsServiceException ex){
            response.sendRedirect(REDIRECT_DUPLICATE);
        }
        catch (ServiceException ex){
            response.sendRedirect(REDIRECT_ERROR);
        }
    }
}
