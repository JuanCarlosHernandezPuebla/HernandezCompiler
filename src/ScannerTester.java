import java.io.File;

public class ScannerTester {

	public static void main(String[] args) {
		//Create a Scanner and point it at a file
		Scanner s = new Scanner(new File("input.txt"));
		//Call nextToken()
		boolean thereIsAToken = true;
		while(thereIsAToken) {
			thereIsAToken = s.nextToken();
			if(thereIsAToken) {
				System.out.println("Found" + s.getLexeme() + " with lexeme " + s.getLexeme());	
			}
			else
		}

	}

}
