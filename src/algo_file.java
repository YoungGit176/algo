import java.io.File;

public class algo_file {
    public static void main(String[] args) {
        File file = new File("D:");
        File[] files= file.listFiles();
        readfiles(files);

    }
    public static  void readfiles(File[] files){
        if (files==null){
            return;
        }
        else {
            for (File f:files){
                if (f.isFile()){
                    System.out.println(f);
                }
                else if (f.isDirectory()){
                    readfiles(f.listFiles());
                }
            }
        }
    }
}

