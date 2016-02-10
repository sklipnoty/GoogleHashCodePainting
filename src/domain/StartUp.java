package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StartUp {

    public static void main(String args[]) {
        try (BufferedReader logoReader = new BufferedReader(new FileReader("input/logo.in"))) {
            Painting logoPainting = new Painting(logoReader);
            Painter painter = new Painter();
            List<String> paintCommands = painter.solvePainting(logoPainting);
            System.out.println(paintCommands.size());
            for (String cmd : paintCommands)
                System.out.println(cmd);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
