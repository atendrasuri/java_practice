package com.suri.AFlipkartInterview.employeeheirarchy;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class EmployeeNode {

    int empId;
    String name;
    int reportToId;
     List<EmployeeNode> subordinates;

    public EmployeeNode(String empId, String name, String reportToId) {

        try {
            this.empId = Integer.parseInt(empId);
            this.name = name;
            this.reportToId = Integer.parseInt(reportToId);
        }catch (Exception e){
            System.out.println(" Error in creating Employee"+e);
        }
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReportToId() {
        return reportToId;
    }

    public void setReportToId(int reportToId) {
        this.reportToId = reportToId;
    }

    public List<EmployeeNode> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeNode> subordinates) {
        this.subordinates = subordinates;
    }
}