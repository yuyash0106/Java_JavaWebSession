package local.hal.night.javawebsession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * JavaWebSession Lesson Src07
 *
 * 登録処理サーブレット。
 *
 * @author yuyas
 */
@WebServlet(name = "InputUserAddServlet", urlPatterns = { "/add" })
public class InputUserAddServlet extends HttpServlet {
	/**
	 * データソース名。
	 */
	private static final String DATASOURCE_NAME = "java:comp/env/javawebdb";

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String jspPath = "/inputUserFinish.jsp";
		Connection con = null;
		PreparedStatement stmt = null;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");

		String sql = "INSERT INTO users (login,passwd,name_first,name_last,mail) VALUES (?,?,?,?,?)";

		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(DATASOURCE_NAME);
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPasswd());
			stmt.setString(3, user.getNameFirst());
			stmt.setString(4, user.getNameLast());
			stmt.setString(5, user.getMail());

			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			request.setAttribute("errormsg", "データ処理に失敗しました。もう一度初めから行ってください。");
		} catch (NamingException ex) {
			ex.printStackTrace();
			request.setAttribute("errormsg", "データ処理に失敗しました。もう一度初めから行ってください。");
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("errormsg", "データ処理に失敗しました。もう一度初めから行ってください。");
		} finally {
			close(stmt);
			close(con);
		}

		session.invalidate();

		request.setAttribute("userInfo", user);

		RequestDispatcher rd = request.getRequestDispatcher(jspPath);
		rd.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

	/**
	 * Connectionオブジェクトをクローズするメソッド。
	 *
	 * @param con クローズ対象のConnentionオブジェクト
	 */
	private void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println("DB接続切断中にSQLExceptionが発生しました：" + ex.getMessage());
			}
		}
	}

	/**
	 * Preraredstatementオブジェクトをクローズするメソッド。
	 *
	 * @param ps クローズ対象のPreparedStatementオブジェクト
	 */
	private void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException ex) {
				System.out.println("Statementオブジェクト切断中にSQLExceptionが発生しました：" + ex.getMessage());
			}
		}
	}
}
