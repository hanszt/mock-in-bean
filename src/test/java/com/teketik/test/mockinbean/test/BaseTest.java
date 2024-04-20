package com.teketik.test.mockinbean.test;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;

@TestExecutionListeners(
        value = { AssertingCleanTestExecutionListener.class },
        mergeMode = MergeMode.MERGE_WITH_DEFAULTS
)
@SpringTest
abstract class BaseTest {
}
