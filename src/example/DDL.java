package example;

/**
 * DDL queries for creating tables
 *
 * @author Richa
 */
public class DDL {

    /**
     * @return String Array of sql statements used for data dictionary in the
     * project
     */
    public static String[] getDDL() {
        String dropTableUser = "DROP TABLE IF EXISTS user;";
        String dropTableStudent = "DROP TABLE IF EXISTS student;";

        String createTableUser = "create table IF NOT EXISTS user("
                + "user_id int(11) NOT NULL AUTO_INCREMENT ,"
                + "name varchar(255),"
                + "contact_no varchar(255),"
                + "PRIMARY KEY (user_id));";

        String createTableStudent = "create table IF NOT EXISTS student("
                + "student_id int(11) NOT NULL AUTO_INCREMENT ,"
                + "name varchar(255),"
                + "contact_no varchar(255),"
                + "PRIMARY KEY (student_id));";

        return new String[]{
            /*dropTableUser, dropTableStudent,*/ createTableUser, createTableStudent};
    }

}
