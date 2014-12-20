package chartsPK;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.RectangleEdge;

public class BubbleChart extends Charts {

    private Vector<BubbleChartDataSeries> dataSeries;

    public BubbleChart(String title, Axis axis, LegendInfo legendInfo,
            Vector<BubbleChartDataSeries> dataSeries, String color, String color1) {
        super(title, axis, legendInfo);
        this.dataSeries = dataSeries;
        setTitle("Bubble Chart");
        JPanel jpanel = createPanel(color, color1);
        jpanel.setPreferredSize(new Dimension(560, 370));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(jpanel);
    }

    private JFreeChart createChart(XYZDataset xyzdataset, String color1,
            String color2) {
        JFreeChart chart = ChartFactory.createBubbleChart(
                getMyTitle(),
                getAxis().getYLabel(),
                getAxis().getXLabel(),
                xyzdataset,
                PlotOrientation.HORIZONTAL,
                true, true, false);
        Color color;

        XYPlot xyplot = (XYPlot) chart.getPlot();
        xyplot.setForegroundAlpha(0.65F);

        try {
            Field field = Class.forName("java.awt.Color").getField(color1);
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        xyplot.setBackgroundPaint(color);

        try {
            Field field = Class.forName("java.awt.Color").getField(color2);
            color = (Color) field.get(null);

        } catch (Exception e) {
            color = null; // Not defined
        }

        chart.setBackgroundPaint(color);

        XYItemRenderer xyitemrenderer = xyplot.getRenderer();

        for (int i = 0; i < dataSeries.size(); i++) {

            try {
                Field field = Class.forName("java.awt.Color").getField(dataSeries.get(i).getColor());
                color = (Color) field.get(null);
            } catch (Exception e) {
                color = null; // Not defined
            }

            xyitemrenderer.setSeriesPaint(i, color);

        }

        RectangleEdge p = RectangleEdge.BOTTOM;
        LegendTitle legend = chart.getLegend();
        switch (getLegend().getPosition().toLowerCase()) {
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

        NumberAxis numberaxis = (NumberAxis) xyplot.getDomainAxis();
        numberaxis.setLowerMargin(0.2);
        numberaxis.setUpperMargin(0.5);

        NumberAxis numberaxis1 = (NumberAxis) xyplot.getRangeAxis();
        numberaxis1.setLowerMargin(0.8);
        numberaxis1.setUpperMargin(0.9);

        return chart;
    }

    public XYZDataset createDataset() {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double x[];
        double y[];
        double z[];
        for (int i = 0; i < dataSeries.size(); i++) {
            x = new double[dataSeries.get(i).getXValue().size()];
            y = new double[dataSeries.get(i).getXValue().size()];
            z = new double[dataSeries.get(i).getXValue().size()];
            for (int j = 0; j < dataSeries.get(i).getXValue().size(); j++) {
                x[j] = dataSeries.get(i).getXValue().get(j);
                y[j] = dataSeries.get(i).getYValue().get(j);
                z[j] = dataSeries.get(i).getZValue().get(j);
            }

            double uniqeBubbleLine[][] = {x, y, z};
            dataset.addSeries(dataSeries.get(i).getTitle(),
                    uniqeBubbleLine);

        }

        return dataset;

    }

    public JPanel createPanel(String color, String color1) {
        JFreeChart jfreechart = createChart(createDataset(), color, color1);
        ChartPanel chartpanel = new ChartPanel(jfreechart);

        chartpanel.setDomainZoomable(true);
        chartpanel.setRangeZoomable(true);

        return chartpanel;
    }

}
