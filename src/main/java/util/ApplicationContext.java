package util;

import config.EntityManagerProvider;
import entity.users.User;
import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final EntityManager em;

    private static final UserRepository<User> userRepository;
    private static final UserService<User> userService;

    private static final AdminRepository adminRepository;
    private static final AdminService adminService;

    private static final CustomerRepository customerRepository;
    private static final CustomerService customerService;

    private static final ExpertRepository expertRepository;
    private static final ExpertService expertService;

    private static final ServiceCollectionRepository serviceCollectionRepository;
    private static final ServiceCollectionService serviceCollectionService;

    private static final SubServiceCollectionRepository subServiceCollectionRepository;
    private static final SubServiceCollectionService subServiceCollectionService;

    private static final OrderRepository orderRepository;
    private static final OrderService orderService;





    static {
        em = EntityManagerProvider.getEntityManager();
        userRepository = new UserRepositoryImpl<>(em) {
            @Override
            public Class<User> getEntityClass() {
                return User.class;
            }
        };
        userService = new UserServiceImpl<>(userRepository);
        adminRepository= new AdminRepositoryImpl(em);
        adminService=new AdminServiceImpl(adminRepository);
        customerRepository= new CustomerRepositoryImpl(em);
        customerService=new CustomerServiceImpl(customerRepository);
        expertRepository= new ExpertRepositoryImpl(em);
        expertService= new ExpertServiceImpl(expertRepository);
        serviceCollectionRepository=new ServiceCollectionRepositoryImpl(em);
        serviceCollectionService= new ServiceCollectionServiceImpl(serviceCollectionRepository);
        subServiceCollectionRepository= new SubServiceCollectionRepositoryImpl(em);
        subServiceCollectionService= new SubServiceCollectionServiceImpl(subServiceCollectionRepository);
        orderRepository = new OrderRepositoryImpl(em);
        orderService = new OrderServiceImpl(orderRepository)


    }

    public static UserService<User> getUserService(){
        return userService;
    }

    public static AdminService getAdminService(){
        return adminService;
    }

    public static CustomerService getCustomerService(){
        return customerService;
    }
    public static ExpertService getExpertService(){
        return expertService;
    }
    public static ServiceCollectionService getServiceCollectionService(){
        return serviceCollectionService;
    }
    public static SubServiceCollectionService getSubServiceCollectionService(){
        return subServiceCollectionService;
    }
    public static OrderService getOrderService(){
        return orderService;
    }

}
