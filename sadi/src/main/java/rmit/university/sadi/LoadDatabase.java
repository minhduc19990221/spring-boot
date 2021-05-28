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
    CommandLineRunner initDatabase(StaffRepository staffRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository, CustomerRepository customerRepository, ProviderRepository providerRepository, SalesInvoiceRepository salesInvoiceRepository) {

        return args -> {
            staffRepository.save(new Staff("Bilbo", "Baggins", "burglar","0933","test1@gmail.com","RMIT"));
            staffRepository.save(new Staff("Frodo", "Baggins", "thief","0909","test2@gmail.com","RMIT"));
            staffRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            customerRepository.save(new Customer("Minh Duc","702 Nguyen Van Linh","09090909","09090fax","test@gmail.com","Duc Minh"));

            salesInvoiceRepository.save(new SalesInvoice( "7/2/2021", staffRepository.getOne(9L), customerRepository.getOne(7L), productRepository.getOne(43L), 500,80.0,90.0 ));


            categoryRepository.save(new Category("Phone"));
            categoryRepository.save(new Category("PC"));
            categoryRepository.findAll().forEach(category -> log.info("Preloaded" + category));

//            productRepository.save(new Product("iphone11 pro max", "version12", "iphone", "Apple", "gold color 164GB","abc", categoryRepository.getOne(1L),1000 ));
//            productRepository.findAll().forEach(product -> {
//                log.info("Preloaded " + product);
//            });
            OrderDetails orderDetails = new OrderDetails(productRepository.getOne(43L),500,60000 );

            orderRepository.save(new Order(staffRepository.getOne(9L), providerRepository.getOne(8L), orderDetails, "aloha", Status.IN_PROGRESS  ));
//            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });



            customerRepository.save(new Customer("Bob","RMIT Customer 1","7021","7021fax","bob@rmit.edu.vn","Bobby"));
            customerRepository.findAll().forEach(customer -> log.info("Preloaded" + customer));

            providerRepository.save(new Provider("James","RMIT Provider 1","7022","7022fax","james@rmit.edu.vn","Jamey"));
            providerRepository.findAll().forEach(provider -> log.info("Preloaded" + provider));

        };
    }
}