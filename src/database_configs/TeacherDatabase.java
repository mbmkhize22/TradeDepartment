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
          PreparedStatement preparedStatement= connection.prepareStatement(query)){
           ResultSet resultSet=preparedStatement.executeQuery();
           while (resultSet.next()){
               teacher.add(new Teacher(
               resultSet.getInt("teacher_id"),
               resultSet.getString("name"),
               resultSet.getInt("age"),
               resultSet.getString("subject")
          ));
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

                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }

  public void updateTeacher(int teacher_id, String name, int age, String subject) {

       String query="UPDATE teacher SET  name = ?, age = ?, subject = ?  WHERE teacher_id = ?";
       try(Connection connection=DatabaseConfig.getConnection();
       PreparedStatement preparedStatement= connection.prepareStatement(query)){
          preparedStatement.setString(1,name);
          preparedStatement.setInt(2,age);
          preparedStatement.setString(3,subject);
          preparedStatement.setInt(4,teacher_id);
          int rowsUpdated=preparedStatement.executeUpdate();
           System.out.println(rowsUpdated+" row(s) updated");
          connection.close();
       }
       catch (SQLException e){
           e.printStackTrace();
       }

  }
  public  void deleteTeacher(int teacherId)  {

      String query = "DELETE FROM teacher WHERE teacher_id=?";
      try (Connection connection = DatabaseConfig.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query)) {
          preparedStatement.setInt(1,teacherId);
          int rowsDeleted= preparedStatement.executeUpdate();
          System.out.println(rowsDeleted+" row(s) deleted" );
           connection.close();


      }catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
