/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsPK;

import java.util.Scanner;
import java.util.Vector;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Abdullah Fadhel
 */
public class ChartsMainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LegendInfo legendInfo = new LegendInfo();
        Scanner input = new Scanner(System.in);
        Vector<Double> z = new Vector<>();
        Vector<Double> x = new Vector<>();
        Vector<Double> y = new Vector<>();
            
        String color, title, position, xLable, yLable,
                chartBackgroundColor, plotBackgroundColor,
                chartTitle;
       
        int numberOfLines, lineLength, choice = 0,choice1 ;
        double oneX, oneY , oneZ;
        
        
        System.out.println("press (1) to draw a line chart");
        System.out.println("press (2) to draw a bubble chart");
        System.out.println("press (3) to draw a pie chart");
        
        System.out.println("Enter Your Choice");
        choice1 = input.nextInt();
        
        if(choice1 == 1 || choice1 == 2)
            choice = 1;
        else if(choice1 == 3)
            choice = 2;
        else{
            System.out.println("CHART SELECTED NOT FOUND");
            System.exit(0);
        }
        

        

        System.out.println("Enter Legend background Color ");
        color = input.next();
        legendInfo.setColor(color);
        
        System.out.println("Enter Legend position ");
        position = input.next();
        legendInfo.setPosition(position);

        
        
        System.out.println("Enter Title of This Chart ");
        chartTitle = input.next();

        System.out.println("Enter chart  background Color ");
        chartBackgroundColor = input.next();
        
        System.out.println("Enter plot background Color ");
        plotBackgroundColor = input.next();

        if(choice == 1)
        {
        System.out.println("Enter Number Of Lines");
        numberOfLines = input.nextInt();
        
        System.out.println("Enter X lable");
        xLable = input.next();
        
        System.out.println("Enter Y lable");
        yLable = input.next();

        Axis axis = new Axis(xLable, yLable, 0, 0, 0, 0);
        
        if (choice1 == 1) {
            Vector<LineChartDataSeries> data = new Vector<>();
            for (int i = 0; i < numberOfLines; i++) {
                System.out.println("Enter Number of points in Line " + (i+1));
                lineLength = input.nextInt();
                System.out.println("Now Enter informatin of line " + (i+1));
                for (int j = 0; j < lineLength; j++) {
                    System.out.println("x");
                    oneX = input.nextDouble();
                    System.out.println("y");
                    oneY = input.nextDouble();
                    x.add(oneX);
                    y.add(oneY);

                }

                System.out.println("Enter Color of line " + (i+1));
                color = input.next();
                System.out.println("Enter Title of line " + (i+1));
                title = input.next();
                data.add(new LineChartDataSeries(color, title, x, y));

                x = new Vector<>();
                y = new Vector<>();

            }

            LineChart lineC = new LineChart(chartTitle, axis, legendInfo, data, plotBackgroundColor,
                    chartBackgroundColor);
            lineC.setVisible(true);

        } 
                
        else if (choice1 == 2) {
            Vector<BubbleChartDataSeries> data1 = new Vector<>();
            for (int i = 0; i < numberOfLines; i++) {
                System.out.println("Enter Number of points in Line " + (i+1));
                lineLength = input.nextInt();
                System.out.println("Now Enter informatin of line " + (i+1));
                for (int j = 0; j < lineLength; j++) {
                    System.out.println("x");
                    oneX = input.nextDouble();
                    System.out.println("y");
                    oneY = input.nextDouble();
                    System.out.println("z");
                    oneZ = input.nextDouble();
                    x.add(oneX);
                    y.add(oneY);
                    z.add(oneZ);

                }

                System.out.println("Enter Color of line " + (i+1));
                color = input.next();
                System.out.println("Enter Title of line " + (i+1));
                title = input.next();
                data1.add(new BubbleChartDataSeries(title, color, x, y, z));

                x = new Vector<>();
                y = new Vector<>();
                z = new Vector<>();

            }

            BubbleChart bubblechart = new BubbleChart(chartTitle, axis, legendInfo, data1,
                    plotBackgroundColor, chartBackgroundColor);

            bubblechart.pack();
            RefineryUtilities.centerFrameOnScreen(bubblechart);
            bubblechart.setVisible(true);
        }
        
        }
        
        else if(choice == 2)
        {
    Vector<PieChartDataSeries> data2 = new Vector<>();
    System.out.println("Enter Number of Sections in Line " );
    lineLength = input.nextInt();
    String category;
    for(int i = 0 ; i < lineLength ; i++)
    {
                    System.out.println("tite of section " + (i+1));
                    category  =  input.next();
                    System.out.println("inventory of section  " + (i+1));
                    oneY = input.nextDouble();
                    
                System.out.println("Enter Color of section  " + (i+1));
                color = input.next();
                data2.add(new PieChartDataSeries(color,category," ", oneY));

        
    }
    
    PieChart pie = new PieChart(chartTitle,null, legendInfo,data2,plotBackgroundColor,
    chartBackgroundColor);  
    pie.setSize( 560 , 367 );
     
    RefineryUtilities.centerFrameOnScreen( pie );    
    pie.setVisible( true );
        }
    
    }
}
