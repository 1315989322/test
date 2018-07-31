package com.example.test.commons;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class FileUtils {
    public static byte[] getFileBytes(String filename) throws IOException {
        File file = new File(filename);
        if(!file.exists()){
            return null;
        }
        FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte tmp[] = new byte[1024];
        while((in.read(tmp)) != -1){
            out.write(tmp);
        }
        in.close();
        return out.toByteArray();
    }
   public static byte[] getFileBytes(File file) throws IOException{
       FileInputStream in = new FileInputStream(file);
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       byte tmp[] = new byte[1024];
       while((in.read(tmp)) != -1){
           out.write(tmp);
       }
       in.close();
       return out.toByteArray();
   }
}
