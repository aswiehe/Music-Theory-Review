import java.util.Scanner;

public class StartProgram {

	public static void main(String[] args) {

		createScale();
		
	}
	
	public static void createScale() {
		// letter represents the "C" in [C - Natural *Major* (Zero Octave)]
		char letter;
		// accidental represents the "Natural" in [C - Natural *Major* (Zero Octave)]
		String accidental;
		// mode represents the "Major" in [C - Natural *Major* (Zero Octave)]
		String mode;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the letter of a note: ");
		letter = input.nextLine().charAt(0);
		System.out.print("Please enter \"Natural\" or \"Sharp\" (\"Flat\" not allowed): ");
		accidental = input.nextLine();
		System.out.print("Please enter the name of your mode (for example Ionian, Dorian, etc.): ");
		mode = input.nextLine();
		System.out.print("\n\n");
		
		// Create new note object using assumed no-arg constructor
		Note note = new Note();
		// letter and accidental are datafields with class level scope, defined via Scanner by user
		// returns the octave-level #id
		int num = note.extractNumFromNote(letter, accidental);
		// Create new scale object using assumed no-arg constructor
		Scale scale = new Scale();
		scale.setMode(mode);
		scale.populateScale(num);
		input.close();
	}		
}
