package mall;

public class Cart {

	private Goods goods;
	private int ea;

	public Cart() {
	}

	public Cart(Goods goods, int ea) {
		super();
		this.goods = goods;
		this.ea = ea;
		int sum=getSum();
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getSum() {
		int sum = goods.getgPrice() * ea;
		return sum;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
			this.ea = ea;
	}

}
