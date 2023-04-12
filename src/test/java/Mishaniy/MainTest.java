package Mishaniy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class MainTest {

    @Test
    public void outputTypeTest() throws IOException {
        Assertions.assertThat(Main.MainM("https://vk.com/lentach")).isInstanceOf(ArrayList.class);
    }

    @Test
    public void zeroPostsTest() throws IOException {
        Assertions.assertThat(Main.MainM("https://vk.com/mixafonin")).isEqualTo(null);
    }

    @Test
    public void invalidUserTest() throws IOException {
        Assertions.assertThat(Main.MainM("q5hthgq54hw3")).isEqualTo(null);
    }
}