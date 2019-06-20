package Graph;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class graph1 extends ApplicationFrame {
	DefaultCategoryDataset ser=null;
	XYSeries ser1 = null;
	XYSeries ser2 = null;
	
    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public graph1(final String title, DefaultCategoryDataset serA) {

        super(title);
        ser = serA;
        
        //final DefaultCategoryDataset dataset = (DefaultCategoryDataset) createDataset(ser);
        final JFreeChart chart = createChart(ser);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        setContentPane(chartPanel);

    }
//    private DefaultCategoryDataset createDataset(DefaultCategoryDataset series1) {
//        
//        
// 
//    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//         dataset.addSeries(series1);
//         return dataset;
//         
//     }
    /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
   
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final DefaultCategoryDataset dataset) {
        
        // create the chart...
         JFreeChart chart = ChartFactory.createBarChart(
            "Time Complexity",      // chart title
            "Algorithms",                      // x axis label
            "Time delay(in ms)",                      // y axis label
             dataset,                  // data
          // PlotOrientation.VERTICAL,
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.green);

 // final StandardLegend legend = (StandardLegend) chart.getLegend();
    //    legend.setDisplaySeriesShapes(true);
        
//        // get a reference to the plot for further customisation...
//         XYPlot plot = chart.getXYPlot();
//        plot.setBackgroundPaint(Color.white);
//   //  plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
//        plot.setDomainGridlinePaint(Color.BLACK);
//        plot.setRangeGridlinePaint(Color.BLACK);
//        
//         XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
//        renderer.setSeriesLinesVisible(0, true);
//        renderer.setSeriesShapesVisible(1, true);
//        renderer.setSeriesPaint(0, Color.BLUE);
//        renderer.setSeriesPaint(1, Color.cyan);
//        plot.setRenderer(renderer);
//        
//        
//        
////        NumberAxis xaxis = (NumberAxis)plot.getRangeAxis();
////        xaxis.setRange(0,3);
////        xaxis.setTickUnit(new NumberTickUnit(1));
////        xaxis.setVerticalTickLabels(false);
////        
////       NumberAxis yaxis = (NumberAxis)plot.getRangeAxis();
////       yaxis.setRange(0,1000);
////       yaxis.setTickUnit(new NumberTickUnit(10));
////       yaxis.setVerticalTickLabels(true);
                
        return chart;
        
    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
	

	
}
