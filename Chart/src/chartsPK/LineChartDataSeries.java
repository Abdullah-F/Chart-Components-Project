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
public class LineChartDataSeries extends DataSeries {

    private Vector<Double> xValues;
    private Vector<Double> yValues;

    public LineChartDataSeries() {
        super();
        xValues = new Vector<>(10);
        yValues = new Vector<>(10);
    }

    public LineChartDataSeries(String color, String title, Vector<Double> x, Vector<Double> y) {
        super(title, color);
        xValues = new Vector<>(x.size());
        yValues = new Vector<>(y.size());

        for (Double x1 : x) {
            xValues.add(x1);
        }

        for (Double y1 : y) {
            yValues.add(y1);
        }
    }

    public void setXValues(Vector<Double> x) {
        for (Double x1 : x) {
            xValues.add(x1);
        }
    }

    public Vector<Double> getXValues() {
        return xValues;
    }

    public void setYValues(Vector<Double> y) {
        for (Double y1 : y) {
            xValues.add(y1);
        }
    }

    public Vector<Double> getYValues() {
        return yValues;
    }
}
