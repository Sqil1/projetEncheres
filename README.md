# projetEncheres
## exigences et configuration
### context.xml: à créer en local/deploiement
- créez: **/webapps/META-INF/context.xml** -> utilisez le template **/utils/context.xml.templates** pour remplir les bonnes infos. (Supprimez les {})
    - À changer : user; mdp; ip_sqlserver (logiquement 127.0.0.1); port (logiquement 1433).
    ```xml
            url = "jdbc:sqlserver://{IP_HOST_SQLSERVER}:{PORT};databaseName=ENCHERES;encrypt=false;"
            username = "{USER}"
            password = "{PASSWORD}"
    ```
### Driver JDBC: À implémenter en local/deploiement
- Chacun devra gérer le driver JDBC en relation avec ses MSSQL/Java versions de son côté.
    - Il faut ajouter le bon driver.jar dans le path Java
    - Pour Gradle/Maven : **com.microsoft.sqlserver 12.4.1.jre11** (ici pour Java 11, mais le projet est sensé supporter 8+)
### SQL d'initialisation de DB
- /utils/initDB.sql -> Pour initialiser la DB
