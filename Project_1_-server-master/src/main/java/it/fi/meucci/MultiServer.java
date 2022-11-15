package it.fi.meucci;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer 
{
    static ArrayList <Socket> Lista_s = new ArrayList<Socket>();
    static ArrayList <Thread> Lista_t = new ArrayList<Thread>();
    static ArrayList <Persona> listaPers = new ArrayList<>();
    static ArrayList <Persona> listaV = new ArrayList<>();
    static ArrayList <Persona> listaNaz = new ArrayList<>();
    static ServerSocket serverSocket;

    public MultiServer() 
    {
        Persona uno = new Persona("Marco", "Baudo", "Italia");
        Persona due = new Persona("Giuseppe", "Ciao", "Italia");
        Persona tre = new Persona("Mark", "Jhonson", "Usa");
        Persona quattro = new Persona("Ivan", "Drago", "Russia");

        listaPers.add(uno);
        listaPers.add(due);
        listaPers.add(tre);
        listaPers.add(quattro);
    }

    public void kickOff()
    {
        try
        {
            serverSocket = new ServerSocket(7777);
            
            for(;;)
            {
                System.out.println("server still waiting");
                Socket socket = serverSocket.accept();
                Lista_s.add(socket);
                System.out.println("server socket" + socket);
                ServerThread serverThread = new ServerThread(socket);
                Lista_t.add(serverThread);
                serverThread.start();
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("error during instance");
        }
        
    }

}
