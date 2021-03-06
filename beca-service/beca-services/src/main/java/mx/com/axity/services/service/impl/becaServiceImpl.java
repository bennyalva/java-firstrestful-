package mx.com.axity.services.service.impl;

import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.LoginDAO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    UserDAO userDAO;// para cceder a los metodos de save delete o find del CrudRepositorio
    @Autowired
    LoginDAO loginDAO;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public int sum(int sum1, int sum2) {
        return sum1 + sum2;
    }

    @Override
    public int substraction(int rest1, int rest2) {
        return rest1 - rest2;
    }

    @Override
    public int div(int div1) {
        return div1 / 4;
    }

    @Override
    public int mult(int mult1) {
        return mult1 * 4;
    }

    @Override
    public List<UserDO> getAllUsers() {
        return (List<UserDO>) this.userDAO.findAll();

    }

    @Override
    public void deleteUser(Long id) {
        this.userDAO.deleteById(id);
    }

    @Override
    public void saveUser(UserDO userDO) {
        this.userDAO.save(userDO);
    }

    @Override
    public UserDO findUserById(Long id) {
        return  this.userDAO.findById(id).get();
    }

    @Override
    public void updateUser(UserDO userDO) {
       // this.userDAO.findById(userDO.getId()).get();
        this.userDAO.save(userDO);
    }

    @Override
    public List<LoginDO> getAllLogin() {
        return (List<LoginDO>) this.loginDAO.findAll();
    }

    @Override
    public void deleteLogin(Long id) {
        this.loginDAO.deleteById(id);
    }

    @Override
    public void saveLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

    @Override
    public LoginDO findLoginById(Long id) {
        return this.loginDAO.findById(id).get();
    }

    @Override
    public void updateLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

    /*@Override
    public LoginDO validateUser(String userName) {
        return this.loginDAO.validateUsername(userName);
    }*/


}
