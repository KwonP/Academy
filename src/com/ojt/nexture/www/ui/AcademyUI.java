package com.ojt.nexture.www.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AcademyUI {
	
	Scanner sc = new Scanner(System.in);	
	
	public AcademyUI() {
		boolean flag = true;
		//メインメニュー表示するためのループ文
		while (flag) {
			menu();
			int choice=0;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				missMatchExCler();
			}

			switch (choice) {
				case 1:
					System.out.println("会員登録へ移動");
					
					boolean flag2 = true;
					while (flag2) {
						typeSelMenu();
						System.out.println("タイプを入力ください");
						int choice2=0;
						try {
							choice2 = sc.nextInt();
						} catch (Exception e) {
							missMatchExCler();
						}
						switch (choice2) {
						case 1:
							//Professor登録
							
							break;
						case 2:
							//Student登録
							
							break;
	
						case 3:
							//Staff登録
							
							break;
	
						case 4:
							flag2 = false;
							break;
	
						default:
							System.out.println("正しくない命令です。");
							break;
						}
	
					}
	
					break;
				case 2:
					String userName;
					String password;
					System.out.println("ログイン画面へ移行");
					System.out.println("会員ID（名前）");
					userName = sc.nextLine();
					password = sc.nextLine();
					break;
				case 3:
					
					break;
				default:
					System.out.println("正しいメニューを選択してください。");
					break;
				}

		}

	}
	
	public void menu() {
		System.out.println("===========アカデミー管理システム=========== \n");
		System.out.println("\t1．会員登録　　　2．ログイン \n");
		System.out.println("======================================");
	}
	
	public void typeSelMenu() {
		System.out.println("==============会員タイプ選択============= \n１．教授　２．学生　３．スタッフ　４．取り消し"
				+ "\n======================================");
	}
	
	public void loginComplMenu(String name) {
		System.out.println("============================================= \n\n"
				+"\t\tようこそ！"+ name + "様!\n\n"
				+"１．担当講義一覧     ２．情報修正     ３．退会     ４．ログアウト\n"
				+ "\n=============================================");
	}
	
	public void missMatchExCler() {
		sc.nextLine();
		System.out.println("メニュー選択は数字を入力してください。");
	}
}
