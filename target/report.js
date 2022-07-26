$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/TC1_LoginPage.feature");
formatter.feature({
  "name": "Verifying adactinhotel login details",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verifying adactinhotel with valid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login1"
    }
  ]
});
formatter.step({
  "name": "User should perform login  \"\u003cusername\u003e\" , \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User should verify after login successfully  \"Hello Alex2727!\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "Alex2727",
        "PXF099"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User should launch browser and pass adactinhotel page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginPageStep.userShouldLaunchBrowserAndPassAdactinhotelPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verifying adactinhotel with valid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login1"
    }
  ]
});
formatter.step({
  "name": "User should perform login  \"Alex2727\" , \"PXF099\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageStep.userShouldPerformLogin(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should verify after login successfully  \"Hello Alex2727!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.userShouldVerifyAfterLoginSuccessfully(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});