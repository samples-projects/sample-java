package sample.junit.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * データベースコネクタ
 */
@Slf4j
public class DatabaseConnecter {
  static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
  static final String USER = "guest";
  static final String PASS = "guest123";

  /**
   * データベース接続
   * 
   * @return 接続オブジェクト
   * @throws SQLException 接続失敗
   */
  protected Connection connect() throws SQLException {
    log.info("connect database");
    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
    return connection;
  }

  /**
   * 社員配列を生成
   * 
   * @param resultSet テーブル
   * @return 社員配列
   * @throws SQLException 変換失敗
   */
  protected Employee createEmployee(ResultSet resultSet) throws SQLException {
    Employee employee = new Employee();
    employee.setAge(resultSet.getInt("age"));
    employee.setFirst(resultSet.getInt("first"));
    employee.setId(resultSet.getInt("id"));
    employee.setLast(resultSet.getInt("last"));

    log.info("Age: {}", employee.getAge());
    log.info("First: {}", employee.getFirst());
    log.info("ID: {}", employee.getId());
    log.info("Last: {}", employee.getLast());

    return employee;
  }

  /**
   * データベースから全社員を取得
   * 
   * @throws SQLException
   * 
   */
  public List<Employee> selectEmployees() throws SQLException {
    String query = "SELECT id, first, last, age FROM Employees";
    var employees = new ArrayList<Employee>();

    try (Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);) {
      while (resultSet.next()) {
        employees.add(createEmployee(resultSet));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      log.error(e.getMessage());

      throw new SQLException();
    }

    return employees;
  }
}
