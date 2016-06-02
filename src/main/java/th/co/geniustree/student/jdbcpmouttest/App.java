/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.student.jdbcpmouttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Suttipong
 */
public class App {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/jdbctest;AUTO_SERVER=TRUE");
        data(connection);
        //เก็บค่าไว้ใน List
        List<Student> student = select("select * from test",connection);
        // รันออกมาแสดง
        for (int i = 0; i < student.size(); i++) {
            System.out.println("List at "+i+" "+student.get(i));
        }
    }
    private static void data(Connection connection) throws SQLException {
        //connection.createStatement().execute("create table test(id varchar(255)not null,name varchar(255))");
        Statement stm = connection.createStatement();
        try {
            //เพื่อ สร้างการป้องกันการผิดพลาดในการคอมมิดว่า ใส่ทั้งหมดเลย
            connection.setAutoCommit(false);
            //begin
            stm.executeUpdate("insert into TEST(ID,NAME)values('X1','Suttipong')");
            stm.executeUpdate("insert into TEST(ID,NAME)values('V2','Promouth')");
            stm.executeUpdate("insert into TEST(ID,NAME)values('C3','SongSang')");
            int x = 5/0;
            connection.commit();
            //commit
        } catch (Exception SQLException) {
            connection.rollback();
            Logger.getLogger(App.class.getName()).log(Level.INFO,"error occur", SQLException);
        }       
        stm.close();
    }

    private static List<Student> select(String str, Connection connection) throws SQLException {
         Statement stm = connection.createStatement();
         ResultSet rs = stm.executeQuery(str);
         List<Student> students = new ArrayList<>();
         while(rs.next()){
             String id = rs.getString("ID");
             String name = rs.getString("NAME");
             students.add(new Student(id, name));
            // Logger.getLogger(App.class.getName()).log(Level.INFO,"ID={0},NAME{1}",new Object[]{id,name});
         }   
         rs.close();
         return students;
    }
    //edit this for just check githup
}
