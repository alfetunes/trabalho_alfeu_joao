import java.awt.event.*;    
import java.awt.*;    
import javax.swing.*;     

public class ColorSelect extends JFrame implements ActionListener {    
    JButton b;    
    Container c;  

    JCheckBox background, foreground;
    JPanel buttonjpannel;
    GridLayout gridlayout;
    JButton ok;
    JButton cancel;
    Color color;
    ColorSelect(){    
        c=getContentPane();    
        c.setLayout(new FlowLayout());         
        b=new JButton("Selecione a cor");    
        b.addActionListener(this);         
        c.add(b);   

        buttonjpannel = new JPanel();
        buttonjpannel.setLayout(new GridLayout(2,2));

        background = new JCheckBox("Background");
        foreground = new JCheckBox("Foreground");
        buttonjpannel.add(background);
        buttonjpannel.add(foreground);

        ok = new JButton("OK");    
        buttonjpannel.add(ok);
        cancel = new JButton("Cancel");    
        buttonjpannel.add(cancel);
 
        add(buttonjpannel);

        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancel.setBackground(Color.RED);
                cancel.setContentAreaFilled(false);
                cancel.setOpaque(true);
                c.setBackground(UIManager.getDefaults().getColor("frame.background"));
                ok.setForeground(Color.BLACK);
                cancel.setForeground(Color.BLACK);
                background.setForeground(Color.BLACK);
                foreground.setForeground(Color.BLACK);
                b.setForeground(Color.BLACK);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancel.setBackground(UIManager.getDefaults().getColor("button.background"));
                cancel.setContentAreaFilled(false);
                cancel.setOpaque(true);
            }
        });

        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ok.setBackground(Color.GREEN);
                ok.setContentAreaFilled(false);
                ok.setOpaque(true);
                if(background.isSelected()){
                    c.setBackground(color);
                }
                if(foreground.isSelected()){
                    ok.setForeground(color);
                    cancel.setForeground(color);
                    background.setForeground(color);
                    foreground.setForeground(color);
                    b.setForeground(color);
                }   

            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ok.setBackground(UIManager.getDefaults().getColor("button.background"));
                ok.setContentAreaFilled(false);
                ok.setOpaque(true);
            }
        });
    }    
    public void actionPerformed(ActionEvent e) {    
        Color initialcolor=Color.RED;    
        color=JColorChooser.showDialog(this,"Selecione a cor e clique em ok na tela principal para mudar cor do frame",initialcolor);    
    }    
    
    public static void main(String[] args) {    
        ColorSelect ch=new ColorSelect();    
        ch.setSize(300,150);    
        ch.setVisible(true);    
        ch.setTitle("ColorSelect");
        ch.setDefaultCloseOperation(EXIT_ON_CLOSE);    
    }    
}    