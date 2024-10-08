package cs3220Lab05.servlet;

import cs3220.model.Event;

import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddEvent() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Print out
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// header
		out.println("<html><head><title>List Events</title></head><body>");
		// body
		out.println("<form action ='AddEvent' method='post'>");
		out.println("<p style='margin-left: 40px'>");
		out.println("Event Name: <input name='name' type='text'><br>");
		out.println("Date: <input name='date' type='date'><br>");
		out.println("Creator: <input name='creator' type='text'><br>");
		out.println(" <button>Add</button>");
		out.println("</p>");
		// close form
		out.println("</form>");
		// closing
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		String creator = request.getParameter("creator");
		Event addEvent = new Event(name, date, creator);
		
		@SuppressWarnings("unchecked")
		List<Event> events = (List<Event>) getServletContext().getAttribute("events");
		
		//add entry to events list
		events.add(addEvent);
		
		//send user back to ListEvents.java
		response.sendRedirect("ListEvents");
	}

}
