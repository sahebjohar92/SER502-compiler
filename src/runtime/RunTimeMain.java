package runtime;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.io.PrintWriter;

public class RunTimeMain {

    public static void main(String[] args) throws IOException {

        String inputFile = "inputFile.intermediate";

        String inputPath = "./src/data/";

        String path = inputPath + inputFile;

        if (args.length > 0) {
            path = args[0];
        }

        CharStream code = CharStreams.fromFileName(path);

        PrintWriter writer = new PrintWriter(path.replace("intermediate", "output"), "UTF-8");

        try {

            RaceRuntime runtime = new RaceRuntime(code.toString());
            runtime.execute();
            System.out.println(runtime.getOutput());

            writer.println("Output of the program ");
            writer.println(runtime.getOutput());
        }catch(Exception ex) {
            writer.println("Syntax error in example program. Please check.");
            System.out.println("Syntax error in example program. Please check.");
        }
        writer.close();
    }
}
