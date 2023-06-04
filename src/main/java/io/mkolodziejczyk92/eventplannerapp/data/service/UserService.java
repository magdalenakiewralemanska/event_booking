package io.mkolodziejczyk92.eventplannerapp.data.service;


import io.mkolodziejczyk92.eventplannerapp.data.repository.UserRepository;
import io.mkolodziejczyk92.eventplannerapp.data.validation.UsernameAndEmailValidator;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;
    private final UsernameAndEmailValidator validator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository repository, UsernameAndEmailValidator validator, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.validator = validator;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    @Override
//    public Customer registerNewCustomer(UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
//        validator.checkThatNewUsernameAndEmailNotRepeat(StringUtils.EMPTY, userDto.getUsername(), userDto.getPassword());
//        Customer customer = new Customer(userDto, bCryptPasswordEncoder.encode(userDto.getPassword()), getRolesForCustomer());
//        return repository.save(customer);
//    }


//    @Override
//    public List<ERole> getRolesForCustomer() {
//        return List.of(ERole.CUSTOMER);
//    }


}
