import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;


public class Rental_Service {
        private static JButton Bas_Button = new JButton();
        private static JButton Bad_Button = new JButton();
        private static JButton Ten_Button = new JButton();
        private static JButton Vol_Button = new JButton();
        private static JButton Bil_Button = new JButton();
            
        static JButton Done_Button = new JButton();
        static JTextArea Order_Area = new JTextArea();
        static JFrame Menu = new JFrame();
        
        public static int total_val;
        
        public static JScrollPane scroll = new JScrollPane(Order_Area,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
        ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    public Rental_Service() {
        
        
        Menu.setBounds(500, 250, 800, 600);
        Menu.setTitle("Equipment Rental Service");
        
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        
        
        
        JPanel Panel1 = new JPanel();
        Panel1.setBorder(new TitledBorder("Choose Sports Equipment"));
        Panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Bas_Button.setIcon(new ImageIcon("Basketball.png"));
        Bas_Button.setBorder(new Rounded_Corners.RoundedBorder(10));
        Bas_Button.setPreferredSize(new Dimension(125, 105));
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        Panel1.add(Bas_Button, gbc);

        Bad_Button.setIcon(new ImageIcon("badminton.png"));
        Bad_Button.setBorder(new Rounded_Corners.RoundedBorder(10));
        Bad_Button.setPreferredSize(new Dimension(125, 105));
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 0;
        Panel1.add(Bad_Button, gbc);

        Ten_Button.setIcon(new ImageIcon("Tennis.png"));
        Ten_Button.setBorder(new Rounded_Corners.RoundedBorder(10));
        Ten_Button.setPreferredSize(new Dimension(125, 105));
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 4;
        gbc.gridy = 0;
        Panel1.add(Ten_Button, gbc);

        Vol_Button.setIcon(new ImageIcon("Volleyball.png"));
        Vol_Button.setBorder(new Rounded_Corners.RoundedBorder(10));
        Vol_Button.setPreferredSize(new Dimension(125, 105));
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        Panel1.add(Vol_Button, gbc);

        Bil_Button.setIcon(new ImageIcon("Billiards.png"));
        Bil_Button.setBorder(new Rounded_Corners.RoundedBorder(10));
        Bil_Button.setPreferredSize(new Dimension(125, 105));
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 3;
        gbc.gridy = 1;
        Panel1.add(Bil_Button, gbc);

        main.add(BorderLayout.PAGE_START,Panel1);
        
        JPanel Panel2 = new JPanel();
        Panel2.setBorder(new TitledBorder("Rental Summary"));
        Panel2.setLayout(new GridBagLayout());
        Panel2.setPreferredSize(new Dimension(450,300));
        
        scroll.setPreferredSize(new Dimension(350,300));
        
        Order_Area.setBorder(new Rounded_Corners.RoundedBorder(10));
        Order_Area.setPreferredSize(new Dimension(250,500));
        Order_Area.setEditable(false);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.ipady = 250;
        gbc.ipadx = 250;
        
        Panel2.add(scroll,gbc);
        main.add(BorderLayout.LINE_START,Panel2); 
        
        JPanel Panel3 = new JPanel();
        Panel3.setLayout(new GridBagLayout());
        Panel3.setSize(300,300);
        
        Done_Button.setText("Done");
        Done_Button.setFont(new Font("Arial",Font.PLAIN,18));
        Done_Button.setPreferredSize(new Dimension(90,20));
        Done_Button.setBorder(new Rounded_Corners.RoundedBorder(10));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(200,0, 0, 25);
        gbc.ipady=0;
        gbc.ipadx=0;
        Panel3.add(Done_Button,gbc);
        
        main.add(BorderLayout.LINE_END,Panel3);
        Menu.add(main);
        Menu.setVisible(true);
        
            Bas_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Menu.dispose();
                    Basketball.Equipment_Menu(e);
                }
            });
        
            Bad_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Menu.dispose();
                    Badminton.Equipment_Menu(e);
                }
            });
            
            Ten_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Menu.dispose();
                    Tennis.Equipment_Menu(e);
                }
            });
        
            Vol_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Menu.dispose();
                    Volleyball.Equipment_Menu(e);
                }
            });
            
            Bil_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Menu.dispose();
                    Billiards.Equipment_Menu(e);
                }
            });
            
            Done_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Menu.setVisible(false);
                    Exit_Form.Payment_Menu(e);
                }
            });
    }
    public static void main(String[] args) {
        new Rental_Service();
    }
}
 
