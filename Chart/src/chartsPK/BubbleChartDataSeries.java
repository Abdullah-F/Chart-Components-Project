/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsPK;

import java.util.Vector;

/**
 *
 * @author Abdullah Fadhel
 */
public class BubbleChartDataSeries extends DataSeries {

    private Vector<Double> xValues;
    private Vector<Double> yValues;
    private Vector<Double> zValues;

    public BubbleChartDataSeries() {
        super();
        xValues = new Vector<>(10);
        yValues = new Vector<>(10);
        zValues = new Vector<>(10);

    }

    public BubbleChartDataSeries(String title, String color,
            Vector<Double> xValue, Vector<Double> yValue, Vector<Double> zValue) {
        super(title, color);

        xValues = new Vector<>(xValue.size());
        yValues = new Vector<>(yValue.size());
        zValues = new Vector<>(zValue.size());

        for (double x1 : xValue) {
            xValues.add(x1);
        }

        for (double y1 : yValue) {
            yValues.add(y1);
        }

        for (double z1 : zValue) {
            zValues.add(z1);
        }
    }

    public void setXValue(Vector<Double> xValues) {
        this.xValues = xValues;
    }

    public void setYValue(Vector<Double> yValues) {
        this.yValues = yValues;
    }

    public void setZValue(Vector<Double> zValues) {
        this.zValues = zValues;
    }

    public Vector<Double> getXValue() {
        return xValues;
    }

    public Vector<Double> getYValue() {
        return yValues;
    }

    public Vector<Double> getZValue() {
        return zValues;
    }

}
