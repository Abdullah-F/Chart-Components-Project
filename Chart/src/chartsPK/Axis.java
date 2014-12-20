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
public class Axis {
    private String xLabel;
    private String yLabel;
    private int yMax;
    private int yMin;
    private int xMax;
    private int xMin;
    
    public Axis()
    {
        xLabel = yLabel ="none";
        yMax = xMax = 50;
        yMin = xMin = 0;
    }
    
    public Axis(String xLabel , String ylabel ,
            int yMax , int yMin,
            int xMax , int xMin)
    {
        this.xLabel = xLabel;
        this.yLabel =ylabel;
        this.yMax = yMax;
        this.xMax =xMax;
        this.yMin =yMin;
        this.xMin =xMin;
    }
    
    public void setXLabel(String xLabel)
    {
        this.xLabel = xLabel;
    }
    
    public void setYLabel(String yLabel)
    {
        this.yLabel = yLabel;
    }
    
    public String getXLabel()
    {
        return xLabel;
    }
    
    public String getYLabel()
    {
        return yLabel;
    }
    
    public void setYMax(int yMax)
    {
     this.yMax = yMax;   
    }
    
    public void setXMax(int xMax)
    {
     this.xMax = xMax;   
    }
    
    public void setYMin(int yMin)
    {
     this.yMin = yMin;   
    }
    
    public void setXMin(int xMin)
    {
     this.xMin = xMin;   
    }
    
    public int getYMax()
    {
     return yMax ;  
    }
    
    public int getXMax()
    {
     return xMax ;  
    }
    
    public int getYMin()
    {
     return yMin ;  
    }
    
    public int getXMin()
    {
     return xMin ;  
    }
    
    }
