package dataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import businessLayer.DeliveryService;
import businessLayer.Order;

public class Serializator {
	File f=new File("fileFromSerialization.ser");
	public  void write(Object object) {
		 // Serialization 
        try
        {   
            //Saving of object in a file
        	
			
            FileOutputStream file = new FileOutputStream(f);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        } 
        catch(IOException ex)
        {
            System.out.println("write error");
        }
	}
	public ArrayList<DeliveryService>  read () {
		Object obj = null;
		//ArrayList<Order> obj =new ArrayList<Order>();
		 // Deserialization
        try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(file);
              
            // Method for deserialization of object
            obj = ((ArrayList<DeliveryService>) in.readObject());
              
            in.close();
            file.close();
              
            System.out.println("Object has been deserialized ");
            
           // System.out.println("client id"+obj.getOrd().getOrderDate());
            
        }
          
        catch(IOException|ClassNotFoundException ex)
        {
            System.out.println("fileFromSerialization is empty");
        }
        return  (ArrayList<DeliveryService>) obj;
          
	}
}
