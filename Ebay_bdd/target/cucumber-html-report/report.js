$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cuc/tests/example.feature");
formatter.feature({
  "line": 1,
  "name": "Demo examples",
  "description": "",
  "id": "demo-examples",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Change Language",
  "description": "",
  "id": "demo-examples;change-language",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I open language selector",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I select \"English\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Selected language is applied",
  "keyword": "Then "
});
formatter.match({
  "location": "ChangeLanguage.iOpenLanguageSelector()"
});
formatter.result({
  "duration": 59676469166,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "English",
      "offset": 10
    }
  ],
  "location": "ChangeLanguage.iSelectLanguage(String)"
});
formatter.result({
  "duration": 806090505,
  "status": "passed"
});
formatter.match({
  "location": "ChangeLanguage.selectedLanguageApplied()"
});
formatter.result({
  "duration": 1208862,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Search for item",
  "description": "",
  "id": "demo-examples;search-for-item",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I search for \"ASUS\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I push Search button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Found element 3 contains \"ASUS\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "ASUS",
      "offset": 14
    }
  ],
  "location": "AddItemToCart.iSetSearchQuery(String)"
});
