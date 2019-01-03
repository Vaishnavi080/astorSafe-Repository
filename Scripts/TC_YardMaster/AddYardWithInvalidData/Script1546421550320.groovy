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
import org.openqa.selenium.Keys as Keys

String Actual1 = 'This file type is not supported.'

String Actual2 = 'Yard Name Already Exists'

WebUI.callTestCase(findTestCase('TC_Login Script/CommonLogin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/Page_astorSafe System/SETUP'))

WebUI.delay(3)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/Page_astorSafe System/YardMasterOption'))

WebUI.delay(2)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/Page_astorSafe System/AddButton'))

WebUI.delay(2)

WebUI.setText(findTestObject('YardMaster Objects/YardMaster2/AddYardPopup/Page_astorSafe System/YardNameField'), 'AV Yard')

WebUI.delay(3)

WebUI.sendKeys(findTestObject('YardMaster Objects/YardMaster2/Dropdown OBJ/Page_astorSafe System/DropdownField'), Keys.chord(
        Keys.DOWN, Keys.DOWN, Keys.ENTER))

WebUI.delay(3)

WebUI.uploadFile(findTestObject('YardMaster Objects/YardMaster2/FileUpload/Page_astorSafe System/BrowseFileButton'), 'C:\\\\Users\\\\Astoria\\\\Desktop\\\\1Sprint Estimation Doc.xlsx')

WebUI.delay(30)

String Expected1 = WebUI.getText(findTestObject('YardMaster Objects/Invalid Data/Page_astorSafe System/span_This file type is not sup'))

System.out.println(Expected1)

WebUI.delay(3)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/FileUpload/Upload2/Page_astorSafe System/RemoveButton'))

WebUI.delay(5)

WebUI.uploadFile(findTestObject('YardMaster Objects/YardMaster2/FileUpload/Upload3/Page_astorSafe System/BrowseFile2'), 
    'C:\\\\Users\\\\Astoria\\\\Desktop\\\\ZYard.png')

WebUI.delay(30)

WebUI.click(findTestObject('YardMaster Objects/YardMaster2/AddYardPopup/Page_astorSafe System/SaveButton'))

WebUI.delay(8)

String Expected2 = WebUI.getText(findTestObject('YardMaster Objects/YardMaster2/Validation Message/Page_astorSafe System/Msg_Yard Name Already Exists'))

System.out.println(Expected2)
if (Expected1.equalsIgnoreCase(Actual1)&&Expected2.equalsIgnoreCase(Actual2)) {
    System.out.println('Adding Yard wrt Invalid Data Testcase is Passed ')
}
 else { 
 
    System.out.println('Adding Yard wrt Invalid Data Testcase is Failed ')
}

WebUI.closeBrowser()

