import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.concurrent.TimeUnit;

/**
 * create by Anthony on 2017/10/24
 */
public class TestngOne {

    WebDriver driver = new ChromeDriver();
    String pass_Phone="15996238380";
    String identity_Number="340421199011086026";
    String card_Number="666601234567899699";
    String bind_Email="Wangfane163@163.com";
    String pay_Pass="zhifu6$";
    String login_Pass="cell66*";
@BeforeClass
    public void mobLogin() {

        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        driver.get("https://mob.163.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("The testing page title is: " + driver.getTitle());
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement frame1 = ((ChromeDriver) driver).findElementByTagName("iframe");
        driver.switchTo().frame(frame1);
        WebElement usrName = ((ChromeDriver) driver).findElementsById("phoneipt").get(0);
        usrName.sendKeys(pass_Phone);

        String path="//*[@class='j-inputtext dlemail']";
//        WebElement passWord = ((ChromeDriver) driver).findElementByXPath("//*[@class='j-inputtext dlemail']");
//        passWord.sendKeys(login_Pass);
        Utils.myFindElementByXpath(driver,path,login_Pass);


        WebElement loginConfirm = driver.findElement(By.id("submitBtn"));
        loginConfirm.click();
        //将当前cookie载入下一个界面中
        try {
            //页面等待
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("https://epay.163.com");//tel password
        driver.manage().window().maximize();

    }



   /* @Test
    public void getDatabase(){
       // init();
       String authcode= JdbcUtil.init();
    //   System.out.println("手机验证码是***************************"+authcode);

    }*/

    @Test
    public void getMoney() {
        driver.get("https://epay.163.com/personaltransfer/receive_view.htm");//tel password
        driver.manage().window().maximize();
        //payIntro1 text_email text_money blue_btn blue_btn4 fr
        WebElement inputGetMoneyText = driver.findElement(By.id("payIntro1"));
        inputGetMoneyText.sendKeys("test");
        WebElement getAccount = driver.findElement(By.className("text_email"));
        getAccount.sendKeys("epay35@163.com");
        WebElement getAmount = driver.findElement(By.className("text_money"));
        getAmount.sendKeys("0.01");
        //手动收入验证码，延迟提交
        try {
            //页面等待
            //Thread.sleep(30000);
            Thread.sleep(30000);
            //  WebElement nextStep = driver.findElement(By.className("blue_btn"));
            //  getAmount.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //  WebElement confirm = driver.findElement(By.className("blue_btn4 fr"));
        //  confirm.click();


        // System.out.println("yyn hello wordld ");
    }

    @Test
    public void getMultiMoney() {
        driver.get("https://epay.163.com/personaltransfer/receive_view.htm");//tel password
        driver.manage().window().maximize();
        try {
            //页面等待
            //Thread.sleep(30000);
            Thread.sleep(300);
            //  WebElement nextStep = driver.findElement(By.className("blue_btn"));
            //  getAmount.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement inputGetMoneyText = driver.findElement(By.id("payIntro1"));
        inputGetMoneyText.sendKeys("test");
        WebElement getAccount = driver.findElement(By.className("text_email"));
        getAccount.sendKeys("epay35@163.com");
        WebElement getAmount = driver.findElement(By.className("text_money"));
        getAmount.sendKeys("0.01");
        WebElement addPeople = driver.findElement(By.id("add_pay_man"));
        addPeople.click();
        try {
            //页面等待
            //Thread.sleep(30000);
            Thread.sleep(1300);
            //  WebElement nextStep = driver.findElement(By.className("blue_btn"));
            //  getAmount.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // WebElement usrName = ((ChromeDriver) driver).findElementsById("phoneipt").get(0);
       // WebElement inputGetMoneyText2 = (driver.findElement(By.id("payIntro1"))).get;

       // WebElement getAccount2 = driver.findElement(By.className("text_email"));
        WebElement getAccount2 = ((ChromeDriver) driver).findElementsById("text_email").get(1);


        getAccount2.sendKeys("epayautotest@163.com");
        WebElement getAmount2 = driver.findElement(By.className("text_money"));
        getAmount2.sendKeys("0.02");


        //手动收入验证码，延迟提交
        try {
            //页面等待
            //Thread.sleep(30000);
            Thread.sleep(6000);
            //  WebElement nextStep = driver.findElement(By.className("blue_btn"));
            //  getAmount.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void payMoney() {
        driver.get("https://epay.163.com/personaltransfer/show_transfer_list.htm?batchId=");//tel password
        driver.manage().window().maximize();


        // System.out.println("yyn hello wordld ");emailAccountId  OTPCtl2
    }

    @Test
    public void bindEmail() {
        driver.get("https://epay.163.com/servlet/controller?operation=bindEmailView");// retypeEmailAccountId
        driver.manage().window().maximize();
        WebElement emailAccountId = driver.findElement(By.id("emailAccountId"));
        emailAccountId.clear();
        emailAccountId.sendKeys(bind_Email);
        WebElement reEmailAccountId = driver.findElement(By.id("retypeEmailAccountId"));
        reEmailAccountId.clear();
        reEmailAccountId.sendKeys(bind_Email);


        WebElement passWord = driver.findElement(By.id("OTPCtl2"));
        passWord.sendKeys(pass_Phone);
        Utils.myFindElementById(driver,"activeBtn","false");


        // System.out.println("yyn hello wordld ");
    }






    @Test
    public void unbindEmail() {
        driver.get("https://epay.163.com/servlet/controller?operation=unBindEmailView");//tel password
        driver.manage().window().maximize();
        WebElement emailAccountId = driver.findElement(By.id("emailAccountId"));
        emailAccountId.clear();
        emailAccountId.sendKeys(bind_Email);
        WebElement passWord = driver.findElement(By.id("OTPCtl2"));
        passWord.sendKeys(pay_Pass);


        // System.out.println("yyn hello wordld ");
    }

    @Test
    public void unbindEmailByPhone() {
        driver.get("https://epay.163.com/servlet/controller?operation=unBindEmailWithMobileView");//tel password
        driver.manage().window().maximize();
        WebElement getVerifyCode= driver.findElement(By.className("checkNoBtn"));
        getVerifyCode.click();
        WebElement verifyCode=driver.findElement(By.id("mobileAuthCode"));
        verifyCode.sendKeys(bind_Email);
        WebElement passWord = driver.findElement(By.id("OTPCtl2"));
        passWord.sendKeys(pay_Pass);


        // System.out.println("yyn hello wordld ");que_0
    }
    @Test
    public void updatePhoneByQue() {
        driver.get("https://epay.163.com/accountmobile/replace_mobile_choose.htm");//btn-2
        driver.manage().window().maximize();

        WebElement getChanged= ((ChromeDriver) driver).findElementByXPath("//*[@href='/accountmobile/replace_by_question.htm']");
        getChanged.click();
        WebElement identityId=driver.findElement(By.id("identityCardNumber"));
        identityId.sendKeys(identity_Number);
        WebElement phoneNumber=driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys(pass_Phone);
        WebElement montherName=driver.findElement(By.id("que_0"));
        montherName.sendKeys("王小红");
        WebElement friendName=driver.findElement(By.id("que_1"));
        friendName.sendKeys("吴敏");
        WebElement fatherName=driver.findElement(By.id("que_2"));
        fatherName.sendKeys("杨小明");
        WebElement nextStep=driver.findElement(By.className("btn-2"));
        nextStep.click();
       //mobile             checkNo   OTPCtl2
       // findElementById(String name,String value)
        Utils.myFindElementById(driver,"mobile",pass_Phone);
        Utils.myFindElementById(driver,"getNoBtn","false");
        Utils.mySleep(100);
        String authcode= JdbcUtil.init();
        Utils.myFindElementById(driver,"checkNo",authcode);
        Utils.myFindElementById(driver,"OTPCtl2",pay_Pass);//
        WebElement confirm=driver.findElement(By.className("btn-2"));
        confirm.click();
        Utils.mySleep(200);
        Boolean result=Utils.isContentAppeared(driver,"您的密保手机号码更换为");
        System.out.println("通过问题更换密保手机的结果*******"+result);

    }

    @Test
    public void updatePhoneByText() {
        driver.get("https://epay.163.com/accountmobile/replace_view.htm");//btn-2 checkNoBtn  mobile checkNoBtn
        driver.manage().window().maximize();

        WebElement getVerifyCode = driver.findElement(By.className("checkNoBtn"));
        getVerifyCode.click();
        Utils.mySleep(100);
        String authcode= JdbcUtil.init();
        Utils.myFindElementById(driver,"mobileAuthCode",authcode);
        Utils.myFindElementById(driver,"OTPCtl2",pay_Pass);
        Utils.myFindElementById(driver,"activeBtn","false");
        Utils.mySleep(300);
        Utils.myFindElementById(driver,"mobile",pass_Phone);
        WebElement reGetVerifyCode = driver.findElement(By.className("checkNoBtn"));
        reGetVerifyCode.click();
        Utils.mySleep(100);
        String reAuthcode=JdbcUtil.init();
        Utils.myFindElementById(driver,"mobileAuthCode",reAuthcode);
        Utils.myFindElementById(driver,"activeBtn","false");
        Utils.mySleep(200);
        Boolean result=Utils.isContentAppeared(driver,"您的密保手机号码更换为");
        System.out.println("通过问题更换密保手机的结果*******"+result);

    }


    @Test
    public void addWithdrawCard() {
        driver.get("https://epay.163.com/withdraw/view.htm");//link-1 btn-new  bank-list-box  form-control input-error class="form-control"
        driver.manage().window().maximize();
        //系统休眠几秒
        Utils.mySleep(10000);
        int i=100;
        while(i>1)
        {
            i--;
        }
//        WebElement addBankCard =((ChromeDriver) driver).findElementByXPath("//*[@href=\"javascript:;\"");
        WebElement addBankCard =driver.findElement(By.className("btn-new"));
        addBankCard.click();
        WebElement bankCard= ((ChromeDriver) driver).findElementByXPath("//*[@class='bank-list-box']/span[7]");
        bankCard.click();
//        WebElement bankCardNumber = driver.findElement(By.className("input-error"));
//        WebElement bankCardNumber =  ((ChromeDriver) driver).findElementByName("cardNo");
//        bankCardNumber.sendKeys(card_Number);//666601234567899966 form-control

         Utils.myFindElementByName(driver,"cardNo",card_Number);
//        WebElement phone = driver.findElement(By.className("form-control"));//mobilePhone
//        phone.sendKeys(pass_Phone);//btn-secondary module-auth-code
        Utils.myFindElementByName(driver,"mobilePhone",pass_Phone);


        WebElement getVerifyCode = driver.findElement(By.className("module-auth-code"));
        getVerifyCode.click();
        Utils.mySleep(100);
        String autocode=JdbcUtil.init();
//        Utils.myFindElementById(driver,);//form-control module-auth-code-target
        WebElement verifyCode = driver.findElement(By.className("module-auth-code-target"));
        verifyCode.sendKeys(autocode);//666601234567899966 form-control  btn-primary
        Utils.myFindElementByClassName(driver,"btn-primary","false");
//        ((ChromeDriver) driver).findElementByName()
//        ((ChromeDriver) driver).findElementsByTagName()


    }



}