/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farra
 */
public class Belakang {
    Vector list;

    public Belakang() {
        fileInput();
    }
    public void fileInput() {
        try {
                FileInputStream fin = new FileInputStream ("listjwb.out");
                ObjectInputStream oin = new ObjectInputStream( fin );
                try {
                    // Read the vector back from the
                    Object obj = oin.readObject();
                    // Cast back to a vector
                    list = (Vector) obj;

                } catch(ClassCastException cce){
                    list = new Vector();
                } catch(ClassNotFoundException cnfe){
                list = new Vector();
                }
                 fin.close();
            }
        catch(FileNotFoundException fnfe){
            list = new Vector();
        }
        catch (IOException ex) {
            Logger.getLogger(Belakang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void simpan(){
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listjwb.out"));
            oos.writeObject(list);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Belakang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Belakang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
