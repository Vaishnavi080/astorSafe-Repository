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
String msg3, c = ' ControlPanel'
WebUI.setText(findTestObject('Login Objects/astorSafe - Login/input_Username_loginCtrlUserNa'), findTestData('UserCredentials').getValue(
	1, 3))

WebUI.setEncryptedText(findTestObject('Login Objects/astorSafe - Login/input_Password_loginCtrlPasswo'), findTestData(
	'UserCredentials').getValue(2, 3))

WebUI.click(findTestObject('Login Objects/astorSafe - Login/input__loginCtrlLoginButton'))

WebUI.delay(5)
WebUI.click(findTestObject('Login Objects/astorSafe-Login1/Frequently Used Pages'))

		WebUI.delay(5)

		WebUI.click(findTestObject('Login Objects/astorSafe-Login1/Control Panel'))

		WebUI.delay(5)

		msg3 = WebUI.getText(findTestObject('Login Objects/astorSafe-Login1/Control Panel'))

		System.out.println(msg3)
		if (msg3 == c) {
			System.out.println('Login Testcase Passed')
		} else {
			System.out.println('Login Testcase Failed')
		}