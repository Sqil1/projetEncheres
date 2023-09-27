package org.encheres.module;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Classe EmailSettings. Cette classe contient tous les configurations d'email.
 */
public class EmailSettings {


    private final String host;
    private final Integer port;
    private final boolean auth;
    private final boolean starttls;
    private final String emailSender;
    private final String username;
    private final String password;
    private final String contentType;
    private final String encoding;
    /**
     * Constructeur privé. Les instances de la classe peuvent être obtenues via le Builder.
     * @param builder Builder d'EmailSettings
     */
    private EmailSettings(Builder builder) {
        this.auth = builder.auth;
        this.host = builder.host;
        this.port = builder.port;
        this.starttls = builder.starttls;
        this.emailSender = builder.emailSender;
        this.username = builder.username;
        this.password = builder.password;
        this.contentType = builder.contentType;
        this.encoding = builder.encoding;
    }

    /**
     * Retourne les propriétés pour la session SMTP.
     * @return Propriétés de la session SMTP.
     */
    public Properties getProperties() {
        final Properties props = new Properties();
        props.put("mail.smtp.host", host); //SMTP Host
        props.put("mail.smtp.port", port); //TLS Port
        props.put("mail.smtp.auth", auth); //enable authentication
        props.put("mail.smtp.starttls.enable", starttls);
        return props;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public boolean isAuth() {
        return auth;
    }

    public boolean isStarttls() {
        return starttls;
    }

    public String getContentType() {
        return contentType;
    }

    public String getHost() {
        return host;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }
    /**
     * Méthode pour obtenir les paramètres de l'e-mail à partir d'un fichier de propriétés.
     * @return EmailSettings à partir du fichier de propriétés.
     */
    static EmailSettings getSettings() {
        String rootPath = Thread.currentThread().getContextClassLoader()
                .getResource("")
                .getPath();
        String appConfigPath = rootPath + "email.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Builder()
                .setAuth(Boolean.valueOf(appProps.getProperty("email.auth", "false")))
                .setHost(appProps.getProperty("email.host", ""))
                .setPort(Integer.valueOf(appProps.getProperty("email.port", "25")))
                .setUsername(appProps.getProperty("email.username"))
                .setPassword(appProps.getProperty("email.password"))
                .setEmailSender(appProps.getProperty("email.sender"))
                .setStarttls(Boolean.valueOf(appProps.getProperty("email.starttls", "false")))
                .setContentType(appProps.getProperty("email.content-type", "text/HTML; charset=UTF-8"))
                .setEncoding(appProps.getProperty("email.encoding", "UTF-8"))
                .build();

    }
    /**
     * La classe Builder pour construire une instance d'EmailSettings.
     */
    public static class Builder {
        private String host;
        private Integer port;
        private boolean auth;
        private boolean starttls;
        private String emailSender;
        private String username;
        private String password;
        private String contentType;
        private String encoding;
        /**
         * Constructeur Builder.
         */
        public Builder() {

        }

        public Builder setAuth(boolean auth) {
            this.auth = auth;
            return this;
        }

        public Builder setEmailSender(String emailSender) {
            this.emailSender = emailSender;
            return this;
        }

        public Builder setEncoding(String encoding) {
            this.encoding = encoding;
            return this;
        }

        public Builder setContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPort(Integer port) {
            this.port = port;
            return this;
        }

        public Builder setStarttls(boolean starttls) {
            this.starttls = starttls;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
        /**
         * Construit une instance d'EmailSettings avec les paramètres fixés.
         * @return instance de EmailSettings
         */
        public EmailSettings build() {
            return new EmailSettings(this);
        }
    }
}
