import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;

public class Exit_Form extends Rental_Service
{   
    private static JPanel Top_Panel = new JPanel();
    private static JPanel Bottom_Panel = new JPanel();
    public  static JFrame Payment_frame = new JFrame();
    
    static JPanel Top_Panel1 = new JPanel();
    static JPanel Top_Panel2 = new JPanel();
    static JPanel Bottom_Panel1 = new JPanel();
    static JPanel Bottom_Panel2 = new JPanel();
    
    static JLabel Name_label= new JLabel();
    static JLabel Number_label = new JLabel();
    static JLabel Address_label = new JLabel();
    
    static JTextField Name_field = new JTextField();
    static JTextField Number_field = new JTextField();
    static JTextField Address_field = new JTextField();
    
    static JButton Checkout_btn = new JButton();
    static JButton Return_btn = new JButton();
    
    public static void Payment_Menu(ActionEvent e){
        Payment_frame.setBounds(500,250,800,600);
        Payment_frame.setLayout(new GridLayout(2,1));
        Payment_frame.setTitle("Personal Information");
        
        Top_Panel.setBorder(new TitledBorder("Payment Information"));
        Top_Panel.setLayout(new BorderLayout());
        
        Top_Panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        Name_label.setText("Name : ");
        gbc.gridx= 0;
        gbc.gridy=0;
        gbc.insets = new Insets(0, 100, 30, 50);
        Top_Panel1.add(Name_label,gbc);
        
        Number_label.setText("Mobile Number : ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 100, 30, 50);
        Top_Panel1.add(Number_label, gbc);

        Address_label.setText("Address : ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 100, 30, 50);
        Top_Panel1.add(Address_label, gbc);
        
        Top_Panel2.setLayout(new GridBagLayout());
        
        Name_field.setColumns(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 50, 30, 100);
        Top_Panel2.add(Name_field, gbc);

        Number_field.setColumns(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 50, 30, 100);
        Top_Panel2.add(Number_field, gbc);

        Address_field.setColumns(15);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 50, 30, 100);
        Top_Panel2.add(Address_field, gbc);
        
        Top_Panel.add(BorderLayout.LINE_START,Top_Panel1);
        Top_Panel.add(BorderLayout.LINE_END,Top_Panel2);
        
        Bottom_Panel.setLayout(new BorderLayout());
        
        Bottom_Panel1.setLayout(new GridBagLayout());
        Bottom_Panel1.setBorder(new TitledBorder("Order Summary"));
        Bottom_Panel1.setPreferredSize(new Dimension(500,300));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.ipady=200;
        gbc.ipadx=350;
        Bottom_Panel1.add(Rental_Service.scroll,gbc);
        
        Bottom_Panel2.setLayout(new GridBagLayout());
        Return_btn.setText("Return to Previous Window");
        Return_btn.setBorder(new Rounded_Corners.RoundedBorder(10));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(0,0, 50,50);
        gbc.ipady=0;
        gbc.ipadx=0;
        Bottom_Panel2.add(Return_btn,gbc);
        
        Checkout_btn.setText("Confirm Renting");
        Checkout_btn.setPreferredSize(new Dimension(180,40));
        Checkout_btn.setBorder(new Rounded_Corners.RoundedBorder(10));
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(0,0, 0,50);
        Bottom_Panel2.add(Checkout_btn,gbc);
        
        Bottom_Panel.add(BorderLayout.LINE_START,Bottom_Panel1);
        Bottom_Panel.add(BorderLayout.LINE_END,Bottom_Panel2);
        
        Payment_frame.add(Top_Panel);
        Payment_frame.add(Bottom_Panel);
        Payment_frame.setVisible(true);
        
                    Checkout_btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Payment_frame.setVisible(false);
                    Order_summary(e);
                
                }
            });
            

            
                    Return_btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Payment_frame.setVisible(false);
                    Return(e);
                
                }
            });
    }

    public static void Order_summary(ActionEvent e){
        Costumer_info client = new Costumer_info();
        if (Name_field.getText().isEmpty() == false
        && Number_field.getText().isEmpty() == false 
        && Address_field.getText().isEmpty() == false){
             client.Set_Name(Name_field.getText());
             client.Set_Number(Number_field.getText());
             client.Set_Address(Address_field.getText());
             JOptionPane.showMessageDialog(null,"Thank you for renting, "+client.Get_Name()+"."+
            "\n We will send an order confirmation to : " + client.Get_Address()+
            "\n We will contact you for further inquiries through : "+ client.Get_Number()+
            "\n Your Total Bill is: ₱"+Rental_Service.total_val+" \n Enjoy!","Thank you!",JOptionPane.INFORMATION_MESSAGE);
        }   else{
            JOptionPane.showMessageDialog(null,"Error, Invalid Input : All Fields must not be empty","Error",JOptionPane.ERROR_MESSAGE);
            Payment_frame.setVisible(true);
        }
    }
    public static void Return(ActionEvent e){
            Menu.setVisible(true);
        }
}
