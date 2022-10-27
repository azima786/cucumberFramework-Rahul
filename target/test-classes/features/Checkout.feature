Feature: Place the order for products

  @PlaceOrder
  Scenario Outline: Search experience for product search in both home and Offers page
    Given user is on GreenKart landing page
    When user searched with shortname <veg> and extract actual name of product
    And added "3" items of the selected product to cart
    Then user proceeds to Checkout and validate the <veg> items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
    |veg  |
    |Tom  |


