package com.example.demo;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
     *
     * @param resultSet reprezinta toate randurile dintr-un tabel
     * @return o lista cu obiectele din acel tabel
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
     *
     * @param fields = numele variabilelor instanta cu care este apelata metoda
     * @return query ce afiseaza toate randurile pentru id-ul trimis prin "?"
     */
    private String createSelectQuery(String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("warehousedb." + type.getSimpleName());
        sb.append(" WHERE " + fields[0] + " = ?");
        return sb.toString();
    }

    /**
     *
     * @return query ce afiseaza toate randurile dintr-un tabel
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
     *
     * @param = numele variabilelor instanta cu care este apelata metoda
     * @return query ce va insera o linie intr-un tabel
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

    public String insertQuery(String[] fields) {
        // String query = "INSERT INTO records (id, time) VALUES (?, ?)";
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
     * metoda insereaza un element intr-o tabela
     *
     * @param t un obiect generic
     * @return obiectul generic t
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
                if (valuesForFields[i].getClass().getSimpleName().equals("Integer"))
                    statement.setInt(i + 1, ((Integer) valuesForFields[i]).intValue());
                else if (valuesForFields[i].getClass().getSimpleName().equals("String"))
                    statement.setString(i + 1, ((String) valuesForFields[i]));
                else if (valuesForFields[i].getClass().getSimpleName().equals("Float"))
                    statement.setFloat(i + 1, ((Float) valuesForFields[i]).floatValue());

            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insertToDB " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return t;
    }

}

