package server.model;

import client.mediator.Client;

import java.io.IOException;

public class ModelManager implements Model {

  private Client client;

  @Override public void connect()
  {
    try{
      client = new Client("localhost", 4026);
    }
    catch(IOException e){
      e.printStackTrace();
    }

  }

  @Override public void disconnect()
  {
    try{
      client.getSocket().close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

  @Override public String convert()
  {
    //what to put here?
    return "";
  }
}

