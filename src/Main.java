import compiler.RaceCompiler;
import main.race.RaceLexer;
import main.race.RaceParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import runtime.RaceRuntime;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String var1 = "/Users/sahebjohar/SER502-Spring2018-Team23/src/example.cc";
        CharStream code = CharStreams.fromFileName(var1);

        RaceLexer raceLexer = new RaceLexer(code);
        CommonTokenStream tokens = new CommonTokenStream(raceLexer);

        RaceParser raceParser = new RaceParser(tokens);
        ParseTree parseTree = raceParser.program();

        System.out.println(parseTree.toStringTree(raceParser));

        RaceCompiler compiler = new RaceCompiler();
        compiler.visit(parseTree);

        System.out.println(compiler.getOutput());

        RaceRuntime runtime = new RaceRuntime(compiler.getOutput());
        runtime.execute();
        System.out.println(runtime.getOutput());


    }
}
