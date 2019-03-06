package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.BaseTest;
import mx.com.axity.services.service.impl.becaServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class becaServiceTest extends BaseTest {
    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);
    @Autowired
    IbecaService ibecaService;

    @Test
    public void updateExisteRegistri(){
       //Exito -> registro exista y se actualiza

        UserDO userDO = this.ibecaService.findUserById((long) 2);
        Assert.assertTrue(userDO != null);
        Assert.assertTrue(new Long(2).equals(userDO.getId()));
        Assert.assertTrue("Bere".equals(userDO.getName()));
    }
    @Test
    public void updateNoExisteRegistrio(){
        UserDO userDO;
       try{
           userDO = this.ibecaService.findUserById((long) 77);
          Assert.assertTrue(userDO != null);//lo que se espera es que sea falso que sea diferente de nulo " que traiga algo"
       }catch (Throwable e){
           Assert.assertTrue(e instanceof NoSuchElementException);

       }
    }

/*
  //tambien quitar el comentarioel basetest
    @Test
    public void shouldReturnTheSumofTwoNumbers(){
        int num1 = 5;
        int num2 = 10;
        int resul = this.becaService.sum(num1,num2);
        Assert.assertEquals(15,resul);
    }

    @Test
    public void shouldReturnTheSubstractionfTwoNumbers(){
        int num1 = 15;
        int num2 = 10;
        int resul = this.becaService.substraction(num1,num2);
        Assert.assertEquals(5,resul);
    }
    @Test
    public void shouldReturnTheMultiplicationOfANumberXConstante(){
        int num1 = 10;
        int resul = this.becaService.mult(num1);
        Assert.assertEquals(40,resul);
    }

    @Test
    public void shouldReturnTheDiviOfANumberXConstante(){
        int num1 = 24;
        int resul = this.becaService.div(num1);
        Assert.assertEquals(6,resul);
    }*/
}
