package connectionToDatabase;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mainData.MainDataForDelivery;

public class SearchOperations {
	public static  JTable searchByTitle(MainDataForDelivery md,JTable tab,String s) {
		JTable taux=tab;
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().stream()
		.filter(x-> x.getTitle().contains(s) )
		.forEach(pro->{
			
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
			model.addRow(row);
		});
		taux.setModel(model);
		return taux;
	}
	public static JTable searchByRating(MainDataForDelivery md,JTable tab,float val,int tip) {
		JTable taux=tab;
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().stream()
		.filter(x-> (x.getRating()<=val && tip==1)||(x.getRating()>=val && tip==2) )
		.forEach(pro->{
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
			
				model.addRow(row);
			
		});
		taux.setModel(model);
		return taux;
	}
	public static JTable searchByCalories(MainDataForDelivery md,JTable tab,int val,int tip) {
		JTable taux=tab;
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().stream()
		.filter(x-> (x.getCalories()<=val && tip==1)||(x.getCalories()>=val && tip==2) )
		.forEach(pro->{
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
			
				model.addRow(row);
		});
		taux.setModel(model);
		return taux;
	}
	public static JTable searchByProteins(MainDataForDelivery md,JTable tab,int val,int tip) {
		JTable taux=tab;
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().stream()
		.filter(x-> (x.getProteins() <=val && tip==1)||(x.getProteins()>=val && tip==2) )
		.forEach(pro->{
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
			
				model.addRow(row);
		});
		taux.setModel(model);
		return taux;
	}
	public static JTable searchByFats(MainDataForDelivery md,JTable tab,int val,int tip) {
		JTable taux=tab;
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().stream()
		.filter(x-> (x.getFats()<=val && tip==1)||(x.getFats()>=val && tip==2) )
		.forEach(pro->{
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
			
				model.addRow(row);
		});
		taux.setModel(model);
		return taux;
	}
	public static JTable searchBySodium(MainDataForDelivery md,JTable tab,int val,int tip) {
		JTable taux=tab;
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().stream()
		.filter(x-> (x.getSodium()<=val && tip==1)||(x.getSodium()>=val && tip==2) )
		.forEach(pro->{
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
			
				model.addRow(row);
		});
		taux.setModel(model);
		return taux;
	}
	public static JTable searchByPrice(MainDataForDelivery md,JTable tab,int val,int tip) {
		JTable taux=tab;
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().stream()
		.filter(x-> (x.getPrice()<=val && tip==1)||(x.getPrice()>=val && tip==2) )
		.forEach(pro->{
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
				model.addRow(row);
		});
		taux.setModel(model);
		return taux;
	}
}
