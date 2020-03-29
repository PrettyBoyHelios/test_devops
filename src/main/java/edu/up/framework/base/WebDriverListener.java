package edu.up.framework.base;


import edu.up.framework.utils.OnFailure;
import edu.up.framework.utils.OnSuccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class WebDriverListener implements IInvokedMethodListener {

    private final static Logger logger = LoggerFactory.getLogger(WebDriverListener.class);

    OnFailure failure = new OnFailure();
    OnSuccess success = new OnSuccess();

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}