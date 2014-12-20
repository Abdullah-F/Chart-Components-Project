/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsPK;

/**
 *
 * @author Abdullah Fadhel
 */
public class LegendInfo {

    private String backGroundColor;
    private String legendPosition;

    public void setColor(String color) {
        backGroundColor = color;
    }

    public String getColor() {
        return backGroundColor;
    }

    public void setPosition(String position) {
        legendPosition = position;
    }

    public String getPosition() {
        return legendPosition;
    }
}
