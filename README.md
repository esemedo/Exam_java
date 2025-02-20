# Exam_java

## API Quotes
- Permet de récupérer des citations motivantes 

### Configuration et installation
Créer un fichier **application.properties** dans le package resources à partir du **application.example.properties**


Modifier ces 3 champs avec vos identifiants de base de données et le nom de votre base de donnée
```YAML
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/nom_db
spring.datasource.username=username
spring.datasource.password=password
```

Les fichiers de base de données se trouvent dans le package resources. 
Dans schema.sql, il y a le script de création de table.
Dans data.sql, il y a le script d'insertion de données.

La base de données se crée automatiquement lors du lancement de l'api.
### Authentification
Renseigner une clé d'api qui permettra d'authentifier les utilisateurs authorisés.
Lors des requêtes vers l'api, il faudra envoyer cette clé via l'en-tête X-API-KEY. 
```YAML
api.key=api-key
```


### Lancement du projet

Lancer le fichier qui est le point d'entrée de l'application.
L'API est accessible à l'url (http://localhost:8081/api/)

### Endpoints
Il y a 2 routes protégées:
- Récupérer une citation aléatoire : http://localhost:8081/api/getQuote 

Réponse : 
```
{
    id: "int",
    quotes: "string"
}
```
- Récupérer toutes les citations : http://localhost:8081/api/getAllQuotes

Réponse :
```
[
    {
        id: "int",
        quotes: "string"
    }
]
```
Réponse en cas d'erreur : 
```
{
    "timestamp": "string",
    "message": "string",
    "status": "int"
}
```


## Application Complaining chat
- Application de chat qui écoute tous les malheurs et donne des conseils aux utilisateurs. 

### Configuration et installation
Créer un fichier **application.properties** dans le package resources à partir du **application.example.properties**


Modifier ces 4 champs avec vos identifiants de base de données, le nom de votre base de donnée et l'url de l'API quotes
```YAML
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/nom_db
spring.datasource.username=username
spring.datasource.password=password
api.quote.url=url-api-quote
```

Les fichiers de base de données se trouvent dans le package resources. 
Il y a des données de base avec un utilisateur et quelques messages par défaut.
Dans schema.sql, il y a le script de création de table.
Dans data.sql, il y a le script d'insertion de données.

La base de données se crée automatiquement lors du lancement de l'api.

### Authentification
Renseigner la clé d'api qui permet de s'authentifier auprès de l'api quotes.
Lors des requêtes vers l'api, il faudra envoyer cette clé via l'en-tête **X-API-KEY**. 
```YAML
api.key=api-key
```

### Lancement du projet

Lancer le fichier qui est le point d'entrée de l'application.
L'application est accessible à l'url (http://localhost:8000/)
