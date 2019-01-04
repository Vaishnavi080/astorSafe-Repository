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
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.IOException as IOException
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

WebUI.openBrowser('')
WebUI.navigateToUrl('http://astoria-qa.astorsafe.com/Login.aspx')
WebUI.delay(5)
FileInputStream file = new FileInputStream('C:\\Users\\Astoria\\Desktop\\Credentials1.xlsx')

XSSFWorkbook workbook = new XSSFWorkbook(file)

XSSFSheet sheet = workbook.getSheetAt(0)

for (int i = 1; i <=sheet.getLastRowNum(); i++) {
   def Username = sheet.getRow(i).getCell(0).getStringCellValue()

   def Password = sheet.getRow(i).getCell(1).getStringCellValue()

    WebUI.delay(5)   

WebUI.setText(findTestObject('Login Objects/astorSafe - Login/input_Username_loginCtrlUserNa'), Username)
WebUI.delay(5)
WebUI.setEncryptedText(findTestObject('Login Objects/astorSafe - Login/input_Password_loginCtrlPasswo'), Password)
WebUI.delay(5)

WebUI.click(findTestObject('Login Objects/astorSafe - Login/input__loginCtrlLoginButton'))
if (i == 1) {
	msg1 = WebUI.getText(findTestObject('Login Objects/astorSafe - Login/td_Invalid Password'))

	sheet.getRow(1).createCell(2).setCellValue(msg1)
} else if (i == 2) {
	msg2 = WebUI.getText(findTestObject('Login Objects/astorSafe - Login/td_Error validating user'))

	sheet.getRow(2).createCell(2).setCellValue(msg2)
} else {
	WebUI.click(findTestObject('Login Objects/astorSafe-Login1/Frequently Used Pages'))

	WebUI.delay(5)

	WebUI.click(findTestObject('Login Objects/astorSafe-Login1/Control Panel'))

	WebUI.delay(5)

	msg3 = WebUI.getText(findTestObject('Login Objects/astorSafe-Login1/Control Panel'))

	sheet.getRow(3).createCell(2).setCellValue(msg3 + 'Element Found. Hence Login Successful')




file.close()

FileOutputStream outFile = new FileOutputStream(new File('C:\\Users\\Astoria\\Desktop\\Credentials1.xlsx'))

workbook.write(outFile)

outFile.close()
}
}
WebUI.closeBrowser()

