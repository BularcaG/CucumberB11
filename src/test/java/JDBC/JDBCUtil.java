package JDBC;

import java.sql.*;
import java.util.*;

public class JDBCUtil {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData rSetMetaData;

    public static void establishConnection(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@techtorial.czxengogo04y.us-east-1.rds.amazonaws.com:1521/ORCL",
                    "student",
                    "Password1");

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e){
            System.out.println("Database connection error occured");
            e.printStackTrace();
        }
    }

    public static List<Map<String,Object>> executeQuery(String query){
        try {


            resultSet = statement.executeQuery(query);
            rSetMetaData = resultSet.getMetaData();
            List<Map<String, Object>> allTable = new ArrayList<>();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Map<String, Object> currentRow = new LinkedHashMap<>();
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
                    currentRow.put(rSetMetaData.getColumnName(i), resultSet.getObject(i));
                    // i is the number for column and our row number is defined by resultSet next method
                    // to be able to get columnName we will use resultSetMeta data object wiht index number of column
                    // to be able to get column's value we will use resultset.getObject method with index number of column

                }
                allTable.add(currentRow);
            }
            return allTable;
        } catch (SQLException e){
            System.out.println("Error occured when getting data from the table");
            e.printStackTrace();
            return null;

        }
    }

    public static void closeConnection(){

        try{if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }
        }catch (SQLException e){
            System.out.println("Error occured when connection is closing");
            e.printStackTrace();
        }
    }

}
