set names utf8;
set foreign_key_checks=0;

drop database if exists sunflower;
create database if not exists sunflower;

use sunflower;

/*会員情報テーブルここから*/
create table user_info(
	id int primary key not null auto_increment comment "ID",
	user_id varchar(16) not null unique comment "ユーザーID",
	password varchar(16) not null comment "パスワード",
	family_name varchar(32) not null comment "姓",
	first_name varchar(32) not null comment "名",
	family_name_kana varchar(32) not null comment "姓かな",
	first_name_kana varchar(32) not null comment "名かな",
	sex tinyint not null default 0 comment "性別",
	email varchar(32) not null comment "メールアドレス",
	status tinyint not null default 0 comment "ステータス",
	logined tinyint not null default 0 comment "ログインフラグ",
	regist_date datetime not null comment "登録日",
	update_date datetime comment "更新日"
) default charset=utf8 comment="会員情報テーブル";
/*会員情報テーブルここまで*/

/*商品情報テーブルここから*/
create table product_info (
	id int primary key not null auto_increment comment "ID",
	product_id int not null unique comment "商品ID",
	product_name varchar(100) not null unique comment "商品名",
	product_name_kana varchar(100) not null unique comment "商品名かな",
	product_description varchar(255) not null comment "商品詳細",
	category_id int not null comment "カテゴリID",
	price int comment "価格",
	image_file_path varchar(100) comment "画像ファイルパス",
	image_file_name varchar(50) comment "画像ファイル名",
	release_date datetime not null comment "発売年月",
	release_company varchar(50) comment "発売会社",
	status tinyint not null default 0 comment "ステータス",
	regist_date datetime not null comment "登録日",
	update_date datetime comment "更新日"
) default charset=utf8 comment="商品情報テーブル";
/*商品情報テーブルここまで*/

/*カート情報テーブルここから*/
create table cart_info (
	id int primary key not null auto_increment comment "ID",
	user_id varchar(16) not null comment "ユーザーID",
	temp_user_id varchar(16) comment "仮ユーザーID",
	product_id int not null unique comment "商品ID",
	product_count int not null comment "個数",
	price int not null comment "金額",
	regist_date datetime not null comment "登録日",
	update_date datetime comment "更新日"
) default charset=utf8 comment="カート情報テーブル";
/*カート情報テーブルここまで*/

/*購入履歴情報テーブルここから*/
create table purchase_history_info (
	id int primary key not null auto_increment comment "ID",
	user_id varchar(16) not null comment "ユーザーID",
	product_id int not null unique comment "商品ID",
	product_count int not null comment "個数",
	price int not null comment "金額",
	destination_id int not null comment "宛先情報ID",
	regist_date datetime not null comment "登録日",
	update_date datetime comment "更新日"
) default charset=utf8 comment="購入履歴テーブル";
/*購入履歴情報テーブルここまで*/

/*宛先情報テーブルここから*/
create table destination_info (
	id int primary key not null auto_increment comment "ID",
	user_id varchar(16) not null unique comment "ユーザーID",
	family_name varchar(32) not null comment "姓",
	first_name varchar(32) not null comment "名",
	family_name_kana varchar(32) not null comment "姓かな",
	first_name_kana varchar(32) not null comment "名かな",
	email varchar(32) not null comment "メールアドレス",
	tell_number varchar(13) not null comment "電話番号",
	user_address varchar(50) not null comment "住所",
	regist_date datetime not null comment "登録日",
	update_date datetime comment "更新日"
) default charset=utf8 comment="宛先情報テーブル";
/*宛先情報テーブルここまで*/

/*カテゴリマスタテーブルここから*/
create table m_category (
	id int primary key not null auto_increment comment "ID",
	category_id int not null unique comment "カテゴリID",
	category_name varchar(20) not null unique comment "カテゴリ名",
	category_description varchar(100) comment "カテゴリ詳細",
	insert_date datetime not null comment "登録日",
	update_date datetime comment "更新日"
) default charset=utf8 comment="カテゴリマスタテーブル";
/*カテゴリマスタテーブルここまで*/
