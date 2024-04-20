package com.teketik.spring.test.mockito;

import org.mockito.MockSettings;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.MethodInvocationReport;
import org.mockito.mock.MockCreationSettings;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Copied from [org.springframework.boot.test.mock.mockito]
 * <p>
 * Reset strategy used on a mock bean. Usually applied to a mock via the
 * {@link [MockBean] @MockBean} annotation but can also be directly applied to any mock in
 * the {@code ApplicationContext} using the static methods.
 *
 * @author Phillip Webb
 * @see [ResetMocksTestExecutionListener]
 * @since 1.4.0
 */
public enum MockReset {

    /**
     * Reset the mock before the test method runs.
     */
    BEFORE,

    /**
     * Reset the mock after the test method runs.
     */
    AFTER,

    /**
     * Don't reset the mock.
     */
    NONE;

    /**
     * Create {@link MockSettings settings} to be used with mocks where a specific reset
     * should occur.
     *
     * @param reset the reset type
     * @return mock settings
     */
    public static MockSettings withSettings(MockReset reset) {
        return apply(reset, Mockito.withSettings());
    }

    /**
     * Apply {@link MockReset} to existing {@link MockSettings settings}.
     *
     * @param reset    the reset type
     * @param settings the settings
     * @return the configured settings
     */
    public static MockSettings apply(MockReset reset, MockSettings settings) {
        Assert.notNull(settings, "Settings must not be null");
        if (reset != null && reset != NONE) {
            settings.invocationListeners(new ResetInvocationListener(reset));
        }
        return settings;
    }

    /**
     * Dummy {@link InvocationListener} used to hold the {@link MockReset} value.
     */
    private record ResetInvocationListener(MockReset reset) implements InvocationListener {

        @Override
        public void reportInvocation(MethodInvocationReport methodInvocationReport) {
        }
    }
}