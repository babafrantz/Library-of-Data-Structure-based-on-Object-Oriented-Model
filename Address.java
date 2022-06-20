
import java.util.Objects;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yomol
 */
public class Address {
    

    String number;
    String street;
    String suburb;
    int postcode;
    String state;

    /**
     *
     */
    public Address() {
    }

    public Address(String number, String street, String suburb, int postcode, String state) {
        this.number = number;
        this.street = street;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" + "number=" + number + ", street=" + street + ", suburb=" + suburb + ", postcode=" + postcode + ", state=" + state + '}';
    }
    
    @Override
    public  int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(number);
        hash = 41 * hash + Objects.hashCode(street);
        hash = 41 * hash + Objects.hashCode(suburb);
        hash = 41 * hash + Objects.hashCode(postcode);
        hash = 41 * hash + Objects.hashCode(state);
        return hash;
    }

    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;

        // We are using number attribute here because number in an address is unique. 
        // Two Addreses cannot have the same number.
        if (number != other.number && this.postcode != other.postcode && this.street != other.street) {
            return false;
        }
        return true;
    }
    
    
    class Addresstest{

    
    public void testHashCode(){
        
      
        System.out.println("hashCode");

            Address address1 = new Address("2/2", "Bulolo", "Ashmont", 2650, "NSW");
            Address address2 = new Address("2/2", "Kopenhagen", "maldive", 3458, "Congo");
            Address address3 = new Address("3/26", "Kopenhagen", "maldive", 3458, "Congo");
            Address address4 = address1;
            Address address5 = null;

            int result2 = address2.hashCode();
            System.out.println(result2);
            int result3 = address3.hashCode();
            int result4 = address4.hashCode();

            assertEquals(-747750533, result2);
            assertEquals(1799051754, result2);
            assertEquals(843663701, result3);
            assertEquals(-747750533, result4);
            // TODO review the generated test code and remove the default call to fail.

        }
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Address address1= new Address("2/2","Bulolo","Ashmont",2650,"NSW");
        Address address2 = new Address("2/2","Kopenhagen","maldive",3458,"Congo");
        Address address3 = new Address("3/26","Kopenhagen","maldive",3458,"Congo");
        Address address4 = address1;
        Address address5 = null;
        
       
        boolean expResult1 = false;
           boolean expResult2 = true;
              boolean expResult3 = true;
                 boolean expResult4 = false;
                
        boolean result1 = address1.equals(address2);
           boolean result2 = address2.equals(address3);
              boolean result3 = address4.equals(address1);
                 boolean result4 = address4.equals(address3);
                
                    
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
  
        
        // TODO review the generated test code and remove the default call to fail.
     
    }
    }

    
      
      
     
        
  

}

