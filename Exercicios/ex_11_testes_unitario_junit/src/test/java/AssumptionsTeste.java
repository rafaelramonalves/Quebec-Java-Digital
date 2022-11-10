import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class AssumptionsTeste {

    @Test
    void validarAlgoSomenteNoUsusarioRafael(){
        //Ao invez de Assertions usa-se Assumptions
        Assumptions.assumeTrue("Rafael".equals(System.getenv("USER")));
        Assertions.assertEquals(10,5+5);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "RAFAEL")
    void validarAlgoSomenteNoUsusarioRafael2(){
        Assertions.assertEquals(10,5+5);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "USER", matches = "RAFAEL")
    void validarAlgoSomenteNoUsusarioRafael3(){
        Assertions.assertEquals(10,5+5);
    }

    //Teste em determinado SO
    @Test
    @EnabledOnOs(OS.LINUX)
    void validarAlgoSomenteNoUsusarioRafael4(){
        Assertions.assertEquals(10,5+5);

    }

    //Teste em determinado ranger de JRE
    @Test
    @EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_17)
    void validarAlgoSomenteNoUsusarioRafael5(){
        Assertions.assertEquals(10,5+5);

    }
}
