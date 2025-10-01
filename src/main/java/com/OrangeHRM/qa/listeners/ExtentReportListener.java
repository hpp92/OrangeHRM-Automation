package com.OrangeHRM.qa.listeners;

import com.OrangeHRM.qa.base.TestBase;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {

	private long suiteStartTime;
	private long suiteEndTime;

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private ExtentTest summaryTest;   // Create placeholder at start so summary appears on top

    // Counters
    private int totalTests = 0;
    private int passedTests = 0;
    private int failedTests = 0;
    private int skippedTests = 0;

    @Override
    public void onStart(ITestContext context) {
        suiteStartTime = System.currentTimeMillis();

        // Fixed folder (no timestamp) → test-output
        String reportDir = "test-output";

        // Ensure folder exists
        new File(reportDir).mkdirs();

        // Configure ExtentSparkReporter with fixed filename
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportDir + "/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Functional Testing");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // 🔹 Create placeholder summary FIRST (will appear on top)
        summaryTest = extent.createTest("🔹 Test Execution Summary 🔹");

        // Add system info
        extent.setSystemInfo("Tester", "Haresh Patel");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        // Store reportDir for screenshots (optional, but still works)
        context.setAttribute("REPORT_DIR", reportDir);

        // Store start time for duration calculation
        context.setAttribute("SUITE_START_TIME", suiteStartTime);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        totalTests++;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test passed");
        passedTests++;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.log(Status.FAIL, "Test failed: " + result.getThrowable());
        failedTests++;

        try {
            if (TestBase.driver != null) {
                Thread.sleep(500);

                // Always save screenshots under test-output/screenshots
                String screenshotDir = "test-output/screenshots";
                new File(screenshotDir).mkdirs();

                // Save local screenshot
                File src = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
                String localPath = screenshotDir + "/" + result.getMethod().getMethodName() + ".png";
                Files.copy(src.toPath(), Paths.get(localPath), StandardCopyOption.REPLACE_EXISTING);

                // Capture Base64 screenshot for embedding in ExtentReport
                String base64Screenshot = ((TakesScreenshot) TestBase.driver)
                                            .getScreenshotAs(OutputType.BASE64);
                test.fail("Screenshot of failure",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            } else {
                test.warning("WebDriver instance is null - cannot capture screenshot");
            }
        } catch (Exception e) {
            test.warning("Exception while capturing screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test skipped: " + result.getThrowable());
        skippedTests++;
    }

    @Override
    public void onFinish(ITestContext context) {
        suiteEndTime = System.currentTimeMillis();
        long durationMillis = suiteEndTime - suiteStartTime;

        long seconds = durationMillis / 1000 % 60;
        long minutes = durationMillis / (1000 * 60) % 60;
        long hours = durationMillis / (1000 * 60 * 60);
        String duration = String.format("%02d:%02d:%02d (HH:MM:SS)", hours, minutes, seconds);

        // Format start and end time
        String startTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(suiteStartTime));
        String endTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(suiteEndTime));

        // Update summary (already created in onStart)
        summaryTest.info(MarkupHelper.createLabel("<b>Start Time: " + startTimeStr + "</b>", ExtentColor.BLUE));
        summaryTest.info(MarkupHelper.createLabel("<b>End Time: " + endTimeStr + "</b>", ExtentColor.TEAL));
        summaryTest.info(MarkupHelper.createLabel("<b>Total Test Duration: " + duration + "</b>", ExtentColor.PURPLE));
        summaryTest.info(MarkupHelper.createLabel("Total Tests: " + totalTests, ExtentColor.BLUE));
        summaryTest.info(MarkupHelper.createLabel("Tests Passed: " + passedTests, ExtentColor.GREEN));
        summaryTest.info(MarkupHelper.createLabel("Tests Failed: " + failedTests, ExtentColor.RED));
        summaryTest.info(MarkupHelper.createLabel("Tests Skipped: " + skippedTests, ExtentColor.ORANGE));

        // Collapsible Google Charts pie
        String chartHtml = "<details><summary><b>📊 Execution Chart (click to expand)</b></summary>"
                + "<div id='piechart' style='width: 500px; height: 300px;'></div>"
                + "<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>"
                + "<script type='text/javascript'>"
                + "google.charts.load('current', {'packages':['corechart']});"
                + "google.charts.setOnLoadCallback(drawChart);"
                + "function drawChart() {"
                + "var data = google.visualization.arrayToDataTable(["
                + "['Result', 'Count'],"
                + "['Passed', " + passedTests + "],"
                + "['Failed', " + failedTests + "],"
                + "['Skipped', " + skippedTests + "]"
                + "]);"
                + "var options = { title: 'Test Execution Results', is3D: true };"
                + "var chart = new google.visualization.PieChart(document.getElementById('piechart'));"
                + "chart.draw(data, options);"
                + "}"
                + "</script></details>";

        summaryTest.info(chartHtml);

        // ===== Build color-coded HTML table for System/Environment =====
        String[][] systemInfo = {
                {"Tester", "Haresh Patel", "#1e90ff"},              // blue
                {"Environment", "QA", "#28a745"},                   // green
                {"Browser", "Chrome", "#ff8c00"},                   // orange
                {"OS", System.getProperty("os.name"), "#6a5acd"},   // purple
                {"Java Version", System.getProperty("java.version"), "#8b4513"}, // brown
                {"Start Time", startTimeStr, "#2f4f4f"},            // dark slate gray
                {"End Time", endTimeStr, "#2f4f4f"},                // dark slate gray
                {"Duration", duration, "#800080"}                   // purple
        };

        StringBuilder sb = new StringBuilder();
        sb.append("<table style='border-collapse:collapse;width:70%;font-family:Arial,Helvetica,sans-serif;'>");
        sb.append("<thead><tr>");
        sb.append("<th style='padding:8px;border:1px solid #ddd;background:#f2f2f2;text-align:left;'>Property</th>");
        sb.append("<th style='padding:8px;border:1px solid #ddd;background:#f2f2f2;text-align:left;'>Value</th>");
        sb.append("</tr></thead><tbody>");

        for (String[] row : systemInfo) {
            String key = row[0];
            String val = row[1];
            String color = row[2];
            sb.append("<tr>");
            sb.append("<td style='padding:8px;border:1px solid #ddd;font-weight:bold;'>").append(key).append("</td>");
            sb.append("<td style='padding:8px;border:1px solid #ddd;'><b><span style='color:").append(color).append("'>")
              .append(val).append("</span></b></td>");
            sb.append("</tr>");
        }
        sb.append("</tbody></table>");
        String sysTableHtml = sb.toString();

        // Wrap in collapsible section
        String collapsibleSys = "<details open><summary><b>⚙️ System / Environment Info</b></summary><div style='margin-top:8px;'>"
                + sysTableHtml + "</div></details>";

        summaryTest.info(collapsibleSys);

        // flush
        extent.flush();
    }
}
