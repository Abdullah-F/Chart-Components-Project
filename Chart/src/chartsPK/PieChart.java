package chartsPK;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class PieChart extends Charts {

    private Vector<PieChartDataSeries> dataSeries;

    public PieChart(String title, Axis axis, LegendInfo legendInfo,
        
        Vector<PieChartDataSeries> dataSeries, String color1,
        String color2) {
        super(title, axis, legendInfo);
        this.dataSeries = dataSeries;
        setTitle("Pie Chart");
        setContentPane(createPanel(color1, color2));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (int i = 0; i < dataSeries.size(); i++) {
            dataset.setValue(dataSeries.get(i).getTitle(),
                    dataSeries.get(i).getPercent());
        }

        return dataset;
    }

    
    private JFreeChart createChart(PieDataset dataset, String color1,
            String color2) {
        JFreeChart chart = ChartFactory.createPieChart(
                getMyTitle(), // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);

        Color color;

        PiePlot plot = (PiePlot) chart.getPlot();

        try {
            Field field = Class.forName("java.awt.Color").getField(color1);
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        plot.setBackgroundPaint(color);

        for (int i = 0; i < dataSeries.size(); i++) {
            try {
                Field field = Class.forName("java.awt.Color").
                        getField(dataSeries.get(i).getColor());

                color = (Color) field.get(null);
            } catch (Exception e) {
                color = null; // Not defined
            }

            plot.setSectionPaint(i, color);

        }

        try {
            Field field = Class.forName("java.awt.Color").getField(color2);
            color = (Color) field.get(null);

        } catch (Exception e) {
            color = null; // Not defined
        }

        chart.setBackgroundPaint(color);

        RectangleEdge p = RectangleEdge.BOTTOM;
        LegendTitle legend = chart.getLegend();
        switch (getLegend().getPosition()) {
            case "top":
                p = RectangleEdge.TOP;
                break;
            case "bottom":
                p = RectangleEdge.BOTTOM;
                break;
            case "left":
                p = RectangleEdge.LEFT;
                break;
            case "right":
                p = RectangleEdge.RIGHT;
                break;
        }

        legend.setPosition(p);

        try {
            Field field = Class.forName("java.awt.Color").getField(getLegend().getColor());
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        legend.setBackgroundPaint(color);

        return chart;
    }

    public JPanel createPanel(String color1, String color2) {
        JFreeChart chart = createChart(createDataset(), color1, color2);

        return new ChartPanel(chart);
    }
}