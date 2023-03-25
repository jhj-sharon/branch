package mall;

import java.util.Map;
import java.util.Scanner;

public class CartManager {

	public void cartMenu() {


		while (true) {
			
			Scanner s = new Scanner(System.in);
			System.out.print("<<cartMenu�� �����ϼ���>> \t");
			System.out.print("[1]��ٱ��� ���� \t");
			System.out.print("[2]��ٱ��� ���� \t");
			System.out.print("[3]��ٱ��� ���� \t");
			System.out.println("[4]���ư���");
			int num = s.nextInt();
			
			switch (num) {
			case 1:
				display();
				break;
				
			case 2:
				changeGoods();
				break;

			case 3:
				remove();
				break;

			case 4:
				MallMain.shopMenu();
				break;

			}// end of switch
		}// end of while
	}// end of cartMenu

	public void add(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("���ϴ� ��ǰ��ȣ�� �Է��ϼ���");
		int goodsNo=s.nextInt();
		System.out.println("�����Ͻð��� �ϴ� ������ �Է��ϼ���");
		int ea = s.nextInt();
		
		Cart c = new Cart((Goods)GoodsManager.goods.get(goodsNo), ea);
		
		Customer customer=(Customer)CustomerManager.user.get(LoginManager.logging.get("id"));
		customer.getCart().put((Goods)GoodsManager.goods.get(goodsNo), c);
			
		}//end of add()
	
	public void display(){
		
		for(Map.Entry<Object, Object> entry: ((Map<Object, Object>) LoginManager.logging.get("cart")).entrySet()){
			Cart c=(Cart)entry.getValue();
			System.out.println("��ǰ��ȣ: "+c.getGoods().getgId()+"\t"+"��ǰ��: "+c.getGoods().getgName()+"\t"+"��ǰ���� :"+c.getEa()+"\t"+"��ǰ����: "+c.getSum());
		}
	}
	
	public void changeGoods(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("���ϴ� ��ǰ��ȣ�� �Է��ϼ���");
		int goodsNo=s.nextInt();
		System.out.println("������ �Է��ϼ���");
		int ea = s.nextInt();

		Customer customer=(Customer)CustomerManager.user.get(LoginManager.logging.get("id"));
		Cart c=(Cart)customer.getCart().get((Goods)GoodsManager.goods.get(goodsNo));		
		c.setEa(ea);
	}
	
	public void remove(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("���ϴ� ��ǰ��ȣ�� �Է��ϼ���");
		int goodsNo=s.nextInt();
		
		Customer customer=(Customer)CustomerManager.user.get(LoginManager.logging.get("id"));
		Cart c=(Cart)customer.getCart().remove((Goods)GoodsManager.goods.get(goodsNo));		
	}
	
	
}//end of class
