package bean;

/**
 * Create a GetBeanFactory to generate object of concrete classes based on given
 * information.
 *
 * @author Richa
 */
public class GetBeanFactory {

    /**
     * @param beanType String value representing Bean class
     * @return Bean instance
     */
    public Bean getBean(String beanType) {
        if (beanType == null) {
            return null;
        }
        if (beanType.equalsIgnoreCase("UserBean")) {
            return new UserBean();
        } else if (beanType.equalsIgnoreCase("StudentBean")) {
            return new StudentBean();
        }
        return null;
    }
}
