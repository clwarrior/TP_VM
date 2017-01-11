package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.lexicalAnalysis.LexicalParser;

public class ConditionParser {

	public static Condition parse(String t1, String op, String t2, LexicalParser Lexical){
		if (op=="<=")
			return new LessEq(t1, t2);
		else if (op=="=")
			return new Equal(t1, t2);
		else if (op=="!=")
			return new NotEqual(t1, t2);
		else if (op=="<")
			return new Less(t1, t2);
	}
}
