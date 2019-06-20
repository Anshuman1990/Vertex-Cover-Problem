package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;

import Forms.Vertex;
import Forms.table;

public class algo {
public ArrayList vtot = new ArrayList();
public static Vector vrem = new Vector();
public static int count=0,rand=0;
public Vector vtemp = new Vector<>();
public static Boolean chk = false;
public static int row=0;
public static int val = 0;
public static ArrayList arr_graph = new ArrayList<>();
public static void main(String[] a)
{
	
}

	public void method(String algo,int num)
	{
		ArrayList list = new ArrayList<>();
		for(int i=1;i<=num;i++)
	     {
	    	 list.add(i);
	     }
		Collections.shuffle(list);
		

		if(algo.equalsIgnoreCase("Approximation"))
		{
		long starttime =System.currentTimeMillis();
			while(count<num)
			{	
			val =(int) list.get(count);
			
			System.out.println("selected vetex= "+val);
			if(chk==false)
			{
			 row = Vertex.dtab.getRowCount();
			}
			if(row!=0)
			{
				int t=0;
				while(t<row)
				{
					String vertex1 = Vertex.dtab.getValueAt(t, 0).toString();
					String vertex2 = Vertex.dtab.getValueAt(t, 1).toString();
					
					System.out.println("vertex1= "+vertex1);
					System.out.println("vertex2= "+vertex2);
					int v1 = Integer.parseInt(vertex1);
					int v2 = Integer.parseInt(vertex2);

					if(val==v1||val==v2)
					{
						System.out.println("Selected Index= "+t);
						//selected_index.add(i);
						System.out.println("val= "+val);
						vtot.add(val);
					update_table(t);
					t=0;
					}
					else{
						t++;
						vtot = redundant_remove(vtot);
					}
				}
		  }			
			count++;
		}
			System.out.println("__________________________");
			for(int i=0;i<vtot.size();i++)
			{
				System.out.println("Elements= "+vtot.get(i));
			}
			vtot = redundant_remove(vtot);
			String pnts="";
			for(int k=0;k<vtot.size();k++)
			{
				pnts+=vtot.get(k)+",";
				System.out.println(vtot.get(k));
			}
			
			System.out.println(pnts);
			String[] arr = {"Approximation",pnts};
			table.dtab.addRow(arr);
			for(int i=0;i<vtot.size();i++)
			{
				Vertex.labels[(int) vtot.get(i)].setIcon(new ImageIcon("D://NWInfo/vertex.png"));
			}
			count=0;
			vtot.clear();
			long stoptime = System.currentTimeMillis();
			System.out.println("Start= "+starttime);
			System.out.println("Stop= "+stoptime);
			long elapsedTime = stoptime-starttime;
			System.out.println("Time Consumed= "+elapsedTime);
			
			String val = elapsedTime+","+algo;
			arr_graph.add(val);
			
			
	}  
		//end of approximation
		else if(algo.equalsIgnoreCase("Greedy"))
		{
			long starttime =System.currentTimeMillis();
			Vector vv1 = new Vector();
			Vector vv2 = new Vector();
			Vector<Integer> vec_count = new Vector<Integer>();
			Vector vec_result = new Vector();
			
			for(int i=1;i<=num;i++)
		     {
		    	 list.add(i);
		     }
			Collections.shuffle(list);
			while(count<num)
			{	
			val =(int) list.get(count);
			
			String vertices = "",vertices1="";
			System.out.println("selected edge= "+val);
			if(chk==false)
			{
			 row = Vertex.dtab.getRowCount();
			 System.out.println("row= "+row);
			}
			int cnt_v1=0,vcount=0;
			
//			while(row!=0)
//			{
			for(int i=0;i<row;i++)
			{
			   String edge = Vertex.dtab.getValueAt(i, 2).toString();
				if(val == Integer.parseInt(edge))
				{
				vertices = Vertex.dtab.getValueAt(i, 0).toString();
				vertices1 = Vertex.dtab.getValueAt(i, 1).toString();
				vv1.add(vertices);
				vv2.add(vertices1);
				}
				else
				{
					val = (int)list.get(count);
				}
				//vv1.removeAllElements();
			}
			while(vcount<vv1.size())
			{
				System.out.println("incident vertices1= "+vv1.elementAt(vcount));
				System.out.println("incident vertices2= "+vv2.elementAt(vcount));
				for(int i=0;i<row;i++)
				{
					if(vv1.elementAt(vcount).equals(Vertex.dtab.getValueAt(i, 0)))
					{
						cnt_v1++;
					}
				}
				
				vec_count.add(cnt_v1);
				
				cnt_v1=0;
				
				for(int i=0;i<row;i++)
				{
					if(vv2.elementAt(vcount).equals(Vertex.dtab.getValueAt(i, 1)))
					{
						cnt_v1++;
					}
				}
				
				vec_count.add(cnt_v1);
				
				for(int i=0;i<vec_count.size();i++)
				{
					System.out.println("Order= "+vec_count.elementAt(i)+"for vertex "+vv1.elementAt(i));
				}
				
				for(int i=0;i<vec_count.size();i++)
				{
					for(int j=0;j<vec_count.size();j++)
					{
						if(vec_count.elementAt(i)>vec_count.elementAt(j) && i!=j)
						{
							System.out.println("Order1= "+vec_count.elementAt(i));
							System.out.println("Order2= "+vec_count.elementAt(j));
							
							System.out.println("Resulted vertex "+vv1.elementAt(i));
							vec_result.add(vv1.elementAt(i));
							int t=0;
							while(t<row)
							{
								String vertex1 = Vertex.dtab.getValueAt(t, 0).toString();
								String vertex2 = Vertex.dtab.getValueAt(t, 1).toString();
								
								System.out.println("vertex1= "+vertex1);
								System.out.println("vertex2= "+vertex2);
								int v1 = Integer.parseInt(vertex1);
								int v2 = Integer.parseInt(vertex2);

								if(Integer.parseInt(vv1.elementAt(i).toString())==v1||Integer.parseInt(vv1.elementAt(i).toString())==v2)
								{
									System.out.println("Selected Index= "+t);
									//selected_index.add(i);
									System.out.println("val= "+vv1.elementAt(i));
									//vec_result.add(vv1.elementAt(i));
									//vtot.add();
								update_table(t);
								t=0;
								}
								else{
									t++;
									//vec_result = redundant_remove(vec_result);
								}
							}
							vec_count.removeAllElements();
						}
						else if(vec_count.elementAt(i).equals(vec_count.elementAt(j)) && i!=j)
								{
							       List<Integer> rnd = new ArrayList<Integer>();
							       rnd.add(i);
							       rnd.add(j);
							       Collections.shuffle(rnd);
							       int v = rnd.get(0);
							       System.out.println("Resulted vertex "+vv1.elementAt(v));
							       vec_result.add(vv1.elementAt(v));
									int t=0;
									while(t<row)
									{
										String vertex1 = Vertex.dtab.getValueAt(t, 0).toString();
										String vertex2 = Vertex.dtab.getValueAt(t, 1).toString();
										
										System.out.println("vertex1= "+vertex1);
										System.out.println("vertex2= "+vertex2);
										int v1 = Integer.parseInt(vertex1);
										int v2 = Integer.parseInt(vertex2);

										if(Integer.parseInt(vv1.elementAt(v).toString())==v1||Integer.parseInt(vv1.elementAt(v).toString())==v2)
										{
											System.out.println("Selected Index= "+t);
											//selected_index.add(i);
											System.out.println("val= "+vv1.elementAt(i));
											
											//vtot.add();
										update_table(t);
										t=0;
										}
										else{
											t++;
											//vec_result = redundant_remove(vec_result);
										}
									}
									vec_count.removeAllElements();
					}
				}
				cnt_v1=0;
			vcount++;
			}
				
				vv1.removeAllElements();
			    vv2.removeAllElements();
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			count++;
			}
		 // }
			vec_result = redundant_remove(vec_result);
			
			String pts = "";
			for(int i=0;i<vec_result.size();i++)
			{
				System.out.println("check= "+vec_result.get(i));
				pts+=vec_result.elementAt(i)+",";
			}
			String[] arr = {"Greedy",pts};
			table.dtab.addRow(arr);
			count=0;
			for(int i=0;i<vec_result.size();i++)
			{
				Vertex.labels[Integer.parseInt(vec_result.get(i).toString())].setIcon(new ImageIcon("D://NWInfo/vertex.png"));
			}
			vec_result.clear();
			
			long stoptime = System.currentTimeMillis();
			System.out.println("Start= "+starttime);
			System.out.println("Stop= "+stoptime);
			long elapsedTime = stoptime-starttime;
			System.out.println("Time Consumed= "+elapsedTime);
			
			String val = elapsedTime+","+algo;
			arr_graph.add(val);
		}
		else if(algo.equalsIgnoreCase("alom"))
		{
			long starttime =System.currentTimeMillis();
			String arr_con = "";
			ArrayList arr = new ArrayList();
            ArrayList<Integer> arrC = new ArrayList<Integer>();
			ArrayList arrV = new ArrayList<>();
			ArrayList SimV = new ArrayList<>();
			ArrayList result = new ArrayList<>();
            ArrayList<Integer> selected_index = new ArrayList<Integer>();		
			
			System.out.println(num);
			int ct = 0;
			
				if(chk==false)
				{
				 row = Vertex.dtab.getRowCount();
				}
				System.out.println("row= "+row);
				while(ct<num && row!=0)
				{
			for(int i=0;i<row;i++)
			{
				arr.add(Vertex.dtab.getValueAt(i, 0).toString());
			}
			for(int i=0;i<row;i++)
			{
				System.out.println("Elements selected= "+arr.get(i));
			}
			System.out.println("+++++++++++++++++START++++++++++++++++++");
		
			arr = redundant_remove(arr);
			
			for(int i=0;i<arr.size();i++)
			{
				System.out.println("Resulted arr = "+arr.get(i));
			}
			
			int inc_count=0;
			String vertex = "";
			for(int i=0;i<arr.size();i++)
			{
				inc_count = 0;
				vertex = "";
				for(int j=0;j<row;j++)
				{
					if(arr.get(i).equals(Vertex.dtab.getValueAt(j, 0)))
					{
						inc_count++;
						vertex = arr.get(i).toString();
					}
				}
				System.out.println("Incident_Count= "+inc_count);
				System.out.println("Vertex= "+vertex);
				arrC.add(inc_count);
				arrV.add(vertex);
			}
			int pos = 0;
			int temp=0,temp1 = 0;
			String tmp="",tmp1="";
			for(int i=0;i<arrC.size();i++)
			{
				pos = i;
				for(int j=i+1;j<arrC.size();j++)
				{
					if(arrC.get(j)>arrC.get(pos))
					{
					  pos = j;	
					}
				}
				temp = arrC.get(pos);
				temp1 = arrC.get(i);
				arrC.set(i, temp);
				arrC.set(pos, temp1);
				
				tmp = arrV.get(pos).toString();
				tmp1 = arrV.get(i).toString();
				arrV.set(i, tmp);
				arrV.set(pos, tmp1);
			}
			
			for(int i=0;i<arrC.size();i++)
			{
				System.out.println("Count= "+arrC.get(i)+" for vertex "+arrV.get(i));
			}
			System.out.println("Count size = "+arrC.size());
			
			if(arrC.get(0).equals(arrC.get(1)) && arrC.size()>1)
			{
				System.out.println("-----------------------Similar Condition---------------------------------");
			   	for(int i=0;i<arrC.size();i++)
			   	{
			   		if(arrC.get(0).equals(arrC.get(i)))
			   		{
			   			SimV.add(arrV.get(i));
			   			//SimC.add(arrC.get(i));
			   		}
			   	}
			   	
			   	for(int i=0;i<SimV.size();i++)
			   	{
			   		System.out.println("Vertex= "+SimV.get(i));
//		   			System.out.println("count= "+SimC.get(i));
			   	}
			   	
			   	for(int i=0;i<SimV.size();i++)
			   	{
			   	for(int j=0;j<row;j++)
	   			{
	   				if(SimV.get(i).equals(Vertex.dtab.getValueAt(j, 0)))
	   				{
	   					String v_cov = Vertex.dtab.getValueAt(j, 1).toString();
	   					arr_con+=v_cov+"-";
	   				}
	   			  }
			   	System.out.println("neighbour= "+arr_con);
			   	String[] a = arr_con.split("-");
			   	int count = 0;
			   	for(int k=0;k<a.length;k++)
			   	{
			   		for(int l=0;l<SimV.size();l++)
			   		{
			   			if(SimV.get(l).equals(a[k]) && l!=i)
			   			{
			   				count++;
			   				break;
			   			}
			   		}
			   	}
			   	if(count == a.length)
			   	{
			   		System.out.println("Safe Vertex "+SimV.get(i));
			   		SimV.remove(i);
			   	}
			   	arr_con="";
			   	}
			   	for(int i=0;i<SimV.size();i++)
			   	{
			   		System.out.println("Resulted vertex are= "+SimV.get(i));
			   	}
			   	Collections.shuffle(SimV);
			   	result.add(SimV.get(0));
				System.out.println("Selected Vertex= "+SimV.get(0));
				int t=0;
				while(t<row)
				{
					String v1 = Vertex.dtab.getValueAt(t, 0).toString();
					String v2 = Vertex.dtab.getValueAt(t, 1).toString();
					if(v1.equals(SimV.get(0)) || v2.equals(SimV.get(0)))
					{
						System.out.println("Selected Index= "+t);
						//selected_index.add(i);
					update_table(t);
					t=0;
					}
					else{
						t++;
					}
				}
			   	for(int i=0;i<row;i++)
				{
                      System.out.println("After deletion vertices are "+Vertex.dtab.getValueAt(i, 0)+" and "+Vertex.dtab.getValueAt(i, 1));
				}
			   	SimV.clear();
			   	arr.clear();
				arrC.clear();
				arrV.clear();
			   	System.out.println("----------------------------------------------------------------");
			}
			else
			{
				System.out.println("=======================Not Similar=============================");
				//Collections.shuffle(arrV);
				
				result.add(arrV.get(0));
				System.out.println("Selected Vertex= "+arrV.get(0));
				int t=0;
				while(t<row)
				{
					String v1 = Vertex.dtab.getValueAt(t, 0).toString();
					String v2 = Vertex.dtab.getValueAt(t, 1).toString();
					if(v1.equals(arrV.get(0)) || v2.equals(arrV.get(0)))
					{
						System.out.println("Selected Index= "+t);
					update_table(t);
					t=0;
					}
					else{
						t++;
					}
				}
			arr.clear();
			arrC.clear();
			arrV.clear();
		  }	
		ct++;
		}
			String t = "";
			for(int i=0;i<result.size();i++)
			{
				t+=result.get(i)+",";
			}
			String[] t1 = {"Alom's",t};
			table.dtab.addRow(t1);
			for(int i=0;i<result.size();i++)
			{
				Vertex.labels[Integer.parseInt(result.get(i).toString())].setIcon(new ImageIcon("D://NWInfo/vertex.png"));
			}
			result.clear();
			
			long stoptime = System.currentTimeMillis();
			System.out.println("Start= "+starttime);
			System.out.println("Stop= "+stoptime);
			long elapsedTime = stoptime-starttime;
			System.out.println("Time Consumed= "+elapsedTime);
			
			String val = elapsedTime+","+algo;
			arr_graph.add(val);
		}
		
		else if(algo.equalsIgnoreCase("sd"))
		{
			long starttime =System.currentTimeMillis();
			ArrayList arr = new ArrayList();
			ArrayList arrV = new ArrayList();
			ArrayList<Integer> arrC = new ArrayList<>();
			ArrayList<Integer> arr_new = new ArrayList();
			ArrayList result = new ArrayList<>();
			
			System.out.println(num);
			int ct = 0;
			
				if(chk==false)
				{
				 row = Vertex.dtab.getRowCount();
				}
				System.out.println("row= "+row);
				while(ct<num && row!=0)
				{
					for(int i=0;i<row;i++)
					{
						arr.add(Vertex.dtab.getValueAt(i, 0).toString());
					}
					for(int i=0;i<row;i++)
					{
						System.out.println("Elements selected= "+arr.get(i));
					}
					
					System.out.println("+++++++++++++++++START++++++++++++++++++");
					
					int inc_count=0;
					String vertex = "";
					for(int i=0;i<arr.size();i++)
					{
						inc_count = 0;
						vertex = "";
						for(int j=0;j<row;j++)
						{
							if(arr.get(i).equals(Vertex.dtab.getValueAt(j, 0)))
							{
								inc_count++;
								vertex = arr.get(i).toString();
							}
						}
						if(inc_count==1)
						{
					    System.out.println("Incident_Count= "+inc_count);
					    System.out.println("Selected Vertex= "+vertex);
						arrV.add(vertex);
						}					
					}
					//checking if there is any vertex having one edge
				if(arrV.size()!=0)
				{
					
					int cnt=0;
					System.out.println("if condition...........");
					for(int i=0;i<arrV.size();i++)
					{
						for(int j=0;j<row;j++)
						{
							String v1 = Vertex.dtab.getValueAt(j, 0).toString();
							String v2 = Vertex.dtab.getValueAt(j, 1).toString();
							if(v2.equals(arrV.get(i)))
							{
								cnt = 0;
								for(int k=0;k<row;k++)
								{
									if(v1.equals(Vertex.dtab.getValueAt(k, 0)))
									{
										cnt++;
									}
								}
								System.out.println("no of edge= "+cnt+" for the vertex "+v1);
								arrC.add(cnt);
								arr_new.add(Integer.parseInt(v1));
							}
						}
					}
	               
					arr_new = sorting(arrC, arr_new);
					 arr_new = redundant_remove(arr_new,arrC);
					for(int i=0;i<arr_new.size();i++)
					{
						System.out.println("selected vertex= "+arr_new.get(i));
						result.add(arr_new.get(i));
					}
					
					
					int t=0;
					for(int i=0;i<arr_new.size();i++)
					{
						t=0;
					while(t<row)
					{
						String v1 = Vertex.dtab.getValueAt(t, 0).toString();
						String v2 = Vertex.dtab.getValueAt(t, 1).toString();
						//System.out.println("check arr= "+arr_new.get(i));
						if(arr_new.get(i)==Integer.parseInt(v1) || arr_new.get(i)==Integer.parseInt(v2))
						{
						System.out.println("Selected Index= "+t);
						update_table(t);
						t=0;
						}
						else{
							t++;
						}
					}
					}
				}
				
				else
				{
					System.out.println("else condition.......");
				}
					arr_new.clear();
					arr.clear();
					arrV.clear();
					arrC.clear();
					System.out.println("count= "+ct);
					ct++;
				}
				String t = "";
				for(int i=0;i<result.size();i++)
				{
					t+=result.get(i)+",";
				}
				String[] t1 = {"SD",t};
				table.dtab.addRow(t1);
				for(int i=0;i<result.size();i++)
				{
					Vertex.labels[Integer.parseInt(result.get(i).toString())].setIcon(new ImageIcon("D://NWInfo/vertex.png"));
				}
				
				result.clear();
				long stoptime = System.currentTimeMillis();
				System.out.println("Start= "+starttime);
				System.out.println("Stop= "+stoptime);
				long elapsedTime = stoptime-starttime;
				System.out.println("Time Consumed= "+elapsedTime);
				
				String val = elapsedTime+","+algo;
				arr_graph.add(val);
				
				
				Vertex.btnNewButton.setVisible(true);
				}
		}
	
	
	
	public void update_table(int it)
	{
		chk = true;
		Vertex.dtab.removeRow(it);
		algo.row = Vertex.dtab.getRowCount();
	}
	
  public ArrayList redundant_remove(ArrayList arr)
  {
	  for(int i=0;i<arr.size();i++)
	  {
		for(int j=0;j<arr.size();j++)
		{
			if(arr.get(i).equals(arr.get(j)) && i!=j)
			{
				arr.remove(j);
			}
		}
	  }
	  return arr;
  }
	
  public Vector redundant_remove(Vector arr)
  {
	  int temp=0;
	  for(int i=0;i<arr.size();i++)
	  {
		for(int j=i;j<arr.size();j++)
		{
			if(arr.get(i).equals(arr.get(j)) && i!=j)
			{
				arr.remove(j);
			}
		}
	  }
	  return arr;
  }
  
  public ArrayList sorting(ArrayList<Integer> arr,ArrayList<Integer> arr1)
  {
	  //ArrayList arr1 = new ArrayList<>();
	  int t=0,t1=0;
	  int tmp = 0;
	  for(int i=0;i<arr.size();i++)
	  {
		  tmp=i;
		  for(int j=tmp;j<arr.size();j++)
		  {
			  if(arr.get(tmp)<arr.get(j))
			  {
				  t = arr1.get(tmp);
				  t1 = arr1.get(j);
				  arr1.set(tmp, t1);
				  arr1.set(j, t);
			  }
		  }
	  }
	  return arr1;
  }
  public ArrayList redundant_remove(ArrayList arr,ArrayList arr1)
  {
	  for(int i=0;i<arr.size();i++)
	  {
		for(int j=0;j<arr.size();j++)
		{
			if(arr.get(i).equals(arr.get(j)) && i!=j)
			{
				arr.remove(j);
				arr1.remove(j);
			}
		}
	  }
	  return arr;
  }
}
