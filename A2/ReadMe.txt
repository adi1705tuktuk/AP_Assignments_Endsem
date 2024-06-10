Zoo Management System

The Zoo Management System is a user-friendly application designed to facilitate the operations and interactions within a zoo. It offers a range of features for both visitors and administrators, allowing for a seamless experience.

Key Features:

User-Friendly Interface: The system provides an easy-to-use text-based menu system for visitors to navigate and interact with the zoo's facilities and services.

Visitor Registration: Visitors can register by providing essential information, including their name, age, contact details, and balance, enabling them to access various services.

Membership Options: Visitors can purchase memberships, choosing between Basic and Premium plans, each with its own pricing and privileges.

Ticket Purchases: Visitors can buy tickets for attractions within the zoo. The system offers varying prices and discounts based on factors such as membership status and age.

Discounts and Special Deals: Special deals and discounts are available for visitors, including options like senior and minor discounts. The application also provides a list of special deals for additional savings.

Attraction Exploration: Visitors can explore and learn about the zoo's attractions through detailed textual descriptions. They can select attractions to visit, each with its own ticket price.

Feedback Mechanism: The system offers a feature for visitors to provide feedback, helping the zoo improve its services.

Administrator Access: While the primary focus is on visitors, administrators can access additional functionalities for managing the zoo's resources, including attraction information and feedback.


Assumpitons:

Visitors need to register and login to access zoo features. Their credentials are email and password.
There are two membership types - Basic and Premium. Premium members get additional benefits.
Animals and attractions are stored in static lists that are initialized with sample data. No database is used.
Ticket pricing for attractions is fixed. Discount percentages are also fixed.
Special deals are defined with fixed criteria like minimum number of attractions and discount percentage.
Feedback submitted by visitors is stored in a simple in-memory list.
Admin actions like add/remove animals, attractions etc. simply modify the in-memory lists. No persistence.
Visitor actions like buying tickets deduct from their account balance. No actual ticketing system.
Stats like visitor counts, revenue etc. are calculated on the fly and not stored.
No actual UI. All interactions are via the command line.
Fixed admin username and password is used for admin login.
No roles or permissions systems beyond basic admin/visitor division.