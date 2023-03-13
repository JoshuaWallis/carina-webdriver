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
package com.zebrunner.carina.webdriver.augmenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmentable;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @deprecated use {@link Augmenter} instead
 */
@Deprecated(forRemoval = true, since = "1.0.0")
public class DriverAugmenter extends Augmenter {

    public DriverAugmenter() {
        super();
    }

    /**
     * @param driver see {@link WebDriver}
     * @return see {@link RemoteWebDriver}
     * @apiNote Renamed from extractRemoteWebDriver to extractRemoteDriver in 1.0.0.
     */
    protected RemoteWebDriver extractRemoteDriver(WebDriver driver) {
        if (driver.getClass().isAnnotationPresent(Augmentable.class)
                || driver
                        .getClass()
                        .getName()
                        .startsWith(
                                "org.openqa.selenium.remote.RemoteWebDriver$$EnhancerByCGLIB")
                || driver
                        .getClass()
                        .getName()
                        .startsWith(
                                "com.qaprosoft.carina.core.foundation.webdriver")) {
            return (RemoteWebDriver) driver;
        } else {
            return null;
        }
    }
}
