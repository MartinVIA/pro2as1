package server.mediator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ServerLog {
  private static ServerLog instance;
  private  Gson gson;

  private ServerLog(){
  }

  public static ServerLog getInstance(){
    if (instance == null)
      instance = new ServerLog();
    return instance;
  }
  public void setGson(Gson gson){
    this.gson = gson;
  }

  public static void makeFile(String title,String filePath){
    try{
      BufferedWriter writer=new BufferedWriter(new java.io.FileWriter(filePath));
      writer.write(title);
      System.out.println("Writen to: ["+filePath+"]");
    }catch(IOException e){
      System.out.println("file writting womp womp error: "+e.getMessage());
    }
  }
  public static void writeToJsonFile(String fileName, Object object){
    try {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String json = gson.toJson(object);
      FileWriter writer = new FileWriter("webpage/json/"+fileName+".json");
      writer.write(json);
      writer.close();
    } catch (IOException e) {
      System.out.println("Error saving tasks: " + e.getMessage());
      e.printStackTrace();
    }
  }
  public static void addData(String text,String filepath){
StringBuilder stringBuilder=new StringBuilder();
  stringBuilder.append("{\n");
  stringBuilder.append("\""+text+"\"");

//  LocalDate time= LocalDate.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//  String formattedDate = time.format(formatter);
//  stringBuilder.append("\" ["+formattedDate+"]\"");

    stringBuilder.append("\n}");
makeFile(stringBuilder.toString(),filepath);
  }
}
