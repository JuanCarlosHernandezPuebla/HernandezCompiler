import java.util.Hashtable;

public class LookUpTable extends Hashtable<String,TokenType> {

	public LookUpTable() {
		this.put("program", TokenType.PROGRAM);
		this.put("while", TokenType.WHILE);
		
	}
	
	
}
