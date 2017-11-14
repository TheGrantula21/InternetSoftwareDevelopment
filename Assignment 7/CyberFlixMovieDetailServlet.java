package edu.txstate.internet.cyberflix;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.FilmCatalog;
import edu.txstate.internet.cyberflix.utils.HTMLTags;

/**
 * Servlet implementation class CyberFlixMovieDetailServlet
 */
@WebServlet("/CyberFlixMovieDetailServlet")
public class CyberFlixMovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixMovieDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		FilmCatalog catalog    = FilmCatalog.getInstance();
		
		String      filmIDStr  = (String)request.getParameter("film_id");
		int         filmID     = Integer.valueOf(filmIDStr);
		Film        film       = catalog.get(filmID);

		System.out.println ("CyberFlixMovieDetailServlet: " + film);
		
		request.setAttribute("film", film);
			//generateHTML (writer, film);
		
		// forward this request to the following jsp page
		request.getRequestDispatcher("moviedetails.jsp").
		    forward(request,  response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void generateHTML (PrintWriter writer, Film film) {
		String detail = "<H3> " +  HTMLTags.BOLD_START 
			             + film.getTitle() + HTMLTags.BOLD_END  
				         + HTMLTags.ITALICS_START + " (" + film.getReleaseYear() + ") " + HTMLTags.ITALICS_END 
			             + "</H3> <br>" 
			             + "Running Time: " + film.getLength() + "<br>" 
			             + "Rating      : " + film.getRating() + "<br>"
						 + film.getDescription();
				writer.append (detail);
	}
}
