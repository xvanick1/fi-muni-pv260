# Task02

## Attributes
1. Fast load time
1. Secure payment network
1. Clear easy appealing navigation and design
1. Good brand
1. Multiplatform availability
1. Effective use of user data and his behaviour to offer suitable products
1. Stability under load

**Why we chosen these attributes**  
- We most often see the features of these attributes in many existing e-shops. 
When choosing the attributes of an imaginary eshop, we therefore proceeded from the properties that we observed in successful existing eshops.  

**Minimizing chances that there are other attributes we do not see, but are of higher importance than selected**
- Discusion with team
- Alfa/Beta testing
- Analysis of project
- Analysis of the market

## Components
1. Intuitive shopping cart
1. Product component
1. Product filter
1. Product comparing tool
1. User control panel
1. Navigation menu
1. Payment gateway
1. Discounts for different types of users
1. Lastly watched & recommended products
1. Search
1. Order details
1. Contacts
1. Pick-up points
1. History of orders
1. Notification about order/product availability

## Capabilities
1. Filtering products
1. Listing products
1. Show product detail 
1. Real-time, customer specific pricing 
1. Quick order & reorder/auto-replenishment
1. Bundle and tiered pricing
1. Future stock availability
1. Customer self-service and administration
1. Invoice and credit reporting
1. Products revie ws

## Test cases

### Shopping cart
>  1. Add items to the cart and continue shopping.
>  1. If the user adds the same item to the cart while continuing to shop, the item count in the shopping cart should get incremented.
>  1. All items and their totals should be displayed in the cart.
>  1. Taxes as per location should be applied.
>  1. A user can add more items to the cart - total should reflect the same.
>  1. Update the contents added to the cart - total should reflect that.
>  1. Remove items from the cart.
>  1. Proceed to checkout.
>  1. Calculate Shipping costs with different shipping options.
>  1. Apply coupons.
>  1. Don’t check out, close the site, and come back later. The site should retain the items in the cart.

### Payment options
>  1. Check different payment options.
>  1. If allowing check out as Guest, simply finish the purchase and provide an option to register at the end.
>  1. Returning customers – Login to check out.
>  1. User sign up.
>  1. If the user is signed up for a long time, make sure the session is timed out or not. Every site has a different threshold. For some, it is 10 minutes. For some, it might be different.
>  1. Emails/Text confirmation with the order number and invoice generated.

### Create order
>  1. Fill up the shopping cart
>  1. Fill up First name, Last name, email, phone number, city, street, number, Postal code.
>  1. Try to create orders with empty First name, Last name, email, phone number, city, street, number, Postal code - every test should fail.
>  1. Try to check and fill up data for firm order.
>  1. Click next step.
>  1. Confirmation of the order should appear.
>  1. Confirm order.
>  1. Check that email with order confirmation was received at listed mail.

### Product details
>  1. Open a specific product page.
>  1. Does this page display all the product related information (e.g. product name, code, price, discount if any, product images, product specifications, user reviews, Add to Cart button, quantity changer etc) as expected?
>  1. If the product parameters are customizable, change its available parameters randomly.
>  1. Can the user select required number of items using the quantity selector? If yes, change the product quantity.
>  1. Does this page show the stock availability accurately?
>  1. Is there "add to card button"? 
>  1. Add the product to card by clicking.
>  1. Does this product gets added to cart when added?
>  1. Does the quantity in cart get updated when the product is added to cart?
>  1. Go again to the product page.
>  1. Add the product to the cart.
>  1. Go to the cart.
>  1. Was product quantity incremented?

### User login
>  1. Enter valid username and password of existing username, click login button -> user should be logged in
>  1. Enter valid username and invalid password of existing username, click login button -> user should not be logged in
>  1. Enter invalid username and valid password of existing username, click login button -> user should not be logged in
>  1. Enter valid username and click login button -> user should not be logged in
>  1. Enter valid password and click login button -> user should not be logged in
>  1. Enter valid username and valid password and click login button -> password should be encrypted in system
>  1. Enter valid username and click login button -> user should not be logged in
>  1. Enter empty username and valid password of existing username, click login button -> Error message should tell that blank space needs to be filled
>  1. Enter valid username and empty password of existing username, click login button -> Error message should tell that blank space needs to be filled
>  1. Click "Forgot password" and enter invalid username when prompted -> Nothing should happen
>  1. Click "Forgot password" and enter valid username when prompted -> Email with link for password reset should have been sent
>  1. Go on password reset link. Enter previous password as new password. Click on "confirm new password" button -> Error message should appear
>  1. Go on password reset link. Enter new password and click on "confirm new password" button -> User new password should work
>  1. Go on password reset link. Enter new password which do not cover basic requirements and click on "confirm new password" button -> User new password should work
>  1. Go on password reset link after link was used once already. -> Error message should appear

## The most risky clusters of impact
>  1. System reliability
    - Server of the internet service provider could crash, e-shop payment system could show errors, database could crash or get into an inconsistent state.
>  1. Privacy issues
    - Personal data of customers and their credit cards could be compromised, used for spamming, theft of finances, and an identity theft could occur.
>  1. Warranty and return of goods
    - Problems when dealing with returned products. Increase of the costs of supply chain. Unable to sell used product for atleast purchase price without loss.
>  1. Disputes of customers
    - Dealing with angry customers who did not received their product. Online description of the product differs from their purchased product. Customers were charged twice or they were charged wrong price/price without applicable discount. Delivery of customers pre-ordered product is being extended.
>  1. Security
    - Malwares, phishing, spam, hacking, ddos.
>  1. Logistics
    - Running out of stock of the product, while many orders are being processed. Delivery of the product to incorrect recipient. Product is being damaged during delivery.
>  1. 