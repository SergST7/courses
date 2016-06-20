/**
 * Main servlet handling the login and registration commands
 * 
 * 
 */

package com.github.vovas11.courses.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.vovas11.courses.command.*;

@SuppressWarnings("serial")
public class Handler extends HttpServlet {
    
    /**
     * Unites the methods doPost and doGet
     * Selects the command and corresponding page for the pressed button
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// gets the CommandFactory instance or create one if applies for the first time
	CommandFactory commandFactory = CommandFactory.getInstance();
	// gets the command from the CommandFactory corresponding to the button pressed by client
	Command command = commandFactory.getCommand(request);
	// runs the command, gets the page to display from the command and sends the page to the client
	String page = command.execute(request);
	RequestDispatcher reqDisp = request.getRequestDispatcher(page);
	reqDisp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// call common method for POST and GET methods
	processRequest(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
	// call common method for POST and GET methods
	processRequest(request, response);
    }
}
