package Forms;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import Graph.Plot_graph;
import Logic.PathPanel;
import Logic.TextImage;
import Logic.plot_vertices;
import Logic.setVertexProperty;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class Vertex extends JFrame {

	private JPanel contentPane;
	public String path="";
	private JTextField tF_vertex;
	public static JLabel[] labels = new JLabel[100];
	public static JPanel[] panels = new JPanel[100];
	public static int posx[] = new int[100];
	public static int posy[] = new int[100];
	public static JPanel panel;
	public JPanel panel_1;
	public static JComboBox comboBox;
	public static JScrollPane scrollPane;
	public static DefaultTableModel dtab=null;
	private JTable table;
	public static JButton btnCalculate;
	public static int edge = 1;
	public static JButton btnCreate;
	public static JLabel lblLoc; 
	public static PathPanel pathPanel = new PathPanel();
    public static ArrayList<String[]> points = new ArrayList<String[]>();
    public static JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	
	static{
		for(int i=0;i<100;i++)
		{
			labels[i] = new JLabel();
            panels[i] = new JPanel();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vertex frame = new Vertex();
					frame.setVisible(true);
					btnCalculate.setEnabled(false);
					comboBox.setEnabled(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vertex() {
		new table().setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	          String val=tF_vertex.getText();
	          int vertex = Integer.parseInt(val);
	          plot_vertices(vertex);
	          comboBox.setEnabled(true);
	          btnCalculate.setEnabled(true);
	          btnCreate.setEnabled(false);
			}
		});
		
		 panel = new JPanel();
		 
		 panel.setBackground(Color.cyan);
		
		panel.setBounds(0, 0, 458, 398);
		contentPane.add(panel);
		
		 panel_1 = new JPanel();
		panel_1.setBounds(478, 11, 357, 671);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Number of vertices:");
		lblNewLabel.setBounds(10, 50, 158, 27);
		panel_1.add(lblNewLabel);
		
		tF_vertex = new JTextField();
		tF_vertex.setBounds(191, 50, 86, 27);
		panel_1.add(tF_vertex);
		tF_vertex.setColumns(10);
		
		
		btnCreate.setBounds(34, 108, 89, 23);
		panel_1.add(btnCreate);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(185, 171, 136, 20);
		panel_1.add(comboBox);
		
		 btnCalculate = new JButton("Calculate");
		 btnCalculate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		Logic.algo al = new Logic.algo();
		 		String algo = "";
		 		if(comboBox.getSelectedItem().equals("Approximation"))
		 		{
		 		 algo = comboBox.getSelectedItem().toString();
		 		String vertices = tF_vertex.getText();
		 		int vnum = Integer.parseInt(vertices);
		 		al.method(algo, vnum);
		 		}
		 		else if(comboBox.getSelectedItem().equals("Greedy"))
		 		{
		 			Vector vec = new Vector();
		 			algo = comboBox.getSelectedItem().toString();		 			
		 			int row = dtab.getRowCount();
                   String val = dtab.getValueAt(row-1, 2).toString();
                   int num = Integer.parseInt(val);
                   System.out.println("num= "+num);
                 al.method(algo, num);
		 		}
		 		else if(comboBox.getSelectedItem().equals("Alom"))
		 		{
		 			algo = comboBox.getSelectedItem().toString();
		 			int row = dtab.getRowCount();
		 			String val = dtab.getValueAt(row-1, 2).toString();
		 			int num = Integer.parseInt(val);
		 			al.method(algo, num);
		 		}
		 		else if(comboBox.getSelectedItem().equals("SD"))
		 		{
		 			algo = comboBox.getSelectedItem().toString();
		 			int row = dtab.getRowCount();
		 			String val = dtab.getValueAt(row-1, 2).toString();
		 			int num = Integer.parseInt(val);
		 			al.method(algo, num);
		 		}
		 	}
		 });
		btnCalculate.setBounds(79, 246, 89, 23);
		panel_1.add(btnCalculate);
		
		JLabel lbl_cal = new JLabel("Select Algo:");
		lbl_cal.setBounds(10, 174, 158, 20);
		panel_1.add(lbl_cal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 303, 313, 357);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		dtab = new DefaultTableModel();
		table.setModel(dtab);
		dtab.addColumn("Vertex1");
		dtab.addColumn("Vertex2");
		dtab.addColumn("Edge");
		
		panel_1.add(scrollPane);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=dtab.getRowCount()-1;i>=0;i--)
				{
					dtab.removeRow(i);
				}
				for(int i=0;i<points.size();i++)
				{
				dtab.addRow(points.get(i));	
				}
				Logic.algo.chk = false;
				
				int n = Integer.parseInt(tF_vertex.getText());
				while(n>0)
				{
					Vertex.labels[n].setIcon(new ImageIcon("F://project/vertex/Vertex"+n+".png"));
					n--;
				}
			}
		});
		btnReset.setBounds(219, 108, 89, 23);
		panel_1.add(btnReset);
		
		 lblLoc = new JLabel("loc");
		lblLoc.setBounds(10, 409, 144, 14);
		contentPane.add(lblLoc);
		algo();
		panel.setLayout(null);
		panel.add(pathPanel);
		
		 btnNewButton = new JButton("Show Graph");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Plot_graph pgraph = new Plot_graph();
				pgraph.plot(Logic.algo.arr_graph);
			}
		});
		btnNewButton.setBounds(134, 509, 102, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton.setVisible(false);
	}
	
	public void plot_vertices(int i){
		while(i>0){
			final int k = i;
	        System.out.println("Inside Vertex...."+i);
	        
	        
	        Vertex.labels[i].setBackground(Color.red);
	        Vertex.panels[i].setBackground(Color.black);
	        setVertexProperty.setProperty(i);
	        
	        TextImage tm=new TextImage();
	        tm.drawImage("Vertex"+i,i);
	        Vertex.labels[i].setIcon(new ImageIcon("F://project/vertex/Vertex"+i+".png"));
	        
	        Vertex.panels[i].addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            PanelMouseClicked(evt,k);
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
	public void algo(){
		String arr[] = {"Approximation","Greedy","Alom","SD"};
		for(int i=0;i<arr.length;i++)
		{
		comboBox.addItem(arr[i]);
		}
	}
	public void PanelMouseClicked(java.awt.event.MouseEvent evt,int i) 
	{
	     System.out.println("Click Event");
		System.out.println("x= "+evt.getX());
	     System.out.println("y= "+evt.getY());
	     System.out.println(">>"+i);
	     JOptionPane.showMessageDialog(null,"You Have Clicked:"+i);
	     Point x=Vertex.panels[i].getLocation();
	     //int y = Vertex.labels[i].getY();
	      JOptionPane.showMessageDialog(null,"Its location is:["+x.x+","+x.y+"]");
	      String pp=JOptionPane.showInputDialog("Enter the Vertex number");
	      int p=Integer.parseInt(pp);
	      Point a=Vertex.panels[p].getLocation();
	      int b = Vertex.labels[p].getY();
	      String path1="path"+i+"-"+"path"+p;
	      drawline(Vertex.posx[i], Vertex.posy[i],Vertex.posx[p], Vertex.posy[p],path1);
	      String qrr[]={i+"",p+"",edge+""};
	      String arr[]={p+"",i+"",edge+""};
	      dtab.addRow(qrr);
	      dtab.addRow(arr);
	      points.add(qrr);
	      points.add(arr);
	      edge++;
	    }
	
	public void drawline(int x,int y,int x1,int y1,String path1)
	{
		this.path=path1;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Request to draw path: "+ path);
					//Vertex.panel.remove(Vertex.pathPanel);
					Vertex.panel.revalidate();
					Vertex.panel.repaint();

					Vertex.pathPanel = new PathPanel(path);
					Vertex.pathPanel.setBounds(0, 0, 900, 900);
					Vertex.pathPanel.revalidate();
					Vertex.pathPanel.repaint();
					Vertex.pathPanel.setVisible(true);

					Vertex.panel.add(Vertex.pathPanel);
					Vertex.panel.revalidate();
					Vertex.panel.repaint();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//Graphics2D grp = (Graphics2D) getGraphics();
		///grp.setColor(Color.black);
		//grp.setStroke(new BasicStroke(3));
		//grp.drawLine(x, y, x1, y1+40);
	}
}
