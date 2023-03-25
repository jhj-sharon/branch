package mall;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {

	static String id;
	static String pwd;
	static String name;
	static String addr;
	static String tel;

	static Map<Object, Object> user = new HashMap<>();

	public void preCustomer() {
		user.put("gold", new Customer("gold", "gold", "이순신", "쌍문", "010"));
		user.put("silver", new Customer("silver", "silver", "홍길동", "수유", "011"));
		user.put("bronze",new Customer("bronze", "bronze", "세종대왕", "미아", "019"));
	}

	public Customer inputAdd() {

		Scanner au = new Scanner(System.in);

		System.out.println("id를 입력하세요");
		id = au.nextLine().trim();
		System.out.println("pwd를 입력하세요");
		pwd = au.nextLine().trim();
		System.out.println("name를 입력하세요");
		String name = au.nextLine().trim();
		System.out.println("addr를 입력하세요");
		String addr = au.nextLine().trim();
		System.out.println("tel를 입력하세요");
		String tel = au.nextLine().trim();

		Customer customer = new Customer(id, pwd, name, addr, tel);

		return customer;
	}

	public void add(Object o) {
		user.put(id, o);
	}

	public void remove() {
		Scanner s = new Scanner(System.in);
		System.out.println("정말로 탈퇴하시겠습니까? (y/n)");
		String input = s.nextLine().trim();
		if(input.equalsIgnoreCase("y")){
			user.remove((String)LoginManager.logging.get("id"));
			MallMain.mainMenu();
		}else if(input.equalsIgnoreCase("n")){
			custMenu();
		}
		
	}

	public void modify() {
		
		Scanner mu = new Scanner(System.in);
		
		System.out.println("정보를 수정합니다.");
		System.out.println("pwd:");
		String mpwd = mu.nextLine().trim();
		System.out.println("name:");
		String mname = mu.nextLine().trim();
		System.out.println("addr:");
		String maddr = mu.nextLine().trim();
		System.out.println("tel:");
		String mtel = mu.nextLine().trim();
		
		Customer c = new Customer((String)LoginManager.logging.get("id"), mpwd, mname, maddr, mtel);
		
		user.put((String)LoginManager.logging.get("id"),c);
		
		Customer u = (Customer)user.get(c.getId());
		
		LoginManager.logging.put("pwd", u.getPwd());
		LoginManager.logging.put("name", u.getName());
		LoginManager.logging.put("addr", u.getAddr());
		LoginManager.logging.put("tel", u.getTel());
		
		custMenu();
	}

	public void display() {
		for (Map.Entry<Object, Object> entry : LoginManager.logging.entrySet()) {
			System.out.print(entry.getKey() + " : " + entry.getValue() + "\t");
		}
		
		System.out.println();
		System.out.println();
	}

	public void custMenu() {

		while (true) {

			Scanner s = new Scanner(System.in);
			System.out.println("메뉴를 선택하세요");
			System.out.print("[1]내 정보 보기 \t");
			System.out.print("[2]내 정보 수정 \t");
			System.out.print("[3]회원 탈퇴 \t");
			System.out.println("[4]돌아가기");

			int menu = s.nextInt();

			switch (menu) {
			case 1:
				display();
				break;
			case 2:
				modify();
				break;
			case 3:
				remove();
				break;
			case 4:
				MallMain.shopMenu();
				break;
			}
		}
	}

}
