package chapter8;

import java.io.*;
import java.util.Arrays;

import static java.io.File.separator;

public class FileExample {

    public static void main(String[] args) {
        System.out.println(separator);

        File file  = new File("c:\\");
        System.out.println(file.exists());
    }
}

class InputStreamOutputStream {

    public static void copy(File source, File destination) {
        try(FileInputStream in = new FileInputStream(source)) {
            OutputStream out = new FileOutputStream(destination);
            int b;
            while((b =  in.read()) != -1) {
                out.write(b);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File source = new File("out\\production\\OCP8_II\\chapter8\\InputStreamOutputStream.class");
        File destination = new File("out\\production\\OCP8_II\\chapter8\\InputStreamOutputStreamCopy.class");
        copy(source, destination);

    }
}
