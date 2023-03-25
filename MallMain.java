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

		custom.preCustomer(); // ȸ�� �̸� �Է�
		goods.preGoods();	  // ��ǰ �̸� �Է�

		mainMenu();

	}

	static void mainMenu() {

		while (!isNext) {

			System.out.println("Menu�� �����ϼ���");
			System.out.print("[1]�α���  \t");
			System.out.println("[2]ȸ������");
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

			System.out.println("Menu�� �����ϼ���");
			System.out.print("[1]��ǰ���� \t");
			System.out.print("[2]��ٱ��� \t");
			System.out.print("[3]������  \t");
			System.out.println("[4]�α׾ƿ�");

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
