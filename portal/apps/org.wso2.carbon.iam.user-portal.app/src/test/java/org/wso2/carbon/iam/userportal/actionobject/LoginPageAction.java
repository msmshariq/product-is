/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.iam.userportal.actionobject;

import org.openqa.selenium.WebDriver;
import org.wso2.carbon.iam.userportal.pageobject.LoginPage;

/**
 * Login page action for generated page objects using chrome plugin.
 */
public class LoginPageAction {

    WebDriver webDriver = null;
    public LoginPageAction(WebDriver driver) {
        webDriver = driver;
    }

    public boolean login(String username, String password) {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean result = false;
        try {
            loginPage.getUsername1().sendKeys(username);
            loginPage.getPassword1().sendKeys(password);
            loginPage.getSignIn().click();

            result = true;

        } catch (Exception e) {
            System.out.print(e.getMessage());
            result = false;
        }
        return result;
    }

    public boolean signUp() {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean result = false;
        try {
            loginPage.getSignUp().click();
            result = true;

        } catch (Exception e) {
            System.out.print(e.getMessage());
            result = false;
        }
        return  result;
    }


    public boolean forgetUsername() {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean result = false;
        try {
            loginPage.getUsername2().click();
            result = true;

        } catch (Exception e) {
            System.out.print(e.getMessage());
            result = false;
        }
        return result;
    }
     public boolean forgetPassword() {
         LoginPage loginPage = new LoginPage(webDriver);
         boolean result = false;
         try {
             loginPage.getPassword2().click();
             result = true;

         } catch (Exception e) {
             System.out.print(e.getMessage());
             result = false;
         }
         return result;
     }

}
