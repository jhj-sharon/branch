package mall;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodsManager {

	static Map<Object, Object> goods = new HashMap<>();
	
	public void preGoods() {
		goods.put(1001, new Goods(1001, "라이터", 1000));
		goods.put(1002, new Goods(1002, "말보르", 4500));
		goods.put(1003,new Goods(1003, "디스플러스", 4100));
	}
	
	public void goodsMenu() {

		while (true) {

			Scanner s = new Scanner(System.in);
			System.out.println("메뉴를 선택하세요");
			System.out.print("[1] 상품 정보 보기 \t");
			System.out.print("[2] 상품 정보 추가 \t");
			System.out.print("[3] 상품 정보 수정 \t");
			System.out.print("[4] 상품 정보 삭제 \t");
			System.out.println("[5] 돌아가기");

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
		
		System.out.println("상품번호를 등록하세요.");
		int gId=s.nextInt();
		System.out.println("상품명을 등록하세요.");
		String gName=u.nextLine().trim();
		System.out.println("상품가격을 등록하세요.");
		int gPrice=s.nextInt();
		
		Goods g = new Goods(gId, gName, gPrice);
		
		goods.put(gId, g);
	}

	public void remove() {
		Scanner s = new Scanner(System.in);
		Scanner d = new Scanner(System.in);
		
		System.out.println("상품번호를 입력하세요");
		int gnum=s.nextInt();
		
		System.out.println("정말로 삭제하시겠습니까? (y/n)");
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
		
		System.out.println("상품 정보를 수정합니다.");
		System.out.println("상품 번호: ");
		int mgId = mg.nextInt();
		System.out.println("상품명:");
		String mgName = mg2.nextLine().trim();
		System.out.println("상품가격:");
		int mgPrice = mg.nextInt();
		
		Goods g = new Goods(mgId, mgName, mgPrice);
		
		goods.put(mgId,g);
		goodsMenu();
	}

	public void display() {
		for (Map.Entry<Object, Object> entry : goods.entrySet()) {
			Goods g = (Goods) entry.getValue();
			System.out.println("상품번호: "+ g.getgId() +"\t" +"상품명 "+g.getgName()+"\t"+"상품가격: "+g.getgPrice());
		}
		
		boolean isN=false;
		while(!isN){
		Scanner s = new Scanner(System.in);
		System.out.print("[1]장바구니에 담기 \t");
		System.out.println("[2]돌아가기");
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
