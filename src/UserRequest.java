//import java.util.Scanner;
//
//public class UserRequest {
//	Note note = new Note();
//	
//	public void passUsersData() {
//		char letter = requestLetter();
//		String accidental = requestAccidental();
//		note.extractNumFromNote(letter, accidental);
//	}
//	
//	public char requestLetter() {
//		Scanner input = new Scanner(System.in);
//		System.out.print("Please enter the letter of a note");
//		char letter = input.next().charAt(0);
//		return letter;
//	}
//	
//	public String requestAccidental() {
//		Scanner input = new Scanner(System.in);
//		System.out.println("Please enter \"Natural\" or \"Sharp\" (\"Flat\" not allowed)");
//		String accidental = input.nextLine();
//		return accidental;
//	}
//	
//	public Note getNote() {
//		return note;
//	}
//	
//}
