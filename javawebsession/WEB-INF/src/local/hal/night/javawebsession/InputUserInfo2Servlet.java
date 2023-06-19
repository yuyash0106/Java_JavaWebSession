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
 * JavaWebSession Lesson Src05
 *
 * 入力２の処理サーブレット。
 *
 * @author yuyas
 */
@WebServlet(name = "InputUserInfo2Servlet", urlPatterns = { "/input2" })
public class InputUserInfo2Servlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String nameLast = request.getParameter("nameLast");
		String nameFirst = request.getParameter("nameFirst");
		String mail = request.getParameter("mail");
		nameLast = nameLast.trim();
		nameFirst = nameFirst.trim();
		mail = mail.trim();

		List<String> validationMsgs = new ArrayList<>();

		String forwardPath = "/inputUserInfo2.jsp";

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		user.setNameLast(nameLast);
		user.setNameFirst(nameFirst);
		user.setMail(mail);
		session.setAttribute("userInfo", user);

		if (nameLast.equals("")) {
			validationMsgs.add("氏名の姓の入力は必須です。");
		}
		if (nameFirst.equals("")) {
			validationMsgs.add("氏名の名の入力は必須です。");
		}
		if (mail.equals("")) {
			validationMsgs.add("メールの入力は必須です。");
		}

		if (validationMsgs.isEmpty()) {
			forwardPath = "/inputUserConfirm.jsp";
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
