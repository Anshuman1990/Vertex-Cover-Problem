/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;



import Forms.Vertex;

//import forms.NodeInfo;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class plot_vertices{
	int i=0;
    public plot_vertices(int vertex) {
		i = vertex;
	}
    public void run(){    
    while(i>0){
    
        System.out.println("Inside Vertex....");
        
        
      
            Vertex.labels[i].setBackground(Color.white);
            Vertex.panels[i].setBackground(Color.black);
      
       
    
        
        setVertexProperty.setProperty(i);
        System.out.println(i);
        TextImage tm=new TextImage();
       
        tm.drawImage("Vertex"+i,i);
        Vertex.labels[i].setIcon(new ImageIcon("D://NWInfo/Vertex"+i+".png"));
        
        
        Vertex.panels[i].addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        PanelMouseClicked(evt,i);
        }
        });
        Vertex.panels[i].addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }
        });
        
        Vertex.panels[i].setBounds(Vertex.posx[i],Vertex.posy[i],20,20);
        System.out.println("**Vertex= "+Vertex.panels[i].getLocation());
        Vertex.panel.add(Vertex.panels[i]);
        Vertex.panels[i].setVisible(true);
        Vertex.panels[i].add(Vertex.labels[i]);
        Vertex.labels[i].setBounds(0,0,20,20);
        Vertex.labels[i].setVisible(true);
       
        JLabel j=new JLabel();
      
        
     
    i--;	
    }
    }
    public void PanelMouseClicked(java.awt.event.MouseEvent evt,int i) {
     System.out.println(""+evt.getSource());
     System.out.println(">>"+i);
     JOptionPane.showMessageDialog(null,"You Have Clicked:"+i);
     int x=Vertex.posx[i];
     int y=Vertex.posy[i];
      JOptionPane.showMessageDialog(null,"Its location is:["+x+","+y+"]");
      String pp=JOptionPane.showInputDialog("Enter the node number");
      int p=Integer.parseInt(pp);
      int x2=Vertex.posx[p];
      int y2=Vertex.posy[p];
      double dis=Math.sqrt((double)((x2-x)*(x2-x)+(y2-y)*(y2-y)));
       JOptionPane.showMessageDialog(null,"Its Distance from node "+dis);
    
       System.out.println("Mouse entered...");
       System.out.println(""+evt.getSource());
       System.out.println(">>"+i);
      
      
       //--------------------------------
    }


private void PanelMouseEntered(java.awt.event.MouseEvent evt,int i) {
        // TODO add your handling code here:
        System.out.println("Mouse entered...");
        System.out.println(""+evt.getSource());
        System.out.println(">>"+i);
        String GNodesList="";

		
        int x=Vertex.posx[i];
        int y=Vertex.posy[i];
   
        
    }
}
