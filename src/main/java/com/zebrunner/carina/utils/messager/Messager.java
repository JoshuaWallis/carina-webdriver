/*******************************************************************************
 * Copyright 2020-2022 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.utils.messager;


import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ReportMessage is used for reporting informational and error messages both
 * using logger and testsNG Reporter.
 * 
 * @author akhursevich
 */
public enum Messager implements IMessager {
	
    TEST_STARTED("TEST [%s] STARTED at [%s]"),

    TEST_PASSED("TEST [%s] PASSED at [%s]"),

    TEST_SKIPPED("TEST [%s] SKIPPED at [%s] - %s"),

    TEST_FAILED("TEST [%s] FAILED at [%s] - %s"),

    RETRY_FAILED("TEST [%s] RETRY %s of %s FAILED - %s"),

    CONFIG_STARTED("CONFIG [%s] START at [%s]"),

    CONFIG_PASSED("CONFIG [%s] PASS at [%s]"),

    CONFIG_SKIPPED("CONFIG [%s] SKIP at [%s] - %s"),

    CONFIG_FAILED("CONFIG [%s] FAIL at [%s] - %s"),

    TEST_RESULT("RESULT #%s: TEST [%s] %s [%s]"),

    GET_PAGE_SOURCE("INFO: getting page source"),
    
    FAIL_GET_PAGE_SOURCE("FAIL: getting page source"),
    
    ADD_COOKIE("INFO: adding cookie '%s'"),
    
    FAIL_ADD_COOKIE("FAIL: adding cookie '%s'"),
    
    OPENING_URL("INFO: opening url '%s'"),
    
    OPENED_URL("INFO: url '%s' is opened."),
    
    NOT_OPENED_URL("FAIL: url '%s' is not opened!"),
    
    FAIL_GET_TITLE("FAIL: page title can't be detected!"),

    VALIDATION_FAIL("FAIL: '%s' !"),

    INFORMATION("INFO: '%s'."),

    ERROR("ERROR: '%s'!"),

    PAUSE("INFO: pause for '%s' seconds."),

    BACK("INFO: navigate to previous page performed."),

    REFRESH("INFO: refresh page."),

    FAIL_REFRESH("FAIL: refresh page."),

    EXPECTED_URL("URL '%s' is correct."),

    UNEXPECTED_URL("FAIL: wrong URL, expected '%s' but actual '%s'!"),

    ELEMENT_PRESENT("Element '%s' presents."),

    ELEMENT_NOT_PRESENT("FAIL: element '%s' is not present!"),
    
    ELEMENT_CONDITION_NOT_VERIFIED("FAIL: %s - waitCondition for element '%s' not satisfied!"),

    ELEMENT_NOT_PRESENT_PASS("Element '%s' is not present"),

    ELEMENT_WITH_ATTRIBUTE_PRESENT("Element '%s' with attribute '%s' = '%s' presents."),

    ELEMENT_WITH_ATTRIBUTE_NOT_PRESENT("FAIL: element '%s' with attribute '%s' = '%s' is not present!"),

    ELEMENT_WITH_TEXT_PRESENT("Element '%s' with text '%s' presents."),

    ELEMENT_WITH_TEXT_NOT_PRESENT("FAIL: element '%s' with text: '%s' is not present!"),

    UNEXPECTED_ELEMENT_PRESENT("FAIL: unexpected element '%s' present!"),

    UNEXPECTED_ELEMENT_WITH_TEXT_PRESENT("FAIL: unexpected element '%s' with text '%s' present!"),

    ELEMENT_CLICKED("Element '%s' is clicked."),
    ELEMENT_ABOUT_TO_CLICK("Trying to click '%s'."),

    ELEMENT_NOT_CLICKED("FAIL: element '%s' is not clicked!"),

    ELEMENT_FOUND("Element '%s' is found."),

    ELEMENT_NOT_FOUND("FAIL: element '%s' is not found!"),
    
    ELEMENT_ATTRIBUTE_FOUND("Attribute/value '%s'/'%s' for element '%s' is found."),

    ELEMENT_ATTRIBUTE_NOT_FOUND("FAIL: attribute '%s' for element '%s' is not found!"),

    ELEMENT_DOUBLE_CLICKED("Element '%s' is double clicked."),

    ELEMENT_NOT_DOUBLE_CLICKED("FAIL: element '%s' is not double clicked!"),

    ELEMENT_RIGHT_CLICKED("Element '%s' is right clicked."),

    ELEMENT_NOT_RIGHT_CLICKED("FAIL: element '%s' is not right clicked!"),

    ELEMENT_HOVERED("Element '%s' is hovered."),

    ELEMENT_NOT_HOVERED("FAIL: element '%s' is not hovered!"),

    ELEMENTS_DRAGGED_AND_DROPPED("Element '%s' is dragged and dropped to '%s'."),

    ELEMENTS_NOT_DRAGGED_AND_DROPPED("FAIL: element '%s' is not dragged and dropped to '%s'!"),

    KEYS_CLEARED_IN_ELEMENT("Keys cleared in element '%s'."),
    
    KEYS_NOT_CLEARED_IN_ELEMENT("FAIL: keys not cleared in element '%s'."),
    
    KEYS_SEND_TO_ELEMENT("Keys '%s' are sent to element '%s'."),

    KEYS_NOT_SEND_TO_ELEMENT("FAIL: keys '%s' are not sent to element '%s'!"),

    UI_OBJECT_PRESENT("UI object '%s' presents!"),

    UI_OBJECT_NOT_PRESENT("FAIL: UI object '%s' does not present!"),

    TITLE_CORRECT("Page has correct title '%s'."),

    TITLE_NOT_CORRECT("FAIL: incorrect title, expected '%s' but actual '%s'!"),

    STEPS_TO_REPRODUCE("Steps to reproduce test failure: \r\n%s"),

    FILE_ATTACHED("File '%s' is attached."),

    FILE_NOT_ATTACHED("FAIL: file '%s' is not attached."),

    SELECT_TEXT("Text '%s' was selected in %s."),

    SELECT_INDEX("Index '%s' was selected in %s."),

    TEST_FAILURES("Test failures: \r\n%s"),

    TEST_CONFIGURATION("INFO: Test configuration: Browser='%s'; Base URL='%s'; Grid host='%s'."),

    HOVER_IMG("Img '%s' was hovered"),

    ALERT_ACCEPTED("Alert was accepted."),

    ALERT_NOT_ACCEPTED("FAIL: alert was not accepted!"),

    ALERT_CANCELED("Alert was cancelled."),

    ALERT_NOT_CANCELED("FAIL: alert was not cancelled!"),

    SELECT_BY_TEXT_PERFORMED("Text '%s' was selected in '%s'."),

    SELECT_BY_TEXT_NOT_PERFORMED("FAIL: text '%s' was NOT selected in '%s'."),

    SELECT_BY_MATCHER_TEXT_PERFORMED("Value by matcher '%s' was selected in '%s'."),

    SELECT_BY_MATCHER_TEXT_NOT_PERFORMED("FAIL: value by matcher '%s' was NOT selected in '%s'."),

    SELECT_BY_INDEX_PERFORMED("Index '%s' was selected in '%s'."),

    SELECT_BY_INDEX_NOT_PERFORMED("FAIL: index '%s' was NOT selected in '%s'."),

    CHECKBOX_CHECKED("Checkbox '%s' was checked."),

    CHECKBOX_UNCHECKED("Index '%s' was unchecked."),

    SLIDER_MOVED("Slider '%s' was moved by offset X:'%s' Y:'%s'."),

    SLIDER_NOT_MOVED("FAIL: slider '%s' was NOT moved by offset X:'%s' Y:'%s'!"),

    TAP_EXECUTED("Tap on X:'%s' Y:'%s' was executed."),

    TAP_NOT_EXECUTED("FAIL: Tap on X:'%s' Y:'%s' was not executed.");
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private String pattern;

    Messager(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
