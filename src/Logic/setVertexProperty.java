package Logic;

import java.util.Random;

import Forms.Vertex;;

public class setVertexProperty {
public static int tRange=0,x=0,y=0;
//public static int dis[],range[]=null;
public static int j=0;
	public static void setProperty(int i){
		System.out.println("setproperty.....");
	Random r=new Random();	
	int count=0;
	
	x=r.nextInt(400);
	y=r.nextInt(200);
	
	Vertex.posx[i] = x;
	Vertex.posy[i] = y;
			

	

	Vertex.posx[i]=x;
	Vertex.posy[i]=y;
    System.out.println(">setNode>"+x+"--"+y);
	}
	
	
	
}
