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
import groovy.time.TimeCategory as TimeCategory
import org.openqa.selenium.Keys as Keys

String name = 'AutYard'

String ExpectedSuccessMsg = 'Yard created successfully'

String todaydate

String nowtime

String yardname

Date today = new Date()

todaydate = today.format('MM/dd/yyyy')

nowtime = today.format('hh:mm a')

System.out.println(todaydate + nowtime)

yardname = WebUI.concatenate((([name, todaydate, nowtime]) as String[]), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('TC_Login Script/CommonLogin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/Page_astorSafe System/SETUP'))

WebUI.delay(3)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/Page_astorSafe System/YardMasterOption'))

WebUI.delay(3)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/Page_astorSafe System/AddButton'))

WebUI.delay(3)

WebUI.setText(findTestObject('YardMaster Objects/YardMaster2/AddYardPopup/Page_astorSafe System/YardNameField'), yardname)

WebUI.delay(3)

WebUI.sendKeys(findTestObject('YardMaster Objects/YardMaster2/Dropdown OBJ/Page_astorSafe System/DropdownField'), Keys.chord(
        Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, 
        Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/AddYardPopup/Page_astorSafe System/EnableClockTimeCapture_YES'))

WebUI.delay(3)

WebUI.uploadFile(findTestObject('YardMaster Objects/YardMaster2/FileUpload/Page_astorSafe System/BrowseFileButton'), 'C:\\\\Users\\\\Astoria\\\\Desktop\\\\Zyard.png')

WebUI.delay(30)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/AddYardPopup/Page_astorSafe System/SaveButton'))

WebUI.delay(10)

WebUI.waitForElementNotClickable(findTestObject('YardMaster Objects/YardMaster2/SuccessMessages/Page_astorSafe System/SuccessMeassage-Yard created successfully'), 
    10)

String ActualSuccessMsg = WebUI.getText(findTestObject('YardMaster Objects/YardMaster2/SuccessMessages/Page_astorSafe System/SuccessMeassage-Yard created successfully'))

WebUI.delay(5)

System.out.println(ActualSuccessMsg)

WebUI.delay(5)

if (ActualSuccessMsg == ExpectedSuccessMsg) {
    System.out.println('Adding New Yard Testcase is Passed')
} else {
    System.out.println('Adding New Yard Testcase is Failed')
}

WebUI.closeBrowser()

