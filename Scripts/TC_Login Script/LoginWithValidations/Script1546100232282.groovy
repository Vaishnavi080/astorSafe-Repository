import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://astoria-qa.astorsafe.com/Login.aspx')

WebUI.maximizeWindow()

String a = 'Invalid Password', b = 'Error validating user', c = ' ControlPanel', msg1, msg2, msg3

for (def row = 1; row <= findTestData('UserCredentials').getRowNumbers(); row++) {
    WebUI.setText(findTestObject('Login Objects/astorSafe - Login/input_Username_loginCtrlUserNa'), findTestData('UserCredentials').getValue(
            'Username', row))

    WebUI.setEncryptedText(findTestObject('Login Objects/astorSafe - Login/input_Password_loginCtrlPasswo'), findTestData(
            'UserCredentials').getValue('Password', row))

    WebUI.click(findTestObject('Login Objects/astorSafe - Login/input__loginCtrlLoginButton'))

    WebUI.delay(5)

    if (row == 1) {
        msg1 = WebUI.getText(findTestObject('Login Objects/astorSafe - Login/td_Invalid Password'))

        System.out.println(msg1)
    } else if (row == 2) {
        msg2 = WebUI.getText(findTestObject('Login Objects/astorSafe - Login/td_Error validating user'))

        System.out.println(msg2)
    } else {
        WebUI.click(findTestObject('Login Objects/astorSafe-Login1/Frequently Used Pages'))

        WebUI.delay(5)

        WebUI.click(findTestObject('Login Objects/astorSafe-Login1/Control Panel'))

        WebUI.delay(5)

        msg3 = WebUI.getText(findTestObject('Login Objects/astorSafe-Login1/Control Panel'))

        System.out.println(msg3)
    }
}

if (msg1 == a) {
    System.out.println('Invalid Password Testcase is Passed')
} else {
    System.out.println('Invalid Password Testcase is Failed')
}

if (msg2 == b) {
    System.out.println('Invalid Username Testcase is Passed')
} else {
    System.out.println('Invalid Username Testcase is Failed')
}

if (msg3 == c) {
    System.out.println('Login Testcase Passed')
} else {
    System.out.println('Login Testcase Failed')
}

WebUI.closeBrowser()

