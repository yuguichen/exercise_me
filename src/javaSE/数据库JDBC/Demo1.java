package javaSE.数据库JDBC;

import java.sql.*;


public class Demo1 {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        try {
            //1、加载jdbc的驱动程序
            //   需要提前将mysql的connect_jar包导入
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");

            //2、建立数据库连接
            //   url："jdbc：mysql：//主机：端口号/创建数据库的名称"
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entity","root","123456");
            System.out.println(connection+"数据库连接成功");

            //3、向数据库发送SQL语句
            Statement sql= connection.createStatement();

            //4、获取结果集
            ResultSet resultSet = sql.executeQuery("select * from users");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
