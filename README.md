# Short Description
Java task done as a first stage of Virtus Lab internship recruitment in April 2022.  
It implements a simple shop, with database stub and a REST-like app created in Spring Boot framework.  
All sub-tasks were completed.

# Sub-tasks Description
The challenges:
- The current tests fail. Therefore, the tests should pass as they check the expected
outcome of the subjects. Fix the source code to make the tests pass. The test
code can be changed, however, the cases must stay the same.
- The product owner came and created a story - a 15% discount on the total price,
which should be applied only if at least 3 grain products (products have categories)
are in the basket. It applies before the 10% discount. So first you apply 15% to get
the new total price and then if it is applicable to the new price, a 10% discount is
applied. Implement the described discount.
- The app is not going to work in the void. So the app needs a REST-like endpoint(s).
Please use the framework of your choice (e.g. Spring, Micronaut) to make the
app accept basket information and then return the receipt data.
- Remember, we must be sure that the app works as expected. Please write alll tests
that you consider required.
