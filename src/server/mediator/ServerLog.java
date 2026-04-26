package server.mediator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ServerLog {
  private ServerLog instance;

  private ServerLog(){
  }

  public ServerLog getInstance(){
    if (instance == null)
      instance = new ServerLog();
    return instance;
  }

  public void makeFile(String title,String filePath){
    try(BufferedWriter writer=new BufferedWriter(new java.io.FileWriter(filePath))){
      writer.write(title);
      System.out.println("Writen to: ["+filePath+"]");
    }catch(IOException e){
      System.out.println("file writting womp womp error: "+e.getMessage());
    }
  }

  public static void addData(String dataType,String text,String filepath){
StringBuilder stringBuilder=new StringBuilder();
  stringBuilder.append("{\n");
  stringBuilder.append("\""+dataType+"\":");
  stringBuilder.append("\""+text+"\"");
  LocalDate time= LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
  String formattedDate = time.format(formatter);
  stringBuilder.append("\" ["+formattedDate+"]\"");
    stringBuilder.append("\n}");
  }
}
