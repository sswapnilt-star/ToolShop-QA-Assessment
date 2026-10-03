AI-Augmented QA Engineer / SDET – Technical Assessment
1. Project Overview
This repository contains my solution for the AI-Augmented QA Engineer / SDET Technical Assessment.
The assessment focused on testing the Toolshop web application by comparing the buggy build against the clean/reference build, identifying reproducible defects, documenting test results, and creating automated regression coverage for critical user journeys.
Application Under Test
•	Application: Toolshop
•	Buggy UI: Toolshop buggy build
•	Reference UI: Toolshop clean/reference build
•	Clean API: https://api.practicesoftwaretesting.com
•	Buggy API: https://api-with-bugs.practicesoftwaretesting.com
________________________________________
2. Testing Scope
The following high-risk areas were covered:
Authentication
•	User registration
•	Duplicate registration
•	Login with valid credentials
•	Login with invalid credentials
•	Authentication/session-related scenarios
Shopping Journey
•	Product browsing
•	Product details
•	Add product to cart
•	Update product quantity
•	Remove products
•	Multiple products
•	Cart calculations
•	Cart-to-checkout flow
Money & Quantity Validation
•	Price × quantity calculations
•	Line totals
•	Cart subtotal
•	Quantity boundary scenarios
•	Recalculation after quantity changes
API Testing
Selected REST API endpoints were compared between the buggy and clean environments to identify behavioral and contract differences.
________________________________________
3. Test Approach
The testing approach was based on risk-focused functional testing and buggy-vs-reference comparison.
The main steps were:
1.	Execute the same scenario against the clean/reference build.
2.	Execute the scenario against the buggy build.
3.	Compare application behavior and results.
4.	Confirm whether differences represent genuine defects.
5.	Document reproducible defects with expected and actual behavior.
6.	Automate important regression scenarios.
7.	Validate API behavior and response contracts for selected endpoints.
________________________________________
4. Test Execution Summary
UI Automation
Metric	Result
Total UI Test Cases Executed	28
Passed	12
Failed	13
Defferred 3
Pass Rate	42.86%
The failed scenarios were investigated against the reference build to distinguish genuine application defects from expected behavior or test-data issues.
Note: The pass/fail results represent the state of the application during the assessment execution.
________________________________________
5. Automation
The automated regression suite is implemented using:
•	Java
•	Maven
•	Selenium
•	TestNG
•	Page Object Model
•	WebDriver-based UI automation
________________________________________
6. API Testing
API testing was performed by comparing the clean and buggy API environments.
Example areas investigated include:
•	Brands
•	Brand creation
•	Brand retrieval
•	Brand update
•	Brand deletion
•	Brand search/filter behavior
The API findings are documented separately in the assessment artifacts.
________________________________________
7. Defect Reporting
Defects were evaluated based on:
•	Reproducibility
•	Expected behavior
•	Actual behavior
•	Comparison with the clean/reference build
•	Impact on the user journey
•	Supporting evidence
Each confirmed defect should provide enough information for a developer to reproduce and investigate the issue.
________________________________________
8. Test Data
Where required, unique test users and appropriate product/quantity combinations were used to avoid interference between test scenarios.
________________________________________
9. How to Run the Tests
Prerequisites
•	Java JDK
•	Maven
•	Chrome browser
Verify Java:
java -version
Verify Maven:
mvn -version
Install Dependencies
From the project root:
mvn clean install
Run Tests
mvn test
________________________________________
10. AI-Assisted Testing
AI tools were used as an augmentation to the QA process for activities such as:
•	Test scenario brainstorming
•	Edge-case identification
•	Test-case refinement
•	API contract review
•	Defect analysis
•	Automation assistance
•	Documentation refinement
Final test execution, defect validation, and conclusions were independently verified against the application behavior and reference build. 
AI selection:-AI was used as an engineering assistant during test design, Defect report generation, API testing. AI-generated suggestions were manually validated against the application and reference build.
Examples of AI output that were corrected or rejected:
- assumptions about application behavior
- unnecessary framework/POM complexity
The final test cases, defect findings, expected results, and automation assertions were validated against the application. Excluded the suggestion given by AI for Tax,discount test cases. Broaden area for testing. Incorrect/Inappropriate Bug/defect rating.
________________________________________
11. Assessment Deliverables
This repository contains the automation implementation and supporting assessment artifacts, including:
•	Test strategy
•	UI test cases
•	API test analysis
•	Defect findings
•	Automated regression tests
•	Test execution results
12. Conclusion
The assessment demonstrates a risk-based QA approach combining:
Manual testing + Reference-build comparison + API validation + UI automation + AI-assisted test design
The objective was not only to identify defects, but also to create maintainable regression coverage that can detect recurrence of important application issues.

