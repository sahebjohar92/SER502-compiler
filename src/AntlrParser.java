import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrParser {
	
	public static void main(String args[]) throws IOException
	{

		String filename = "./example.cc";
		CharStream charstream = CharStreams.fromFileName(filename);
		RaceLexer javaLexer= new RaceLexer(charstream);
		CommonTokenStream commonTokenStream=new CommonTokenStream(javaLexer);
		RaceParser raceParser=new RaceParser(commonTokenStream);
		
		ParseTree parseTree = raceParser.program();
		System.out.println("done");

		ParseTreeWalker walker = new ParseTreeWalker();
		RaceWalker raceWalk = new RaceWalker();
		walker.walk( raceWalk, parseTree );
		
	}

}
