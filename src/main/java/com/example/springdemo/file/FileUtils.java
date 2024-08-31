package com.example.springdemo.file;

import java.io.*;

public  class FileUtils {

    public static void readFile(String filePath){

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 逐行读取文件内容，并输出到控制台
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void writeFile(String filePath,String content){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(content);
            writer.newLine();
            writer.close();
            System.out.println("Content has been appended to the file.");
        }catch (IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void deleteFile(String filePath){

        // 创建 File 对象
        File file = new File(filePath);

        // 尝试删除文件
        if (file.delete()) {
            System.out.println("文件删除成功: " + file.getAbsolutePath());
        } else {
            System.out.println("无法删除文件: " + file.getAbsolutePath());
        }
    }
}
