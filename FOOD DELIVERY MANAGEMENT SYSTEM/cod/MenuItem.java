package businessLayer;

import java.io.Serializable;

public class MenuItem implements Serializable{
	private String title;
	private int price=0;
	private String tip;
	
	//int computePrice() {
	//	return 0; }
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	};
	
		
}
