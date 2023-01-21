package com.example.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarsUtil {
    CarsUtil(){}
    public static void createTable() {
        String createSql = "CREATE TABLE FAV_CARS (" +
                "ID INTEGER NOT NULL AUTO_INCREMENT, " +
                "DATE INTEGER NOT NULL , " +
                "MAKE VARCHAR(255)," +
                "MODEL VARCHAR(255)," +
                "ENGINE_VOLUME INTEGER NOT NULL ,"+
                "PRIMARY KEY(ID))";
        try {
            JDBCUtil.getStatement().executeUpdate(createSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Created table in given database...");
    }
    public static void insert(Cars cars) {
        String insertSql = "INSERT INTO FAV_CARS(DATE,MAKE,MODEL,ENGINE_VOLUME) VALUES(" +
                "'" + cars.getDate() + "', " +
                "'" + cars.getMake() + "', " +
                "'" + cars.getModel() + "', " +
                "" + cars.getEngineVolume() + ")";
        try {
            JDBCUtil.getStatement().executeUpdate(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Cars> getAllCars() {

        String selectSql = "SELECT * FROM FAV_CARS";

        List<Cars> cars = new ArrayList<>();

        try {

            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSql);

            while (resultSet.next()) {

                cars.add(new Cars(
                        resultSet.getInt("DATE"),
                        resultSet.getString("MAKE"),
                        resultSet.getString("MODEL"),
                        resultSet.getInt("ENGINE_VOLUME")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cars;

    }


}
