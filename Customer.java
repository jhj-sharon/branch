package mall;

import java.util.HashMap;

public class Customer {
	private String id;
	private String pwd;
	private String name;
	private String addr;
	private String tel;
	private HashMap<Object, Object> cart;

	public Customer() {
	}

	public Customer(String id, String pwd, String name, String addr, String tel) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		cart=new HashMap<Object, Object>();
	}
	

	public HashMap<Object, Object> getCart() {
		return this.cart;
	}

	public void setCart(HashMap<Object, Object> cart) {
		this.cart = cart;
	}

//	public Customer(String pwd, String name, String addr, String tel) {
//		super();
//		this.pwd = pwd;
//		this.name = name;
//		this.addr = addr;
//		this.tel = tel;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", addr=" + addr + ", tel=" + tel + "]";
	}

}
