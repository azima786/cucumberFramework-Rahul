Feature: Search and place order for products
  Scenario: Search experience for product search in both home and Offers page

  Given user is on GreenKart landing page
    When user searched with shortname "Tom" and extract actual name of product
    Then user searches for "Tom" shortname on offers page
  And validate product name matches with landing page


