package com.suri.java.object;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 31/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ReferenceAndEquals {
  public static void main(String[] args) {

    Employee e1= new Employee(1,"A");
    Employee e2= new Employee(1,"A");

    System.out.println(e1==e2);
    System.out.println(e1.equals(e2));


  }
}

class Employee{
  private int eid;
  private String ename;


  Employee(int eid, String ename){
    this.eid = eid;
    this.ename = ename;
  }


 /* @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Employee employee = (Employee) o;

    if (eid != employee.eid) return false;
    return ename.equals(employee.ename);
  }

  @Override
  public int hashCode() {
    int result = eid;
    result = 31 * result + ename.hashCode();
    return result;
  }*/


}