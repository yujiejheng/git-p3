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
public class getClassTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        getClassTest getClassTest = new getClassTest();
//        String A = getClassTest.toString();
//        System.out.println(A);

        Object obj = new Object();
        int[] array1 = {1, 2, 3, 4, 5};
        double[] array2 = {1.0, 2.0, 3.0};
        String str = "Java";
        System.out.println(obj.toString());
        System.out.println(array1.toString());
        System.out.println(array2.toString());
        System.out.println(str.toString());

    }
    public String toString() {
    return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }
}
