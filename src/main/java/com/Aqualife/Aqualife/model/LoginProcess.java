
package com.Aqualife.Aqualife.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginProcess {
    public boolean ifLogged(String email, String password){ // to check login inputs are correct and return true if not return false

        try{
            Connection con = DbConnection.getConnection();
            String mySqlQuery =
                    "SELECT username, password, id FROM tbl_admin WHERE username = '"+
                            email+
                            "' AND password = '"+
                            password+
                            "'";
            PreparedStatement preparedStatement = con.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                LoginSession.Email = resultSet.getString("username");
                LoginSession.Password = resultSet.getString("password");
                LoginSession.Id = resultSet.getInt("id");


                return true;
            }

        }catch (Exception exception){
            System. out. println("Database error: " + exception.getMessage());
        }

        return false;
    }
    
}
