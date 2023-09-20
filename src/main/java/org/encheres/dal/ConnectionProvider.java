package org.encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * La class ConnectionProvider offre une methode static pour obtenir une connection à la DB utilisant un objet
 * DataSource.
 * 
 * Exemple d'utilisation {@link ConnectionProvider} class:
 * <pre>
 *  try (Connection connection = ConnectionProvider.getConnection()) {
 *     // PreparedStatement, ResultSet, etc.
 * } catch (SQLException e) {
 *     // Gestion d'erreur
 * }
 * </pre>
 * @throws SQLException
 */
public class ConnectionProvider {
    private static DataSource dataSource;

    static {
        Context context;

        try {
            String url = "java:comp/env/sqlserver/jdbc/pool_connection";
            context = new InitialContext();
            ConnectionProvider.dataSource = (DataSource) context.lookup(url);
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur: ne peut se connecter à la DB.");
        }
    }

    public static Connection getConnection() throws SQLException {
        return ConnectionProvider.dataSource.getConnection();
    }
}
