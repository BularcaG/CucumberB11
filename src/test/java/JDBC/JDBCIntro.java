package JDBC;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCIntro {


    /*

    Connection --> It will connect us to database
                   allow us to enter our credentials

    Statement  --> We define our conditions to get data from db.

    ResultSet  --> We store the data from db to java object

    ALL 3 are interfaces in java which comes from jdbc dependency




    declaring the exception --  in method signature

     */


    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@techtorial.czxengogo04y.us-east-1.rds.amazonaws.com:1521/ORCL",
                "student",
                "Password1");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        ResultSet resultSet = statement.executeQuery("select * from employees");



        resultSet.next(); //will return true if there is a next row otherwise it will return false;
        // also it will take us to the next row
        System.out.println(resultSet.getString("first_name"));
        //using getString we can get our column value from the row we are in
        System.out.println(resultSet.getRow());
        //if you want to go to the last row we could use resultSet.last() method
        resultSet.last();
        System.out.println(resultSet.getString("first_name"));
        resultSet.first();  //this method will take the row as first
        System.out.println(resultSet.getString("first_name"));
        //  resultSet.deleteRow();  if you want to delete the row

        //MetaData
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        // ex: count of the columns for your table

        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(1)); // it gives colujmn name in uppercse

        // how can I print all the column names from employees table ?


        // Creating a map for one row

        Map<String, Object> oneRow = new HashMap<>();
        System.out.println(resultSet.getRow());
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

            oneRow.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));

            //  i is the number for column and our row number is defined by resultSet next method
            //to be able to get columnName we will use resultSetMeta data object with index number of row
            //to be able to get column's value we will use resultSet.getObject method with index number of columns

        }

        System.out.println(oneRow);
        List<Map<String, Object>> allTable = new ArrayList<>();
        resultSet.beforeFirst();
        while (resultSet.next()) {
            Map<String, Object> currentRow = new HashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

                currentRow.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));


            }
            allTable.add(currentRow);

        }
        System.out.println(allTable);
    }
}
