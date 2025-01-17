package com.example.shop.Unit;

import com.example.shop.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConfigurationUnitTest {

    // Test №1
    @Test
    @DisplayName("Получени свойств в верной конфигурацией")
    void ShouldGetPropsWithCorrectConfiguration() {
        Properties expectedProps = new Properties();
        expectedProps.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        expectedProps.setProperty("hibernate.connection.url", "jdbc:postgresql://stampy.db.elephantsql.com:5432/nykbjfyu");
        expectedProps.setProperty("hibernate.connection.username", "nykbjfyu");
        expectedProps.setProperty("hibernate.connection.password", "BJ0QQMsy2UK45xWFY1PP9GNxa3yNr2jh");
        expectedProps.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        expectedProps.setProperty("hibernate.show_sql", "true");
        expectedProps.setProperty("hibernate.hbm2ddl.auto", "update");
        expectedProps.setProperty("hibernate.connection.autocommit", "true");

        Properties actualProps = Configuration.getProps();

        assertEquals(expectedProps, actualProps);
    }

    private void assertEquals(Properties expectedProps, Properties actualProps) {
    }

    // Test №2
    @Test
    @DisplayName("Получение исключения при построении экземпляра объекта SessionFactory не равному нуль")
    void ShouldGetSessionFactoryWithoutException() {
        Configuration configuration = new Configuration();

        SessionFactory sessionFactory = configuration.buildFactory();

        assertNotNull(sessionFactory);
    }

    // Test №3
    @Test
    @DisplayName("Получение исключения при получении экземпляра объекта равному нуль")
    void ShouldCheckGetExceptionWhenFactoryNull() {
        assertThrows(NullPointerException.class, () -> {
            Configuration.createNewSession(null);
        });
    }

    // Test №4
    @Test
    @DisplayName("Получение нового объекта session, при маппинге для базы данных")
    void ShouldCreateNewSessionWithFactory() {
        SessionFactory mockFactory = mock(SessionFactory.class);
        Session mockSession = mock(Session.class);

        when(mockFactory.openSession()).thenReturn(mockSession);

        Session session = Configuration.createNewSession(mockFactory);

        assertNotNull(session);

        verify(mockFactory, times(1)).openSession();
    }
}
