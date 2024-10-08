package cs3220Lab05.servlet;

import cs3220.model.Event;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ListEvents", loadOnStartup = 1)
public class ListEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListEvents() {
		super();
	}

	public void init() throws ServletException {
		// Create List of Event type
		List<Event> events = new ArrayList<>();
		// Create two Event objects from sample display
		events.add(new Event("Room 19 Valentine Party", LocalDate.of(2023, 2, 14), "Amy Frank"));
		events.add(new Event("Room 19 Kindergarten Graduation", LocalDate.of(2023, 6, 15), "Amy Frank"));
		getServletContext().setAttribute("events", events);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get events List
		@SuppressWarnings("unchecked")
		List<Event> events = (List<Event>) getServletContext().getAttribute("events");
		// Format Date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");

		// Print out
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>List Events</title></head><body>");
		out.println("<p style=\"padding-left: 40px;\"><strong>Events</strong></p>");
		out.println(
				"<p style=\"padding-left: 40px;\"><a class=\"inline_disabled\" href=\"AddEvent\" target=\"_blank\">New Event</a></p>");
		out.println("<div style=\"padding-left: 40px;\">");
		out.println("<table border=\"1\" cellspacing=\"2\" cellpadding=\"5\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Event</th>");
		out.println("<th>Date</th>");
		out.println("<th>Created By</th>");
		out.println("</tr>");
		out.println("</thead>");
		// begin table body
		out.println("<tbody>");
		
		//forEach list element
		for(Event event : events) {
			out.println("<tr>");
			out.println("<td>" + event.getName() + "</td>");
			out.println("<td>" + formatter.format(event.getEventDate()) + "</td>");
			out.println("<td>" + event.getCreatedBy() + "</td>");
			out.println("</tr>");
		}

		// close table
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body></html>");

	}

}
