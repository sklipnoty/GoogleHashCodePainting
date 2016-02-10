package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class StartUp {

    public static void main(String args[]) {
        try (BufferedReader logoReader = new BufferedReader(new FileReader("input/logo.in"))) {
            Painting logoPainting = new Painting(logoReader);
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
