### S4 API Documentation - Account Balance Service

#### **Base URL**

- Public Address (Code Engine): `https://service4-account-balance.<project-name>.<region>.codeengine.appdomain.cloud/`

------

### **API Endpoints**

#### **1. Create or Update Account Balance**

- **Method**: `PUT`
- **Path**: `/api/account-balances/{id}`
- **Description**: Creates or updates the account balance for a specific user.

##### **Request**

- Path Parameter

  :

  - `id` (required): The unique identifier of the user.

- **Content-Type**: `application/json`

- Request Body

  :

  ```json
  {
    "userId": "string",
    "currency": "string",
    "balance": "number"
  }
  ```

##### **Response**

- **Status Code**: `200 OK`

- **Response Body**:

  ```json
  {
    "id": "string",
    "userId": "string",
    "currency": "string",
    "balance": "number"
  }
  ```

- **Status Code**: `404 Not Found`

- **Response Body**:

  ```json
  {
    "error": "Account not found"
  }
  ```

------

#### **2. Get Account Balances by User ID**

- **Method**: `GET`
- **Path**: `/api/account-balances/user/{userId}`
- **Description**: Retrieves all account balances for a specific user.

##### **Request**

- Path Parameter

  :

  - `userId` (required): The unique identifier of the user.

##### **Response**

- **Status Code**: `200 OK`

- **Response Body**:

  ```json
  [
    {
      "id": "string",
      "userId": "string",
      "currency": "string",
      "balance": "number"
    }
  ]
  ```

- **Status Code**: `404 Not Found`

- **Response Body**:

  ```json
  {
    "error": "No accounts found for user"
  }
  ```

------

#### **3. Delete Account Balance**

- **Method**: `DELETE`
- **Path**: `/api/account-balances/{id}`
- **Description**: Deletes the account balance for a specific user.

##### **Request**

- Path Parameter

  :

  - `id` (required): The unique identifier of the account balance.

##### **Response**

- **Status Code**: `204 No Content`

- **Status Code**: `404 Not Found`

- **Response Body**:

  ```json
  {
    "error": "Account not found"
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
    "message": "Account not found",
    "path": "/api/account-balances/123"
  }
  ```

