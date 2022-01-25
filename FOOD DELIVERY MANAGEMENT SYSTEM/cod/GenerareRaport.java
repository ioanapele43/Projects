package connectionToDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import dataLayer.WriteFile;
import mainData.MainDataForDelivery;

public class GenerareRaport {
	private MainDataForDelivery md;
	public GenerareRaport(MainDataForDelivery m) {
		md=m;
	}
	public void timeIntervalOrders(Date d1, Date d2){
		WriteFile wf= new WriteFile("time_intervals_raport.txt");
		md.getOrder()
		.stream()
		.filter(x-> x.getOrd().getData().after(d1) && x.getOrd().getData().before(d2))
		.forEach(ord-> wf.scriere("order "+ord.getOrd().getOrderID()));
		wf.inchidere();
	}
	public void productsOrder(int nrmin){
		WriteFile wf= new WriteFile("products_ordered_more.txt");
		Map<String,Integer> lista=new HashMap<String,Integer>();
		md.getOrder().stream()
		.forEach(o->{
			o.getMenuitems().forEach(mn->{
				if(lista.containsKey(mn.getTitle())) {
					int v=lista.get(mn.getTitle());
					lista.replace(mn.getTitle(), v, v+1);
				}
				else {
					lista.put(mn.getTitle(), 1);
				}
			});
		});
		String s="";
		for(Entry<String,Integer> entry: lista.entrySet()) {
			if(entry.getValue()>nrmin) {
				s=s+entry.getKey()+" -> "+entry.getValue()+"\n";
			}
		}
		wf.scriere(s);
		
		wf.inchidere();
	}
	int nrap;
	int nrcom;
	public void clientsRap(int minord, int minprice) {
		WriteFile wf= new WriteFile("clients_raport.txt");
		List<Integer> idclienti=new ArrayList<Integer>();
		md.getOrder().stream()
		.forEach(ord-> {
			 nrap=0;
			idclienti.forEach(cl->{
				if( ord.getOrd().getClientID()==cl) {
					nrap++;
				}
			});
			if(nrap==0) {
				idclienti.add(ord.getOrd().getClientID());
			}
		});
		idclienti.stream()
		.forEach(cl->{
			nrcom=0;
			md.getOrder().stream()
			.filter(x-> x.getOrd().getClientID()==cl && x.getOrd().getTotal()>minprice)
			.forEach(o->{
				nrcom++;
			});
			if(nrcom>=minord && nrcom!=0) {
				wf.scriere("Clientul"+cl);
			}
		});
		wf.inchidere();
	}
	int count;
	public void productsDay(Date d) {
		WriteFile wf= new WriteFile("products_day_raport.txt");
		Map<String,Integer> lista=new HashMap<String,Integer>();
		md.getOrder().stream()
		.filter(x-> x.getOrd().getData().getDay()==d.getDay())
		.forEach(o->{
			o.getMenuitems().forEach(mn->{
				if(lista.containsKey(mn.getTitle())) {
					int v=lista.get(mn.getTitle());
					lista.replace(mn.getTitle(), v, v+1);
				}
				else {
					lista.put(mn.getTitle(), 1);
				}
			});
		});
		wf.scriere(lista+" ");
		wf.inchidere();
	}
	
	
}
