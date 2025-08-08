package database_configs;
import trade_department.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DoctorDatabase {

    public DoctorDatabase() {
        createDoctorTable();
    }

    private void createDoctorTable() {
        String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS doctor(
                    id integer PRIMARY KEY,
                    name text NOT NULL,
                    age integer NOT NULL,
                    specialization text NOT NULL
                    );
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDoctor(DoctorDatabase doctor) {
        String sql = "INSERT INTO Doctor (id, name, age, specialization) VALUES(?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctor.getN());
            statement.setInt(2, doctor.getA());
            statement.setString(3, doctor.getSpecilization());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getA() {
        return getA();
    }
    private String getN(){
        return "";
    }
    private String getSpecilization(){
        return "";
    }



    public Doctor getDoctorId(int id) throws SQLException {
        String SQL = "SELECT * FROM Doctor WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Doctor(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("specialization")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Doctor> getDoctor(){
        List<Doctor>DoctorList=new ArrayList<>();
        String SQL= "SELECT FROM Doctor";


        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DoctorList.add(new Doctor(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("badgeNumber")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DoctorList;
    }
    public void updateDoctor(int id, Doctor doctor) throws SQLException {
        String uSQL = "UPDATE Doctor SET name = ?, age = ?, specialization = ?";

        try(Connection connection = DatabaseConfig.getConnection()){

        PreparedStatement statement= connection.prepareStatement((uSQL)) ;
                statement.setInt(1, doctor.getA());
                statement.setString(2, doctor.getN());
                statement.setString(3, doctor.getSpecialization());
                statement.executeUpdate();

            }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteDoctor(int id, Doctor doctor){
        String dSQL = "DELETE FROM Doctor WHERE id=?";
        try(Connection connection=DatabaseConfig.getConnection()){
            PreparedStatement statement=connection.prepareStatement((dSQL));
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
 }
