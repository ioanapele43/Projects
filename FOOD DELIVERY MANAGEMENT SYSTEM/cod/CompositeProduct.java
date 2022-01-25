package businessLayer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
	//private String title;
	private List<BaseProduct> produse;
	//private int price;
	public CompositeProduct() {
		super.setTitle("");
		produse= new ArrayList<BaseProduct>();
		super.setPrice(0);
	}
	public CompositeProduct(String t, List<BaseProduct> pr, int pret){
		super.setTitle(t);
		produse=pr;
		super.setPrice(pret);
	}
	public void addProduse(BaseProduct pr) {
		produse.add(pr);
		int price=super.getPrice();
		super.setPrice(price+pr.getPrice());
	}
	
	public List<BaseProduct> getProduse() {
		return produse;
	}
	public void setProduse(List<BaseProduct> produse) {
		this.produse = produse;
	}
	
	
}
