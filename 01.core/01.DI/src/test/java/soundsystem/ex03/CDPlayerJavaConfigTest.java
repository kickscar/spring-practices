package soundsystem.ex03;

import soundsystem.CDPlayerConfig;
import com.github.blindpirate.extensions.CaptureSystemOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.containsString;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CDPlayerConfig.class})
public class CDPlayerJavaConfigTest {
    @Autowired
    private CDPlayer01 cdPlayer01;

    @Autowired
    private CDPlayer02 cdPlayer02;

    @Autowired
    private CDPlayer03 cdPlayer03;

    @Autowired
    private CDPlayer04 cdPlayer04;

    @Test
    @CaptureSystemOutput
    public void testCDPlayer01(CaptureSystemOutput.OutputCapture outputCapture) {
        cdPlayer01.play();
        outputCapture.expect(containsString("Playing She by Green Day"));
    }

    @Test
    @CaptureSystemOutput
    public void testCDPlayer02(CaptureSystemOutput.OutputCapture outputCapture) {
        cdPlayer02.play();
        outputCapture.expect(containsString("Playing She by Green Day"));
    }

    @Test
    @CaptureSystemOutput
    public void testCDPlayer03(CaptureSystemOutput.OutputCapture outputCapture) {
        cdPlayer03.play();
        outputCapture.expect(containsString("Playing She by Green Day"));
    }

    @Test
    @CaptureSystemOutput
    public void testCDPlayer04(CaptureSystemOutput.OutputCapture outputCapture) {
        cdPlayer04.play();
        outputCapture.expect(containsString("Playing She by Green Day"));
    }

}