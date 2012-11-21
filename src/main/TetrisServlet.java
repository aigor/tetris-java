import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TetrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;		

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String figure = req.getParameter("figure");
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));
        String glass = req.getParameter("glass");        
        System.out.println(String.format("Figure: %s, coordinates: (%d, %d)", figure, x, y));
                  
                
        Glass gl = new Glass(glass);          
        Figure f = Figure.map.get(figure);
        
        Finder finder = new Finder();
        Solution s = finder.findBestPosition(gl, f, x, y);
        
        resp.getWriter().write(answer(s));        
	}
    
    
    public String answer(Solution s) {        
        return s.toString();
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8888);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(new ServletHolder(new TetrisServlet()), "/*");
        server.setHandler(context);
        server.start();
    }   
}
