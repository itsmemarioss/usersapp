## Overview

Sample app to save users.

```bash
./mvnw clean package -DskipTests
```

## HTTP Requests

Add a new user
```
curl --location --request POST 'http://localhost:8080/save' \
--header 'Content-Type: application/json' \
--data-raw '{
"user": "user",
"password": "password"
}'
```

User login
```
curl --location --request GET 'http://localhost:8080/login' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "user",
"password": "adsadasda"
}'

```