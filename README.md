# User Service Microservice

This is the beta version of a project, please see its original code base in these two repositories

https://github.com/teuzowebdeveloper9/ms_user


## 📄 Description

This project is the first part of a microservices system. It is responsible for creating users and sending emails using the RabbitMQ messaging system. The database used is PostgreSQL.

## 🚀 Features

- ✅ User creation
- ✅ Sending messages to the RabbitMQ queue when a user is created
- ✅ Sending emails to created users

## 🛠️ Technologies Used

- Spring Boot
- Spring AMQP
- Spring Mail
- PostgreSQL
- RabbitMQ

## 📂 Project Structure

### 🧩 Dependencies

The main dependencies used in the project are:

- `spring-boot-starter-web`: To create REST endpoints
- `spring-boot-starter-amqp`: For integration with RabbitMQ
- `spring-boot-starter-mail`: For sending emails
- `spring-boot-starter-data-jpa`: For integration with the PostgreSQL database
- `lombok`: To reduce code verbosity

### ⚙️ Configuration

The RabbitMQ and email service configurations are defined in the `application.properties` file:

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=your-email@example.com
spring.mail.password=your-email-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

```
🧑‍💻 User Service
The UserService class is responsible for the logic of creating users and sending messages to the RabbitMQ queue:

java
Copiar
Editar
// UserService.java
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void createUser(User user) {
        // Logic to save user to database
        // ...

        // Send message to RabbitMQ
        rabbitTemplate.convertAndSend("userQueue", user);
    }
}
🌐 User Controller
The UserController exposes REST endpoints to create users:

java
Copiar
Editar
// UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
📧 Email Listener
The EmailListener listens to messages from the RabbitMQ queue and sends emails to created users:

java
Copiar
Editar
// EmailListener.java
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = "userQueue")
    public void handleUserCreated(User user) {
        // Send email to the user
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Welcome to our service");
        message.setText("Dear " + user.getName() + ",\n\nThank you for registering with us!");

        mailSender.send(message);
    }
}
👤 User Model
The User class represents the user model:

java
Copiar
Editar
// User.java
import lombok.Data;

@Data
public class User {
    private String name;
    private String email;
    // Other fields...
}
✅ Testing
The messaging system has been thoroughly tested and passed all 3 manual tests conducted.

🔮 Next Steps
This is the first part of a larger project. In the future, controllers will be added to manage user actions. Depending on the actions performed by the users, different messages will be sent using spring-boot-starter-mail and the RabbitMQ messaging system.

🤝 Contribution
Feel free to contribute to this project. To do so, fork the repository, create a branch for your changes, and submit a pull request.

▶️ Running Locally
Clone the repository:

bash
Copiar
Editar
git clone https://github.com/your-username/your-repo.git
cd your-repo
Configure application.properties with your RabbitMQ and email credentials.

Run PostgreSQL and RabbitMQ (you can use Docker).

Run the application:
