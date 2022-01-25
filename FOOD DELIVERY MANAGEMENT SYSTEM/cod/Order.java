package businessLayer;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
	private int orderID;
	private int clientID;
	private int livrat;
	private Date data;
	
	//private List<BaseProduct> baseProducts;
	//private List<CompositeProduct> compositeProducts;
	//private List<MenuItem> menuitems;
	private int total;
	public Order(){
		orderID=0;
		clientID=0;
		livrat=0;
		total=0;
		//menuitems=new ArrayList<MenuItem>();
		//baseProducts= new ArrayList<BaseProduct>();
		//compositeProducts=new ArrayList<CompositeProduct>();
	}
	public Order(int o,int c,String date, int t){
		orderID=o;
		clientID=c;
		livrat=0;
		total=t;
		//menuitems=new ArrayList<MenuItem>();
		//baseProducts= new ArrayList<BaseProduct>();
		//compositeProducts=new ArrayList<CompositeProduct>();
	}
	
	public void addBaseProduct(BaseProduct bp) {
		//baseProducts.add(bp);
		//menuitems.add(bp);
		
		total=total+bp.getPrice();
	}
	public void addCompositeProduct(CompositeProduct cp) {
		//compositeProducts.add(cp);
		//menuitems.add(cp);
		total=total+cp.getPrice();
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public int getLivrat() {
		return livrat;
	}
	public void setLivrat(int livrat) {
		this.livrat = livrat;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
