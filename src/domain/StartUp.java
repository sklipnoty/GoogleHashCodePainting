package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StartUp {

    public static void main(String args[]) {
        try (
                BufferedReader logoReader = new BufferedReader(new FileReader("input/logo.in"));
                BufferedReader learnReader = new BufferedReader(new FileReader("input/learn_and_teach.in"));
                BufferedReader rightAngle = new BufferedReader(new FileReader("input/right_angle.in"))) {
            Painting logoPainting = new Painting(logoReader);
            Painting learnPainting = new Painting(learnReader);
            Painting rightPainting = new Painting(rightAngle);

            Painter painter = new Painter();
            OutputMaker outputMaker = new OutputMaker();

            outputMaker.makeOutput(painter.solvePainting(logoPainting), "logoOut");
            outputMaker.makeOutput(painter.solvePainting(learnPainting), "learnOut");
            outputMaker.makeOutput(painter.solvePainting(rightPainting), "rightOut");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
