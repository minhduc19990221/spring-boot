package rmit.university.sadi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rmit.university.sadi.model.Employee;
import rmit.university.sadi.model.Order;
import rmit.university.sadi.repository.EmployeeRepository;
import rmit.university.sadi.repository.OrderRepository;
import rmit.university.sadi.repository.Status;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar","0933","test1@gmail.com","RMIT"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief","0909","test2@gmail.com","RMIT"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }
}