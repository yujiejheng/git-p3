/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlanalysis;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author user
 */
public class XmlAnalysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DocumentException {

     try {
         
         
         File inputFile = new File("D:\\netbeansproject_d\\TestProject\\input7.txt");    
         SAXReader reader = new SAXReader();
         Document document = reader.read( inputFile );

         xmltest xmltest = new xmltest();
         xmltest.printResult(document.getRootElement(),0);
      
         
      } catch (DocumentException e) {
         e.printStackTrace();
      }  
    }
        private static void printElement(Element element, int level){
        // 依照階層print
        for(int i = 0; i < level; i++){
            System.out.print("\t");
        }
        
        System.out.print( "<" + element.getQualifiedName() + ">" );
        // 取得該TAG的Attr
        
        List attributes = element.attributes();
        for(int i = 0; i < attributes.size(); i++){
            Attribute a = ((Attribute)attributes.get(i));
            System.out.print(" (Attr:\"" + a.getName() + "\"==" + a.getValue() + ")");
        }
        
        System.out.println( " " + element.getTextTrim());

        Iterator iter = element.elementIterator();
        while(iter.hasNext()){
            Element sub = (Element)iter.next();
            printElement(sub, level+1 );
        }
        return;
    }
         
}

//         //顯示RootElement
//         System.out.println("Root element :" 
//            + document.getRootElement().getName());
//
//         //顯示RootElement
//         Element classElement = document.getRootElement();
//         System.out.println(classElement.getDocument());
//    
//         //顯示class/teacher下的所有標籤
//         List<Node> nodes = document.selectNodes("/class/teacher" );
//         System.out.println("----------------------------");
//         for (Node node : nodes) {
//            System.out.println("\nCurrent Element :" 
//               + node.getName());
//            System.out.println("Student roll no : " 
//               + node.valueOf("@rollno") );
//            System.out.println("First Name : " + node.selectSingleNode("firstname").getText());
//            System.out.println("Last Name : " + node.selectSingleNode("lastname").getText());
//            System.out.println("First Name : " + node.selectSingleNode("nickname").getText());
//            System.out.println("Marks : " + node.selectSingleNode("marks").getText());
//         }
         
//        printElement(document.getRootElement(), 0);
         
    


