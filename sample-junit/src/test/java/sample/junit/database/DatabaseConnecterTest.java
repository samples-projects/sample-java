package sample.junit.database;

import static org.mockito.ArgumentMatchers.anyString;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

// @RunWith(JUnit4.class)
public class DatabaseConnecterTest {

  @Before
  public void SetUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testSelectEmployees() throws Exception {

    DatabaseConnecter connecter = new DatabaseConnecter() {
      @Override
      protected Connection connect() throws SQLException {
        Connection connection = PowerMockito.mock(Connection.class);
        Statement statement = PowerMockito.mock(Statement.class);
        ResultSet resultSet = PowerMockito.mock(ResultSet.class);

        PowerMockito.when(resultSet.next())
            .thenReturn(true)
            .thenReturn(false);
        PowerMockito.when(resultSet.getInt(anyString()))
            .thenReturn(1)
            .thenReturn(2)
            .thenReturn(3)
            .thenReturn(4);

        PowerMockito.when(statement.executeQuery(anyString()))
            .thenReturn(resultSet);

        PowerMockito.when(connection.createStatement())
            .thenReturn(statement);

        return connection;
      }
    };

    List<Employee> employees = connecter.selectEmployees();

    assertThat(employees.size(), is(1));
    assertThat(employees.get(0).getAge(), is(1));
    assertThat(employees.get(0).getFirst(), is(2));
    assertThat(employees.get(0).getId(), is(3));
    assertThat(employees.get(0).getLast(), is(4));
  }
}
