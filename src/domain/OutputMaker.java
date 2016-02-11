package domain;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OutputMaker {

    public OutputMaker() {

    }

    public void makeOutput(List<String> commands, String fileName) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output/"+fileName+".txt"), "utf-8"))) {
            writer.write(commands.size()+"\n");
            for(String command : commands) {
                writer.write(command+"\n");
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(OutputMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OutputMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OutputMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
