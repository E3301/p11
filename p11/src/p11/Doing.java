/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author NEVERMIND
 */
public class Doing {
    
    public void One() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\NEVERMIND\\Documents\\ciao2.txt")))) {
            String[] linee = new String[20];
            int i = 0;
            for(String line; (line = br.readLine()) != null; i++) {
                linee[i] = line;
                System.out.println(linee[i]);
            }
            Two(linee);
        }
    }
    
    
    public void Two(String[] linee){
        System.out.println(linee[2].length());
        int[][] matrix = new int[20][20];
        for(int x=0; x<20; x++){
           for(int y=0; y<20; y++){
               matrix[x][y] = Integer.valueOf(linee[x].substring(3*y, (3*y)+2));
           }  
        }
        
        for(int x=0; x<20; x++){
            System.out.println("\n");
           for(int y=0; y<20; y++){
               System.out.print(matrix[x][y] + ", ");
           }  
        }
        
        System.out.println("\n");
        
        long big[] = new long[20];
        for(int x=0; x<20; x++){
            big[x] = 0; 
            int d = 0;
            for(int y=0; y<16; y++){
               d = matrix[x][y]*matrix[x][y+1]*matrix[x][y+2]*matrix[x][y+3];
               if(big[x]<d){
                   big[x] = d;
               }
            }
            System.out.println("x: " + x + " big: " + big[x]);
        }
        
        long giant =0;
        for(int i=0; i<big.length; i++){
            if(big[i]>giant){
                giant = big[i];
            }
        }
        System.out.println("il più grande in orizzontale: " + giant);
        Three(matrix);
    }
    
    public void Three(int[][] matrix){
        long big[] = new long[20];
        for(int y=0; y<20; y++){
            big[y] = 0; 
            int d = 0;
            for(int x=0; x<16; x++){
               d = matrix[x][y]*matrix[x+1][y]*matrix[x+2][y]*matrix[x+3][y];
               if(big[y]<d){
                   big[y] = d;
               }
            }
            System.out.println("x: " + y + " big: " + big[y]);
        }
        
        long giant =0;
        for(int i=0; i<big.length; i++){
            if(big[i]>giant){
                giant = big[i];
            }
        }
        System.out.println("il più grande in verticale: " + giant);
        Four(matrix);
    }
    
    public void Four(int[][] matrix){
        long big[] = new long[16];
        
        
        for(int y=0; y<16; y++){
            big[y] = 0; 
            int d = 0;
            for(int x=0; x<16; x++){
               d = matrix[x][y]*matrix[x+1][y+1]*matrix[x+2][y+2]*matrix[x+3][y+3];
               if(big[y]<d){
                   big[y] = d;
               }
            }
            System.out.println("x: " + y + " big: " + big[y]);
        }
        
        long giant =0;
        for(int i=0; i<big.length; i++){
            if(big[i]>giant){
                giant = big[i];
            }
        }
        System.out.println("il più grande in diagonale sx: " + giant);
        Five(matrix);
    }
    
    public void Five(int[][] matrix){
        long big[] = new long[21];
        System.out.println("x: ");
        
        for(int y=19; y>4; y--){
            big[y] = 0; 
            int d = 0;
            System.out.println("x: " + y + " big: " + big[y]);
            for(int x=0; x<16; x++){
               d = matrix[x][y]*matrix[x+1][y-1]*matrix[x+2][y-2]*matrix[x+3][y-3];
               if(big[y]<d){
                   big[y] = d;
               }
            }
            System.out.println("x: " + y + " big: " + big[y]);
        }
        
        long giant =0;
        for(int i=0; i<big.length; i++){
            if(big[i]>giant){
                giant = big[i];
            }
        }
        System.out.println("il più grande in diagonale dx: " + giant);
    }
}
