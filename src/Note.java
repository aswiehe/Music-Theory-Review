
public class Note {
	
	// letterChar represents the letter as represented as <char>
	private char letterChar;
	// letter int represents the letter as represented as <int>
	private int letterInt;
	// an array of all possible notes within an octave that standard traditional western music allows (as far as tradional theory is concerned)
	//// those possible notes represented as <char>
	private char[] validLetterChars = {'C', 'D', 'E', 'F', 'G', 'A', 'B'};
	//// those possible notes represented as <int>
	private char[] validLetterInts = {0, 2, 4, 5, 7, 9, 11};
	// ROGUE VAR
	private String accidentalString;
	// ROGUE VAR
	private int accidentalInt;
	// ROGUE VAR
	private String[] validAccidentalStrings = {"Natural", "Sharp"};
	
	public void assembleNoteFromNum(int num) {
		
		num %= 12;
		switch(num) {
		case 0:
		case 1: letterChar = validLetterChars[0];
		break;
		case 2:
		case 3: letterChar = validLetterChars[1];
		break;
		case 4: letterChar = validLetterChars[2];
		break;
		case 5: 
		case 6: letterChar = validLetterChars[3];
		break;
		case 7:
		case 8: letterChar = validLetterChars[4];
		break;
		case 9:
		case 10: letterChar = validLetterChars[5];
		break;
		case 11: letterChar = validLetterChars[6];
		}
		
		for(int i = 0; i < validLetterInts.length; i++) {
			if (num - validLetterInts[i] > 1) {
			}
			else if(num - validLetterInts[i] == 1) {
				accidentalInt = 1;
				accidentalString = validAccidentalStrings[1];
				letterInt = validLetterInts[i];
			}
			else if(num - validLetterInts[i] == 0) {
				accidentalInt = 0;
				accidentalString = validAccidentalStrings[0];
				letterInt = validLetterInts[i];
			}
			else {
				
			}
		}
	}

	public int extractNumFromNote(char letter, String accidental) {
		// Changed soon underneath in switch statement, initialization required. See below for what var represents.
		int letterHalfStepsFromC = 0;
		// Changed soon underneath in switch statement, initialization required. See below for what var represents.
		int accidentalHalfStepsFromC = 0;
		// Converts the letter passed in from <char> into <int>, representing that letter's half steps from C
		switch(letter) {
		case 'C': letterHalfStepsFromC = 0;
		break;
		case 'D': letterHalfStepsFromC = 2;
		break;
		case 'E': letterHalfStepsFromC = 4;
		break;
		case 'F': letterHalfStepsFromC = 5;
		break;
		case 'G': letterHalfStepsFromC = 7;
		break;
		case 'A': letterHalfStepsFromC = 9;
		break;
		case 'B': letterHalfStepsFromC = 11;
		break;
		}
		// Converts accidental passed in from <String> into <int>, representing that accidental's (Natural or Sharp) steps up from a given letters Natural
		if(accidental.equals("Natural")) {
			accidentalHalfStepsFromC = 0;
		}
		else if(accidental.equals("Sharp")){
			accidentalHalfStepsFromC = 1;
		}
		else {
			System.out.println("invalid accidental");
			System.exit(0);
		}
		// Sum of the two <int> pitch numbers is equal to the pitch id 
		int num = letterHalfStepsFromC + accidentalHalfStepsFromC;
		return num;
	}
	
	public String formatNote() {
		String formattedNote = letterChar + " - " + accidentalString;
		return formattedNote;
	}

	
	public int getNoteNum() {
		int num = letterInt + accidentalInt;
		return num;
	}
	
	
	public String toString() {
		String s = letterChar + " - " + accidentalString;
		return s;
	}
}
