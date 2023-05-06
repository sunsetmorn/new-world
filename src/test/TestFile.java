package test;

import java.io.*;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String localPath = "2.txt";
        File file = new File(localPath);
        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "GB2312");
        outputStreamWriter.write("12313131安达就能看见女接");
        outputStreamWriter.close();
        outputStream.close();
    }
}
