package local.hal.night.javawebsession.asgmt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PlusServlet", urlPatterns = { "/asgmt/plus" })
public class PlusServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		//
		String forwardPath = "/asgmt/input.jsp";

		//session設定
		HttpSession session = request.getSession();

		//JSPから値の取得
		String inputNumstr = request.getParameter("number");

		//値の数値変換
		Integer inputNum = Integer.parseInt(inputNumstr);

		//現在の値
		int currentNum = (int) session.getAttribute("currentNum");

		if (inputNumstr.equals("")) {
			currentNum = 0;
			session.setAttribute("currentNum", currentNum);
		} else if (currentNum == 0) {
			currentNum = 0 + inputNum;
			session.setAttribute("currentNum", currentNum);
		} else {
			currentNum = currentNum + inputNum;
			session.setAttribute("currentNum", currentNum);
		}

		//画面遷移
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}
}
