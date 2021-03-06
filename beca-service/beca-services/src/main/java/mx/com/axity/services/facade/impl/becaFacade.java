package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired
    private IbecaService becaService;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public int operation(int a, int b) {
       int c = this.becaService.sum(a,b);
       b = this.becaService.substraction(c,a);
       int d = this.becaService.mult(b);
       return  this.becaService.div(d);
    }

    @Override
    public List<UserTO> getAllUsers() {
        List<UserDO> userDOList= this.becaService.getAllUsers();
        Type userTOType = new TypeToken<List<UserTO>>() {}.getType();
        List<UserTO> result = this.modelMapper.map(userDOList, userTOType);
        return result;
    }

    @Override
    public void deleteUser(Long id) {
        this.becaService.deleteUser(id);
    }

    @Override
    public void saveUser(UserTO userTO) {
        UserDO userDO = this.modelMapper.map(userTO,UserDO.class);
        this.becaService.saveUser(userDO);
    }

    @Override
    public UserTO findUserById(Long id) {
        UserDO userDO = this.becaService.findUserById(id);
        UserTO userTO = this.modelMapper.map(userDO, UserTO.class);
        return userTO;
    }

    @Override
    public void updateUser(UserTO userTO) {
        UserDO userDO = this.modelMapper.map(userTO,UserDO.class);
        this.becaService.updateUser(userDO);
    }

    @Override
    public List<LoginTO> getAllLogin() {
        List<LoginDO> loginDOList= this.becaService.getAllLogin();
        Type loginTOType = new TypeToken<List<LoginTO>>() {}.getType();
        List<LoginTO> result = this.modelMapper.map(loginDOList, loginTOType);
        return result;
    }

    @Override
    public void deleteLogin(Long id) {
        this.becaService.deleteLogin(id);
    }

    @Override
    public void saveLogin(LoginTO loginTO) {
        LoginDO loginDO = this.modelMapper.map(loginTO,LoginDO.class);
        this.becaService.saveLogin(loginDO);
    }

    @Override
    public LoginTO findLoginById(Long id) {
        LoginDO loginDO = this.becaService.findLoginById(id);
        LoginTO loginTO = this.modelMapper.map(loginDO, LoginTO.class);
        return loginTO;
    }

    @Override
    public void updateLogin(LoginTO loginTO) {
        LoginDO loginDO = this.modelMapper.map(loginTO,LoginDO.class);
        this.becaService.updateLogin(loginDO);
    }

   /* @Override
    public LoginTO validateUser(String userName) {
        LoginDO loginDO = this.becaService.validateUser(userName);
        return null;
    }*/


}
