package bean;

import java.sql.SQLException;

/**
 * Create a Bean abstract class.
 *
 * @author Richa
 */
public abstract class Bean {

  
    public abstract void setData();

    /**
     * @return user_id
     * @throws SQLException raises SQLException
     */
    public abstract int create() throws SQLException;

    /**
     * @return 1 if entry is updated
     * @throws SQLException raises SQLException
     */
    public abstract int update() throws SQLException;

    /**
     * Prints all records of user
     *
     * @throws SQLException raises SQLException
     */
    public abstract void print() throws SQLException;
}
