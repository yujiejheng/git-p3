/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlanalysis;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Dom4jTest {

    private static Element root;
    private static List<String> name = new ArrayList<String>();
    private static Document document;

    /** print all xml data */
    public static void printXMLTree(){
        printElement(root, 0);
        return;
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
        System.out.println( " "+element.getTextTrim());

        Iterator iter = element.elementIterator();
        while(iter.hasNext()){
            Element sub = (Element)iter.next();
            printElement(sub, level+1 );
        }
        return;
    }

    /** 從指定的檔案路徑 讀取XML檔案 */
    public static Document loadXMLFile(String filename) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(filename));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        return document;
    }   

    /** 依照Path  印出所有data
    *  example: String path="/rss/channel/item/title"
    *  @param path
    */
    public static List<String> getAllDataByPath( String path ){
        List<String> data = new ArrayList<String>();
        Iterator it = document.selectNodes( path ).iterator();
        while(it.hasNext()) {  
            Element ele = (Element)it.next();
            System.out.println( path + " = "+ele.getStringValue());
            data.add(ele.getStringValue());
        }    
        return data;
    }   
}