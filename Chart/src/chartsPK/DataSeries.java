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
public class DataSeries {

    private String title;
    private String color;

    public DataSeries() {
        title = color = "";
    }

    public DataSeries(String title, String color) {
        this.title = title;
        this.color = color;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
