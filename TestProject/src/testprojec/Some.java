/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojec;

/**
 *
 * @author user
 */
public class Some {
    
    private String name;
    public Some(String name) {
        this.name = name;
        System.out.println(name + ": 被建立");
    }
    protected void finalize() {
        System.out.println(name + ": 被回收");
    }
 
    public static void main(String[] args) {
        Some some1 = new Some("Object 1");
        Some some3 = new Some("Object 3");
        Some some2 = new Some("Object 2");
 
        some1 = null;
        some2 = null;
        some3 = null;
 
        // 建議回收資源
        System.gc();
        System.out.println("程式結束");
    }
    
}
