package BeanIO;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

public class BeanIORead {

	public static void main(String[] args) throws IllegalArgumentException, FileNotFoundException {
		StreamFactory sf= StreamFactory.newInstance();
		sf.load("C:\\Users\\vishw\\eclipseEE-workspace\\BeanIO\\src\\main\\resources\\mapping.xml");
		
		 BeanReader reader = sf.createReader("stream1", new FileReader("C:\\Users\\vishw\\eclipseEE-workspace\\BeanIO\\src\\main\\resources\\employee1.csv"));
		 
		 Object record;
		 while((record = reader.read()) != null) {
			  Employee emp = (Employee) record;
	            System.out.println(emp.getName());
		 }

	        reader.close();

	}

}
