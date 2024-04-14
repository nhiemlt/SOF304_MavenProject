package mainTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.UIMap;

public class TestFile {

    private WebDriver driver;
    private UIMap uimap;
    private UIMap datafile;
    private String workingDir;
    
    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private Map<String, Object[]> testNGResults;

    @BeforeClass(alwaysRun = true)
    public void suiteSetUp() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("TestNG Result Summary");
        testNGResults = new LinkedHashMap<>();
        testNGResults.put("1", new Object[]{"Test Step No.", "Action", "Expected Output", "Actual Output"});
        workingDir = System.getProperty("user.dir");
        datafile = new UIMap(workingDir + "/Resources/datafile.properties");
        uimap = new UIMap(workingDir + "/Resources/locator.properties");
        System.setProperty("webdriver.chrome.driver", "D:/SOF304/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(description = "Opens the TestNG Demo Website for Login Test", priority = 1)
    public void launchWebsite() {
        try {
            driver.get("https://kbeauty.itfpolycantho.online/admin/login");
            driver.manage().window().maximize();
            testNGResults.put("2", new Object[]{1d, "Navigate to demo website", "Site gets opened", "Pass"});
        } catch (Exception e) {
            testNGResults.put("2", new Object[]{1d, "Navigate to demo website", "Site does not open", "Fail"});
            Assert.fail("Failed to navigate to the website: " + e.getMessage());
        }
    }

    @Test(description = "Enter login information", priority = 2)
    public void enterLoginInfo() {
        try {
            WebElement username = driver.findElement(uimap.getLocator("Username_field"));
            username.sendKeys(datafile.getData("username"));
            WebElement password = driver.findElement(uimap.getLocator("Password_field"));
            password.sendKeys(datafile.getData("password"));
            Thread.sleep(1000);
            testNGResults.put("3", new Object[]{
                2d, "Enter login form data (username/password)", "Login information entered", "Pass"
            });
        } catch (Exception e) {
            testNGResults.put("3", new Object[]{
                2d, "Enter login form data (username/password)", "Failed to enter login form data", "Fail"
            });
            Assert.fail("Failed to enter login information: " + e.getMessage());
        }
    }

    @Test(description = "Perform login", priority = 3)
    public void performLogin() {
        try {
            WebElement loginButton = driver.findElement(uimap.getLocator("Login_button"));
            loginButton.click();
            Thread.sleep(2000);
            WebElement checkElement = driver.findElement(uimap.getLocator("check_element"));
            Assert.assertEquals(checkElement.getTagName(), "input");
            testNGResults.put("4", new Object[]{
                3d, "Click Login and verify welcome message", "Login successful", "Pass"
            });
        } catch (Exception e) {
            testNGResults.put("4", new Object[]{
                3d, "Click Login and verify welcome message", "Login failed", "Fail"
            });
            Assert.fail("Login failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void suiteTearDown() {
        Set<String> keySet = testNGResults.keySet();
        int rowIndex = 0;

        for (String key : keySet) {
            Row row = sheet.createRow(rowIndex++);
            Object[] data = testNGResults.get(key);
            int cellIndex = 0;
            for (Object obj : data) {
                Cell cell = row.createCell(cellIndex++);
                if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        try (FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xls"))) {
            workbook.write(out);
            System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.quit();
    }
}
