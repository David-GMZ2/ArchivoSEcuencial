/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajoarchivosdg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAX
 */
public class Main {

    //Archivos secuenciales de NBytes
    private void escrituraBinariaNbytes(String nombre,String telefono,String  edad){
        try {
            FileOutputStream archivo=new FileOutputStream("datos.bin");
            DataOutputStream data=new DataOutputStream(archivo);
            
            data.writeBytes(nombre);
            data.writeBytes(telefono);
            data.writeBytes(edad);
            data.writeByte(0000);
            
            
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void lecturaBinariaNbytes(int n){
        try {
            FileInputStream archivo=new FileInputStream("datos.bin");
            DataInputStream data=new DataInputStream(archivo);
            data.readNBytes(n);
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Archivos secuenciale de tamaño fijo
    private void escrituraBinariaFijo(String nombre,int telefono,int edad){
        try {
            FileOutputStream archivo=new FileOutputStream("datos.bin");
            DataOutputStream data=new DataOutputStream(archivo);
           
           data.writeUTF(nombre);
           data.writeInt(telefono);
           data.writeChar(edad);
           
          
           
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lecturaBinariaFija(){
        try {
            FileInputStream archivo=new FileInputStream("datos.bin");
            DataInputStream data=new DataInputStream(archivo);
            data.readNBytes(10);
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada =new Scanner (System.in);
        Scanner dato =new Scanner (System.in);
        Main main=new Main();
        int opc,telefono,edad,ct,ce,cn,r=0;
        String nombre,t,e;
        do{
        System.out.println("1.Guaradar Datos (N Bytes)");
        System.out.println("2.Guardar Datos (Tamaño fijo)");
        System.out.println("3.leer Datos (N Bytes)");
        System.out.println("4.leerDatos (Tamaño fijo)");
        System.out.println("5.Salir)");
        opc=entrada.nextInt();
        switch(opc){
            case 1:
                System.out.println("Ingrese su nombre");
                nombre=dato.nextLine();
                cn=nombre.length();
                
                System.out.println("Ingrese su telefono");
                telefono=entrada.nextInt();
                t=Integer.toString(telefono);
                ct=t.length();
                
                System.out.println("Ingrese su edad");
                edad=entrada.nextInt();  
                e=Integer.toString(edad);
                ce=t.length();
                main.escrituraBinariaNbytes(nombre, t, e);
                 r=cn+ct+ce;
                break;
            case 2 :
                System.out.println("Ingrese su nombre");
                nombre=dato.nextLine();
                 
                System.out.println("Ingrese su telefono");
                telefono=entrada.nextInt();
                
                
                System.out.println("Ingrese su edad");
                edad=entrada.nextInt();
               
               
                break;
            case 3:
                main.lecturaBinariaNbytes(r);
                break;
            case 4:
                    main.lecturaBinariaFija();
                 break;
                
            
        }}while(opc!=5);
    }
    
}
