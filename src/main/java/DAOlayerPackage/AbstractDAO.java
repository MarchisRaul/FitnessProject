package DAOlayerPackage;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.demo.ConnectionFactory;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * @param fields = variable names of the required table
     * @return the query that selects a row based on the value of the first column of that table
     */
    private String createSelectQuery(String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("fitnesscarddb." + type.getSimpleName());
        sb.append(" WHERE " + fields[0] + " = ?");
        return sb.toString();
    }

    /**
     * @return the query that selects all rows from a certain table
     */
    public String createFindAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("* ");
        sb.append("FROM ");
        sb.append("fitnesscarddb." + type.getSimpleName());

        return sb.toString();
    }

    /**
     * @param fields = variable names of the required table
     * @return the query that deletes a certain row based on the value of the first column of that table
     */
    public String createDeleteQuery(String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append("FROM ");
        sb.append("fitnesscarddb." + type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(fields[0]);
        sb.append(" = ");
        sb.append("?");

        return sb.toString();
    }

    /**
     * @param fields = variable names of the required table
     * @return the query that updates a certain row from a table based on the value of the first column of that table (
     */
    public String createUpdateQuery(String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("fitnesscarddb." + type.getSimpleName());
        sb.append(" set ");
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            sb.append(" = ?");
            if (i != fields.length - 1)
                sb.append(", ");
        }
        sb.append(" WHERE ");
        sb.append(fields[0]);
        sb.append(" = ");
        sb.append("?");

        return sb.toString();
    }

    /**
     * @param fields = variable names of the required table
     * @return the query that inserts a new row in a certain table
     */
    public String insertQuery(String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ");
        sb.append("INTO ");
        sb.append("fitnesscarddb." + type.getSimpleName());
        sb.append(" (");
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i != fields.length - 1)
                sb.append(", ");
        }
        sb.append(") ");
        sb.append(" VALUES ");
        sb.append(" (");
        for (int i = 0; i < fields.length; i++) {
            sb.append("?");
            if (i != fields.length - 1)
                sb.append(", ");
        }
        sb.append(")");

        return sb.toString();
    }

    /**
     * @return a list with all the rows from a certain table
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = createFindAllQuery();
        try {
            connection = ConnectionFactory.getConnection(); // facem conexiunea
            statement = connection.prepareStatement(query); // pregatim query-ul
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            //ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * @param id = the id of a certain row from a table
     * @return the row from a table for which the id (first column) is equal to the id received as a parameter
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Field[] fields = type.getDeclaredFields();
        String[] fieldsName = new String[fields.length];
        Object[] valuesForFields = new Object[fields.length];
        for (int i = 0; i < fields.length; i++)
            fieldsName[i] = fields[i].getName();

        String query = createSelectQuery(fieldsName);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();


            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } catch(Exception exp) {
            return null;
        } finally {
            ConnectionFactory.close(resultSet);
            //ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * @param resultSet = the rows from a certain table resulted after executing a specific query
     * @return a list with the objects created from the resultSet parameter
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        try {
            while (resultSet.next()) {
                T instance = type.getDeclaredConstructor().newInstance();
                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param t = generic parameter which will be substituted with the instance type of the object that is wanted to be inserted into a table
     * @return the generic object t that wants to be inserted
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Field[] fields = type.getDeclaredFields();
        String[] fieldsName = new String[fields.length];
        Object[] valuesForFields = new Object[fields.length];
        for (int i = 0; i < fields.length; i++)
            fieldsName[i] = fields[i].getName();

        int j = 0;
        for (Field field : fields) {
            field.setAccessible(true);

            Object value = null;

            try {
                value = field.get(t);
                valuesForFields[j++] = value;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        String query = insertQuery(fieldsName);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            for (int i = 0; i < valuesForFields.length; i++)
                if (valuesForFields[i].getClass().getSimpleName().equals("Integer") || valuesForFields[i].getClass().getSimpleName().equals("int"))
                    statement.setInt(i + 1, ((Integer) valuesForFields[i]).intValue());
                else if (valuesForFields[i].getClass().getSimpleName().equals("String"))
                    statement.setString(i + 1, ((String) valuesForFields[i]));
                else if (valuesForFields[i].getClass().getSimpleName().equals("Float"))
                    statement.setFloat(i + 1, ((Float) valuesForFields[i]).floatValue());
                else if (valuesForFields[i].getClass().getSimpleName().equals("Date")) {
                    statement.setTime(i + 1, new Time(((Date)valuesForFields[i]).getTime()));
                }

            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insertToDB " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            //ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return t;
    }

    /**
     * @param t = generic parameter which will be substituted with the instance type of the object that is wanted a row to be updated with from a table
     * @param id = the id of the old objects that is going to be updated
     * @return the generic object t that is going to substitute the old object
     */
    public T update(T t, int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Field[] fields = type.getDeclaredFields();
        String[] fieldsName = new String[fields.length];
        Object[] valuesForFields = new Object[fields.length];
        for (int i = 0; i < fields.length; i++)
            fieldsName[i] = fields[i].getName();

        int j = 0;
        for (Field field : fields) {
            field.setAccessible(true);

            Object value = null;

            try {
                value = field.get(t);
                valuesForFields[j++] = value;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        String query = createUpdateQuery(fieldsName);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for (int i = 0; i < valuesForFields.length; i++)
                if (valuesForFields[i].getClass().getSimpleName().equals("Integer"))
                    statement.setInt(i + 1, ((Integer) valuesForFields[i]).intValue());
                else if (valuesForFields[i].getClass().getSimpleName().equals("String"))
                    statement.setString(i + 1, ((String) valuesForFields[i]));
                else if (valuesForFields[i].getClass().getSimpleName().equals("Float"))
                    statement.setFloat(i + 1, ((Float) valuesForFields[i]).floatValue());
                else if (valuesForFields[i].getClass().getSimpleName().equals("Date"))
                    statement.setTime(i + 1, new Time(((Date)valuesForFields[i]).getTime()));
            statement.setInt(valuesForFields.length + 1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:updateTheDB " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            //ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return t;
    }

    /**
     * @param t = generic parameter which will be substituted with the instance type of the object that is wanted to be deleted from a table
     */
    public void delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Field[] fields = type.getDeclaredFields();
        String[] fieldsName = new String[fields.length];
        Object[] valuesForFields = new Object[fields.length];
        for (int i = 0; i < fields.length; i++)
            fieldsName[i] = fields[i].getName();

        int j = 0;
        for (Field field : fields) {
            field.setAccessible(true);

            Object value = null;

            try {
                value = field.get(t);
                valuesForFields[j++] = value;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        String query = createDeleteQuery(fieldsName);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            if (valuesForFields[0].getClass().getSimpleName().equals("Integer"))
                statement.setInt(1, ((Integer) valuesForFields[0]).intValue());
            else if (valuesForFields[0].getClass().getSimpleName().equals("String"))
                statement.setString(1, ((String) valuesForFields[0]));
            else if (valuesForFields[0].getClass().getSimpleName().equals("Float"))
                statement.setFloat(1, ((Float) valuesForFields[0]).floatValue());
            //statement.setInt(1, ((Integer) valuesForFields[0]).intValue());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteFromDB " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
