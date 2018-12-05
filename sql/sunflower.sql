set names utf8;
set foreign_key_checks=0;

drop database if exists sunflower;
create database if not exists sunflower;

use sunflower;

drop table if exists user_info;
drop table if exists product_info;
drop table if exists cart_info;
drop table if exists purchase_history_info;
drop table if exists destination_info;
drop table if exists m_category;


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

insert into user_info values
	(1,"guest","guest","インターノウス","ゲストユーザー","いんたーのうす","げすとゆーざー",0,"guest@gmail.com",0,0,now(),now()),
	(2,"guest2","guest2","インターノウス","ゲストユーザー2","いんたーのうす","げすとゆーざー2",0,"guest2@gmail.com",0,0,now(),now()),
	(3,"guest3","guest3","インターノウス","ゲストユーザー3","いんたーのうす","げすとゆーざー3",0,"guest3@gmail.com",0,0,now(),now()),
	(4,"guest4","guest4","インターノウス","ゲストユーザー4","いんたーのうす","げすとゆーざー4",0,"guest4@gmail.com",0,0,now(),now()),
	(5,"guest5","guest5","インターノウス","ゲストユーザー5","いんたーのうす","げすとゆーざー5",0,"guest5@gmail.com",0,0,now(),now()),
	(6,"guest6","guest6","インターノウス","ゲストユーザー6","いんたーのうす","げすとゆーざー6",0,"guest6@gmail.com",0,0,now(),now()),
	(7,"guest7","guest7","インターノウス","ゲストユーザー7","いんたーのうす","げすとゆーざー7",0,"guest7@gmail.com",0,0,now(),now()),
	(8,"guest8","guest8","インターノウス","ゲストユーザー8","いんたーのうす","げすとゆーざー8",0,"guest8@gmail.com",0,0,now(),now()),
	(9,"guest9","guest9","インターノウス","ゲストユーザー9","いんたーのうす","げすとゆーざー9",0,"guest9@gmail.com",0,0,now(),now()),
	(10,"guest10","guest10","インターノウス","ゲストユーザー10","いんたーのうす","げすとゆーざー10",0,"guest10@gmail.com",0,0,now(),now()),
	(11,"guest11","guest11","インターノウス","ゲストユーザー11","いんたーのうす","げすとゆーざー11",0,"guest11@gmail.com",0,0,now(),now()),
	(12,"guest12","guest12","インターノウス","ゲストユーザー12","いんたーのうす","げすとゆーざー12",0,"guest12@gmail.com",0,0,now(),now()),
	(13,"admin","admin","インターノウス","管理者ユーザー","いんたーのうす","かんりしゃゆーざー",0,"admin@gmail.com",1,0,now(),now()),
	(14,"admin2","admin2","インターノウス","管理者ユーザー2","いんたーのうす","かんりしゃゆーざー2",0,"admin2@gmail.com",1,0,now(),now()),
	(15,"admin3","admin3","インターノウス","管理者ユーザー3","いんたーのうす","かんりしゃゆーざー3",0,"admin3@gmail.com",1,0,now(),now()),
	(16,"admin4","admin4","インターノウス","管理者ユーザー4","いんたーのうす","かんりしゃゆーざー4",0,"admin4@gmail.com",1,0,now(),now()),
	(17,"admin5","admin5","インターノウス","管理者ユーザー5","いんたーのうす","かんりしゃゆーざー5",0,"admin5@gmail.com",1,0,now(),now()),
	(18,"admin6","admin6","インターノウス","管理者ユーザー6","いんたーのうす","かんりしゃゆーざー6",0,"admin6@gmail.com",1,0,now(),now()),
	(19,"admin7","admin7","インターノウス","管理者ユーザー7","いんたーのうす","かんりしゃゆーざー7",0,"admin7@gmail.com",1,0,now(),now()),
	(20,"admin8","admin8","インターノウス","管理者ユーザー8","いんたーのうす","かんりしゃゆーざー8",0,"admin8@gmail.com",1,0,now(),now()),
	(21,"admin9","admin9","インターノウス","管理者ユーザー9","いんたーのうす","かんりしゃゆーざー9",0,"admin9@gmail.com",1,0,now(),now()),
	(22,"admin10","admin10","インターノウス","管理者ユーザー10","いんたーのうす","かんりしゃゆーざー10",0,"admin10@gmail.com",1,0,now(),now()),
	(23,"admin11","admin11","インターノウス","管理者ユーザー11","いんたーのうす","かんりしゃゆーざー11",0,"admin11@gmail.com",1,0,now(),now()),
	(24,"admin12","admin12","インターノウス","管理者ユーザー12","いんたーのうす","かんりしゃゆーざー12",0,"admin12@gmail.com",1,0,now(),now());
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
/*画像・10以降の値段後から修正します*/
insert into product_info values
	(1,1,"ソファ","そふぁ","リビングルーム詳細1",2,50000,"./images/product","noimage.jpg",now(),"会社1",0,now(),now()),
	(2,2,"クッション","くっしょん","リビングルーム詳細2",2,3000,"./images/product","noimage.jpg",now(),"会社2",0,now(),now()),
	(3,3,"カーテン","かーてん","リビングルーム詳細3",2,5000,"./images/product","noimage.jpg",now(),"会社3",0,now(),now()),
	(4,4,"ローテーブル","ろーてーぶる","リビングルーム詳細4",2,15000,"./images/product","noimage.jpg",now(),"会社4",0,now(),now()),
	(5,5,"ダイニングテーブル","だいにんぐてーぶる","リビングルーム詳細5",2,20000,"./images/product","noimage.jpg",now(),"会社5",0,now(),now()),
	(6,6,"ダイニングチェア","だいにんぐちぇあ","リビングルーム詳細6",2,7000,"./images/product","noimage.jpg",now(),"会社6",0,now(),now()),
	(7,7,"ラグ","らぐ","リビングルーム詳細7",2,6000,"./images/product","noimage.jpg",now(),"会社7",0,now(),now()),
	(8,8,"時計","とけい","リビングルーム詳細8",2,2000,"./images/product","noimage.jpg",now(),"会社8",0,now(),now()),
	(9,9,"フロアライト","ふろあらいと","リビングルーム詳細9",2,3000,"./images/product","noimage.jpg",now(),"会社9",0,now(),now()),
	(10,10,"学習机","がくしゅうつくえ","キッズルーム詳細1",3,1000,"./images/product","noimage.jpg",now(),"会社10",0,now(),now()),
	(11,11,"学習イス","がくしゅういす","キッズルーム詳細2",3,1000,"./images/product","noimage.jpg",now(),"会社11",0,now(),now()),
	(12,12,"二段ベッド","にだんべっど","キッズルーム詳細3",3,1000,"./images/product","noimage.jpg",now(),"会社12",0,now(),now()),
	(13,13,"ランドセルラック","らんどせるらっく","キッズルーム詳細4",3,1000,"./images/product","noimage.jpg",now(),"会社13",0,now(),now()),
	(14,14,"キッズカーテン","きっずかーてん","キッズルーム詳細5",3,1000,"./images/product","noimage.jpg",now(),"会社14",0,now(),now()),
	(15,15,"キッズラグ","きっずらぐ","キッズルーム詳細6",3,1000,"./images/product","noimage.jpg",now(),"会社15",0,now(),now()),
	(16,16,"小物トレー","こものとれー","キッズルーム詳細7",3,1000,"./images/product","noimage.jpg",now(),"会社16",0,now(),now()),
	(17,17,"ぬいぐるみ","ぬいぐるみ","キッズルーム詳細8",3,1000,"./images/product","noimage.jpg",now(),"会社17",0,now(),now()),
	(18,18,"ウォールステッカー","うぉーるすてっかー","キッズルーム詳細9",3,1000,"./images/product","noimage.jpg",now(),"会社18",0,now(),now()),
	(19,19,"食器棚","しょっきだな","キッチン詳細1",4,1000,"./images/product","noimage.jpg",now(),"会社19",0,now(),now()),
	(20,20,"レンジラック","れんじらっく","キッチン詳細2",4,1000,"./images/product","noimage.jpg",now(),"会社20",0,now(),now()),
	(21,21,"ダストボックス","だすとぼっくす","キッチン詳細3",4,1000,"./images/product","noimage.jpg",now(),"会社21",0,now(),now()),
	(22,22,"キッチンマット","きっちんまっと","キッチン詳細4",4,1000,"./images/product","noimage.jpg",now(),"会社22",0,now(),now()),
	(23,23,"調味料入れ","ちょうみりょういれ","キッチン詳細5",4,1000,"./images/product","noimage.jpg",now(),"会社23",0,now(),now()),
	(24,24,"カトラリーケース","かとらりーけーす","キッチン詳細6",4,1000,"./images/product","noimage.jpg",now(),"会社24",0,now(),now()),
	(25,25,"トレー","とれー","キッチン詳細7",4,1000,"./images/product","noimage.jpg",now(),"会社25",0,now(),now()),
	(26,26,"ランチョンマット","らんちょんまっと","キッチン詳細8",4,1000,"./images/product","noimage.jpg",now(),"会社26",0,now(),now()),
	(27,27,"コースター","こーすたー","キッチン詳細9",4,1000,"./images/product","noimage.jpg",now(),"会社27",0,now(),now()),
	(28,28,"ベッドフレーム","べっどふれーむ","ベッドルーム詳細1",5,1000,"./images/product","noimage.jpg",now(),"会社28",0,now(),now()),
	(29,29,"マットレス","まっとれす","ベッドルーム詳細2",5,1000,"./images/product","noimage.jpg",now(),"会社29",0,now(),now()),
	(30,30,"敷布団","しきふとん","ベッドルーム詳細3",5,1000,"./images/product","noimage.jpg",now(),"会社30",0,now(),now()),
	(31,31,"シーツ","しーつ","ベッドルーム詳細4",5,1000,"./images/product","noimage.jpg",now(),"会社31",0,now(),now()),
	(32,32,"ボックスシーツ","ぼっくすしーつ","ベッドルーム詳細5",5,1000,"./images/product","noimage.jpg",now(),"会社32",0,now(),now()),
	(33,33,"掛け布団","かけふとん","ベッドルーム詳細6",5,1000,"./images/product","noimage.jpg",now(),"会社33",0,now(),now()),
	(34,34,"掛け布団カバー","かけふとんかばー","ベッドルーム詳細7",5,1000,"./images/product","noimage.jpg",now(),"会社34",0,now(),now()),
	(35,35,"枕","まくら","ベッドルーム詳細8",5,1000,"./images/product","noimage.jpg",now(),"会社35",0,now(),now()),
	(36,36,"枕カバー","まくらかばー","ベッドルーム詳細9",5,1000,"./images/product","noimage.jpg",now(),"会社36",0,now(),now()),
	(37,37,"シャワーカーテン","しゃわーかーてん","バスルーム詳細1",6,1000,"./images/product","noimage.jpg",now(),"会社37",0,now(),now()),
	(38,38,"洗面器","せんめんき","バスルーム詳細2",6,1000,"./images/product","noimage.jpg",now(),"会社38",0,now(),now()),
	(39,39,"風呂イス","ふろいす","バスルーム詳細3",6,1000,"./images/product","noimage.jpg",now(),"会社39",0,now(),now()),
	(40,40,"手桶","ておけ","バスルーム詳細4",6,1000,"./images/product","noimage.jpg",now(),"会社40",0,now(),now()),
	(41,41,"ソープディスペンサー","そーぷでぃすぺんさー","バスルーム詳細5",6,1000,"./images/product","noimage.jpg",now(),"会社41",0,now(),now()),
	(42,42,"ボトルラック","ぼとるらっく","バスルーム詳細6",6,1000,"./images/product","noimage.jpg",now(),"会社42",0,now(),now()),
	(43,43,"バスボール","ばすぼーる","バスルーム詳細7",6,1000,"./images/product","noimage.jpg",now(),"会社43",0,now(),now()),
	(44,44,"タオル","たおる","バスルーム詳細8",6,1000,"./images/product","noimage.jpg",now(),"会社44",0,now(),now()),
	(45,45,"バスマット","ばすまっと","バスルーム詳細9",6,1000,"./images/product","noimage.jpg",now(),"会社45",0,now(),now());
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

insert into m_category values
	(1,1,"全てのカテゴリ","お家全体のインテリアが対象となります",now(),null),
	(2,2,"リビングルーム","リビングルームのインテリアが対象となります",now(),null),
	(3,3,"キッズルーム","キッズルームのインテリアが対象となります",now(),null),
	(4,4,"キッチン","キッチンのインテリアが対象となります",now(),null),
	(5,5,"ベッドルーム","ベッドルームのインテリアが対象となります",now(),null),
	(6,6,"バスルーム","バスルームのインテリアが対象となります",now(),null);
/*カテゴリマスタテーブルここまで*/
