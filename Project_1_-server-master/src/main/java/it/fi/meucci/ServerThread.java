package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerThread extends Thread 
{
    ServerSocket server = null;
    Socket client = null;
    String stringRecived = null;
    String stringModified = null;
    BufferedReader inputFromClient;
    DataOutputStream outputToClient;

    public ServerThread (Socket socket)
    {
        this.client = socket;
    }

    public void run()
    {
        try
        {
            comunicate();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void comunicate() throws Exception
    {
        inputFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outputToClient = new DataOutputStream(client.getOutputStream());

        ObjectMapper mapper = new ObjectMapper();

        while(true)
        {
            

            stringRecived = inputFromClient.readLine();
            Messaggio m = new Messaggio(stringRecived, Messaggio.class);
        

            if(m.listaPersone.size() == 0)
            {
                Messaggio messaggioN = new Messaggio(MultiServer.listaV);
                outputToClient.writeBytes("la lista è vuota!"  + '\n');
                outputToClient.writeBytes("voui aggiungere persone?" + '\n');
            }
            else if (m.equals("RICHIESTA ELENCO PER NAZIONE")) 
            {
                outputToClient.writeBytes("scegliere nazione desiderata: " + '\n');
                stringRecived = inputFromClient.readLine();
                
                for (int i = 0; i < MultiServer.listaPers.size(); i++) 
                {
                    if (stringRecived.equals(MultiServer.listaPers.get(i).getNazioneResidenza())) 
                    {
                        MultiServer.listaNaz.add(MultiServer.listaPers.get(i));
                    }
                }

                Messaggio nuovo = new Messaggio(MultiServer.listaNaz);
                outputToClient.writeBytes(mapper.writeValueAsString(nuovo) + '\n');
            }
            else if(m.equals("RICHIESTA ELENCO COMPLETO"))
            {
                Messaggio nu = new Messaggio(MultiServer.listaPers);
                outputToClient.writeBytes(mapper.writeValueAsString(nu) + '\n');
            }
        }
    }
    
}
