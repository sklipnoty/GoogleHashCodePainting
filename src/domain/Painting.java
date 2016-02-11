package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class Painting
{

    private int rows;
    private int cols;

    private boolean[][] mapping;
    private boolean[][] painted;

    public Painting(BufferedReader input) throws IOException
    {
        // read 
        String currentLine = input.readLine();
        String[] dimensions = currentLine.split(" ");
        setCols(Integer.parseInt(dimensions[1]));
        setRows(Integer.parseInt(dimensions[0]));
        mapping = new boolean[rows][cols];
        painted = new boolean[rows][cols];

        int row = 0;

        while ((currentLine = input.readLine()) != null)
        {

            char[] chars = currentLine.toCharArray();

            for (int i = 0; i < chars.length; i++)
            {
                if (chars[i] == '.')
                {
                    mapping[row][i] = false;
                }
                else
                {
                    mapping[row][i] = true;
                }
            }
            row++;
        }

    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getCols()
    {
        return cols;
    }

    public void setCols(int cols)
    {
        this.cols = cols;
    }

    public boolean[][] getMapping()
    {
        return mapping;
    }

    public void setMapping(boolean[][] mapping)
    {
        this.mapping = mapping;
    }

    public void print()
    {
        System.out.println("-------------------------------------------------------------------------------------------");
        for(int i = 0; i < rows; i++) {
            System.out.println("");
            for(int j = 0; j < cols; j++) {
                System.out.print((painted[i][j] ? "#" : "."));
            }
        }
        
        System.out.println("");
    }

    public void removeLine(Line line)
    {
        if (line.isVertical())
        {
            for (int i = line.getStartX(); i <= line.getEndX(); i++)
            {
                mapping[line.getStartY()][i] = false;
                painted[line.getStartY()][i] = true;
            }
        }
        else
        {
            for (int i = line.getStartY(); i <= line.getEndY(); i++)
            {
                mapping[i][line.getEndX()] = false;
                painted[i][line.getEndX()] = true;
            }
        }
    }
    
    public boolean isAlreadyPainted(Line line)
    {
        if (line.isVertical())
        {
            for (int i = line.getStartX(); i <= line.getEndX(); i++)
            {
                if (!(painted[line.getEndY()][i]))
                    return false;
            }
            
            return true;
        }
        else
        {
            for (int i = line.getStartY(); i <= line.getEndY(); i++)
            {
                if (!(painted[i][line.getEndX()]))
                    return false;
            }
            
            return true;
        }
    }

}
