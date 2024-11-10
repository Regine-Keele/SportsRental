import javax.swing.*;
import java.awt.*;
public class Costumer_info
{
    private String Current_name;
    private String Current_number;
    private String Current_address;
    
    public String Get_Name(){
        return Current_name;
    }
    public String Get_Number(){
        return Current_number;
    }
            
    public String Get_Address(){
        return Current_address;
    }
    
        public void Set_Name(String Name){
        this.Current_name = Name;
    }
    
        public void Set_Number(String Number){
        this.Current_number = Number;
    }
    
        public void Set_Address(String Address){
        this.Current_address = Address; 
    }
}
