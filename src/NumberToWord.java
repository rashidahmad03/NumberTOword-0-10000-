/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rashid ahmad
 */

import java.awt.*;
import java.awt.event.*;

public class NumberToWord {
    public static void main(String []s)	{
             new Gui();  
    }
}
class Gui  implements ActionListener
{
    class WC extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
                System.exit(0);
        }
    }
    Frame f;
    Label l1,l2,l3;
    TextField tf1;
    Button b;
    String a1[]={"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " ninteen"};
    String a2[]={"","", " twenty", " thirty", " fourty", " fifty", " sixty", " seventy", " eighty", " ninty"};
    String a3[]= {" hundred", " thousand"};
    String str="";
    int n;
    Gui()
    {
            f=new Frame("Number to Word");
            l1=new Label("Enter the number(must be less then 10000): ");
            l1.setBounds(40,40,300,20);
            f.add(l1);
            tf1=new TextField("");
            tf1.setBounds(40,80,100,20);
            f.add(tf1);
            l2=new Label("Number in words: ");
            l2.setBounds(40,120,100,20);
            f.add(l2);
            l3=new Label("-------------------------------------------------");
            l3.setBounds(40,160,550,20);
            f.add(l3);
            b=new Button("change");
            b.setBounds(40,200,60,30);
            f.add(b);
            b.addActionListener(this);
            f.addWindowListener(new WC());
            f.setLayout(null);
            f.setSize(600,400);
            f.setVisible(true);
           
    }
    public void actionPerformed(ActionEvent e){
        int r;
        n=Integer.parseInt(tf1.getText());
        str="";
        if(n>0 && n<=10000)
        {
            r=n%100;
            n=n/100;
            int q;
            if(r>0 && r<20)
            {
                str=a1[r]+str; 
            }
            if(r>19)
            {
                int r1=r%10;
                q=r/10;
                if(r1==0)
                {
                    str=a2[q]+str;    
                }
                else
                {
                    str=a1[r1]+str;    
                    str=a2[q]+str;    
                }
            }
            if(n!=0)
            {
                r=n%10;
                if(r!=0)
                {
                    str=a3[0]+str;    
                    str=a1[r]+str;    
                }
                n=n/10;
                if(n!=0)
                {
                    r=n%100;
                    if(r!=0)
                    {
                        str=a3[1]+str;   
                        str=a1[r]+str;
                    }
                }
            }
        }
        else 
            str="Out of Range";
        l3.setText(str);
    }
}
