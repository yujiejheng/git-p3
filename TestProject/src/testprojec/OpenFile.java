/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojec;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author user
 */
public class OpenFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {


              Desktop.getDesktop().open(new File("./Service_Template_Interface.xls"));
        
    }
    
}
