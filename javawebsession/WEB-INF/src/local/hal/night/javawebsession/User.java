package local.hal.night.javawebsession;

/**
 * JavaWebSession Lesson Src01
 *
 * ユーザー情報エンティティクラス。
 *
 * @author yuyas
 */
public class User {
	/**
	 * 主キーであるID。
	 */
	private Integer _id;
	/**
	 * ログインID。
	 */
	private String _login = "";
	/**
	 * パスワード。
	 */
	private String _password = "";
	/**
	 * 姓。
	 */
	private String _nameLast = "";
	/**
	 * 名。
	 */
	private String _nameFirst = "";
	/**
	 * メールアドレス。
	 */
	private String _mail = "";

	//以下アクセサメソッド

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getLogin() {
		return _login;
	}

	public void setLogin(String login) {
		_login = login;
	}

	public String getPasswd() {
		return _password;
	}

	public void setPasswd(String password) {
		_password = password;
	}

	public String getNameLast() {
		return _nameLast;
	}

	public void setNameLast(String nameLast) {
		_nameLast = nameLast;
	}

	public String getNameFirst() {
		return _nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		_nameFirst = nameFirst;
	}

	public String getMail() {
		return _mail;
	}

	public void setMail(String mail) {
		_mail = mail;
	}
}
