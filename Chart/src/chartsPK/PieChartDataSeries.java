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
public class PieChartDataSeries extends DataSeries{
    
    private  double percent;
    
    public PieChartDataSeries()
    {
        super();
        percent = 0.0;
    }
    
    public PieChartDataSeries(String color , String title, String x , double y)
    {
        super(title , color);
        percent = y;
        
        
    }
    
    public void setPercent(double y)
    {
        
            percent = y;
        
    }
    
    public double getPercent()
    {
        return percent;
    }    
}
