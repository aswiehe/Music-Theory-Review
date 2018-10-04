import java.util.Arrays;

public class Scale {
	
	@SuppressWarnings("unused")
	// ROGUE VAR
	private String modeName;
	private int modeShift;
	private final int[] STEPS_IN_IONIAN_MODE = {2, 2, 1, 2, 2, 2, 1};
	private int[] stepsInMode;
	private String[] composition = {"Major", "Minor", "Minor", "Major", "Major", "Minor", "Diminished"};
	private String[] chordsInProgression = new String[composition.length];
	// 
	Note[] degrees = new Note[STEPS_IN_IONIAN_MODE.length];
	
	int[] ionian = {2, 2, 1, 2, 2, 2, 1};
	int[] dorian = {2, 1, 2, 2, 2, 1, 2};
	int[] phrygian = {1, 2, 2, 2, 1, 2, 2};
	int[] lydian = {2, 2, 2, 1, 2, 2, 1};
	int[] mixolydian = {2, 2, 1, 2, 2, 1, 2};
	int[] aeolian = {2, 1, 2, 2, 1, 2, 2};
	int[] locrian = {1, 2, 2, 1, 2, 2, 2};
	
	
	public void populateScale(int root) {
		// At this point, degrees is an empty array that with the length of 7 (which is equal to STEPS_IN_IONIAN_MODE which is really equal to the number of steps in all modes)
		degrees[0] = new Note();
		// perform assembleNoteFromNum on the first element in the degrees[] array and pass in the root which came from Scanner via the user in previously called methods
		degrees[0].assembleNoteFromNum(root);
		// toString is an overridden method in the Notes class. See method for formatting.
		System.out.print(degrees[0].toString());
		// CLARITY
		System.out.print(" (" + composition[(modeShift) % composition.length] + ")");
		// CLARITY
		chordsInProgression[0] = degrees[0].toString() + " (" + composition[(modeShift) % composition.length] + ")";
		for(int i = 1; i < stepsInMode.length; i++) {
			degrees[i] = new Note();
			degrees[i].assembleNoteFromNum(degrees[i - 1].getNoteNum() + stepsInMode[i - 1]);
			System.out.println();
			String s = degrees[i].toString();
			System.out.print(s);
			// CLARITY
			System.out.print(" (" + composition[(i + modeShift) % composition.length] + ")");
			// ClARITY
			chordsInProgression[i] = degrees[i].toString() + " (" + composition[(i + modeShift) % composition.length] + ")";
		}
		
		System.out.println("\n\n" + Arrays.toString(chordsInProgression));
	}
	
	public void setMode(String modeName) {
		// Change mode of this object to the mode passed in by user via Scanner 
		this.modeName = modeName;
		// Declare and define modes
		//// CONSIDER - Should these int[] be class variables -> No, because they change depending on the mode passed in <- But if they change, why does it matter what they are initialized to, aren't references being created when they will almost definitely be sent to garbage?
		/*
//		int[] ionian = {2, 2, 1, 2, 2, 2, 1};
//		int[] dorian = {2, 1, 2, 2, 2, 1, 2};
//		int[] phrygian = {1, 2, 2, 2, 1, 2, 2};
//		int[] lydian = {2, 2, 2, 1, 2, 2, 1};
//		int[] mixolydian = {2, 2, 1, 2, 2, 1, 2};
//		int[] aeolian = {2, 1, 2, 2, 1, 2, 2};
//		int[] locrian = {1, 2, 2, 1, 2, 2, 2};
		*/
		switch(modeName) {
		case "Ionian": stepsInMode = ionian;
		modeShift = 0;
		break;
		case "Dorian": stepsInMode = dorian;
		modeShift = 1;
		break;
		case "Phrygian": stepsInMode = phrygian;
		modeShift = 2;
		break;
		case "Lydian": stepsInMode = lydian;
		modeShift = 3;
		break;
		case "Mixolydian": stepsInMode = mixolydian;
		modeShift = 4;
		break;
		case "Aeolian": stepsInMode = aeolian;
		modeShift = 5;
		break;
		case "Locrian": stepsInMode = locrian;
		modeShift = 6;
		break;
		}
	}
}
