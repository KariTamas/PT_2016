import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class Userinterface extends JFrame

{   
    
 


	public static JFrame userInterface;
    public static JPanel buttons, polys; 
    public static JButton add, sub, div, mul, integ, der;
    JLabel P1, P2, result;
    public static JTextField p1Field, p2Field, resultField;
        
    public Userinterface()
    {
        userInterface= new JFrame();
        
        // create and modify the panel where we will have the buttons
        buttons = new JPanel();
        userInterface.add(buttons,BorderLayout.CENTER);
        buttons.setBackground(Color.YELLOW);
        add=new JButton("add");
        buttons.add(add);
        sub=new JButton("sub");
        buttons.add(sub);
        mul=new JButton("mul");
        buttons.add(mul);
        div=new JButton("div");
        buttons.add(div);
        integ=new JButton("integ");
        buttons.add(integ);
        der=new JButton("der");
        buttons.add(der);
        
        
        //create and modify the panel where we will have the two polynomials and the result
        polys = new JPanel();
        userInterface.add(polys,BorderLayout.PAGE_START);    
        polys.setBackground(Color.gray);
        P1 = new JLabel("P1");
        polys.add(P1);
        p1Field = new JTextField("", 15);
        p1Field.setEditable(true);
        polys.add(p1Field);
        P2 = new JLabel("P2");
        polys.add(P2);
        p2Field = new JTextField("", 15);
        p2Field.setEditable(true);
        polys.add(p2Field);
        result = new JLabel("result");
        polys.add(result);
        resultField = new JTextField("", 30);
        resultField.setLocation(100, 100);
        resultField.setEditable(false);
        polys.add(resultField);
        
        //define handlers
        HandlerClass handler = new HandlerClass();
        integ.addActionListener(handler);
        der.addActionListener(handler);
        div.addActionListener(handler);
        mul.addActionListener(handler);
        sub.addActionListener(handler);
        add.addActionListener(handler);
           
    }
  //the handler class for the buttons
   
  public static class HandlerClass implements ActionListener
  {
	  static String input="";
      public void actionPerformed(ActionEvent event){
          
          Polynomial pol1, pol2, resultPol;     //store the polynomials
          input=p1Field.getText();				//get pol1, pol2
          pol1=new Polynomial(input);
          input=p2Field.getText();
          pol2=new Polynomial(input);
          String output;
          
          //if add was pressed
          if(event.getSource()==add){
              
        	  resultPol=new Polynomial();
        	  resultPol=Operations.add(pol1, pol2);
              output=resultPol.toString();
              resultField.setText(output);
          }    
        //if sub was pressed
          if(event.getSource()==sub){
        	  resultPol=new Polynomial();
        	  resultPol=Operations.sub(pol1, pol2);
        	  output=resultPol.toString();
        	  if (output.equals(""))
        		  resultField.setText("0");
        	  else 
        		  resultField.setText(output);

          }
        //if mul was pressed
          if(event.getSource()==mul){
        	  
        	  resultPol=new Polynomial();
        	  resultPol=Operations.mul(pol1, pol2);
        	  output=resultPol.toString();
              resultField.setText(output);
          }
          
        //if div was pressed
          if(event.getSource()==div){        	 
        	  
        	  resultPol=new Polynomial();
        	  resultPol=Operations.div(pol1, pol2);
        	  output=resultPol.toString();
        	  if (output.equals(""))
        		  resultField.setText("0");
        	  else 
        		  resultField.setText(output);	
              
          }
          
        //if der was pressed
          if(event.getSource()==der){
        	  
        	  resultPol=new Polynomial();
        	  resultPol=Operations.deriv(pol1);
        	  output=resultPol.toString();
              if (output.equals(""))
    		  resultField.setText("0");
    	  else 
    		  resultField.setText(output);	
          }
          
        //if integ was pressed
          if(event.getSource()==integ){
        	       	  
        	  resultPol=new Polynomial();
        	  resultPol=Operations.integ(pol1);
        	  output=resultPol.toString();
              resultField.setText(output + " +c");
          }
     }
  } 
}


