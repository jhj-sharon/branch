package mall;

public class Goods {
	private int gId;
	private String gName;
	private int gPrice;

	public Goods() {
	}

	public Goods(int gId, String gName, int gPrice) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgPrice() {
		return gPrice;
	}

	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId=gId;
	}

	@Override
	public String toString() {
		return "Goods [gName=" + gName + ", gPrice=" + gPrice + ", id=" + gId
				+ "]";
	}
}
