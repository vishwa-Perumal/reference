package BeanIO;

import java.io.FileWriter;
import java.io.IOException;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

public class BeanIO1 {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		
		StreamFactory sf = StreamFactory.newInstance();
		sf.load("C:\\Users\\vishw\\eclipseEE-workspace\\BeanIO\\src\\main\\resources\\mapping.xml");
		
		BeanWriter bw = sf.createWriter("stream1", new FileWriter("C:\\Users\\vishw\\eclipseEE-workspace\\BeanIO\\src\\main\\resources\\employee1.csv"));
		 Employee e1 = new Employee();
	        e1.setId(1);
	        e1.setName("Vishwa");
	        e1.setRole("Developer");
	        bw.write(e1);
	        
	        
	        
	        Employee e2 = new Employee();
	        e2.setId(112);
	        e2.setName("Vishwa12");
	        e2.setRole("Developer12");

	        bw.write(e2);
	        
	        Employee e11 = new Employee();
            e11.setId(3);
            e11.setName("Anita");
            e11.setRole("Tester");

            bw.write(e11);

            Employee e23 = new Employee();
            e23.setId(4);
            e23.setName("Rahul");
            e23.setRole("Manager");

            bw.write(e23);
	        
	        bw.flush();
	        bw.close();
 

	}

}
