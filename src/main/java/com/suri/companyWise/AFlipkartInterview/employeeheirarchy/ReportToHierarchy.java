package com.suri.companyWise.AFlipkartInterview.employeeheirarchy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ReportToHierarchy {

    static Map<Integer, EmployeeNode> employees;
    static EmployeeNode root;

    public static void main(String[] args) {
        employees = new HashMap<>();
        readDataandCreateMap();
        buildHierarchyTree(root);
        printHeirarchy(root,0);

    }

    public static void readDataandCreateMap(){




        EmployeeNode employee1 = new EmployeeNode("001","AAA","004");
        EmployeeNode employee2 = new EmployeeNode("002","BBB","004");
        EmployeeNode employee3 = new EmployeeNode("003","CCC","004");

        EmployeeNode employee4 = new EmployeeNode("004","DDD","");

        EmployeeNode employee5 = new EmployeeNode("005","EEE","003");
        EmployeeNode employee6 = new EmployeeNode("006","FFF","003");

        EmployeeNode employee7 = new EmployeeNode("007","GGG","003");

        employees.put(employee1.getEmpId(),employee1);
        employees.put(employee2.getEmpId(),employee2);
        employees.put(employee3.getEmpId(),employee3);
        employees.put(employee4.getEmpId(),employee4);
        employees.put(employee5.getEmpId(),employee5);
        employees.put(employee6.getEmpId(),employee6);
        employees.put(employee7.getEmpId(),employee7);

        for(Integer eid:employees.keySet()){

            EmployeeNode e= employees.get(eid);

            if(e.getReportToId()==0){
                root=e;
            }
        }

    }
    public static List<EmployeeNode> getSubordinatesById(int rid){

        List<EmployeeNode>subOrdinates= new ArrayList<>();
        for(EmployeeNode e:employees.values()){
            if(e.getReportToId()==rid){
                subOrdinates.add(e);
            }
        }
        return subOrdinates;
    }


    public static void buildHierarchyTree(EmployeeNode localroot){

        EmployeeNode employee=localroot;

        List<EmployeeNode> subOrdinates = getSubordinatesById(employee.getEmpId());

        employee.setSubordinates(subOrdinates);

        if(subOrdinates.size()==0){
            return;
        }

        for(EmployeeNode e: subOrdinates){
            buildHierarchyTree(e);
        }
    }

    public static void printHeirarchy(EmployeeNode localRoot, int level){

        for(int i=0;i<level;i++){
            System.out.print("\t");
        }

        System.out.println(localRoot.getName());

        List<EmployeeNode> subOrdinates= localRoot.getSubordinates();

        System.out.println(" ");

        for(EmployeeNode e:subOrdinates){
            printHeirarchy(e,level+1);
        }
    }

}