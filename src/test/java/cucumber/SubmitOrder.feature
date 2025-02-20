
@tag
Feature: Purchase an order from E-commerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on E-Commerce Page

  @tag1
  Scenario Outline: Positive test for submitting the order
    Given Logged in with username <name> and password <password>
    When I add the product  <productName> from Cart
    And checkout the product <productName> <firstName> <lastName> <zipCode> and submit the order
    Then I verify the <orderConfirmText> text

    Examples: 
      | name         | password     | productName              | firstName | lastName | zipCode | orderConfirmText          |
      | standard_user| secret_sauce | Sauce Labs Fleece Jacket | Deepak    | Bohara   | 411     | Thank you for your order! |
  
