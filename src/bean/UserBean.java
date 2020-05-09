package bean;

import example.DBHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create the concrete classes that extends Bean abstract class.
 *
 * @author Richa
 */
public class UserBean extends Bean {

    private int user_id;
    private String name, contact_no;

    public UserBean() {
    }

  

    /**
     * @return user_id
     * @throws SQLException raises SQLException
     */
    @Override
    public int create() throws SQLException {
        int result = -1;
        String sql = "insert into user (name,contact_no) values (?,?);";
        ArrayList param = new ArrayList();
        param.add(this.name);
        param.add(this.contact_no);

        result = DBHandler.ins_up_del(sql, param);
        return result;
    }

    /**
     * @return 1 if entry is updated
     * @throws SQLException raises SQLException
     */
    @Override
    public int update() throws SQLException {
        int result = -1;
        String sql = "UPDATE user SET name=?,contact_no=? where user_id=?";
        ArrayList param = new ArrayList();
        param.add(this.name);
        param.add(this.contact_no);
        param.add(this.user_id);
        result = DBHandler.ins_up_del(sql, param);
        return result;
    }

    /**
     * Prints all records of user
     *
     * @throws SQLException raises SQLException
     */
    @Override
    public void print() throws SQLException {
        ResultSet result = null;
        String sql = "select user_id,name,contact_no FROM user;";

        result = DBHandler.getData(sql, null);
        while (result.next()) {
            System.out.println(result.getInt("user_id") + "\t" + result.getString("name") + "\t" + result.getString("contact_no") + "\t");
        }

    }

   

    @Override
    public void setData() {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter User Name : ");
        name=input.next();
        System.out.print("Enter Contact No. : ");
        contact_no=input.next();
      
    }
}
