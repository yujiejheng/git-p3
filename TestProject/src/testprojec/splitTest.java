/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojec;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class splitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String a = "AB:";
                
        String b = a.substring(a.indexOf("_")+1,a.length());

        String c = a.substring(3,a.length());
        
        System.out.println(c);
        
    }
    
}
