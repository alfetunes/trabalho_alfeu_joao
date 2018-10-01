import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.util.ArrayList;
import java.util.List;
 
public class Calculadora extends JPanel implements ActionListener {
 
  private JTextField display = new JTextField("0");
  private double resultado = 0;
  private String operador = "=";
  private boolean calculando = true;


  public Calculadora() {
    setLayout(new BorderLayout());
    
    //adiciona display da calculadora
    display.setEditable(false);
    add(display, "North");
 
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 4));
 
    //adiciona botões no panel
    String buttonLabels = "abcdefgh789/456*123-0.=+";
    for (int i = 0; i < buttonLabels.length(); i++) {
      JButton b = new JButton(buttonLabels.substring(i, i + 1));
      if(i==0){
        ImageIcon imageIcon = new ImageIcon("ex.jpg");
        b.setIcon(imageIcon);
        b.setForeground(Color.CYAN);
      }else if(i==1){
        ImageIcon imageIcon = new ImageIcon("raizQuadrada.jpg");
        b.setIcon(imageIcon);
        b.setForeground(Color.CYAN);
      }else if(i==2){
        ImageIcon imageIcon = new ImageIcon("raizCubica.jpg");
        b.setIcon(imageIcon); 
        b.setForeground(Color.CYAN);        
      }else if(i==3){
        ImageIcon imageIcon = new ImageIcon("porcentagem.jpg");
        b.setIcon(imageIcon);   
        b.setForeground(Color.CYAN);     
      }else if(i==4){
        ImageIcon imageIcon = new ImageIcon("elevaQuadrado.jpg");
        b.setIcon(imageIcon);        
        b.setForeground(Color.CYAN);
      }else if(i==5){
        ImageIcon imageIcon = new ImageIcon("elevaCubo.jpg");
        b.setIcon(imageIcon);   
        b.setForeground(Color.CYAN);       
      }else if(i==6){
        ImageIcon imageIcon = new ImageIcon("elevay.jpg");
        b.setIcon(imageIcon);   
        b.setForeground(Color.CYAN);       
      }else if(i==7){
        ImageIcon imageIcon = new ImageIcon("fatorial.jpg");
        b.setIcon(imageIcon);  
        b.setForeground(Color.CYAN);        
      }
      panel.add(b);
      b.addActionListener(this);
    }
    add(panel, "Center");//adiciona panel no principal
  }
 
  public void actionPerformed(ActionEvent evt) {
    String cmd = evt.getActionCommand();
    
    if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.equals(".")) {//se for numeros ou ponto
      if (calculando){//primeiro numero
        display.setText(cmd);
      }else{
        display.setText(display.getText() + cmd);
      }
      calculando = false;
    }else {//se for operações
      if (calculando) {//primeira operação digitada
        if (cmd.equals("-")) {
          display.setText(cmd);
          calculando = false;
        }else{
          operador = cmd;
        }
      } else {
        double x = Double.parseDouble(display.getText());
        calcular(x);
        operador = cmd;
        calculando = true;
      }
    }
  }
 
  private double fatorial(double num) {
    if (num <= 1) {
        return 1;
    } else {
        return fatorial(num - 1) * num;
    }
  }

  private void calcular(double n) {
    if (operador.equals("+"))
      resultado += n;
    else if (operador.equals("-"))
      resultado -= n;
    else if (operador.equals("*"))
      resultado *= n;
    else if (operador.equals("/"))
      resultado /= n;
    else if (operador.equals("="))
      resultado = n;
    else if (operador.equals("a"))//exponencial
      resultado = Math.pow(2.718281828,n);  
    else if (operador.equals("b"))//raiz quadrada
      resultado = Math.sqrt(n);
    else if (operador.equals("c"))//raiz cubica
      resultado = Math.cbrt(n);
    else if (operador.equals("d"))//porcentagem
      resultado = n/100;
    else if (operador.equals("e"))//eleva ao quadrado
      resultado = n*n;
    else if (operador.equals("f"))//eleva ao cubo
      resultado = (n*n)*n;
    else if (operador.equals("h"))//fatorial
      resultado = fatorial(n);
    else if (operador.equals("g")){//x elevado ao y
      resultado = Math.pow(resultado,n);  
    }
    display.setText("" + resultado);

  }
 
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("Calculadora");
    frame.setSize(400,400);
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 
    Container contentPane = frame.getContentPane();
    contentPane.add(new Calculadora());
    frame.setVisible(true);
  }
}