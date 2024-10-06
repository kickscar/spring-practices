package scanwiring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private final YourComponent yourComponent;

    public MyComponent(YourComponent yourComponent) {
        this.yourComponent = yourComponent;
    }

    public YourComponent getYourComponent(){
        return yourComponent;
    }
}
