package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Painter {

    public List<String> solvePainting(Painting painting) {
        //Just look for horz. and vert lines.
        
        boolean[][] mapping = painting.getMapping();
        PriorityQueue<Line> lines = new PriorityQueue<>();
        ArrayList<Line> removedLines = new ArrayList<>();
        
        //hozir
        for(int i = 0; i < mapping.length; i++) {
            Line line = new Line();
            for(int j = 0; j < mapping[0].length; j++) {
                
                //end row or start of a line
                while(j < mapping[i].length && !mapping[i][j]) 
                    j++;
                
                line.setStartX(i);
                line.setStartY(j);
            
                while (j < mapping[i].length && mapping[i][j]) {
                    j++;
                }
                
                line.setEndX(i);
                line.setEndY(j-1);
                
                lines.add(line);
            }
        }
        
        //vert
        for(int i = 0; i < mapping[0].length; i++) {
            Line line = new Line();
            for(int j = 0; j < mapping.length; j++) {
                
                //end row or start of a line
                while(j < mapping.length && !mapping[j][i]) 
                    j++;
                
                line.setStartX(j);
                line.setStartY(i);
            
                while (j < mapping.length && mapping[j][i]) {
                    j++;
                }
                
                line.setEndX(j-1);
                line.setEndY(i);
                
                lines.add(line);
            }
        }
        
        // remove from painting
        
        ArrayList<String> commands = new ArrayList<>();
        
        while (!lines.isEmpty()) {
            Line line = lines.poll();
            removedLines.add(line);
            if (!painting.isAlreadyPainted(line))
            {
                painting.removeLine(line);
                commands.add(generatePaintCommand(line));
            }
        }
        
        return commands;
    }
    
    public String generatePaintCommand(Line line)
    {
        // PAINT_LINE 0 4 3 4
        return String.format("PAINT_LINE %d %d %d %d",
                line.getStartX(), line.getEndX(),
                line.getStartY(), line.getEndY());
                
    }
}
