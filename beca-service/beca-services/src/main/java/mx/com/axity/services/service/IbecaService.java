package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;

public interface IbecaService {


    int sum(int sum1, int sum2);
    int substraction(int rest1, int rest2);
    int div(int div1);
    int mult(int mult1);

    List<UserDO> getAllUsers();
    void deleteUser(Long id);
    void saveUser(UserDO userDO);
    UserDO findUserById(Long id);
}
