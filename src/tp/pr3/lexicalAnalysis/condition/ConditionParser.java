package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;

public class ConditionParser{
	
	private static final Condition[] conditions = { new Equal(), new Less(), new LessEq(), new NotEqual()};

	public static Condition parse(String t1, String op, String t2, LexicalParser lexParser) throws LexicalAnalysisException{
			Condition condition = null;
			int i=0;
				while(condition == null && i<conditions.length){
				condition = conditions[i].parse(t1, op, t2, lexParser);
				++i;
			}
			return condition;
	}
}
