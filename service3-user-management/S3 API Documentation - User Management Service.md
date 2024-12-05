### S3 API Documentation - User Management Service

#### **Base URL**

- Public Address: `https://service03.1p0sj4mn37zu.ca-tor.codeengine.appdomain.cloud/`

------

### **API Endpoints**

#### **1. Create a User**

- **Method**: `POST`
- **Path**: `/api/users`
- **Description**: Creates a new user.

##### **Request**

- **Content-Type**: `application/json`

- Request Body

  :

  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```

##### **Response**

- **Status Code**: `201 Created`

- Response Body

  :

  ```json
  {
    "id": "string",
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```

------

#### **2. Retrieve All Users**

- **Method**: `GET`
- **Path**: `/api/users`
- **Description**: Retrieves a list of all users.

##### **Request**

- No request body.

##### **Response**

- **Status Code**: `200 OK`

- Response Body

  :

  ```json
  [
    {
      "id": "string",
      "username": "string",
      "email": "string",
      "password": "string"
    }
  ]
  ```

------

#### **3. Retrieve User by ID**

- **Method**: `GET`
- **Path**: `/api/users/{id}`
- **Description**: Retrieves a user's details by their ID.

##### **Request**

- Path Parameter

  :

  - `id` (required): The unique identifier of the user.

##### **Response**

- **Status Code**: `200 OK`

- **Response Body**:

  ```json
  {
    "id": "string",
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```

- **Status Code**: `404 Not Found`

- **Response Body**:

  ```json
  {
    "error": "User not found"
  }
  ```

------

#### **4. Login**

- **Method**: `POST`
- **Path**: `/api/users/login`
- **Description**: Verifies user login credentials.

##### **Request**

- **Content-Type**: `application/json`

- Request Body

  :

  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```

##### **Response**

- **Status Code**: `200 OK`

- **Response Body**:

  ```json
  {
    "login": true
  }
  ```

- **Status Code**: `401 Unauthorized`

- **Response Body**:

  ```json
  {
    "login": false
  }
  ```

------

#### **5. Update User Information**

- **Method**: `PUT`
- **Path**: `/api/users/{id}`
- **Description**: Updates the specified user's information.

##### **Request**

- Path Parameter

  :

  - `id` (required): The unique identifier of the user.

- **Content-Type**: `application/json`

- Request Body

  :

  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```

##### **Response**

- **Status Code**: `200 OK`

- **Response Body**:

  ```json
  {
    "id": "string",
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```

- **Status Code**: `404 Not Found`

- **Response Body**:

  ```json
  {
    "error": "User not found"
  }
  ```

------

#### **6. Delete User**

- **Method**: `DELETE`
- **Path**: `/api/users/{id}`
- **Description**: Deletes the specified user.

##### **Request**

- Path Parameter

  :

  - `id` (required): The unique identifier of the user.

##### **Response**

- **Status Code**: `204 No Content`

- **Status Code**: `404 Not Found`

- **Response Body**:

  ```json
  {
    "error": "User not found"
  }
  ```

------

### **Error Response Format**

When an error occurs, the API returns a JSON response with the following structure:

```json
{
  "timestamp": "string",
  "status": "integer",
  "error": "string",
  "message": "string",
  "path": "string"
}
```

- Example

  :

  ```json
  {
    "timestamp": "2024-12-04T12:00:00.000+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "User not found",
    "path": "/api/users/123"
  }
  ```

------

