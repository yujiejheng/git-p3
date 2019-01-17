/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class ArrayListRemove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<Object,Object> map = new HashMap<Object, Object>();
        
        map.put("teacher", 1);
        map.put("student", 2);
        map.put("doctor", 3);
        
        System.out.println(map.containsKey("student"));
        Integer a = (Integer)map.get("student");
        System.out.println(a);
       
             
    }
    
}
