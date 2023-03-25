package mall;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//�α��� �������� �� �α����� ���ΰ��� ���� �ӽ� �����
public class LoginManager {

	static Map<Object, Object> logging = new HashMap<Object, Object>();
	static boolean isNext=false;
	
	public boolean loginUser() {

		Scanner lu = new Scanner(System.in);

		System.out.println("id�� �Է��ϼ���");
		String id = lu.nextLine().trim();
		System.out.println("pwd�� �Է��ϼ���");
		String pwd = lu.nextLine().trim();
		
		boolean isUser = CustomerManager.user.containsKey(id);

		if (isUser) {
			Customer u = (Customer) CustomerManager.user.get(id);
			if (u.getPwd().equals(pwd)) {
				System.out.println("���� ����.");
				
				logging.put("id", u.getId());
				logging.put("pwd", u.getPwd());
				logging.put("name", u.getName());
				logging.put("addr", u.getAddr());
				logging.put("tel", u.getTel());
				logging.put("cart", u.getCart());
				
				return true;
				
			} else {
				System.out.println("��й�ȣ�� Ȯ���ϼ���.");
			}
		} else {
			System.out.println("�ش��ϴ� ����ڰ� �����ϴ�.");
		}
		return false;
	}
}
