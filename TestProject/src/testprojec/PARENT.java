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
    class PARENT {
       protected void showinfo() {
            System.out.println("invoke the method of class PARENT.");
        }
    } 

    class CHILD extends PARENT { 
        public void showinfo() {
            //System.out.println("invoke the method of class CHILD.");
            super.showinfo(); // 叫用父類別的showme()方法
            this.showthisfunction();
      }
        public void showthisfunction(){
            System.out.println("invoke the method of class CHILD.");
        }
      public static void main(String[] args) {
       CHILD objDemo = new CHILD();
       objDemo.showinfo();
        }
     }
