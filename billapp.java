import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class billapp extends JPanel {
    private BufferedImage img;


    // Constructor
    public billapp() {
        loadImage("/images/menupic.jpg");

        MenuBar m = new MenuBar();
        Menu fileMenu = new Menu("FILE");
        MenuItem CUSTOMER = new MenuItem("CUSTOMER ENTRY");
        MenuItem PRODUCT = new MenuItem("PRODUCT ENTRY");
        MenuItem BILLING = new MenuItem("BILLING OPTION");
        MenuItem EXIT = new MenuItem("EXIT");

        m.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
        m.add(fileMenu);
        fileMenu.add(CUSTOMER);
        fileMenu.add(PRODUCT);
        fileMenu.add(BILLING);
        fileMenu.add(EXIT);

        JFrame f = new JFrame("BILLING SOFTWARE");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/shopping-icon-2184065_1280.png"));
        f.setIconImage(icon.getImage());

        f.setMenuBar(m);
        
        
        CUSTOMER.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cusinfo info = new cusinfo();
            info.setVisible(true);
              
        }
    });

    PRODUCT.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            product pro = new product();
            pro.setVisible(true);
        }
    });

    BILLING.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            bill b = new bill();
            b.setVisible(true);
                  }
 });

        EXIT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
       
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.8);
        int height = (int) (screenSize.getHeight() * 0.8);

       

        f.setSize(width,height);
        f.setVisible(true);
        f.add(this);
        f.setLocationRelativeTo(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

 
             
        f.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == JFrame.NORMAL) {
                    f.setSize(width,height);  
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
}
