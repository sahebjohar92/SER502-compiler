import compiler.RaceCompiler;
import main.race.RaceLexer;
import main.race.RaceParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import runtime.RaceRuntime;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        String inputFile = "inputFile.race";

        String inputPath = "./src/data/";

        String path = inputPath + inputFile;

        if (args.length > 0) {
            path = args[0];
        }

        CharStream code = CharStreams.fromFileName(path);

        RaceLexer raceLexer = new RaceLexer(code);
        CommonTokenStream tokens = new CommonTokenStream(raceLexer);

        RaceParser raceParser = new RaceParser(tokens);
        ParseTree parseTree = raceParser.program();

        PrintWriter writer = new PrintWriter(path.replace("race", "intermediate"), "UTF-8");
        
        try {
            RaceCompiler compiler = new RaceCompiler();
            compiler.visit(parseTree);
            
            System.out.println(parseTree.toStringTree(raceParser));
            System.out.println(compiler.getOutput());
            writer.println(compiler.getOutput());

            RaceRuntime runtime = new RaceRuntime(compiler.getOutput());
            runtime.execute();
            System.out.println(runtime.getOutput());

            PrintWriter writerOutput = new PrintWriter(path.replace("race", "output"), "UTF-8");
            writerOutput.println("Output of the program ");
            writerOutput.println(runtime.getOutput());
            writerOutput.close();
        }catch(Exception ex) {
        	writer.println("Syntax error in example program. Please check.");
        	System.out.println("Syntax error in example program. Please check.");
        }

        writer.close();
    }
}
