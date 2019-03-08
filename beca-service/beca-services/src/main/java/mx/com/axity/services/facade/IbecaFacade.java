package mx.com.axity.services.facade;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;

public interface IbecaFacade {
    int operation( int a, int b);
    List<UserTO> getAllUsers();
    void deleteUser(Long id);
    void saveUser(UserTO userTO);
    UserTO findUserById(Long id);
    void updateUser(UserTO userTO);

    List<LoginTO> getAllLogin();
    void deleteLogin(Long id);
    void saveLogin(LoginTO loginTO);
    LoginTO findLoginById(Long id);
    void updateLogin(LoginTO loginTO);
    LoginTO validateUser(String userName);
}
