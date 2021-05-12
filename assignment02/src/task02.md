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
>  1. A user can add more items to the cart- total should reflect the same.
>  1. Update the contents added to the cart- total should reflect that too.
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
>  1. If storing customer Credit card or any other financial information, perform security testing around this to make sure it is secure.(PCI compliance is a must).
>  1. If the user is signed up for a long time, make sure the session is timed out or not. Every site has a different threshold. For some, it is 10 minutes. For some, it might be different.
>  1. Emails/Text confirmation with the order number and invoice generated.

### Create order
>  1. Fill up the shopping cart
>  1. Fill up First name, Last name, email, phone number, city, street, number, Postal code
>  1. Try to create orders with empty First name, Last name, email, phone number, city, street, number, Postal code - every test should fail
>  1. Try to check and fill up data for firm order
>  1. Click next step
>  1. Confirmation of the order should appear
>  1. Confirm order
>  1. Check that email with order confirmation was received at listed mail



## The most risky clusters of impact
- 

