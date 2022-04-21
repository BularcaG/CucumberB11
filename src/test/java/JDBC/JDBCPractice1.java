package JDBC;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static JDBC.JDBCUtil.*;

public class JDBCPractice1 {


    @Test
    public void jdbcTest(){

        //Printout all the names from employees table that are starting with S
        establishConnection();
        List<Map<String,Object>> nameS=executeQuery(" select first_name from employees\n" +
                "        where first_name like 'S%'");

        for (int i=0;i< nameS.size();i++){

            System.out.println(nameS.get(i).get("FIRST_NAME"));
        }
        closeConnection();  //--> Will be in hook class or after hook

    }
}
