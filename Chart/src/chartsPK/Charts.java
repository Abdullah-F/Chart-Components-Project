/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsPK;

import javax.swing.JFrame;

/**
 *
 * @author Abdullah Fadhel
 */
public class Charts extends JFrame {

    private String title;
    private Axis axis;
    private LegendInfo legendInfo;

    public Charts() {
        super();
    }

    public Charts(String title, Axis axis, LegendInfo legendInfo) {
        super();
        this.axis = axis;
        this.legendInfo = legendInfo;
        this.title = title;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    public Axis getAxis() {
        return axis;
    }

    public void setMyTitle(String title) {
        this.title = title;
    }

    public String getMyTitle() {
        return title;
    }

    public void setLegend(LegendInfo legendInfo) {
        this.legendInfo = legendInfo;
    }

    public LegendInfo getLegend() {
        return legendInfo;
    }
}
