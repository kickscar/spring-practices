package scanwiring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    @Autowired
    private YourComponent yourComponent;

    public YourComponent getYourComponent(){
        return yourComponent;
    }
}
