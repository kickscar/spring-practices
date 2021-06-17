package soundsystem.ex04;

import com.github.blindpirate.extensions.CaptureSystemOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.containsString;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:soundsystem/CDPlayerConfig.xml"})
public class CD3ChangerXmlConfigTest {
    @Autowired
    private CD3Changer cd3Changer;

    @Test
    @CaptureSystemOutput
    public void testPlay1(CaptureSystemOutput.OutputCapture outputCapture) {
        cd3Changer.play(1);
        outputCapture.expect(containsString("Playing She by Green Day"));
    }

    @Test
    @CaptureSystemOutput
    public void testPlay2(CaptureSystemOutput.OutputCapture outputCapture) {
        cd3Changer.play(2);
        outputCapture.expect(containsString("Playing Jaded by Green Day"));
    }

    @Test
    @CaptureSystemOutput
    public void testPlay3(CaptureSystemOutput.OutputCapture outputCapture) {
        cd3Changer.play(3);
        outputCapture.expect(containsString("Playing Jinx by Green Day"));
    }
}