Feature: Order T-Shirt

  @Sanity
  Scenario: Login Functionalaity
    Given User have the valid credential and application is up
    When User login to the application with Valid Credentials
    Then login should be successful  "My account - My Store"

  @Sanity
  Scenario: Order Tshirt - Opening the Tshirt page
    Given User is on My Account My store page
    When User click on TShirt Tab
    Then User should land on "T-SHIRTS" shopping Page
    And User should see the Tshirts in my TShirt shopping page

  @Sanity
  Scenario Outline: Order Tshirt - Adding a TShirt to the cart
    Given User is on a TShirt shopping Page
    When User sort the TShirt "<SortBy>"
    And User open the required TShirt "<ProductName>"
    And User select the Quanity/Size/Colour "<Colour>","<Size>","<Quantity>"
    And User click on add to card button
    Then User should see the selected TShirt in the add to cart confirmation page with "<ProductName>","<Colour>","<Size>","<Quantity>"
    And User  shoud see the message "Product successfully added to your shopping cart"

    Examples: 
      | SortBy   | ProductName                 | Quantity | Size | Colour |
      | In stock | Faded Short Sleeve T-shirts |        2 | S    | Blue   |

  @Sanity
  Scenario Outline: Order Tshirt -Check out the selected TShirt to the shopping cart summary
    Given User is on the "SHOPPING-CART SUMMARY" page
    Then User should  see the selected TShirt in the shopping cart summary page with "<ProductName>","<Quantity>","<Size>","<Colour>"

    Examples: 
      | ProductName                 | Quantity | Size | Colour |
      | Faded Short Sleeve T-shirts |        2 | S    | Blue   |

  @Sanity
  Scenario Outline: Order Tshirt -Check out the selected product to the Address to update the address
    Given User is on "ADDRESSES" page
    When User click on delivery address update button
    And User update the address Fields with "<Address>"
    And User clicks on save button
    Then User should see the updated address in the delivery item box "<Address>"

    Examples: 
      | Address      |
      | pallikaranai |

  @Sanity
  Scenario: Order Tshirt -Check out the selected product to the shipping
    Given User is on the shipping page with title "SHIPPING"
    Then User should able to select the Terms of service "1"

  Scenario Outline: Order Tshirt - Payment Mode for the Selected Product
    Given User is on a Payment Page with title "PLEASE CHOOSE YOUR PAYMENT METHOD"
    When User select the paymentmode "<PaymentMode>"
    Then User should see the payment details in the order summary page

    Examples: 
      | PaymentMode |
      |             |

  Scenario: Order Tshirt  - Confirm the Order
    Given User is on the  order confirmation page
    Then the order should be sucessfully completed
    And User should able to see the order refernce number"<OrderReferenceNumber>"

  Scenario: Order Tshirt - Verify the Order in My Order page
    Given User is on My orders history page
    When User click on the order reference number
    Then user should able to see the corresponding order details
