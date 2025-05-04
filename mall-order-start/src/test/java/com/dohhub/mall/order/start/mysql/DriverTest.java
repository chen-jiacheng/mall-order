package com.dohhub.mall.order.start.mysql;

import com.dohhub.mall.order.start.MallOrderApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * Created by chenjiacheng on 2025/5/5 00:31
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
public class DriverTest extends MallOrderApplicationTest {

    @Test
    public void testDriver() {
        log.info("Testing MySQL driver...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://101.32.33.26:13306/mall_order_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "mall_order_app",
                    "5A)+~n;UTNr,puK8"
            );

            if (connection != null) {
                log.info("MySQL connection established successfully.");
            } else {
                log.error("Failed to establish MySQL connection.");
            }

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM t_order_accept");
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    String columnValue = resultSet.getString(columnName);
                    log.info("Column Name: {}, Column Value: {}", columnName, columnValue);
                }
            }
            resultSet.close();
            statement.close();
            connection.close();


            log.info("MySQL driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            log.error("Failed to load MySQL driver.", e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
