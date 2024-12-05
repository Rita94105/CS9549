## **S4: Account Balance Service**

### **1. Overview**

The S4 service manages user account balances, including creating, retrieving, updating, and deleting balances.

------

### **2. How to Run Locally**

1. **Prerequisites**:

   - Ensure you have **Java 17**, **Maven**, and **MongoDB** installed.
   - MongoDB must be running locally or accessible remotely.

2. **Configure `application.properties`**: Update the `application.properties` file to connect to your local MongoDB and Eureka server:

   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/exchangefx
   eureka.client.service-url.defaultZone=http://<eureka-server-url>/eureka/
   server.port=8084
   ```

3. **Run the Application**: Execute the following command in the project root directory:

   ```bash
   mvn spring-boot:run
   ```

------

### **3. How to Package as a Docker Image**

1. **Build the Application**: Clean and package the project into a JAR file:

   ```bash
   mvn clean package
   ```

2. **Create a Docker Image**: Use Docker to build the image (for x86 architecture):

   ```bash
   docker buildx build --platform linux/amd64 -t service4-account-balance:latest .
   ```

3. **Run the Docker Image Locally**:

   ```bash
   docker run -p 8084:8084 service4-account-balance:latest
   ```

------

## **Common Notes**

1. **Eureka Server**: Ensure the Eureka Server is running and accessible. For Code Engine deployments, use the internal Eureka URL in the `application.properties` file:

   ```properties
   eureka.client.service-url.defaultZone=http://<eureka-server-internal-url>/eureka/
   ```

2. **MongoDB**: Update the `spring.data.mongodb.uri` property to match your MongoDB connection string.

3. **Code Engine Deployment**: After pushing the images to IBM Cloud Container Registry, deploy the services to Code Engine using the following command:

   ```bash
   ibmcloud ce application create --name <application-name> \
       --image us.icr.io/<namespace>/<image-name>:latest \
       --cpu 0.25 --memory 512Mi --port <port>
   ```

------

