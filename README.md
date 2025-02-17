# Calculator Web Application (Spring Boot)

This is a simple yet fully functional **calculator web application** built using **Spring Boot**, **Thymeleaf**, and **CSS**. The app provides users with an interactive web interface to perform basic arithmetic calculations such as addition, subtraction, multiplication, division, and modulus. The project demonstrates strong proficiency in **Java**, **Spring Boot**, **web development**, and **software design principles**.

---

## **Features:**

- **🖥️ Simple User Interface:** Clean and easy-to-use design with buttons for numbers and operators.
- **➕ Basic Arithmetic Operations:** Supports addition, subtraction, multiplication, division, and modulus.
- **🔄 Stateful Calculation:** Keeps track of the calculation and displays the result in real time.
- **📤 Form Handling:** Users can input calculations using buttons, and results are processed on the backend.
- **⚠️ Error Handling:** Handles common errors like division by zero and invalid input gracefully.
- **📱 Responsive Design:** Mobile-friendly layout for a seamless user experience across devices.

---

## **Technologies Used:**

- **Java 17+** - Backend logic
- **Spring Boot** - Web framework for building the backend
- **Thymeleaf** - Templating engine for dynamic HTML rendering
- **CSS** - Styling for a modern and responsive UI
- **Spring MVC** - Request-response management
- **Model-View-Controller (MVC)** - Structured code architecture
- **Basic Input Validation** - Ensures proper input format before calculation

## **Screenshots:**
<div style="text-align: center;">
  <img src="https://github.com/user-attachments/assets/8b164d0a-926a-4595-bd02-ebde009819bd" width="200" alt="Calculator Screenshot">
</div>

## **Getting Started:**

To run this project locally, follow these steps:

### **Prerequisites:**

- **Java 17 or higher** installed
- **Maven** for managing dependencies and building the project
- **IDE** (e.g., IntelliJ IDEA, Eclipse, or VS Code with Java support)

### **Steps to Run the Application:**

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/calculator-web-app.git
    cd calculator-web-app
    ```

2. Build and run the application:
    ```bash
    mvn spring-boot:run
    ```

3. Open your browser and visit `http://localhost:8080` to start using the calculator.

---

## **Key Features in Action:**

- Clicking the buttons adds values to the input field.
- Pressing the `=` button processes the calculation and displays the result.
- Pressing the `C` button clears the input field for a fresh calculation.

---

## **Code Overview:**

### **Controller Layer:**

- The `CalculatorAppController` is responsible for handling HTTP requests and managing interactions between the frontend and the backend.
  
    - **GET `/`**: Displays the main calculator interface.
    - **GET `/clear`**: Clears the input field.
    - **POST `/gotNumbers`**: Processes the input and returns the calculated result.

### **Service Layer:**

- The `CalculatorService` contains the business logic for parsing the input, performing calculations, and returning the result.
  
    - **`parseNums()`**: Parses the user input and extracts the operands and operator.
    - **`doCalc()`**: Performs the appropriate arithmetic operation.
    - **`checkValidInput()`**: Ensures that the input is in the correct format.

### **Model Layer:**

- The `CalculatorModel` stores the state of the calculation (operands, operator, and result).

### **Frontend (Thymeleaf and CSS):**

- The **Thymeleaf templates** render the dynamic HTML, ensuring the UI stays in sync with the backend.
- The **CSS styles** make the calculator interface visually appealing and responsive.

---

## **Future Improvements:**

- **🔗 Database Integration:** Connect the application to an SQL database (e.g., MySQL or PostgreSQL) to store calculation history.
- **⚙️ Advanced Operations:** Add more complex functions like square roots, powers, and trigonometric calculations.
- **🧪 Unit Tests:** Write unit tests for critical parts of the application to improve test coverage.
- **🌐 Deployment:** Host the application on platforms like **AWS** or **Heroku** for easy access and sharing.
- **🔒 Security:** Implement user authentication to allow personalized experiences (e.g., saving calculation history).

---

## **Conclusion:**

This project demonstrates my abilities as a backend developer proficient in **Java** and **Spring Boot**, as well as my experience with **web development** and **software architecture**. The application follows the **Model-View-Controller (MVC)** pattern, ensuring the code is maintainable and scalable. The project also highlights my capacity for **input validation**, **error handling**, and building **interactive web applications**.

I’m excited to continue developing my skills and apply them in real-world projects.

---
