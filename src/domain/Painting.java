package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class Painting {

    private int rows;
    private int cols;

    private boolean[][] mapping;

    public Painting(BufferedReader input) throws IOException {
        // read 
        String currentLine = input.readLine();
        String[] dimensions = currentLine.split(" ");
        setCols(Integer.parseInt(dimensions[1]));
        setRows(Integer.parseInt(dimensions[0]));
        mapping = new boolean[rows][cols];

        int row = 0;

        while ((currentLine = input.readLine()) != null) {

            char[] chars = currentLine.toCharArray();

            for (int i = 0; i < chars.length; i++) {

                if (chars[i] == '.') {
                    mapping[row][i] = false;
                } else {
                    mapping[row][i] = true;
                }
            }

            row++;
        }

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

}
