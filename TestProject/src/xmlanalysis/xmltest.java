/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlanalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 *
 * @author user
 */
public class xmltest {

    public static ArrayList<String> levelList = new ArrayList<String>();

    public static ArrayList<String> xmltagList = new ArrayList<String>();

    public static ArrayList<String> parentxmltagList = new ArrayList<String>();

    public static ArrayList<String> valueList = new ArrayList<String>();

    public static ArrayList<String> groupList = new ArrayList<String>();

    public static ArrayList<String> attributeNameList = new ArrayList<String>();

    public static ArrayList<String> attributeValueList = new ArrayList<String>();

    public static Map<Object, Object> xmltagcheckMap = new HashMap<Object, Object>();

    public boolean flag = true;
    public boolean flagcheck = true;

    public Integer levelcheck = 0;

    public void printResult(Element element, int level) {

        getNodes(element, level);

        groupList = namegrouping(levelList);

        System.out.println(levelList.size());
        System.out.println(levelList);
        System.out.println(groupList.size());
        System.out.println(groupList);
        System.out.println(xmltagList.size());
        System.out.println(xmltagList);
        System.out.println(parentxmltagList.size());
        System.out.println(parentxmltagList);
        System.out.println(valueList.size());
        System.out.println(valueList);
        System.out.println(attributeNameList.size());
        System.out.println(attributeNameList);
        System.out.println(attributeValueList.size());
        System.out.println(attributeValueList);

        //   Set<String> uniqueGas = new HashSet<String>(parentxmltagList);
        //   System.out.println(uniqueGas);
    }

    public void getNodes(Element node, int level) {

        checkFunction(node, level);

        if (flag) {

            xmltagList.add(node.getName());

            if (node.getParent() != null) {
                parentxmltagList.add(node.getParent().getName());
            } else {
                parentxmltagList.add("");
            }

            levelList.add(String.valueOf(level));
            valueList.add(node.getTextTrim());

            System.out.println("--------------------");

            //当前节点的名称、文本内容和属性
            System.out.println("当前节点名称：" + node.getName());//当前节点名称

            if (node.getParent() != null) {
                System.out.println("當前節點父節點: " + node.getParent().getName());//當前節點父節點
            } else {
                System.out.println("當前節點父節點: ");//當前節點父節點
            }

            System.out.println("當前節點階層: " + level);//當前節點階層
            System.out.println("当前节点的内容：" + node.getTextTrim());//当前节点名称

            List<Attribute> listAttr = node.attributes();//当前节点的所有属性的list

            if (listAttr.isEmpty()) {
                attributeNameList.add("");
                attributeValueList.add("");
            }

            for (Attribute attr : listAttr) {//遍历当前节点的所有属性
                String name = attr.getName();//属性名称
                String value = attr.getValue();//属性的值

                attributeNameList.add(attr.getName());
                attributeValueList.add(attr.getValue());

                System.out.println("属性名称：" + name + "属性值：" + value);
            }

        }

        //递归遍历当前节点所有的子节点
        List<Element> listElement = node.elements();//所有一级子节点的list
        for (Element e : listElement) {//遍历所有一级子节点
            int sublevel = level + 1;
            this.getNodes(e, sublevel);//递归
        }
    }

    public ArrayList<String> namegrouping(List level_p) {

        ArrayList<String> leafGroup = new ArrayList<String>();

        for (int j = 0; j < level_p.size(); j++) {

            if (j + 1 < level_p.size()) {
                if (!level_p.get(j).equals("") && !level_p.get(j + 1).equals("")) {

                    int lev_num = Integer.parseInt((String) level_p.get(j));
                    int lev_num2 = Integer.parseInt((String) level_p.get(j + 1));

                    if ((lev_num2 - lev_num) > 0) {

                        leafGroup.add("Group");

                    } else {

                        leafGroup.add("leaf");

                    }

                } else {

                    leafGroup.add("leaf");

                }
            } else {

                leafGroup.add("leaf");

            }
        }

        return leafGroup;

    }

    //判斷重複群組
    public void checkFunction(Element node, int level) {
        if (xmltagcheckMap.containsKey(node.getName())) {
            if (level == (Integer) xmltagcheckMap.get(node.getName())) {
                checkFailFunction(node,level);
            } else {
                checkSuccessFunction(node,level);
            }
        } else {
                if(flag){
                    checkSuccessFunction(node,level); 
                }else{
                    checkFailFunction2(node,level);
                }
        }
    }
    
    public void checkSuccessFunction(Element node,int level){
            if (!flagcheck) {
                xmltagcheckMap.clear();
                flagcheck = true;
            }
            xmltagcheckMap.put(node.getName(), level);
            levelcheck = level;
            flag = true;
    }
    
    public void checkFailFunction(Element node,int level){
                    if (level < levelcheck || level == levelcheck) {
                        flag = false;
                        flagcheck = false;
                    }            
    }
    public void checkFailFunction2(Element node,int level){
        if (level > levelcheck || level == levelcheck) {
                   flag = false;
                   flagcheck = false;
        }
        else{
            flag = true;
        }
    }
    
}

//    public void getNodes_root(Element node) {
//        System.out.println("--------------------");
//
//        //当前节点的名称、文本内容和属性
//        System.out.println("当前节点名称：" + node.getName());//当前节点名称
//        System.out.println("当前节点的内容：" + node.getTextTrim());//当前节点名称
//        List<Attribute> listAttr = node.attributes();//当前节点的所有属性的list
//
//        for (Attribute attr : listAttr) {//遍历当前节点的所有属性
//            String name = attr.getName();//属性名称
//            String value = attr.getValue();//属性的值
//            System.out.println("属性名称：" + name + "属性值：" + value);
//        }
//
//        //递归遍历当前节点所有的子节点
//        List<Element> listElement = node.elements();//所有一级子节点的list
//        for (Element e : listElement) {//遍历所有一级子节点
//            //        this.getNodes(e);//递归
//        }
//    }
