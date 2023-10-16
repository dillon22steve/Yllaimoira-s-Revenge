package utilz.load_save;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoadSave {
    
    public static int[][] LoadBuildingCanMove(String bldgName, int height, int width) {
		int[][] canMoveData = new int[height][width];
		String pathToRes = "C:\\Users\\dillo\\OneDrive\\Documents\\GitHub\\Yllaimoira-s-Revenge";
		File file = new File(pathToRes + "/res/can-move-files/" + bldgName + "-can-move.txt");
		try {
			Scanner fileScanner = new Scanner(file);
			int i, j;
			while (fileScanner.hasNextInt()) {
				j = fileScanner.nextInt();
				i = fileScanner.nextInt();
				canMoveData[i][j] = 1;
			} //while
			fileScanner.close();
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} //catch

		return canMoveData;
	} //LoadBuildingCanMove
    
} //LoadSave
