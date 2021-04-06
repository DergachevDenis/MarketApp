package sample.storage;


import sample.model.User;

import java.sql.*;

public class UserDB {
    private static String userDB = "root";
    private static String passwordDB = "19930305";
    private static String connectionURLDB = "jdbc:mysql://localhost:3306/dbinternetmarket?serverTimezone=Europe/Moscow&useSSL=false";
    private static Connection dbConnection;

//    public static void main(String[] args) {
//        UserDB userDB = new UserDB();
//        System.out.println(userDB.checkLogin("TIFik"));
//    }

    private Connection getDbConnection() { // Подключаемся к базе данных
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionURLDB, userDB, passwordDB);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

    private static void closeConnection() { // Закрываем соеденение с базой данных
        try {
            dbConnection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public boolean checkLogin(String loginDB) { // Проверяем логин
        boolean flag = false;
        String sqlCommand = "SELECT EXISTS (SELECT login FROM users WHERE login = ?)";
        try {
            PreparedStatement prStatement = getDbConnection().prepareStatement(sqlCommand);
            prStatement.setString(1, loginDB);
            ResultSet resultSet = prStatement.executeQuery();
            while (resultSet.next()) {
                flag = resultSet.getBoolean(1);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeConnection();
        }
        return flag;
    }

    public User getUser(String loginDB) { // Получаем пользователя из базы данных
        User user = null;
        String sqlCommand = "SELECT *  FROM users WHERE login = ?";
        try {
            PreparedStatement prStatement = getDbConnection().prepareStatement(sqlCommand);
            prStatement.setString(1, loginDB);
            ResultSet resultSet = prStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                boolean bollCard = resultSet.getBoolean("card");
                String numberCard = null;
                if (bollCard) {
                    numberCard = resultSet.getString("numberCard");
                }
                if (bollCard) {
                    user = new User(login, password, name, lastname, email, numberCard);
                } else {
                    user = new User(login, password, name, lastname, email);
                }

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }

    public void insertNewUser(User newUser) { //Создаём пользователя
        String sqlCommand = "INSERT INTO users (login, password, name, lastname, email, card, numberCard) VALUES (?,?,?,?,?,?,?) ";
        try {
            PreparedStatement prStatement = getDbConnection().prepareStatement(sqlCommand);
            prStatement.setString(1, newUser.getLogin());
            prStatement.setInt(2, newUser.getPassword());
            prStatement.setString(3, newUser.getName());
            prStatement.setString(4, newUser.getLastName());
            prStatement.setString(5, newUser.getEmail());
            if (newUser.isCard()) {
                prStatement.setInt(6, 1);
                prStatement.setString(7, newUser.getNumberCard());
            } else {
                prStatement.setInt(6, 0);
                prStatement.setString(7, null);
            }
            prStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void updateUser(User user) {
        String sqlCommand = "UPDATE users SET password = ?, name = ?, lastName = ?, email = ?, card = ?, numberCard = ? where login = ?";
        try {
            PreparedStatement prStatement = getDbConnection().prepareStatement(sqlCommand);
            prStatement.setInt(1, user.getPassword());
            prStatement.setString(2, user.getName());
            prStatement.setString(3, user.getLastName());
            prStatement.setString(4, user.getEmail());
            if (user.isCard()) {
                prStatement.setInt(5, 1);
                prStatement.setString(6, user.getNumberCard());
            } else {
                prStatement.setInt(5, 0);
                prStatement.setString(6, null);
            }
            prStatement.setString(7, user.getLogin());
            prStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}





