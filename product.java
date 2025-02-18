import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class product extends JPanel {
   
    private Image img;
    
private JFrame frame;

    public product() {
        loadImage("/images/2148305919.jpg");

     
        String jdbc_Url = "jdbc:sqlserver://SANJAY-1011:1433;databaseName=project;user=deepak;password=123;encrypt=true;trustServerCertificate=true;";

        frame=new JFrame("PRODUCT ENTRY");
        JLabel l = new JLabel("PRODUCT ID");
        JLabel l1 = new JLabel("PRODUCT NAME");
        JLabel l2 = new JLabel("DESCRIPTION");
        JLabel l3 = new JLabel("QUANTITY");
        JLabel l4 = new JLabel("PRICE");
        JLabel l5 = new JLabel("CLIENT NAME");
        JLabel l6 = new JLabel("CONTACT No");
        JTextField t = new JTextField();
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();

        String s1[] = {"", "FRESH FRUITS AND VEGETABLES", "DAIRY PRODUCTS",
                "MEAT AND EAT AND POULTRY",
                "SEA FOOD",
                "BREADS AND BAKERY ITEMS",
                "CANNED GOODS",
                "PASTA AND GRAINS",
                " CEREALS AND OATS",
                "SNACKS"};
        JComboBox<String> c = new JComboBox<>(s1);
        String s2[] = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        JComboBox<String> c1 = new JComboBox<>(s2);
        String s3[] = {"", "KILOGRAM", "GRAMS", "LITRE"};
        JComboBox<String> c2 = new JComboBox<>(s3);
        JButton b = new JButton("INSERT");
        JButton b1 = new JButton("SELECT");
        JButton b2 = new JButton("UPDATE");
        JButton b3 = new JButton("DELETE");
        JButton b4 = new JButton("CLEAR");

        setLayout(null);
        l.setBounds(30, 50, 120, 30);
        t.setBounds(200, 50, 150, 30);
        l1.setBounds(30, 120, 170, 30);
        t1.setBounds(200, 120, 150, 30);
        l2.setBounds(30, 190, 120, 30);
        c.setBounds(200, 190, 150, 30);
        l3.setBounds(30, 260, 120, 30);
        c1.setBounds(200, 260, 70, 30);
        c2.setBounds(300, 260, 100, 30);
        t2.setBounds(425, 260, 150, 30);
        l4.setBounds(30, 330, 120, 30);
        t3.setBounds(200, 330, 150, 30);
        l5.setBounds(30, 400, 120, 30);
        t4.setBounds(200, 400, 150, 30);
        l6.setBounds(30, 470, 120, 30);
        t5.setBounds(200, 470, 150, 30);
        b.setBounds(625, 85, 120, 30);
        b1.setBounds(625, 170, 120, 30);
        b2.setBounds(625, 255, 120, 30);
        b3.setBounds(625, 340, 120, 30);
        b4.setBounds(625, 425, 120, 30);
        l.setFont((new Font("Arial", Font.BOLD, 16)));
        l1.setFont((new Font("Arial", Font.BOLD, 16)));
        l2.setFont((new Font("Arial", Font.BOLD, 16)));
        l3.setFont((new Font("Arial", Font.BOLD, 16)));
        l4.setFont((new Font("Arial", Font.BOLD, 16)));
        l5.setFont((new Font("Arial", Font.BOLD, 16)));
        l6.setFont((new Font("Arial", Font.BOLD, 16)));
        t.setFont((new Font("Arial", Font.BOLD, 16)));
        t1.setFont((new Font("Arial", Font.BOLD, 16)));
        t2.setFont((new Font("Arial", Font.BOLD, 16)));
        t3.setFont((new Font("Arial", Font.BOLD, 16)));
        t4.setFont((new Font("Arial", Font.BOLD, 16)));
        t5.setFont((new Font("Arial", Font.BOLD, 16)));
        c.setFont((new Font("Arial", Font.BOLD, 16)));
        c1.setFont((new Font("Arial", Font.BOLD, 16)));
        c2.setFont((new Font("Arial", Font.BOLD, 16)));

        b.setFont((new Font("Arial", Font.BOLD, 16)));
        b1.setFont((new Font("Arial", Font.BOLD, 16)));
        b2.setFont((new Font("Arial", Font.BOLD, 16)));
        b3.setFont((new Font("Arial", Font.BOLD, 16)));
        b4.setFont((new Font("Arial", Font.BOLD, 16)));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);

        t2.setEditable(false);
        

        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(t);
        add(t1);
        add(t4);
        add(t5);
        add(t2);
        add(t3);
        add(l4);
        add(l5);
        add(l6);
        add(c);
        add(c1);
        add(c2);
        add(b);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/shopping-icon-2184065_1280.png"));

       frame. setVisible(true);
        frame.setSize(820, 625);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setIconImage(icon.getImage());

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t.getText().isEmpty() || t1.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "FILL ALL DETAILS", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    try (Connection connection = DriverManager.getConnection(jdbc_Url);
                         Statement statement = connection.createStatement()) {

                        String selectedOption1 = (String) c1.getSelectedItem();
                        String selectedOption2 = (String) c2.getSelectedItem();
                        String textToSet = selectedOption1 + " " + selectedOption2;
                        t2.setText(textToSet);

                        String price = t3.getText();
                        String des = (String) c.getSelectedItem();
                        String id = t.getText();
                        String pname = t1.getText().toUpperCase();
                        String cname = t4.getText().toUpperCase();
                        String cno = t5.getText();
                        String query = "INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_NAME, DESCRIPTION_, QUANTITY_, PRICE, CLIENT_NAME, CONTACT_NO) VALUES ('" + id + "', '" + pname + "', '" + des + "', '" + textToSet + "', '" + price + "', '" + cname + "','" + cno + "')";
                        int rowsAffected = statement.executeUpdate(query);
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Successfully Inserted.", "INFO BOX", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Failed to store", "WARNING BOX", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if (t.getText().isEmpty()) 
                {
                  JOptionPane.showMessageDialog(frame, "ENTER ID TO SEARCH", "Error", JOptionPane.ERROR_MESSAGE);
                  return;
              }
              else{
				   try (Connection connection = DriverManager.getConnection(jdbc_Url);
		                     Statement statement = connection.createStatement()) {
		                String ID=t.getText();
 

		                    String query = "select *from PRODUCT  where PRODUCT_ID='"+ID+"' ";
		                    
		                  ResultSet resultset=statement.executeQuery(query);
				
				  
			
				while(resultset.next())
				{
					String PRODUCT_NAME=resultset.getString(2);
          t1.setText(PRODUCT_NAME);

          String selectedProductCategory = resultset.getString(3);
          c.setSelectedItem(selectedProductCategory);

          String selectedQuantity = resultset.getString(4);
          String[] quantityParts = selectedQuantity.split(" ");
          c1.setSelectedItem(quantityParts[0]);
          c2.setSelectedItem(quantityParts[1]);

               String QUANTITY_=resultset.getString(4);
               t2.setText(QUANTITY_);
               String price=resultset.getString(5);
               t3.setText(price);
					
				String CLIENT_NAME=resultset.getString(6);
                t4.setText(CLIENT_NAME);
                String CONTACT_NO=resultset.getString(7);
                t5.setText(CONTACT_NO);				
				  }
				  }catch(SQLException ex1) {
					   
	                   JOptionPane.showMessageDialog(frame, "UNABLE TO GET DATA ","WARNING BOX",JOptionPane.WARNING_MESSAGE);

				   }
			}	}
			
		});
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t.getText().isEmpty() || t1.getText().isEmpty()|| t4.getText().isEmpty()|| t5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "FILL ALL DETAILS", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    try (Connection connection = DriverManager.getConnection(jdbc_Url);
                         Statement statement = connection.createStatement()){
        
                        String selectedOption1 = (String) c1.getSelectedItem();
                        String selectedOption2 = (String) c2.getSelectedItem();
                        String textToSet = selectedOption1 + " " + selectedOption2;
                        t2.setText(textToSet);
                      
                       String price=t3.getText();
        
                        String id = t.getText();
                        String pname = t1.getText().toUpperCase();
                        String des = (String) c.getSelectedItem();
                        String cname = t4.getText().toUpperCase();
                        String cno = t5.getText();
        
                        String query = "UPDATE PRODUCT SET PRODUCT_NAME='" + pname + "', DESCRIPTION_='" + des + "', QUANTITY_='" + textToSet + "', PRICE='" + price + "', CLIENT_NAME='" + cname + "', CONTACT_NO='" + cno + "' WHERE PRODUCT_ID='" + id + "'";
                        int rowsAffected = statement.executeUpdate(query);
        
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Successfully Updated.", "INFO BOX",JOptionPane.INFORMATION_MESSAGE);
                      
                 } else {
                            JOptionPane.showMessageDialog(frame, "Failed to Update.","WARNING BOX",JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try(Connection connection=DriverManager.getConnection(jdbc_Url);
                        
                        Statement statement=connection.createStatement()){
                    
                       String ID = t.getText();
            
                        
                        String query="delete from PRODUCT where PRODUCT_ID ='"+ID+"'";
                       
                        int resultset=statement.executeUpdate(query);
                        
                        if(resultset>0)
                        {
                            JOptionPane.showMessageDialog(frame, "SUCCESSFULLY REMOVED", "INFO BOX",JOptionPane.INFORMATION_MESSAGE);
                          
                                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame, "FALIED TO DELETE", "INFO BOX",JOptionPane.WARNING_MESSAGE);

                        }
                    
                }catch(SQLException ex) {
                    System.out.println(ex);
                    
                }
                
            }
        });
 t.addKeyListener(new KeyAdapter(){
    public void  keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            b.doClick();
        }
    }
 });
                t1.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER)
                        {
                            b.doClick();
                        }
                    }
                });
                t2.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                            b.doClick();
                        }
                    }
                });
                t3.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                            b.doClick();
                        }
                    }
                });
                t4.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                            b.doClick();
                        }
                    }
                });
                t5.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                            b.doClick();
                        }
                    }
                });
                c.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                            b.doClick();
                        }
                    }
                });
                c1.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                            b.doClick();
                        }
                    }
                });
            c2.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                            b.doClick();
                        }
                    }
                });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                c.setSelectedIndex(0);
                c1.setSelectedIndex(0);
                c2.setSelectedIndex(0);
            }
        });
    
    }
 


    
    private void loadImage(String path) {
        try {
            URL url = getClass().getResource(path);
            if (url == null) {
                throw new IOException("Cannot find resource: " + path);
            }
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
