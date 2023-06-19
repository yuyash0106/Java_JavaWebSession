-- NI22 JavaWebSession Lesson サポートファイル
--
-- テーブル作成、データ登録SQLファイル
-- scottユーザで使用
-- コマンド: mysql -u scott --default-character-set=utf8 -p javawebdb < "C:\…\JavaWebDB_dbinit3.sql"
--
-- @author Shinzo SAITO

-- usersテーブル削除
DROP TABLE IF EXISTS users;

-- usersテーブル作成
CREATE TABLE users (
	id INTEGER AUTO_INCREMENT,
	login TEXT NOT NULL,
	passwd TEXT NOT NULL,
	name_last TEXT,
	name_first TEXT,
	mail TEXT,
	PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- usersデータ登録
INSERT INTO users (login, passwd, name_last, name_first, mail) VALUES ('shinzo', 'hogehoge', '齊藤', '新三', 'hoge@bow.com');
