package mall;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodsManager {

	static Map<Object, Object> goods = new HashMap<>();
	
	public void preGoods() {
		goods.put(1001, new Goods(1001, "������", 1000));
		goods.put(1002, new Goods(1002, "������", 4500));
		goods.put(1003,new Goods(1003, "���÷���", 4100));
	}
	
	public void goodsMenu() {

		while (true) {

			Scanner s = new Scanner(System.in);
			System.out.println("�޴��� �����ϼ���");
			System.out.print("[1] ��ǰ ���� ���� \t");
			System.out.print("[2] ��ǰ ���� �߰� \t");
			System.out.print("[3] ��ǰ ���� ���� \t");
			System.out.print("[4] ��ǰ ���� ���� \t");
			System.out.println("[5] ���ư���");

			int menu = s.nextInt();

			switch (menu) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				MallMain.shopMenu();
				break;
			}
		}
	}
	
	
	public void add() {
		
		Scanner s = new Scanner(System.in);
		Scanner u = new Scanner(System.in);
		
		System.out.println("��ǰ��ȣ�� ����ϼ���.");
		int gId=s.nextInt();
		System.out.println("��ǰ���� ����ϼ���.");
		String gName=u.nextLine().trim();
		System.out.println("��ǰ������ ����ϼ���.");
		int gPrice=s.nextInt();
		
		Goods g = new Goods(gId, gName, gPrice);
		
		goods.put(gId, g);
	}

	public void remove() {
		Scanner s = new Scanner(System.in);
		Scanner d = new Scanner(System.in);
		
		System.out.println("��ǰ��ȣ�� �Է��ϼ���");
		int gnum=s.nextInt();
		
		System.out.println("������ �����Ͻðڽ��ϱ�? (y/n)");
		String input = d.nextLine().trim();
		
		if(input.equalsIgnoreCase("y")){
			goods.remove(gnum);
			goodsMenu();
		}else if(input.equalsIgnoreCase("n")){
			goodsMenu();
		}
	}

	public void modify() {
		Scanner mg = new Scanner(System.in);
		Scanner mg2 = new Scanner(System.in);
		
		System.out.println("��ǰ ������ �����մϴ�.");
		System.out.println("��ǰ ��ȣ: ");
		int mgId = mg.nextInt();
		System.out.println("��ǰ��:");
		String mgName = mg2.nextLine().trim();
		System.out.println("��ǰ����:");
		int mgPrice = mg.nextInt();
		
		Goods g = new Goods(mgId, mgName, mgPrice);
		
		goods.put(mgId,g);
		goodsMenu();
	}

	public void display() {
		for (Map.Entry<Object, Object> entry : goods.entrySet()) {
			Goods g = (Goods) entry.getValue();
			System.out.println("��ǰ��ȣ: "+ g.getgId() +"\t" +"��ǰ�� "+g.getgName()+"\t"+"��ǰ����: "+g.getgPrice());
		}
		
		boolean isN=false;
		while(!isN){
		Scanner s = new Scanner(System.in);
		System.out.print("[1]��ٱ��Ͽ� ��� \t");
		System.out.println("[2]���ư���");
		int num = s.nextInt();
				
		switch (num) {
		case 1:
			CartManager c = new CartManager();
			c.add();
			break;
			
		case 2:
			goodsMenu();
			break;
		}
		
		}//end of while
		
		
	}//end of display()
	
}//end of class
