import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;


public class Tennis extends Rental_Service
{
    private static JPanel Top_Panel = new JPanel();
    private static JPanel Bottom_Panel = new JPanel();
    private static JFrame sport_frame = new JFrame();
    private static JButton Rent_btn = new JButton();
    private static JButton Return_btn = new JButton();
    
    static SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, 10, 1);
    static SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, 10, 1);
    static SpinnerNumberModel model3 = new SpinnerNumberModel(0, 0, 10, 1);
    private static JSpinner Racket_num = new JSpinner(model1);
    private static JSpinner Ball_num = new JSpinner(model2);
    private static JSpinner Court_num = new JSpinner(model3);
    
    static JPanel Top_Panel1 = new JPanel();
    static JPanel Top_Panel2 = new JPanel();
    static String Order = Order_Area.getText();
    
    private static JCheckBox Racket = new JCheckBox("Racket --- ₱100",false);
    private static JCheckBox Ball = new JCheckBox("Ball--- ₱50",false);
    private static JCheckBox Court = new JCheckBox("Court --- ₱300",false);
    
    public static void Equipment_Menu(ActionEvent e){
        sport_frame.setBounds(500,200,800,500);
        sport_frame.setLayout(new GridLayout(2,1));
        sport_frame.setTitle("Badminton Equipment");
        
        Top_Panel.setLayout(new GridLayout(1,2));
        Top_Panel.setBorder(new TitledBorder("Badminton Equipment"));
        
        Top_Panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0, 30, 0);
        Top_Panel1.add(Racket,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0, 30, 0);
        Top_Panel1.add(Ball,gbc);  
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(30,0, 0, 0);
        Top_Panel1.add(Court,gbc);
        
        Top_Panel.add(Top_Panel1);
    
        Top_Panel2.setLayout(new GridBagLayout());    
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0, 30, 0);
        Top_Panel2.add(Racket_num,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0, 30, 0);
        Top_Panel2.add(Ball_num,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(30,0, 0, 0);
        
        Top_Panel2.add(Court_num,gbc);
        Top_Panel.add(Top_Panel2);
                
        Bottom_Panel.setLayout(new BorderLayout());
        
        JPanel Bottom_Panel1 = new JPanel();
        Bottom_Panel1.setLayout(new GridBagLayout());
        
        Rent_btn.setText("Rent Equipment");
        Rent_btn.setBorder(new Rounded_Corners.RoundedBorder(10));
        Rent_btn.setPreferredSize(new Dimension(200,20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,100, 0, 0);
        Bottom_Panel1.add(Rent_btn,gbc);
        
        JPanel Bottom_Panel2 = new JPanel();
        Bottom_Panel2.setLayout(new GridBagLayout());
        
        Return_btn.setText("Return to Previous Screen");
        Return_btn.setBorder(new Rounded_Corners.RoundedBorder(10));
        Return_btn.setPreferredSize(new Dimension(200,20));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0, 0, 100);
        Bottom_Panel2.add(Return_btn,gbc);
        
        Bottom_Panel.add(BorderLayout.LINE_START,Bottom_Panel1);
        Bottom_Panel.add(BorderLayout.LINE_END,Bottom_Panel2);
        
        sport_frame.add(Top_Panel);
        sport_frame.add(Bottom_Panel);
        sport_frame.setVisible(true);
        
            Rent_btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sport_frame.setVisible(false);
                    Order_summary(e);
                
                }
            });
            
            Return_btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sport_frame.setVisible(false);
                    Return(e);
                
                }
            });
    }
    
    public static void Order_summary(ActionEvent e){
            int Racket_val = (Integer) Racket_num.getValue();
            int Court_val = (Integer) Court_num.getValue();
            int Ball_val = (Integer) Ball_num.getValue();
            
            if(Racket.isSelected()&& !Court.isSelected()&&!Ball.isSelected()){
                if(Racket_val > 0){
                int price = 100;
                int val;
                val = price*Racket_val;
                Order_Area.setText("");
                Order_Area.setText(Order+"\nTennis:\n"+"Racket  --- "+Racket_val+" for ₱ "+price+" each"+"\n");
                Rental_Service.total_val +=val;
            }   else{
                Order_Area.setText("Invalid Input");}}
            else if(!Racket.isSelected()&& Court.isSelected()&&!Ball.isSelected()){
                if(Court_val>0){
                Order_Area.setText("");
                int price = 300;
                int val;
                val = price*Court_val;
                Order_Area.setText(Order+"\nTennis:\n"+"Court  --- "+Court_val+" for ₱ "+price+" each"+"\n");
                Rental_Service.total_val +=val;
            }   else{
                Order_Area.setText("Invalid Input");}}
            else if(!Racket.isSelected()&&!Court.isSelected()&&Ball.isSelected()){
                if(Ball_val>0){
                Order_Area.setText("");
                int price = 50;
                int val;
                val = price*Ball_val;
                Order_Area.setText(Order+"\nTennis:\n"+"Ball  --- "+Ball_val+" for ₱ "+price+" each"+"\n");
                Rental_Service.total_val +=val;
            }   else{
                Order_Area.setText("Invalid Input");}}
            else if(Racket.isSelected()&&Court.isSelected()&&!Ball.isSelected()){
                if(Racket_val>0&&Court_val>0){
                Order_Area.setText("");
                int price1 = 100;
                int price2 = 300;
                int val;
                val = (price1*Racket_val)+(price2*Court_val);
                Order_Area.setText(Order+"\nTennis:\n"+"Racket  --- "+Racket_val+" for ₱ "+price1+" each"+"\n"
                +"Court --- "+Court_val+ " for ₱ " +price2+ " each");
                Rental_Service.total_val +=val;
            }   else{
                Order_Area.setText("Invalid Input");}}
            else if(Racket.isSelected()&&!Court.isSelected()&&Ball.isSelected()){
                if(Racket_val>0&&Ball_val>0){
                Order_Area.setText("");
                int price1 = 100;
                int price2 = 50;
                int val;
                val = (price1*Racket_val)+(price2*Ball_val);
                Order_Area.setText(Order+"\nTennis:\n"+"Racket  --- "+Racket_val+" for ₱ "+price1+" each"+"\n"
                +"Ball --- "+Ball_val+ " for ₱ " +price2+ " each");
                Rental_Service.total_val +=val;
            }   else{
                Order_Area.setText("Invalid Input");}}
            else if(!Racket.isSelected()&&Court.isSelected()&&Ball.isSelected()){
                if(Court_val>0&&Ball_val>0){
                Order_Area.setText("");
                int price1 = 50;
                int price2 = 300;
                int val;
                val = (price1*Ball_val)+(price2*Court_val);
                Order_Area.setText(Order+"\nTennis:\n"+"Ball  --- "+Ball_val+" for ₱ "+price1+" each"+"\n"
                +"Court --- "+Court_val+ " for ₱ " +price2+ " each");
                Rental_Service.total_val +=val;
            }   else{
                Order_Area.setText("Invalid Input");}}
            else if(Racket.isSelected()&& Court.isSelected()&&Ball.isSelected()){
                if(Racket_val>0 && Court_val > 0&&Ball_val>0){
                int price1 = 100;
                int price2 = 50;
                int price3 = 300;
                int val;
                val = (price1*Racket_val)+(price2*Ball_val)+(price3*Court_val);
                Order_Area.setText("");
                Order_Area.setText(Order+"\nTennis:\n"+"Racket  --- "+Racket_val+  " for ₱ "+price1+" each"+"\n"
                +"Ball ---"+Ball_val+" for ₱ "+price2+" each"+"\n"
                +"Court ---"+Court_val+" for ₱ "+price3+" each"+"\n");
                Rental_Service.total_val +=val;
            }   else{
                Order_Area.setText("Invalid Input");}}
            else{
                Order_Area.setText("Invalid Input");}

            Menu.setVisible(true);
    }
    
    public static void Return(ActionEvent e){
            Menu.setVisible(true);
    }
}
