package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(User.builder().email("user1@mail.ru").firstName("User1").lastName("Lastname1")
                .car(Car.builder().model("Ford").series(324).build()).build());
        userService.add(User.builder().email("user2@mail.ru").firstName("User2").lastName("Lastname2")
                .car(Car.builder().model("Toyota").series(254).build()).build());
        userService.add(User.builder().email("user3@mail.ru").firstName("User3").lastName("Lastname3")
                .car(Car.builder().model("Daewoo").series(945).build()).build());
        userService.add(User.builder().email("user4@mail.ru").firstName("User4").lastName("Lastname4")
                .car(Car.builder().model("Honda").series(823).build()).build());
        
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        System.out.println(userService.getUserCar("Ford", 324));
        System.out.println(userService.getUserCar("Toyota", 254));
        System.out.println(userService.getUserCar("Daewoo", 945));
        System.out.println(userService.getUserCar("Honda", 823));
        context.close();
    }
}
