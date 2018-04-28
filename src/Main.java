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

        String inputPath = "./src/sample/input/";
        String outputPath = "./src/sample/output/";
        CharStream code = CharStreams.fromFileName(inputPath + inputFile);

        RaceLexer raceLexer = new RaceLexer(code);
        CommonTokenStream tokens = new CommonTokenStream(raceLexer);

        RaceParser raceParser = new RaceParser(tokens);
        ParseTree parseTree = raceParser.program();

        System.out.println(parseTree.toStringTree(raceParser));

        PrintWriter writer = new PrintWriter(outputPath + inputFile, "UTF-8");
        
        String parseTreeOutput = parseTree.toStringTree(raceParser);
        
        if(parseTreeOutput !=null && !parseTreeOutput.contains("mismatched input")) {
        	System.out.println(parseTree.toStringTree(raceParser));

            RaceCompiler compiler = new RaceCompiler();
            compiler.visit(parseTree);

            System.out.println(compiler.getOutput());
            writer.println(compiler.getOutput());

            RaceRuntime runtime = new RaceRuntime(compiler.getOutput());
            runtime.execute();
            System.out.println(runtime.getOutput());

            writer.println("Output of the program ");
            writer.println(runtime.getOutput());
        }else {
        	System.out.println(parseTree.toStringTree(raceParser));
        	System.out.println("Syntax error in example");
        }

        writer.close();
    }
}
