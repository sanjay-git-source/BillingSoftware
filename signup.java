import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.*;



class signup  extends JPanel{
	 private Image img;

    public signup() {
        loadImage("/images/pexels-fwstudio-33348-129731.jpg");
        
        String jdbc_Url = "jdbc:sqlserver://SANJAY-1011:1433;databaseName=project;user=deepak;password=123;encrypt=true;trustServerCertificate=true;";


       JFrame f = new JFrame("SIGNUP PAGE");
       JLabel l=new JLabel("USERNAME");
       JLabel l1=new JLabel("PASSWORD");
       JButton b=new JButton("SIGN IN");
       JLabel l2 = new JLabel("USER-TYPE");

       String s[] = {"ADMIN", "MEMBER"};
       JComboBox<String> c = new JComboBox<>(s);
       JTextField t=new JTextField();
       JTextField t1=new JTextField();
       setLayout(null);
       l.setBounds(100,20,120,30);
       t.setBounds(250,20,120,30);
       l1.setBounds(100,70,120,30);
       t1.setBounds(250,70,120,30);
       l2.setBounds(100,120, 120, 30);
       c.setBounds(250,120, 120,30);
       b.setBounds(180,200,120,30);

       b.setFont((new Font("Arial", Font.BOLD, 16)));
      
       l.setFont((new Font("Arial", Font.BOLD, 16)));
       l1.setFont((new Font("Arial", Font.BOLD, 16)));
       t.setFont((new Font("Arial", Font.BOLD, 16)));
       t1.setFont((new Font("Arial", Font.BOLD, 16)));
       l2.setFont((new Font("Arial", Font.BOLD, 16)));
       c.setFont((new Font("Arial", Font.BOLD, 16)));


       b.setBackground(Color.BLACK);
       b.setForeground(Color.WHITE);

  

     
      add(t1);add(b);add(t);add(l);add(l1);add(c);add(l2);
      ImageIcon icon = new ImageIcon(getClass().getResource("/images/shopping-icon-2184065_1280.png"));

       f.setSize(500,300);
       f.setVisible(true);
       f.setLocationRelativeTo(null);
       f.add(this);
       f.setIconImage(icon.getImage());


       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
     
       ActionListener a=new ActionListener() {
        public void actionPerformed(ActionEvent e){
          
        String enteredpass=t1.getText().toUpperCase();
        String usertype= (String) c.getSelectedItem();
    String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            
            String enteredname=t.getText().toUpperCase();
        try{
                   if(t.getText().isEmpty() || t1.getText().isEmpty()) 	
                   {
                       JOptionPane.showMessageDialog(f, "FILL ALL DETAILS ","WARNING BOX",JOptionPane.WARNING_MESSAGE);
       
                   }
                   else {
                   Connection connection = DriverManager.getConnection(jdbc_Url);
                     Statement statement = connection.createStatement();

                    String query = "insert into SIGNUP values('" + enteredname + "', '" + enteredpass + "','"+usertype+"','"+datetime+"')";
                   
                   statement.executeUpdate(query);
                JOptionPane.showMessageDialog(f, "SUCCESSFULLY STORED ","INFO BOX",JOptionPane.INFORMATION_MESSAGE);
                   loginpage login=new loginpage();
                   login.setVisible(true);
                       f.dispose();
                       
                    	
                    }
                } catch (SQLException ex) {
                	System.out.println(ex);
                	
                }

    
        }
       };
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
    c.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                b.doClick();
            }
        }
    });
       b.addActionListener(a);
       
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

