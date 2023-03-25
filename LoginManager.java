package mall;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//로그인 성공여부 및 로그인한 쇼핑객의 정보 임시 저장소
public class LoginManager {

	static Map<Object, Object> logging = new HashMap<Object, Object>();
	static boolean isNext=false;
	
	public boolean loginUser() {

		Scanner lu = new Scanner(System.in);

		System.out.println("id를 입력하세요");
		String id = lu.nextLine().trim();
		System.out.println("pwd를 입력하세요");
		String pwd = lu.nextLine().trim();
		
		boolean isUser = CustomerManager.user.containsKey(id);

		if (isUser) {
			Customer u = (Customer) CustomerManager.user.get(id);
			if (u.getPwd().equals(pwd)) {
				System.out.println("접속 성공.");
				
				logging.put("id", u.getId());
				logging.put("pwd", u.getPwd());
				logging.put("name", u.getName());
				logging.put("addr", u.getAddr());
				logging.put("tel", u.getTel());
				logging.put("cart", u.getCart());
				
				return true;
				
			} else {
				System.out.println("비밀번호를 확인하세요.");
			}
		} else {
			System.out.println("해당하는 사용자가 없습니다.");
		}
		return false;
	}
}
