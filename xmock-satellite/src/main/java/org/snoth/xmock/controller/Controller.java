package org.snoth.xmock.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by robbie on 21/02/2018.
 */
public interface Controller {

    void dispatch(HttpServletRequest request, HttpServletResponse response) throws Exception;
    boolean hasMatchEndpoints(HttpServletRequest request);

}
