package local.hal.night.javawebsession.asgmt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClearServlet", urlPatterns = { "/asgmt/clear" })
public class ClearServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

				//session設定
				HttpSession session = request.getSession();

					session.setAttribute("currentNum",0);




				RequestDispatcher rd = request.getRequestDispatcher("/asgmt/input.jsp");
				rd.forward(request, response);

	}
}
