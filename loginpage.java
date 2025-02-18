import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class loginpage extends JPanel {

    private Image img; 
    private JFrame frame;
   

    public loginpage() {
        loadImage("/images/pexels-fwstudio-33348-129731.jpg"); 

   
        String jdbc_Url = "jdbc:sqlserver://SANJAY-1011:1433;databaseName=project;user=deepak;password=2310;encrypt=true;trustServerCertificate=true;";


        JLabel l = new JLabel("USER-NAME");
        JLabel l1 = new JLabel("PASSWORD");
        JButton b = new JButton("LOGIN");
        JButton b1 = new JButton("SIGN UP");
        JTextField t = new JTextField();
        JTextField t1 = new JTextField();

        setLayout(null); 

        
        l.setBounds(100, 50, 120, 30);
        t.setBounds(250, 50, 120, 30);
        l1.setBounds(100, 100, 120, 30);
        t1.setBounds(250, 100, 120, 30);
        b.setBounds(100, 150, 120, 30);
        b1.setBounds(250, 150, 120, 30);

        
        b.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        l.setFont(new Font("Arial", Font.BOLD, 16));
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        t.setFont(new Font("Arial", Font.BOLD, 16));
        t1.setFont(new Font("Arial", Font.BOLD, 16));

        
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

       
        add(l);
        add(l1);
        add(t);
        add(t1);
        add(b);
        add(b1);
        

    
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/shopping-icon-2184065_1280.png"));
   


        frame = new JFrame("LOGIN PAGE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.add(this);
        frame.setIconImage(icon.getImage());

        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);

        
        

        
       b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean loginSuccessful = false;
                try {
                    Connection connection = DriverManager.getConnection(jdbc_Url);
                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM SIGNUP";
                    ResultSet resultset = statement.executeQuery(query);
                    if (t.getText().isEmpty() || t1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(loginpage.this, "FILL ALL DETAILS", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String E_name = t.getText().toUpperCase();
                    String E_pass = t1.getText().toUpperCase();

                    while (resultset.next()) {
                        String ename = resultset.getString(2);
                        String epass = resultset.getString(3);

                        if (E_name.equals(ename) && E_pass.equals(epass)) {
                            billapp bi = new billapp();
                            bi.setVisible(true);
                            frame.dispose();
                            loginSuccessful = true;
                            break;
                        }
                    }
                    if (!loginSuccessful) {
                        JOptionPane.showMessageDialog(loginpage.this, "LOGIN FAILED ", "WARNING BOX",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }); 
       
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup sign = new signup();
                sign.setVisible(true);
             
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

      

        t.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    b1.doClick();
                }
            }
        });
        t1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    b1.doClick();
                }
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new loginpage();
            }
        });
    }
}
