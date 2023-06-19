package local.hal.night.javawebsession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * JavaWebSession Lesson Src03
 *
 * 入力１の処理サーブレット。
 *
 * @author yuyas
 */
@WebServlet(name = "InputUserInfoServlet", urlPatterns = { "/input1" })
public class InputUserInfo1Servlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");

		login = login.trim();
		passwd = passwd.trim();
		passwd2 = passwd2.trim();

		List<String> validationMsgs = new ArrayList<>();

		String forwardPath = "/inputUserInfo1.jsp";

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");

		if (user == null) {
			user = new User();
		}
		user.setLogin(login);
		user.setPasswd(passwd);

		session.setAttribute("userInfo", user);

		if (login.equals("")) {
			validationMsgs.add("ログインIDの入力は必須です。");
		}
		if (passwd.equals("")) {
			validationMsgs.add("パスワードの入力は必須です。");
		}
		if (passwd2.equals("")) {
			validationMsgs.add("パスワード再入力の入力は必須です。");
		}
		if (!passwd.equals(passwd2)) {
			validationMsgs.add("パスワードとパスワード再入力が一致しません。");
		}

		if (validationMsgs.isEmpty()) {
			forwardPath = "/inputUserInfo2.jsp";
		} else {
			request.setAttribute("validationMsgs", validationMsgs);
		}

		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
}
