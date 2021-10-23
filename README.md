# productManagement

This is an API that exposes endpoints for stock management example. Bellow are the endpoints and its description:

1. http://localhost:8080/api/v1/products - Endpoint that lists all the products
2. http://localhost:8080/api/v1/suppliers - Endpoint that lists all the suppliers
3. http://localhost:8080/api/v1/products/1 - Endpoint that list the product with ID 1, for example
4. http://localhost:8080/api/v1/products - Endpoint that save a product, given the body content bellow:

{
        "name": "Ananas",
        "quantityInStock": 250.00,
        "unitPrice": 2.00,
        "supplierId": 1,
        "creationDate": "2021-10-21T00:00:00.000Z"
}

5. http://localhost:8080/api/v1/products - Endpoint that updates a product, given the body content bellow:

{
        "id":1,
        "name": "Tomate",
        "quantityInStock": 250.00,
        "unitPrice": 10.00,
        "supplierId": 1,
        "creationDate": "2021-10-21T00:00:00.000Z"
}

6. http://localhost:8080/api/v1/products/3 - Endpoint that removes the product with ID 3, for example
7. http://localhost:8080/api/v1/products/1 - Endpoint that updates the product with ID 1, for example, for specific field, given the body content bellow:

{
    "quantityInStock":200.00,
    "isAdd":false
}

Database Scripts

There is a schema.sql file in the project which is also used in src/test/resources folder for Unit Tests. Please create a database with the name "stockManagement",
you can find it in the application.properties file in src/main/resources folder and update the database user and password according to your MySQL DB Credentials.

How to run the project

After forking, downloading or cloning the project from Git, follow the instructions bellow:

1. Enter in the root path of the project
2. Run "mvn clean install", in order to let maven install the necessary dependencies. Before, make sure you have maven installed
3. Run "mvnw spring-boot:run", in order to let maven run the project for you
4. There is a file with all the Postman Collection, called "STOCK_MANAGEMENT-API.postman_collection" in the root path of the project,
5. please open or import it to Postman, each endpoint has a description
