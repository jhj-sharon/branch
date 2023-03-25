package mall;

import java.util.Scanner;

public class MallMain {

	static Scanner num = new Scanner(System.in);

	static CustomerManager custom = new CustomerManager();
	static GoodsManager goods = new GoodsManager();
	static LoginManager login = new LoginManager();
	static CartManager cart = new CartManager();

	static boolean isNext = false; 

	public static void main(String[] args) {

		custom.preCustomer(); // 회원 미리 입력
		goods.preGoods();	  // 상품 미리 입력

		mainMenu();

	}

	static void mainMenu() {

		while (!isNext) {

			System.out.println("Menu를 선택하세요");
			System.out.print("[1]로그인  \t");
			System.out.println("[2]회원가입");
			int menu = num.nextInt();

			switch (menu) {
			case 1:
				isNext = login.loginUser();

				break;

			case 2:
				custom.add(custom.inputAdd());
				break;
			}
		}
		shopMenu();
	}

	static void shopMenu() {

		isNext = false;

		while (!isNext) {

			System.out.println("Menu를 선택하세요");
			System.out.print("[1]상품보기 \t");
			System.out.print("[2]장바구니 \t");
			System.out.print("[3]내정보  \t");
			System.out.println("[4]로그아웃");

			int sMenu = num.nextInt();

			switch (sMenu) {
			case 1:
				goods.goodsMenu();
				isNext = true;
				break;
				
			case 2:
				cart.cartMenu();
				isNext = true;
				break;
				
			case 3:
				custom.custMenu();
				isNext = true;
				break;
				
			case 4:
				mainMenu();
				break;

			}
		}
	}

}
