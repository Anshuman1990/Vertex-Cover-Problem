package Graph;

import java.util.ArrayList;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RefineryUtilities;



public class Plot_graph {

	public static void plot(ArrayList arr)
	{
		
		
		DefaultCategoryDataset ser1 = new DefaultCategoryDataset();
		for(int i=0;i<arr.size();i++)
		{
			String[] a = arr.get(i).toString().split(",");
			ser1.setValue(Double.parseDouble(a[0]), "Time delay(in ms)", a[1]);
		}
		final graph1 demo1 = new graph1("Line Graph",ser1);
	    demo1.pack();
	    RefineryUtilities.centerFrameOnScreen(demo1);
	    demo1.setVisible(true);
	}
}
