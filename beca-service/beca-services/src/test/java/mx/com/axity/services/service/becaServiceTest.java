package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class becaServiceTest extends BaseTest {


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
    }
}
