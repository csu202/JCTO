package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class InputFile {
    private boolean isopen;
    private String filename;
    private File file = null;
    private FileInputStream isf = null;
    private Scanner reader = null;

    public InputFile() {

    }

    public InputFile(String filename) {
        if (isfile(filename)) openFile(filename);
        else System.err.println("File '" + filename + "' is not existed");
    }

    public boolean isfile(String filename) {
        File file = new File(filename);
        if (file.exists()) return true;
        else return false;
    }

    public void openFile(String filename) {

        if (!isopen)
            try {
                this.filename = filename;
                this.file = new File(filename);
                this.isf = new FileInputStream(file);
                this.reader = new Scanner(isf, "UTF-8");
                //this.reader = new InputStreamReader(isf, "UTF-8");
                this.isopen = true;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        else {
            System.err.println("Already opened file:" + filename);
        }
    }

    public String readline() {
        if (isopen) {
            if (reader.hasNextLine())
                return reader.nextLine();
        } else
            System.err.println("File is not open,can not readline");
        return null;
    }


    public void close() {
        if (isopen)
            try {
                reader.close();
                isf.close();
                isopen = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        else {
            System.err.println("File is not open,can not close");
        }
    }

}
