Feature: Search and place order for products

  @OffersPage
  Scenario Outline: Search experience for product search in both home and Offers page


  Given user is on GreenKart landing page
    When user searched with shortname <veg> and extract actual name of product
    Then user searches for <veg> shortname on offers page
  And validate product name matches with landing page
    Examples:
    |veg|
      |Tom  |
    | Beet  |


