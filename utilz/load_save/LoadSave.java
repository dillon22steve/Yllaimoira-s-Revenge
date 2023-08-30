package utilz.load_save;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class LoadSave {
    
    public static void createFile(int saveNum) {
		File txtFile = new File(("res/Save" + saveNum));
		
		try {
			txtFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} //createFile


    public static void writeToFile(File f) {
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.close();
        } catch (IOException e) {

        }
    } //WriteToFile


    public static void getLevelData(String filename) {
        File levelFile = new File("res/" + filename + ".txt");
		
		if(levelFile.exists()) {
			return;
		} else {
			System.out.println("File " + filename +  "does not exist!");
		}
    } //GetLevelData
    
}
