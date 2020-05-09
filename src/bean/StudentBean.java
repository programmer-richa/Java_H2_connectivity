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
public class StudentBean extends Bean {

    private int student_id;
    private String name, contact_no;

    public StudentBean() {
    }

    /**
     * @param student_id studentid value
     * @param name name
     * @param contact_no contact no
     */
    public StudentBean(int student_id, String name, String contact_no) {
        this.student_id = student_id;
        this.name = name;
        this.contact_no = contact_no;
    }

    /**
     *
     * @param name name
     * @param contact_no contact no
     */
    public StudentBean(String name, String contact_no) {
        this.name = name;
        this.contact_no = contact_no;
    }

    /**
     * @return student_id
     */
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return contact_no
     */
    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    /**
     * @return student_id
     * @throws SQLException raises SQLException
     */
    @Override
    public int create() throws SQLException {
        int result = -1;
        String sql = "insert into student (name,contact_no) values (?,?);";
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
        String sql = "UPDATE student SET name=?,contact_no=? where student_id=?";
        ArrayList param = new ArrayList();
        param.add(this.name);
        param.add(this.contact_no);
        param.add(this.student_id);
        result = DBHandler.ins_up_del(sql, param);
        return result;
    }

    /**
     * Prints all records of student
     *
     * @throws SQLException raises SQLException
     */
    @Override
    public void print() throws SQLException {
        ResultSet result = null;
        String sql = "select student_id,name,contact_no FROM student;";

        result = DBHandler.getData(sql, null);
        while (result.next()) {
            System.out.println(result.getInt("student_id") + "\t" + result.getString("name") + "\t" + result.getString("contact_no") + "\t");
        }

    }

    @Override
    public void setData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student Name : ");
        name = input.next();
        System.out.print("Enter Contact No. : ");
        contact_no = input.next();
       
    }
}
