import java.lang.reflect.Proxy;

import com.frank.invocationHandler.LogInvocatoinHandler;
import com.frank.mapper.Car;
import com.frank.service.CarImpl;

public class Test {

    public static void main(String[] args) {
       
    	Car car = new CarImpl();
    	Car carProxy = (Car)Proxy.newProxyInstance(car.getClass().getClassLoader(),
    			car.getClass().getInterfaces(), new LogInvocatoinHandler(car));
    	carProxy.move(10000L);
    	
    	
    }

}
