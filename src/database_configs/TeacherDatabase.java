package database_configs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import trade_department.Teacher;

public class TeacherDatabase {
public TeacherDatabase(){createTeacherTable();}
   private void createTeacherTable(){

     String query="CREATE TABLE IF NOT EXISTS teacher(teacher_id int,name varchar(30),age int,subject varchar(50))";
     try(Connection connection=DatabaseConfig.getConnection();
         PreparedStatement preparedStatement=connection.prepareStatement(query)) {
         preparedStatement.execute();
         System.out.println("table created successfully");
         connection.close();
     }
     catch (SQLException e) {
         e.printStackTrace();
     }
   }


public void addTeacher(Teacher teacher){
    String query="INSERT INTO teacher(teacher_id,name,age,subject) VALUES(?,?,?,?)";
    try (Connection connection=DatabaseConfig.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(query)){

         preparedStatement.setInt(1,teacher.getTeacher_id());
         preparedStatement.setString(2,teacher.getName());
         preparedStatement.setInt(3,teacher.getAge());
         preparedStatement.setString(4,teacher.getSubject());
         preparedStatement.executeUpdate();
        System.out.println("records inserted successfully");
        connection.close();

    }catch (SQLException e){
        e.printStackTrace();
    }
   }

  public List<Teacher> selectAllTeacher(){
   List<Teacher> teacher=new ArrayList<>();
       String query="SELECT * FROM teacher";
       try(Connection connection=DatabaseConfig.getConnection();
           Statement statement= connection.createStatement()){
           ResultSet resultSet= statement.executeQuery(query);
           while (resultSet.next()){
               int teacher_id= resultSet.getInt("teacher_id");
               String name= resultSet.getString("name");
               int age= resultSet.getInt("age");
               String subject= resultSet.getString("subject");
               teacher.add(new Teacher(teacher_id,name,age,subject));
          }
       }
       catch (SQLException e){
           e.printStackTrace();
       }
       return teacher;
  }
    public  Teacher selectTeacherById(int id){
        Teacher teacher=null;
        String query="SELECT teacher_id,name,age,subject FROM teacher WHERE teacher_id=1";
        try(Connection connection= DatabaseConfig.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int teacher_id= resultSet.getInt("teacher_id");
                String name= resultSet.getString("name");
                int age= resultSet.getInt("age");
                String subject= resultSet.getString("subject");
                teacher=new Teacher(teacher_id,name,age,subject);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }

  public  boolean updateTeacher(Teacher teacher) throws SQLException {
       boolean rowUpdated;
       String query="UPDATE teacher SET teacher_id=? name=? age=? subject=? Java WHERE teacher_id=1";
       try(Connection connection=DatabaseConfig.getConnection();
       PreparedStatement preparedStatement= connection.prepareStatement(query)){
          preparedStatement.setInt(1,teacher.getTeacher_id());
          preparedStatement.setString(2,teacher.getName());
          preparedStatement.setInt(3,teacher.getAge());
          preparedStatement.setString(4,teacher.getSubject());
          rowUpdated=preparedStatement.executeUpdate()>0;

       }
       return rowUpdated;
  }
  public  void deleteTeacher()  {

      String query = "DELETE FROM teacher WHERE teacher_id=4";
      try (Connection connection = DatabaseConfig.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.executeUpdate();



      }catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
