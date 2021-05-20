package rmit.university.sadi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rmit.university.sadi.entity.*;
import rmit.university.sadi.repository.*;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, CustomerRepository customerRepository, ProviderRepository providerRepository) {

        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar","0933","test1@gmail.com","RMIT"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief","0909","test2@gmail.com","RMIT"));
            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

            categoryRepository.save(new Category("Phone"));
            categoryRepository.save(new Category("PC"));
            categoryRepository.findAll().forEach(category -> log.info("Preloaded" + category));

            customerRepository.save(new Customer("Bob","RMIT Customer 1","7021","7021fax","bob@rmit.edu.vn","Bobby"));
            customerRepository.findAll().forEach(customer -> log.info("Preloaded" + customer));

            providerRepository.save(new Provider("James","RMIT Provider 1","7022","7022fax","james@rmit.edu.vn","Jamey"));
            providerRepository.findAll().forEach(provider -> log.info("Preloaded" + provider));

        };
    }
}