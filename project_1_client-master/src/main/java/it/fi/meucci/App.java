package it.fi.meucci;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ClientStr client = new ClientStr();
        client.connect();
        client.comunicate();
    }
}
