package socialstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
        private static Connection connection;
        public static Connection getConnection () {
            return connection;
        }

        static {
            try {
                Class.forName("org.h2.Driver");
                System.out.println("Driver Loaded");

                connection = DriverManager.getConnection("jdbc:h2:file:\\Users\\Pranjali\\Desktop\\h2", "sa", "");
                System.out.println("Established Connection");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        //Insert Data
//        Statement statement = connection.createStatement();
//       String sql = "insert into userdata(name, email, password) values('Alice', 'alice@abc.com', 'alicepass'), ('Bob', 'bob@agc.com', 'bobless'), ('eve', 'eve@ght.com', 'eveutil')";
//       int res = statement.executeUpdate(sql);
//        System.out.println(res + " rows inserted.");

//        Statement statement = connection.createStatement();
//        String sql = "insert into post(user_id) values(1), (1), (2)";
//        int res = statement.executeUpdate(sql);
//        System.out.println(res + " rows inserted.");
//
//        Statement statement = connection.createStatement();
//       String sql = "insert into comment(post_id, user_id) values(1, 2), (1,3), (2, 3), (3, 1)";
//       int res = statement.executeUpdate(sql);
//       System.out.println(res + " rows inserted.");

    }
}
