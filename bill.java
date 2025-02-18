import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class bill extends JPanel {
	
private Image img;
private JFrame f;

public bill()
{
    loadImage("/images/shopping-bag.jpg");


		                  
		                          String jdbc_Url = "jdbc:sqlserver://SANJAY-1011:1433;databaseName=project;user=deepak;password=123;encrypt=true;trustServerCertificate=true;";

		        
		     f=new JFrame("BILLING");
		    JLabel l=new JLabel("CUSTOMER ID");
		    JLabel l1=new JLabel("NAME");
		    JLabel l2=new JLabel("ADDRESS");
		    JLabel l3=new JLabel("BILL ID");
		    JLabel l4=new JLabel("DOP");
		    JTextField t=new JTextField();
		    JTextField t1=new JTextField();
		    JTextField t2=new JTextField();
		    JTextField t3=new JTextField();
		    JTextField t4=new JTextField();
		    JButton b=new JButton("CLICK");
		    JButton b1=new JButton("INSERT");
		    JButton b2=new JButton("DELETE");
		    JButton b3=new JButton("BILL");

		    JLabel l5=new JLabel("PRODUCT");
		    JLabel l6=new JLabel("QTY");
		    JLabel l7=new JLabel("PRICE");
		    JLabel l8=new JLabel("NET PRICE");
		    JLabel l9=new JLabel("TOTAL");
		    JLabel l10=new JLabel("STOCK");
		    String s[] = {"", "1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21", "22", "23","24","25","26","27","28","29","30"};
		        JComboBox<String> c= new JComboBox<>(s);
		        
		    String s1[] = {"", "KILOGRAM", "GRAMS", "LITRE"};
		        JComboBox<String> c1 = new JComboBox<>(s1);
		        
		    JTextField t5=new JTextField();
		    JTextField t6=new JTextField();
		    JTextField t7=new JTextField();
		    JTextField t8=new JTextField();
		    JTextField t9=new JTextField();
		    JTextField t10=new JTextField();
		    JTextArea txtbill=new JTextArea();
		   
		    JButton b4=new JButton("ENTER");
		    JButton b5=new JButton("CLEAR");
		    JButton b6=new JButton("PRINT");

		     DefaultTableModel model = new DefaultTableModel();
		        model.addColumn("PRODUCT");
		        model.addColumn("QTY");
		        model.addColumn("PRICE");
		        model.addColumn("NET PRICE");
		        
		        

		        JTable j = new JTable(model);
		        JScrollPane sp = new JScrollPane(j);
		    
		    setLayout(null);
		    
		    l.setBounds(30,30,120,30);
		    t.setBounds(170,30,120,30);

		    l1.setBounds(30,90,120,30);
		    t1.setBounds(170,90,120,30);

		    l2.setBounds(30,150,120,30);  
		    t2.setBounds(170,150,120,30);  

		    l3.setBounds(320,30,120,30);
		    t3.setBounds(400,30,160,30);

		    l4.setBounds(320,90,120,30);
		    t4.setBounds(400,90,160,30);

		    b.setBounds(625,90,120,30);
		    b1.setBounds(825,30,120,30);
		    b3.setBounds(825,90,120,30);
		    b2.setBounds(825,150,120,30);
		    b6.setBounds(825,210 ,120, 30);

		    l5.setBounds(30,210,120,30); 
		   t5.setBounds(170,210,120,30);
		    l6.setBounds(30,270,120,30); 
		    c.setBounds(170,270,120,30);
		    c1.setBounds(320, 270, 150,30);
		    l7.setBounds(30,330,120,30); 
		    t7.setBounds(170,330,120,30);
		    l10.setBounds(320, 150, 120,30);
		    t10.setBounds(400,150,160,30);
		    l8.setBounds(30,390,120,30); 
		    t8.setBounds(170,390,120,30);
		    l9.setBounds(320,210,120,30);
		   t9.setBounds(400,210 , 160, 30);
		    b4.setBounds(170,460, 120, 30);
		    b5.setBounds(350, 460, 120,30);
		    sp.setBounds(500, 250, 450, 250);
		    txtbill.setBounds(980, 100,310, 400);

		    t3.setEditable(false);
		    t4.setEditable(false);
		    t7.setEditable(false);
		    t8.setEditable(false);
		    t9.setEditable(false);
		    t10.setEditable(false);
		    txtbill.setEditable(false);
		    l.setFont((new Font("Arial", Font.BOLD, 16)));
		    l1.setFont((new Font("Arial", Font.BOLD, 16)));
		    l2.setFont((new Font("Arial", Font.BOLD, 16)));
		    l3.setFont((new Font("Arial", Font.BOLD, 16)));
		    l4.setFont((new Font("Arial", Font.BOLD, 16)));
		    l5.setFont((new Font("Arial", Font.BOLD, 16)));
		    l6.setFont((new Font("Arial", Font.BOLD, 16)));
		    l7.setFont((new Font("Arial", Font.BOLD, 16)));
		    l8.setFont((new Font("Arial", Font.BOLD, 16)));
		    l9.setFont((new Font("Arial", Font.BOLD, 16)));
		    l10.setFont((new Font("Arial", Font.BOLD, 16)));

		    sp.setFont((new Font("Arial", Font.BOLD, 16)));
		    c.setFont((new Font("Arial", Font.BOLD, 16)));
		     t.setFont((new Font("Arial", Font.BOLD, 16)));
		    t1.setFont((new Font("Arial", Font.BOLD, 16)));
		    t2.setFont((new Font("Arial", Font.BOLD, 16)));
		    t3.setFont((new Font("Arial", Font.BOLD, 16)));
		    t4.setFont((new Font("Arial", Font.BOLD, 16)));
		    t5.setFont((new Font("Arial", Font.BOLD, 16)));
		    t6.setFont((new Font("Arial", Font.BOLD, 16)));
		    t7.setFont((new Font("Arial", Font.BOLD, 16)));
		    t8.setFont((new Font("Arial", Font.BOLD, 16)));
		    t9.setFont((new Font("Arial", Font.BOLD, 16)));
		    t10.setFont((new Font("Arial", Font.BOLD, 16)));

		    b.setFont((new Font("Arial", Font.BOLD, 16)));
		    b1.setFont((new Font("Arial", Font.BOLD, 16)));
		    b2.setFont((new Font("Arial", Font.BOLD, 16)));
		    b3.setFont((new Font("Arial", Font.BOLD, 16)));
		    b4.setFont((new Font("Arial", Font.BOLD, 16)));
		    b5.setFont((new Font("Arial", Font.BOLD, 16)));
		    b6.setFont((new Font("Arial", Font.PLAIN, 16)));



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
		    b5.setBackground(Color.BLACK);
		    b5.setForeground(Color.WHITE);
		    b6.setBackground(Color.BLACK);
		    b6.setForeground(Color.WHITE);
		    
		    add(l4);add(l3);add(l2);add(l1);add(l);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);
		    add(t);add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(t8);add(t9);add(t10);
		  add(b);add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);
		    add(sp);add(c);add(c1);add(txtbill);
		   

		    
		    
	        ImageIcon icon = new ImageIcon(getClass().getResource("/images/shopping-icon-2184065_1280.png"));

		    f.setVisible(true);
		    f.add(this);
	        f.setIconImage(icon.getImage());

		    f.setSize(1310,625);
	        f.setLocationRelativeTo(null);

		    b.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		if(t.getText().isEmpty()){
		    JOptionPane.showMessageDialog(f, "ENTER CUSTOMER ID", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		else{
		    try (Connection connection = DriverManager.getConnection(jdbc_Url);
				                     Statement statement = connection.createStatement()) {
				            String id=t.getText();
		                                String query = "select *from CUSTOMERINFO  where C_ID='"+id+"'";
		                               ResultSet resultset=statement.executeQuery(query);
		                               while(resultset.next())
		                               {
		                                 String NAME=resultset.getString(2);
		                                 String address=resultset.getString(6);
		                                 String C_ID=resultset.getString(1);
		         if(C_ID.equals(id)){
		t1.setText(NAME);
		t2.setText(address);
		         }
		         }
		        }catch(SQLException ex1) {
		         
		            JOptionPane.showMessageDialog(f, "UNABLE TO GET DATA ","WARNING BOX",JOptionPane.WARNING_MESSAGE);
		         }
		}
		        }
		    });
		    
		   b3.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	if(t9.getText().isEmpty() || t3.getText().isEmpty()){
		    		    JOptionPane.showMessageDialog(f, "FILL ALL DETAILS", "Error", JOptionPane.ERROR_MESSAGE);
		    		    return;
		    		}
		    		else{
		        	
		            String total=t9.getText();
		            String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String billid=t3.getText();
		            DefaultTableModel model=new DefaultTableModel();
		            model=(DefaultTableModel)j.getModel();
		            txtbill.setText(txtbill.getText()+"****************************************************************\n");
		            txtbill.setText(txtbill.getText()+"                             SUPER MARKET                         \n");
		            txtbill.setText(txtbill.getText()+"****************************************************************\n");
		txtbill.setText(txtbill.getText()+"BILL No :"  + billid +"\t" +"\t" +"DOP :" +datetime +"\n" );
		txtbill.setText(txtbill.getText()+"\n");

		            txtbill.setText(txtbill.getText()+ "PRODUCT" +"\t" + "PRICE" + "\t" + "QTY" + "\t"  + "AMOUNT" +"\n");
		            txtbill.setText(txtbill.getText()+"\n");
		            


		            for(int i=0; i<model.getRowCount();i++){
		String product=(String)model.getValueAt(i, 0).toString();
		String qty=(String)model.getValueAt(i, 1).toString();
		String price=(String)model.getValueAt(i, 2).toString();
		String amount=(String)model.getValueAt(i, 3).toString();

		 txtbill.setText(txtbill.getText()+ product +"\t" + price + "\t" + qty + "\t" + amount +"\n");

		                
		      }
		      txtbill.setText(txtbill.getText()+"\n");
		      txtbill.setText(txtbill.getText()+"\n");

		      txtbill.setText(txtbill.getText()+"\t" +"\t"   +"TOTAL : " +total +"\n");

		      txtbill.setText(txtbill.getText()+"\n");

		      txtbill.setText(txtbill.getText()+"****************************************************************\n");
		      txtbill.setText(txtbill.getText()+"                         THANK YOU COME AGAIN                     \n");

		    		}

		        }
		    }); 

		    b4.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            String productName = t5.getText().trim().toUpperCase();
		            if (productName.isEmpty()) {
		                JOptionPane.showMessageDialog(f, "FILL DETAILS", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
		            try (Connection connection = DriverManager.getConnection(jdbc_Url);
		                 Statement statement = connection.createStatement()) {
		                
		                String query = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME='" + productName + "'";
		                ResultSet resultSet = statement.executeQuery(query);
		                
		                if (resultSet.next()) {
		                    String price = resultSet.getString(5);
		                    String stock = resultSet.getString(4);
		                    
		                    int sto;
		                    String[] stockParts = stock.split(" ");
		                    if (stockParts.length > 0) {
		                        sto = Integer.parseInt(stockParts[0]);
		                      
		                        t10.setText(stock);

		    

		    
		                        String unit = (String) c1.getSelectedItem();
		                        int qty = Integer.parseInt((String) c.getSelectedItem());
		                        int price_ = Integer.parseInt(price);
		                        int netPrice = qty * price_;
		                        if(sto<qty){
		                            JOptionPane.showMessageDialog(f, "OUT OF STOCK", "Error", JOptionPane.INFORMATION_MESSAGE);
		                    return;
		                        }
		                       
		                       
		                        else{
		                        t5.setText(productName);
		                        t7.setText(price);
		                        t8.setText(String.valueOf(netPrice));
		    
		                        int balSto = sto - qty;
		                    
		                        t10.setText(Integer.toString(balSto));
		    
		                        String query1 = "UPDATE PRODUCT SET QUANTITY_='" + balSto + " " + unit + "' WHERE PRODUCT_NAME='" + productName + "'";
		                        statement.executeUpdate(query1);
		    
		                        model.addRow(new Object[]{productName, qty + " " + unit, price, netPrice});
		    
		                        int totalNetPrice = 0;
		                        for (int i = 0; i < model.getRowCount(); i++) {
		                            totalNetPrice += (int) model.getValueAt(i, 3);
		                        }
		                        t9.setText(String.valueOf(totalNetPrice));
		                    } }
		                } else {
		                    JOptionPane.showMessageDialog(f, "PRODUCT NOT FOUND", "Error", JOptionPane.ERROR_MESSAGE);
		                
		            }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(f, "DATABASE OPERTAION FAILED", "Error", JOptionPane.ERROR_MESSAGE);
		           }
		        }
		    });
		    
		    
		    b1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            if (t.getText().isEmpty() || t1.getText().isEmpty() || t2.getText().isEmpty() || t5.getText().isEmpty()) {
		                JOptionPane.showMessageDialog(f, "PLEASE FILL ALL DETAILS", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		    
		            try (Connection connection = DriverManager.getConnection(jdbc_Url);
		                 PreparedStatement statement = connection.prepareStatement("INSERT INTO BILL(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS_, PRODUCT_, QTY_, PRICE_, NET_PRICE, TOTAL_, DOP) "
		                         + "VALUES (?, ?, ?, ?,?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
		    
		                String cid = t.getText();
		                String cname = t1.getText();
		                String address = t2.getText();
		                String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		                t4.setText(datetime);
		    
		                StringBuilder products = new StringBuilder();
		                StringBuilder qty = new StringBuilder();
		                StringBuilder price = new StringBuilder();
		                StringBuilder amount = new StringBuilder();
		    
		                for (int i = 0; i < model.getRowCount(); i++) {
		                    String product = (String) model.getValueAt(i, 0).toString();
		                    String qtyValue = (String) model.getValueAt(i, 1).toString();
		                    String priceValue = (String) model.getValueAt(i, 2).toString();
		                    String amountValue = (String) model.getValueAt(i, 3).toString();
		

		                    products.append(product).append(",");
		                    qty.append(qtyValue).append(",");
		                    price.append(priceValue).append(",");
		                    amount.append(amountValue).append(",");
		                }
		    
		                statement.setString(1, cid);
		                statement.setString(2, cname);
		                statement.setString(3, address);
		                statement.setString(4, products.toString());
		                statement.setString(5, qty.toString());
		                statement.setString(6, price.toString());
		                statement.setString(7, amount.toString());
		                statement.setString(8, t9.getText());
		                statement.setString(9, datetime);
		    
		                int rowsAffected = statement.executeUpdate();
		    
		                if (rowsAffected > 0) {
		                    ResultSet generatedKeys = statement.getGeneratedKeys();
		                    if (generatedKeys.next()) {
		                        int generatedBillId = generatedKeys.getInt(1);
		                        t3.setText(String.valueOf(generatedBillId));
		                    }
		                    JOptionPane.showMessageDialog(f, "SUCCESSFULLY INSERTED", "INFO BOX", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(f, "FAILED TO STORE ", "Warning Box", JOptionPane.WARNING_MESSAGE);
		                }
		    
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(f, "ERROR OCCURRED" + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    });
		    
		    b2.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            DefaultTableModel model = (DefaultTableModel) j.getModel();

		            int[] selectedRows = j.getSelectedRows();

		            if (selectedRows.length == 0) {
		                JOptionPane.showMessageDialog(f, "NO ROW SELECTED", "Error", JOptionPane.ERROR_MESSAGE);
		            } else {
		              
		                for (int i = selectedRows.length - 1; i >= 0; i--) {
		                    model.removeRow(selectedRows[i]);
		                }
		            }
		        }
		    });

		    b6.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e){
		            if(txtbill.getText().isEmpty()){
		                JOptionPane.showMessageDialog(f, "BILL NOT FOUND ", "Error", JOptionPane.ERROR_MESSAGE);
		return;
		            }
		            else{
		                try {
		                txtbill.print();
		            } catch (PrinterException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		    });
		    
		  

		  t.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b.doClick();
		        }
		    }
		  });  
		  t5.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b4.doClick();
		        }
		    }
		  });  
		  t6.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b4.doClick();
		        }
		    }
		  });  
		  t7.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b4.doClick();
		        }
		    }
		  });  t8.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b4.doClick();
		        }
		    }
		  });  t9.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b4.doClick();
		        }
		    }
		  });  
		 c.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b4.doClick();
		        }
		    }
		  });  
		  c1.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b4.doClick();
		        }
		    }
		  }); 
		   t.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });  t1.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  }); 

		   t2.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  }); 
		  t3.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });  t4.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });  t5.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });  
		  t6.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });  t7.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });                  
		  t8.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });  t9.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });
		  t10.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_ENTER){
		            b1.doClick();
		            b4.doClick();
		        }
		    }
		  });
		    c.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		        }
		    }
		  });  c1.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
		            b1.doClick();
		            
		        }
		    }
		  }); 
		 t.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t1.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t2.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t3.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t4.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t5.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t6.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t7.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t8.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t9.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t10.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 txtbill.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 c.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 c1.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown() )
		        {
		            b3.doClick();
		        }
		    }
		 });
		 t.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t1.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t2.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t3.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t4.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t5.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t6.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t7.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t8.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t9.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 t10.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 txtbill.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 c.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });
		 c1.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e){
		        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P  )
		        {
		            b6.doClick();
		        }
		    }
		 });


		    b5.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            t.setText("");
		            t1.setText("");
		            t2.setText("");
		            t3.setText("");
		            t4.setText("");
		            t5.setText("");
		            t6.setText("");
		            t7.setText("");
		            t8.setText("");
		            t9.setText("");
		            t10.setText("");
		            txtbill.setText("");
		            c.setSelectedIndex(0);
		            c1.setSelectedIndex(0);
		            model.setRowCount(0);
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
