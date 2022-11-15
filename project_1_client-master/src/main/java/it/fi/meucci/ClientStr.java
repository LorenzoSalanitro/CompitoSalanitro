package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientStr {
    String name_server = "localhost";
    int serverport = 7777;
    Socket mysocket;
    BufferedReader keyboard;
    String user;
    String received;
    DataOutputStream output;
    BufferedReader input;
    String elenco;

    public Socket connect()
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            mysocket = new Socket(name_server, serverport);
            output = new DataOutputStream(mysocket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));

            
            

            




        } catch (UnknownHostException e) {
            
            System.err.println("Unknowed host");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Error during connection");
            System.exit(1);
        }
        return mysocket;
        
    }

    public void comunicate() throws IOException
    {   
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        mysocket = new Socket(name_server, serverport);
        output = new DataOutputStream(mysocket.getOutputStream());
        input = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));
        
        ObjectMapper mapper = new ObjectMapper();

        while(true)
        {
            System.out.println("scegliere operazione:1) AGGIUNTA PERSONE;2) RICHIESTA ELENCO PER NAZIONE; 3)RICHIESTA ELENCO COMPLETO");
            user = keyboard.readLine();
            

            switch (user)
             {
                case "AGGIUNTA PERSONE":
                    
                    break;
            
                case "RICHIESTA ELENCO PER NAZIONE" :
                    elenco = input.readLine();
                    Messaggio ne = mapper.readValue(elenco, Messaggio.class);

                    for (int i = 0; i < ne.listaPersone.size(); i++) 
                    {
                        
                    }

                    break;
                
                case "RICHIESTA ELENCO COMPLETO":
                    elenco = input.readLine();
                    Messaggio ms = mapper.readValue(elenco, Messaggio.class);
    
                    System.out.println("l'elenco completo: ");
    
                    for (int i = 0; i < ms.listaPersone.size(); i++) 
                    {
                        System.out.println("nazione: " + ms.listaPersone.get(i).getNazioneResidenza() + "nome: " + ms.listaPersone.get(i).getNome() + "cognome: " + ms.listaPersone.get(i).getCognome());
                    }
                    break;
            }
        }

    } 
}
