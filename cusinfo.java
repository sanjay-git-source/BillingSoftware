import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.*;

public class cusinfo extends JPanel {

    private Image img;
    private JFrame frame;
    private JTextField t, t1, t2, t3;
    private JCheckBox r, r1;

    public cusinfo() {
      
        String jdbc_Url = "jdbc:sqlserver://SANJAY-1011:1433;databaseName=project;user=deepak;password=123;encrypt=true;trustServerCertificate=true;";


        frame = new JFrame("CUSTOMER INFORMATION");

        JLabel l = new JLabel("NAME");
        JLabel l1 = new JLabel("GENDER");
        JLabel l2 = new JLabel("CONTACT No");
        JLabel l3 = new JLabel("GMAIL-ID");
        JLabel l4 = new JLabel("ADDRESS");
        JButton b = new JButton("INSERT");
        JButton b1 = new JButton("SELECT");
        JButton b2 = new JButton("UPDATE");
        JButton b3 = new JButton("DELETE");
        JButton b4 = new JButton("CLEAR");

        t = new JTextField();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        r = new JCheckBox("MALE");
        r1 = new JCheckBox("FEMALE");

        r.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    r1.setSelected(false);
                }
            }
        });

        r1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    r.setSelected(false);
                }
            }
        });

        setLayout(null);

        l.setBounds(100, 20, 120, 30);
        t.setBounds(250, 20, 140, 30);
        l1.setBounds(100, 70, 120, 30);
        r.setBounds(250, 70, 70, 30);
        r1.setBounds(330, 70, 100, 30);
        l2.setBounds(100, 120, 120, 30);
        t1.setBounds(250, 120, 140, 30);
        l3.setBounds(100, 170, 120, 30);
        t2.setBounds(250, 170, 140, 30);
        l4.setBounds(100, 220, 120, 30);
        t3.setBounds(250, 220, 140, 30);
        b.setBounds(30, 300, 120, 30);
        b1.setBounds(180, 300, 120, 30);
        b2.setBounds(330, 300, 120, 30);
        b3.setBounds(480, 300, 120, 30);
        b4.setBounds(440, 150, 120, 30);

        l.setFont((new Font("Arial", Font.BOLD, 16)));
        l1.setFont((new Font("Arial", Font.BOLD, 16)));
        l2.setFont((new Font("Arial", Font.BOLD, 16)));
        l3.setFont((new Font("Arial", Font.BOLD, 16)));
        l4.setFont((new Font("Arial", Font.BOLD, 16)));
        t.setFont((new Font("Arial", Font.BOLD, 16)));
        t1.setFont((new Font("Arial", Font.BOLD, 16)));
        t2.setFont((new Font("Arial", Font.BOLD, 16)));
        t3.setFont((new Font("Arial", Font.BOLD, 16)));
        r.setFont((new Font("Arial", Font.BOLD, 16)));
        r1.setFont((new Font("Arial", Font.BOLD, 16)));
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

        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t);
        add(t1);
        add(t2);
        add(t3);
        add(r);
        add(r1);
        add(b);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/shopping-icon-2184065_1280.png"));

        frame.setSize(650, 425);
        frame.add(this);
        frame.setIconImage(icon.getImage());

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        loadImage("/images/AIforCustomerService_Cover-1024w.jpg"); 

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t.getText().isEmpty() || t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "FILL ALL DETAILS", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    try (Connection connection = DriverManager.getConnection(jdbc_Url);
                         Statement statement = connection.createStatement()) {

                        String name = t.getText().toUpperCase();
                        int contact = Integer.parseInt(t1.getText());
                        String email = t2.getText().toLowerCase();
                        String address = t3.getText().toUpperCase();
                        String gender;
                        if (r.isSelected()) {
                            gender = "MALE";
                        } else if (r1.isSelected()) {
                            gender = "FEMALE";
                        } else {
                            gender = "";
                        }
                        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                        String query = "INSERT INTO CUSTOMERINFO (C_NAME, GENDER, CONTACT, MAIL_ID, ADDRESS_, LOGIN_TIME) "
                                + "VALUES ('" + name + "', '" + gender + "', " + contact + ", '" + email + "', '" + address + "', '" + datetime + "')";
                        int rowsAffected = statement.executeUpdate(query);

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Successfully Inserted.", "INFO BOX", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Failed to Store", "WARNING BOX", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        
        
        b1.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
                  if (t.getText().isEmpty() ) 
                  {
                    JOptionPane.showMessageDialog(frame, "ENTER NAME TO SEARCH", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
  				   try (Connection connection = DriverManager.getConnection(jdbc_Url);
  		                     Statement statement = connection.createStatement()) {
  		                String name=t.getText();
   

  		                    String query = "select *from CUSTOMERINFO  where C_NAME='"+name+"' ";
  		                    
  		                  ResultSet resultset=statement.executeQuery(query);
  				
  				  
  			
  				while(resultset.next())
  				{
  					
  					
  					String gender=resultset.getString(3);
            if (gender.equals("MALE")) {
              r.setSelected(true);
              r1.setSelected(false); 
          } else if (gender.equals("FEMALE")) {
              r.setSelected(false);
              r1.setSelected(true);
          }
  				
  					String ename=resultset.getString(2);
            t.setText(ename);

  					     String contact=resultset.getString(4);
  					     t1.setText(contact);
                 String mail=resultset.getString(5);
                 t2.setText(mail);
                 String address=resultset.getString(6);
                 t3.setText(address);
  				  }
  				  }catch(SQLException ex1) {
  					   
  	                   JOptionPane.showMessageDialog(frame, "UNABLE TO GET DATA ","WARNING BOX",JOptionPane.WARNING_MESSAGE);

  				   }
  			}	}
  			
  		});
          b2.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e){
            	   if (t.getText().isEmpty() ) 
                   {
                     JOptionPane.showMessageDialog(frame, "ENTER NAME TO UPDATE", "Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }
            	   else {
                  try (Connection connection = DriverManager.getConnection(jdbc_Url);
                  Statement statement = connection.createStatement()) {
                      String name = t.getText().toUpperCase();
                      int contact = Integer.parseInt(t1.getText());
                      String email=t2.getText().toLowerCase();;
      
                      String address=t3.getText().toUpperCase();;
                      String gender;
                    if (r.isSelected()) {
                        gender = "MALE";
                        
                    } else if (r1.isSelected()) {
                        gender = "FEMALE";
                       
                    } else {
                        gender = ""; 
                    }
      String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      String query="update  CUSTOMERINFO set GENDER='"+gender+"',CONTACT='"+contact+"', MAIL_ID='"+email+"',ADDRESS_='"+address+"',UPDATED_TIME='"+datetime+"' where  C_NAME='"+name+"'";
      int resultset=statement.executeUpdate(query);
  			                  
      if(resultset>0) {
          
      
       JOptionPane.showMessageDialog(frame, "SUCCESSFULLY CHANGED ","INFO BOX",JOptionPane.INFORMATION_MESSAGE);
      

      }
      else {
           JOptionPane.showMessageDialog(frame, "FAILED TO CHANGE VALUES ","WARNING BOX",JOptionPane.WARNING_MESSAGE);

      }
  }catch(SQLException ex) {

   System.out.println(ex);
   
  }   
            	   }       }
              
          });
          b3.addActionListener(new ActionListener() {
  					
              @Override
              public void actionPerformed(ActionEvent e) {
                  try(Connection connection=DriverManager.getConnection(jdbc_Url);
                          
                          Statement statement=connection.createStatement()){
                      
                         String name = t.getText();
              
                          
                          String query="delete from CUSTOMERINFO where C_NAME ='"+name+"'";
                         
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
          t.addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      b.doClick();
                  }
              }
          });
          
          t1.addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      b.doClick();
                  }
              }
          }); 
          t2.addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      b.doClick();
                  }
              }
          });
          
          t3.addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      b.doClick();
                  }
              }
          });
          r.addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      b.doClick();
                  }
              }
          });
          
          r1.addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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
            r.setSelected(false);
           r1.setSelected(false);
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
