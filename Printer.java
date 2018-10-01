import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class Printer extends JPanel  {
    JCheckBox image,text,code,printtofile;
    JTextArea textArea1,textArea2,textArea3;
    JRadioButton selection,all,applet;
    JLabel printer,printquality;
    JButton ok,cancel,setup,help;
    JComboBox combo;
    protected String opcoes[] = {"high","low"};
    Printer(){   
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        printer = new JLabel("Printer: My Printer");
        add(printer, "North");
        

        JPanel btpanel = new JPanel();
        btpanel.setLayout(new GridLayout(4, 1));
        ok = new JButton("OK");
        btpanel.add(ok);
        cancel = new JButton("Cancel");
        btpanel.add(cancel);
        setup = new JButton("Setup...");
        btpanel.add(setup);
        help = new JButton("Help");
        btpanel.add(help);
        add(btpanel, "East");


        JPanel panelcheck = new JPanel();
        panelcheck.setLayout(new GridLayout(3, 1));
        image = new JCheckBox("Image");
        panelcheck.add(image);
        text = new JCheckBox("Text");
        panelcheck.add(text);
        code = new JCheckBox("Code");
        panelcheck.add(code);

        JPanel paneltext1 = new JPanel();
        paneltext1.setLayout(new GridLayout(1, 2));
        textArea1 = new JTextArea();
        paneltext1.add(textArea1);
        paneltext1.add(panelcheck);
       // add(paneltext1, "West");
      


        JPanel panelradio = new JPanel();
        panelradio.setLayout(new GridLayout(3, 1));
        selection = new JRadioButton("Selection");
        panelradio.add(selection);
        all = new JRadioButton("All");
        panelradio.add(all);
        applet = new JRadioButton("Applet");
        panelradio.add(applet);

        JPanel paneltext2 = new JPanel();
        paneltext2.setLayout(new GridLayout(1, 2));
        textArea2 = new JTextArea();
        paneltext2.add(textArea2);
        paneltext2.add(panelradio);
        //add(paneltext2,"Center");

   
        textArea3 = new JTextArea();
      
        JPanel texts = new JPanel();
        texts.setLayout(new GridLayout(1, 3));
        texts.add(paneltext1);
        texts.add(paneltext2);
        texts.add(textArea3);
        add(texts, "West");

        JPanel panelbaixo = new JPanel();
        panelbaixo.setLayout(new GridLayout(1, 3));
        printquality = new JLabel("Print Quality:");
        panelbaixo.add(printquality);
        combo = new  JComboBox(opcoes);
        panelbaixo.add(combo);
        printtofile = new JCheckBox("Print to File");
        panelbaixo.add(printtofile);
        add(panelbaixo, "South");

    
        add(panel);

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Printer");
        frame.setSize(600,200);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
     
        Container contentPane = frame.getContentPane();
        contentPane.add(new Printer());
        frame.setVisible(true);
      }
}