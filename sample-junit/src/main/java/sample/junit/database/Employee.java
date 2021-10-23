package sample.junit.database;

import java.sql.ResultSet;
import lombok.Data;

@Data
public class Employee {
  int id;
  int first;
  int last;
  int age;
}
