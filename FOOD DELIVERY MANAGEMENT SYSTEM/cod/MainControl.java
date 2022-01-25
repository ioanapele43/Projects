package mainData;

import dataLayer.Serializator;
import presentationLayer.FirstFrame;

public class MainControl {
	private static MainDataForDelivery maind;
	private static FirstFrame ff;
	public static void afisareFirst() {
		ff.show();
	}
	public static void setmain(MainDataForDelivery md) {
		maind=md;
	}
	public static void main(String[] args) {
		maind=new MainDataForDelivery();
		Serializator s=new Serializator();
		if(s.read()!=null) {
			maind.setOrder(s.read());
		}
		
		ff=new FirstFrame(maind);
		afisareFirst();
		//ff.show();
	}
	
}
