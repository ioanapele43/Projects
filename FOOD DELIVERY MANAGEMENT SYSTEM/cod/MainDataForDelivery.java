package mainData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;
import presentationLayer.Employee;
import presentationLayer.Observer;
public class MainDataForDelivery implements Serializable {
	private List<BaseProduct> baseProducts;
	private List<CompositeProduct> compositeProducts;
	private List<DeliveryService> order;
	
	public MainDataForDelivery(){
		baseProducts= new ArrayList<BaseProduct>();
		compositeProducts=new ArrayList<CompositeProduct>();
		order=new ArrayList<DeliveryService>();
	}
	public void addOrder(Order o,Collection<MenuItem> cos) {
		DeliveryService d=new DeliveryService(this);
		d.setOrd(o);
		d.setMenuitems(cos);
		
		order.add(d);
		
	}
	public void addBasePr(BaseProduct bp) {
		baseProducts.add(bp);
		
	}
	public void addCompositePr(CompositeProduct cp) {
		compositeProducts.add(cp);
	}
	public List<BaseProduct> removeBasePr(BaseProduct bp) {
		List<BaseProduct> baseProducts2=new ArrayList<BaseProduct>();
		baseProducts.forEach(pro->{
			if(pro.getTitle().equals(bp.getTitle()) && pro.getPrice()==bp.getPrice()) {
				
				System.out.println("a sters!");
			}
			else {
				baseProducts2.add(pro);
			}
		});
		return baseProducts2;
	} 
	public List<BaseProduct> modifyBasePr(BaseProduct bp) {
		List<BaseProduct> baseProducts2=new ArrayList<BaseProduct>();
		baseProducts.forEach(pro->{
			if(pro.getTitle().equals(bp.getTitle()) && pro.getPrice()==bp.getPrice()) {
				
				baseProducts2.add(bp);
			}
			else {
				baseProducts2.add(pro);
			}
		});
		return baseProducts2;
	} 
	
	
	public List<DeliveryService> getOrder() {
		return order;
	}
	public void setOrder(List<DeliveryService> order) {
		this.order = order;
	}
	public void removeCompositePr(CompositeProduct cp) {
		compositeProducts.remove(cp);
	}
	public List<BaseProduct> getBaseProducts() {
		return baseProducts;
	}
	public void setBaseProducts(List<BaseProduct> baseProducts) {
		this.baseProducts = baseProducts;
	}
	public List<CompositeProduct> getCompositeProducts() {
		return compositeProducts;
	}
	public void setCompositeProducts(List<CompositeProduct> compositeProducts) {
		this.compositeProducts = compositeProducts;
	}
	
}
