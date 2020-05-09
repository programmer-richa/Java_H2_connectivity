package h2_connectivity;

import bean.Bean;
import bean.GetBeanFactory;
import example.DBHandler;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Bean Class object is used to interact with Database
 *
 * @author Richa
 */
public class H2_connectivity {

    /**
     * @param args the command line arguments
     * @throws SQLException raises SQLException
     */
    public static void main(String[] args) throws SQLException {
////        UserBean userbean = new UserBean("Rohan", "123456");
//        UserBean userbeanUp = new UserBean(2, "Hemant", "23123456");
////        System.out.println(userbean.createEntryUser());
//        System.out.println(userbeanUp.updateEntryUser());
//        UserBean.printEntryUser();
//        DBHandler.closeConnections();
        Scanner input = new Scanner(System.in);
        GetBeanFactory beanFactory = new GetBeanFactory();
        Bean bean;
        String beanClassName = "";
        for (int i = 1; i < 5; i++) {
            System.out.print("Enter userbean for user or studentbean for student : ");
            beanClassName = input.next();
            bean = beanFactory.getBean(beanClassName);
            if (bean != null) {
                bean.setData();
                bean.create();
                bean.print();
            }
        }
        DBHandler.closeConnections();
    }

}
