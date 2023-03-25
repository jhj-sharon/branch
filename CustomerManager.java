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
		user.put("gold", new Customer("gold", "gold", "�̼���", "�ֹ�", "010"));
		user.put("silver", new Customer("silver", "silver", "ȫ�浿", "����", "011"));
		user.put("bronze",new Customer("bronze", "bronze", "�������", "�̾�", "019"));
	}

	public Customer inputAdd() {

		Scanner au = new Scanner(System.in);

		System.out.println("id�� �Է��ϼ���");
		id = au.nextLine().trim();
		System.out.println("pwd�� �Է��ϼ���");
		pwd = au.nextLine().trim();
		System.out.println("name�� �Է��ϼ���");
		String name = au.nextLine().trim();
		System.out.println("addr�� �Է��ϼ���");
		String addr = au.nextLine().trim();
		System.out.println("tel�� �Է��ϼ���");
		String tel = au.nextLine().trim();

		Customer customer = new Customer(id, pwd, name, addr, tel);

		return customer;
	}

	public void add(Object o) {
		user.put(id, o);
	}

	public void remove() {
		Scanner s = new Scanner(System.in);
		System.out.println("������ Ż���Ͻðڽ��ϱ�? (y/n)");
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
		
		System.out.println("������ �����մϴ�.");
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
			System.out.println("�޴��� �����ϼ���");
			System.out.print("[1]�� ���� ���� \t");
			System.out.print("[2]�� ���� ���� \t");
			System.out.print("[3]ȸ�� Ż�� \t");
			System.out.println("[4]���ư���");

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
