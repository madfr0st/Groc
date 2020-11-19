package com.frost.groc.DBMS;

import java.sql.*;
import java.util.*;

public class DBMS {

    private Connection connection;
    public String DBMSLocation = "jdbc:sqlite:C:\\Users\\suman\\Documents\\DBMS\\test.db";
    private Statement statement;

    public void setDBMSLocation(String string) {
        DBMSLocation = string;
    }

    public void getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\suman\\Documents\\DBMS\\test.db");
    }

    public void closeConnection() throws SQLException, ClassNotFoundException {
        connection.close();
    }


    public void createSingleUserTable(int id) throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists userid_" + id + "(itemName TEXT,itemMeasuredIn TEXT,itemAmount INTEGER)");
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during creating single user table :" + e.getMessage());
        }
    }

    public void creatingVegetablesDatabaseTable() throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists " + "allvegetables" + "(itemName TEXT,itemMeasuredIn TEXT,itemAmount INTEGER)");
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during creating allvegetables table :" + e.getMessage());
        }
    }

    public void creatingFruitsDatabaseTable() throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists " + "allfruits" + "(itemName TEXT,itemMeasuredIn TEXT,itemAmount INTEGER)");
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during creating allfruits table :" + e.getMessage());
        }
    }

    public void creatingGroceryDatabaseTable() throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists " + "allgrocery" + "(itemName TEXT,itemMeasuredIn TEXT,itemAmount INTEGER)");
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during creating allgrocery table :" + e.getMessage());
        }
    }

    public void createAllUsersTable() throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists allusers (id INTEGER,userName TEXT,password TEXT,phoneNumber INTEGER)");
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during creating alluser table :" + e.getMessage());
        }
    }

    public void createImageTable() throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists image (itemName TEXT, itemImage TEXT)");
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during creating image table :" + e.getMessage());
        }
    }


    public void printTable(String tableName) throws SQLException, ClassNotFoundException {
        getConnection();
        statement = connection.createStatement();

        String string = "SELECT * FROM " + tableName;
        ResultSet resultSet = statement.executeQuery(string);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int columnsNumber = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            String s = "";
            for (int i = 1; i <= columnsNumber; i++) {
                s += resultSet.getString(i) + " ";
            }
            System.out.println(s);
        }
        statement.close();
        closeConnection();
    }

    public int checkUser(String name, String pass) throws SQLException,ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            if (statement.executeQuery("select * from allusers where userName='" + name + "'").next()) {
                ResultSet resultSet = statement.executeQuery("select * from allusers where userName='" + name + "'");
                resultSet.next();
                String pass1 = resultSet.getString(2);
                if (pass.equals(pass1)) {
                    statement.close();
                    closeConnection();
                    return 2;
                } else {
                    statement.close();
                    closeConnection();
                    return 1;
                }
            } else {
                statement.close();
                closeConnection();
                return 0;
            }
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during checking user :" + e.getMessage());
        }
        return 0;
    }

    public boolean insertUser(String name, String password, long phoneNumber) throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();

            if (!statement.executeQuery("select * from allusers where userName='" + name + "'").next()) {
                String s = "INSERT INTO allusers VALUES(";
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM allusers");
                int last = 0;
                while (resultSet.next()) {
                    last = resultSet.getInt(1);
                }
                last++;
                s += last + ",'" + name + "','" + password + "','" + phoneNumber + "')";
                statement.execute(s);
                statement.close();
                closeConnection();
                return true;
            } else {
                statement.close();
                closeConnection();
                return false;
            }

        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during inserting users :" + e.getMessage());
        }
        return false;
    }

    public boolean insertVegetableIntoDatabase(String itemName, String itemMeasuredIn, int itemAmount) throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            String a = "SELECT * FROM allvegetables WHERE itemName ='" + itemName + "'";
            if (!statement.executeQuery(a).next()) {
                String s = "INSERT INTO allvegetables VALUES('" + itemName + "','" + itemMeasuredIn + "','" + itemAmount + "')";
                statement.execute(s);
                statement.close();
                closeConnection();
            } else {

                String s = "UPDATE allvegetables  SET itemAmount = '" + itemAmount + "' WHERE itemName ='" + itemName + "'";
                statement.execute(s);
                statement.close();
                closeConnection();
            }
            return true;
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during inserting vegetables :" + e.getMessage());
        }
        return false;
    }

    public boolean insertFruitsIntoDatabase(String itemName, String itemMeasuredIn, int itemAmount) throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();

            String a = "SELECT * FROM allfruits WHERE itemName ='" + itemName + "'";
            if (!statement.executeQuery(a).next()) {
                String s = "INSERT INTO allfruits VALUES('" + itemName + "','" + itemMeasuredIn + "','" + itemAmount + "')";
                statement.execute(s);
                statement.close();
                closeConnection();
            } else {

                String s = "UPDATE allfruits  SET itemAmount = '" + itemAmount + "' WHERE itemName ='" + itemName + "'";
                statement.execute(s);
                statement.close();
                closeConnection();
            }
            return true;
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during inserting fruits :" + e.getMessage());
        }
        return false;
    }

    public boolean insertGroceryIntoDatabase(String itemName, String itemMeasuredIn, int itemAmount) throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();

            String a = "SELECT * FROM allgrocery WHERE itemName ='" + itemName + "'";
            if (!statement.executeQuery(a).next()) {
                String s = "INSERT INTO allgrocery VALUES('" + itemName + "','" + itemMeasuredIn + "','" + itemAmount + "')";
                statement.execute(s);
                statement.close();
                closeConnection();
            } else {

                String s = "UPDATE allgrocery  SET itemAmount = '" + itemAmount + "' WHERE itemName ='" + itemName + "'";
                statement.execute(s);
                statement.close();
                closeConnection();
            }
            return true;
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during inserting grocery :" + e.getMessage());
        }
        return false;
    }

    public boolean insertImage(String itemName, String itemImage) throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();

            String a = "SELECT * FROM image WHERE itemName ='" + itemName + "'";
            if (!statement.executeQuery(a).next()) {
                String s = "INSERT INTO image VALUES('" + itemName + "','" + itemImage + "')";
                statement.execute(s);
                statement.close();
                closeConnection();
            } else {

                String s = "UPDATE image  SET itemImage = '" + itemImage + "' WHERE itemName ='" + itemName + "'";
                statement.execute(s);
                statement.close();
                closeConnection();
            }
            return true;
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during inserting image :" + e.getMessage());
        }
        return false;
    }

    public ArrayList<Pair<String, Pair<String, Integer>>> getAllVegetables() throws SQLException, ClassNotFoundException {
        ArrayList<Pair<String, Pair<String, Integer>>> list = new ArrayList<>();
        try {
            String s = "SELECT * FROM allvegetables";
            getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                list.add(new Pair<String, Pair<String, Integer>>(resultSet.getString(1), new Pair<String, Integer>(
                        resultSet.getString(2), resultSet.getInt(3)
                )));
            }
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("error while getting allvegetables :" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Pair<String, Pair<String, Integer>>> getAllFruits() throws SQLException, ClassNotFoundException {
        ArrayList<Pair<String, Pair<String, Integer>>> list = new ArrayList<>();
        try {
            String s = "SELECT * FROM allfruits";
            getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                list.add(new Pair<String, Pair<String, Integer>>(resultSet.getString(1), new Pair<String, Integer>(
                        resultSet.getString(2), resultSet.getInt(3)
                )));
            }
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("error while getting allvegetables :" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Pair<String, Pair<String, Integer>>> getAllGrocery() throws SQLException, ClassNotFoundException {
        ArrayList<Pair<String, Pair<String, Integer>>> list = new ArrayList<>();
        try {
            String s = "SELECT * FROM allgrocery";
            getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                list.add(new Pair<String, Pair<String, Integer>>(resultSet.getString(1), new Pair<String, Integer>(
                        resultSet.getString(2), resultSet.getInt(3)
                )));
            }
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("error while getting allvegetables :" + e.getMessage());
        }
        return list;
    }

    public Map<String, String> getImages() throws SQLException, ClassNotFoundException {
        Map<String, String> map = new HashMap<>();
        try {
            String s = "SELECT * FROM image";
            getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                map.put(resultSet.getString(1), resultSet.getString(2));
            }
            statement.close();
            closeConnection();
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("error while getting images :" + e.getMessage());
        }
        return map;
    }

    public boolean singleUserCart(int id, String itemName, String itemMeasuredIn,int itemAmount) throws SQLException, ClassNotFoundException {
        try {
            createSingleUserTable(id);
            closeConnection();
            getConnection();
            statement = connection.createStatement();

            String a = "SELECT * FROM userid_"+id+" WHERE itemName ='" + itemName + "'";
            if (!statement.executeQuery(a).next()) {
                String s = "INSERT INTO userid_"+id+" VALUES('" + itemName + "','" + itemMeasuredIn + "','" + itemAmount + "')";
                statement.execute(s);
                statement.close();
                closeConnection();
            } else {
                String s = "UPDATE userid_"+id+"  SET itemAmount = '" + itemAmount + "' WHERE itemName ='" + itemName + "'";
                statement.execute(s);
                statement.close();
                closeConnection();
            }
            return true;
        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error while singleUserCart :" + e.getMessage());
        }
        return false;
    }

    public int getUserId(String userName) throws SQLException, ClassNotFoundException {
        try {
            getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from allusers where userName='" + userName + "'");
            resultSet.next();
            int id = resultSet.getInt(1);
            statement.close();
            closeConnection();
            return id;

        } catch (Exception e) {
            statement.close();
            closeConnection();
            System.out.println("Error during getting userID :" + e.getMessage());
        }
        return -1;
    }

}
