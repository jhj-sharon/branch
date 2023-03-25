package mall;

import java.util.Map;
import java.util.Scanner;

public class CartManager {

	public void cartMenu() {


		while (true) {
			
			Scanner s = new Scanner(System.in);
			System.out.print("<<cartMenu를 선택하세요>> \t");
			System.out.print("[1]장바구니 보기 \t");
			System.out.print("[2]장바구니 수정 \t");
			System.out.print("[3]장바구니 삭제 \t");
			System.out.println("[4]돌아가기");
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
		
		System.out.println("원하는 상품번호를 입력하세요");
		int goodsNo=s.nextInt();
		System.out.println("구입하시고자 하는 수량을 입력하세요");
		int ea = s.nextInt();
		
		Cart c = new Cart((Goods)GoodsManager.goods.get(goodsNo), ea);
		
		Customer customer=(Customer)CustomerManager.user.get(LoginManager.logging.get("id"));
		customer.getCart().put((Goods)GoodsManager.goods.get(goodsNo), c);
			
		}//end of add()
	
	public void display(){
		
		for(Map.Entry<Object, Object> entry: ((Map<Object, Object>) LoginManager.logging.get("cart")).entrySet()){
			Cart c=(Cart)entry.getValue();
			System.out.println("상품번호: "+c.getGoods().getgId()+"\t"+"상품명: "+c.getGoods().getgName()+"\t"+"상품수량 :"+c.getEa()+"\t"+"상품총합: "+c.getSum());
		}
	}
	
	public void changeGoods(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("원하는 상품번호를 입력하세요");
		int goodsNo=s.nextInt();
		System.out.println("수량을 입력하세요");
		int ea = s.nextInt();

		Customer customer=(Customer)CustomerManager.user.get(LoginManager.logging.get("id"));
		Cart c=(Cart)customer.getCart().get((Goods)GoodsManager.goods.get(goodsNo));		
		c.setEa(ea);
	}
	
	public void remove(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("원하는 상품번호를 입력하세요");
		int goodsNo=s.nextInt();
		
		Customer customer=(Customer)CustomerManager.user.get(LoginManager.logging.get("id"));
		Cart c=(Cart)customer.getCart().remove((Goods)GoodsManager.goods.get(goodsNo));		
	}
	
	
}//end of class
