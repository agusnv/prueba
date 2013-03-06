/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploservidor;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Profesor
 */
public class EjemploServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket scliente = null;
            // TODO code application logic here
            ServerSocket s = new ServerSocket(4444);
            while( (scliente=s.accept())!=null  ) {
                InputStream is = scliente.getInputStream();
                OutputStream os = scliente.getOutputStream();
                DataInputStream input = new DataInputStream(is);
                DataOutputStream output = new DataOutputStream(os);
                
                String msg = input.readUTF();
                output.writeUTF("Hola " + msg);
                
                input.close();
                output.close();
            }
        } catch (IOException ex) {
        }
        
    }
}
