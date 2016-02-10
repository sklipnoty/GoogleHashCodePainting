package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Painter {
    public Painter(Painting painting) {
       solvePainting(painting); 
    }

    private void solvePainting(Painting painting) {
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
            
                while(mapping[i][j]) {
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
            
                while(mapping[j][i]) {
                    j++;
                }
                
                line.setEndX(j-1);
                line.setEndY(i);
                
                lines.add(line);
            }
        }
        
        // remove from painting
        
        while(!lines.isEmpty()) {
            Line line = lines.poll();
            
            for(int i = 0;  i < removedLines.size(); i++) {
                if(line.isValid(removedLines.get(i))){
                    
                }
            }
            
            
            removedLines.add(line);
            painting.removeLine(line);
        }
        
        
        
        
        
    }
}
