/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsPK;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.ui.RectangleEdge;

public class LineChart extends Charts {

    private Vector<LineChartDataSeries> dataSeries;

    public LineChart() {
        super();
    }

    public LineChart(String title, Axis axis, LegendInfo legendInfo,
            Vector<LineChartDataSeries> dataSeries, String color, String color1) {

        super(title, axis, legendInfo);
        this.dataSeries = dataSeries;

        JPanel chartPanel = createChartPanel(color, color1);
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setTitle("Line  Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private JPanel createChartPanel(String color1, String color2) {

        XYDataset dataset = createDataset();

        boolean showLegend = false;
        boolean createURL = false;
        boolean createTooltip = false;

        JFreeChart chart = ChartFactory.createXYLineChart(getMyTitle(),
                getAxis().getXLabel(), getAxis().getYLabel(), dataset,
                PlotOrientation.VERTICAL, true, true, true);

        Color color;

        XYPlot plot = (XYPlot) chart.getPlot();

        try {
            Field field = Class.forName("java.awt.Color").getField(color1);
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        plot.setBackgroundPaint(color);

        try {
            Field field = Class.forName("java.awt.Color").getField(color2);
            color = (Color) field.get(null);

        } catch (Exception e) {
            color = null; // Not defined
        }

        chart.setBackgroundPaint(color);

        for (int i = 0; i < dataSeries.size(); i++) {

            try {
                Field field = Class.forName("java.awt.Color").getField(dataSeries.get(i).getColor());
                color = (Color) field.get(null);
            } catch (Exception e) {
                color = null; // Not defined
            }

            plot.getRenderer().setSeriesPaint(i, color);

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

        return new ChartPanel(chart);
    }

    private XYDataset createDataset() {

        XYSeriesCollection dataset = new XYSeriesCollection();
        Vector<XYSeries> series = new Vector<>();

        for (LineChartDataSeries dataSerie : dataSeries) {
            series.add(new XYSeries(dataSerie.getTitle()));
        }

        for (int i = 0; i < dataSeries.size(); i++) {
            for (int j = 0; j < dataSeries.get(i).getXValues().size(); j++) {
                series.get(i).add(dataSeries.get(i).getXValues().get(j),
                        dataSeries.get(i).getYValues().get(j));
            }
        }

        for (XYSeries serie : series) {
            dataset.addSeries(serie);
        }

        return dataset;
    }

}
