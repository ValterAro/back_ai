# AI Directory for Estonians

This project is an **AI Directory website** specifically designed for Estonians to explore, review, and share insights on various AI tools. It aims to foster a community where users can discover new AI tools, provide feedback, share user stories, and contribute to the overall knowledge about AI technology available for Estonian users.

## Features

- **AI Tool Listings**: View a directory of AI tools with details like name, description, company, and link.
- **User Reviews and Ratings**: Users can add reviews, rate tools, and share their experiences.
- **Community Feedback**: Comments and feedback on each AI tool, helping others make informed decisions.
- **User Profiles**: Manage user accounts with roles and points.
- **Admin Management**: Admin users can manage listings and moderate content.

## Technology Stack

### Backend

- **Java 17**: The main programming language used for the backend.
- **Spring Boot**: Provides an efficient and robust framework for creating RESTful APIs and managing dependencies.
- **Gradle (Groovy)**: Used as the build tool for dependency management and project configuration.
- **PostgreSQL**: The database for storing AI tool data, user accounts, reviews, and other records.
- **JPA & Hibernate**: Java Persistence API and ORM tool to interact with the PostgreSQL database.
- **Lombok**: Reduces boilerplate code by providing annotations for getters, setters, constructors, etc.
- **Swagger (OpenAPI)**: Integrated to document and test APIs, making it easier for developers to understand and interact with the API.
- **java-dotenv**: Loads environment variables from a `.env` file to manage sensitive information like database credentials securely.

### Frontend

- **HTML, CSS, JavaScript, Vue.js**: The frontend is built with Vue.js for interactivity and uses HTML/CSS for structuring and styling the pages. Currently it is just bare bones over there. (https://github.com/ValterAro/front_ai)

## Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/ValterAro/back_ai.git
   ```
   
2. **Create a .env file in the root directory with the following environment variables:**
   ```
   DB_HOST=localhost
   DB_PORT=5432
   DB_NAME=your_database_name
   DB_USER=your_database_user
   DB_PASSWORD=your_database_password
   ```
3. **Build and run the backend:**
   ```bash
   ./gradlew bootrun
   ```
4. **Access the API documentation:**
   
   Once the backend is running, access Swagger UI for API documentation at http://localhost:8080/swagger-ui/index.html.

## Contributing
Feel free to open issues or submit pull requests to contribute to the project. Whether it's a new feature, bug fix, or documentation improvement, your contribution is welcome!

## License
This project is licensed under the MIT License.
