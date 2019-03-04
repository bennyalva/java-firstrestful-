package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.UserTO;
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

}
