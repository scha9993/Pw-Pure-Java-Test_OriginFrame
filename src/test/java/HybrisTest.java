import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HybrisTest {

    @Test
    private void PaymentPopUpTest(){
        //UN: paypagetest7@qa.com
        //PW: Welcome123
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
        page.navigate("https://www-s3.brake.co.uk/");
        Locator btnUser = page.locator("div#v-login-popup button");
        btnUser.click();
        //TODO navigate to update card
//        Locator btnUpdateCard = page.locator("button[role='button']:has-text('Update')");
//        btnUpdateCard.click();
        Locator iFramePayment = (Locator) page.frameLocator("#paymentIframe");
        Locator txtFldCardNo = iFramePayment.getByPlaceholder("0000 0000 0000 0000");
        Locator txtFldCardHolder = iFramePayment.getByPlaceholder("John Doe");
        Locator txtFldExpiry = iFramePayment.getByPlaceholder("MM/YY");
        Locator txtFldCVV = iFramePayment.getByPlaceholder("123");
        Locator btnConfirm = iFramePayment.locator("//input[@value='Confirm']");
        Locator txtFldSecretCode = iFramePayment.getByPlaceholder("Enter Code here");
        txtFldCardNo.fill("5434600000000044");
        txtFldCardHolder.fill("Brakes test1");
        txtFldExpiry.fill("12/25");
        txtFldCVV.fill("123");
        btnConfirm.click();
        txtFldSecretCode.fill("555");

    }
}
