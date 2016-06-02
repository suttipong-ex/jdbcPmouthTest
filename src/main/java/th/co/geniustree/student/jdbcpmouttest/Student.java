/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.student.jdbcpmouttest;

/**
 *
 * @author Suttipong
 */
public class Student {
    private String id;
    private String name;
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    } 
    @Override
    public String toString() {
        String str = "exodus edit";
        return "id is  : "+id+"  name is : "+name;
    }  
}
