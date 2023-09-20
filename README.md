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
    - Pour Eclipse regardez la vidéo citez plus haut, il faut ajouter le bon driver.jar comme vous avez déjà fais avant. (Demandez un coup de main si vous galérez.)
    - Pour Arthur ou ceux qui veulent utiliser Gradle/Maven si tu es toujours sur Java 11 tu as besoin de **com.microsoft.sqlserver 12.4.1.jre11**
### SQL d'initialisation de DB
- /utils/initDB.sql -> Pour initialiser la DB
