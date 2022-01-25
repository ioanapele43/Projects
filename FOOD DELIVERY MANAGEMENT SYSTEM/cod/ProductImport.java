package importing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import businessLayer.BaseProduct;
import mainData.MainDataForDelivery;

public class ProductImport {
	
	public MainDataForDelivery importpr(MainDataForDelivery mai) {
		MainDataForDelivery maind=mai;
	String line = "";  
	String splitBy = ",";  
	List<BaseProduct> listaprod=new ArrayList<BaseProduct>();
	try   
	{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("products.csv"));  
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] product = line.split(splitBy);    // use comma as separator  
		String title=product[0];
		try {
			float rating=Float.parseFloat(product[1]);
			int i2=Integer.parseInt(product[2]);
			int i3=Integer.parseInt(product[3]);
			int i4=Integer.parseInt(product[4]);
			int i5=Integer.parseInt(product[5]);
			int i6=Integer.parseInt(product[6]);
			BaseProduct bp=new BaseProduct(product[0],(Float.parseFloat(product[1])),Integer.parseInt(product[2]),Integer.parseInt(product[3]),Integer.parseInt(product[4]),Integer.parseInt(product[5]),Integer.parseInt(product[6]));
			//maind.addBasePr(bp);	
			listaprod.add(bp);
		}
		catch(Exception e) {}
		}  
		List<BaseProduct> listaSortata=listaprod.stream().collect(Collectors.toList()); //stream 
		listaSortata.forEach(prod->{//lambda 
			maind.addBasePr(prod);
		});
		
	} catch (IOException e)   
	{  
	e.printStackTrace();  
	//}  
	}
	return maind;
	}
}
