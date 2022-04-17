package soundsystem.ex01;

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
    private CDPlayer cdPlayer;

    @Test
    @CaptureSystemOutput
    public void testPlay(CaptureSystemOutput.OutputCapture outputCapture) {
        cdPlayer.play();
        outputCapture.expect(containsString("Playing She by Green Day"));
    }
}