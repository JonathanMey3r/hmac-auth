package de.otto.hmac.proxy;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static de.otto.hmac.proxy.CLIParameterToConfigurationReader.toConfiguration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Test
public class CLIParameterToConfigurationReaderTest {

    @BeforeMethod
    public void beforeEveryTest() {
        ProxyConfiguration.setUser(null);
        ProxyConfiguration.setPort(-1);
        ProxyConfiguration.setPassword(null);
        ProxyConfiguration.setTargetHost(null);
    }


    @Test
    public void shouldSetTargetHostWithLongParameter() {
        toConfiguration(new String[]{"--host", "develop-ci.lhotse.ov.otto.de"});
        assertThat(ProxyConfiguration.getTargetHost(), is("develop-ci.lhotse.ov.otto.de"));
    }

    @Test
    public void shouldSetTargetHostWithShortParameter() {
        toConfiguration(new String[]{"-h", "develop-ci.lhotse.ov.otto.de"});
        assertThat(ProxyConfiguration.getTargetHost(), is("develop-ci.lhotse.ov.otto.de"));
    }

    @Test
    public void shouldSetTargetPortWithLongParameter() {
        toConfiguration(new String[]{"--targetPort", "201839"});
        assertThat(ProxyConfiguration.getPort(), is(201839));
    }

    @Test
    public void shouldSetTargetPortWithShortParameter() {
        toConfiguration(new String[]{"-tp", "-23174891"});
        assertThat(ProxyConfiguration.getPort(), is(-23174891));
    }

}
