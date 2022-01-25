package businessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import mainData.MainDataForDelivery;
import presentationLayer.Employee;
import presentationLayer.Observer;

public class DeliveryService implements Serializable{
	//private Map<Order,Collection<MenuItem>> comenzi;
	private Order ord;
	private Collection<MenuItem> menuitems;
	
	private MainDataForDelivery mdc;
	public DeliveryService(MainDataForDelivery md) {
		mdc=md;
		ord=new Order();
		menuitems=new ArrayList<MenuItem>();
	}
	
	public void addMenu(MenuItem m) {
		assert m.getTitle().equals("") : "obiect gol";
		int s=menuitems.size();
		menuitems.add(m);
		assert menuitems.size()==s :"nu s-a adaugat ";
	}
	public Order getOrd() {
		return ord;
	}

	public void setOrd(Order ord) {
		this.ord = ord;
	}

	public Collection<MenuItem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(Collection<MenuItem> menuitems) {
		this.menuitems = menuitems;
	}

	/*public void actualizare() {
		comenzi.put(ord,menuitems);
		
	}
	public Map<Order, Collection<MenuItem>> getComenzi() {
		return comenzi;
	}
	public void setComenzi(Map<Order, Collection<MenuItem>> comenzi) {
		this.comenzi = comenzi;
	}
*/
	@Override
	public String toString() {
		return "DeliveryService [ord=" + ord + ", menuitems=" + menuitems + "]";
	}

	

	
}
